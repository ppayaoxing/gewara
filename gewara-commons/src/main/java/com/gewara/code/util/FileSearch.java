/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.code.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class FileSearch {
	public static void searchFile(Writer writer, String path, boolean onlyGen, Date date) throws IOException {
		FileSearch.GenFileFilter filter = new FileSearch.GenFileFilter(onlyGen, date);
		File dir = new File(path);
		searchFile((File) dir, (Writer) writer, (FilenameFilter) filter);
	}

	public static void searchFile(File dir, Writer writer, FilenameFilter filter) throws IOException {
		File[] result = dir.listFiles(filter);
		ArrayList dirList = new ArrayList();
		System.out.println("search " + dir.getCanonicalPath() + " ...");
		File[] arg4 = result;
		int f = result.length;

		for (int arg6 = 0; arg6 < f; ++arg6) {
			File f1 = arg4[arg6];
			if (f1.isDirectory()) {
				dirList.add(f1);
			} else {
				writer.append(f1.getCanonicalPath() + "\t" + f1.lastModified() + "\t" + f1.length() + "\n");
			}
		}

		Iterator arg8 = dirList.iterator();

		while (arg8.hasNext()) {
			File arg9 = (File) arg8.next();
			searchFile(arg9, writer, filter);
		}

	}

	public static void searchFile(File dir, Writer writer, Date from) throws IOException {
		searchFile((File) dir, (Writer) writer, (FilenameFilter) (new FileSearch.DateFileFilter(from)));
	}

	public static List<String> findInFile(String file, List<String> searchKeyList) throws IOException {
		String encoding = "GBK";
		if (file.endsWith(".vm")) {
			encoding = "UTF-8";
		}

		BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
		List fileLines = IOUtils.readLines(is, encoding);
		is.close();
		ArrayList result = new ArrayList();
		Iterator arg5 = searchKeyList.iterator();

		while (true) {
			while (arg5.hasNext()) {
				String key = (String) arg5.next();
				Iterator arg7 = fileLines.iterator();

				while (arg7.hasNext()) {
					String line = (String) arg7.next();
					if (line.contains(key)) {
						result.add(key);
						break;
					}
				}
			}

			return result;
		}
	}

	public static void searchFile(List<String> fileList, String path, final String ext) throws IOException {
		FileFilter filter = new FileFilter() {
			public boolean accept(File pathname) {
				try {
					return pathname.isDirectory() && !pathname.getCanonicalPath().contains(".svn")
							|| pathname.getCanonicalPath().endsWith(ext);
				} catch (IOException arg2) {
					return false;
				}
			}
		};
		File dir = new File(path);
		searchFile(dir, fileList, filter);
	}

	public static void searchFile(File dir, List<String> fileList, FileFilter filter) throws IOException {
		File[] result = dir.listFiles(filter);
		ArrayList dirList = new ArrayList();
		System.out.println("search " + dir.getCanonicalPath() + " ...");
		File[] arg4 = result;
		int f = result.length;

		for (int arg6 = 0; arg6 < f; ++arg6) {
			File f1 = arg4[arg6];
			if (f1.isDirectory()) {
				dirList.add(f1);
			} else {
				fileList.add(f1.getCanonicalPath());
			}
		}

		Iterator arg8 = dirList.iterator();

		while (arg8.hasNext()) {
			File arg9 = (File) arg8.next();
			searchFile(arg9, fileList, filter);
		}

	}

	public static class GenFileFilter implements FilenameFilter {
		private boolean onlyGen;
		private Long from;

		public GenFileFilter(boolean onlyGen, Date from) {
			this.onlyGen = onlyGen;
			this.from = Long.valueOf(from.getTime());
		}

		public boolean accept(File dir, String name) {
			File f = new File(dir, name);
			if (f.isDirectory()) {
				return true;
			} else if (f.lastModified() < this.from.longValue()) {
				return false;
			} else {
				boolean result = StringUtils.startsWith(name, "w") || StringUtils.startsWith(name, "sw")
						|| StringUtils.startsWith(name, "rw");
				return this.onlyGen ? result : !result;
			}
		}
	}

	public static class DateFileFilter implements FilenameFilter {
		private Long from;

		public DateFileFilter(Date from) {
			this.from = Long.valueOf(from.getTime());
		}

		public boolean accept(File dir, String name) {
			File f = new File(dir, name);
			return f.isDirectory() ? true : f.lastModified() > this.from.longValue();
		}
	}
}