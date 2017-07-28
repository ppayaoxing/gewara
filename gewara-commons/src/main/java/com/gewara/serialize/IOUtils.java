/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class IOUtils {
	private static final int BUFFER_SIZE = 8192;

	public static long write(InputStream is, OutputStream os) throws IOException {
		return write((InputStream) is, (OutputStream) os, 8192);
	}

	public static long write(InputStream is, OutputStream os, int bufferSize) throws IOException {
		long total = 0L;
		byte[] buff = new byte[bufferSize];

		while (is.available() > 0) {
			int read = is.read(buff, 0, buff.length);
			if (read > 0) {
				os.write(buff, 0, read);
				total += (long) read;
			}
		}

		return total;
	}

	public static String read(Reader reader) throws IOException {
		StringWriter writer = new StringWriter();

		String arg1;
		try {
			write((Reader) reader, (Writer) writer);
			arg1 = writer.getBuffer().toString();
		} finally {
			writer.close();
		}

		return arg1;
	}

	public static long write(Writer writer, String string) throws IOException {
		StringReader reader = new StringReader(string);

		long arg2;
		try {
			arg2 = write((Reader) reader, (Writer) writer);
		} finally {
			reader.close();
		}

		return arg2;
	}

	public static long write(Reader reader, Writer writer) throws IOException {
		return write((Reader) reader, (Writer) writer, 8192);
	}

	public static long write(Reader reader, Writer writer, int bufferSize) throws IOException {
		long total = 0L;

		int read;
		for (char[] buf = new char[8192]; (read = reader.read(buf)) != -1; total += (long) read) {
			writer.write(buf, 0, read);
		}

		return total;
	}

	public static String[] readLines(File file) throws IOException {
		return file != null && file.exists() && file.canRead() ? readLines((InputStream) (new FileInputStream(file)))
				: new String[0];
	}

	public static String[] readLines(InputStream is) throws IOException {
		ArrayList lines = new ArrayList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String[] arg3;
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			arg3 = (String[]) lines.toArray(new String[0]);
		} finally {
			reader.close();
		}

		return arg3;
	}

	public static void writeLines(OutputStream os, String[] lines) throws IOException {
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));

		try {
			String[] arg2 = lines;
			int arg3 = lines.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				String line = arg2[arg4];
				writer.println(line);
			}

			writer.flush();
		} finally {
			writer.close();
		}
	}

	public static void writeLines(File file, String[] lines) throws IOException {
		if (file == null) {
			throw new IOException("File is null.");
		} else {
			writeLines((OutputStream) (new FileOutputStream(file)), lines);
		}
	}

	public static void appendLines(File file, String[] lines) throws IOException {
		if (file == null) {
			throw new IOException("File is null.");
		} else {
			writeLines((OutputStream) (new FileOutputStream(file, true)), lines);
		}
	}
}