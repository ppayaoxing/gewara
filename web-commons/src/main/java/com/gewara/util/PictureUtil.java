/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.CompressCallback;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.TmpFileUtil;
import com.gewara.util.WebLogger;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.core.Info;

public abstract class PictureUtil {
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(PictureUtil.class);
	private static final List<String> validPicExt = Arrays.asList(new String[]{"jpg", "jpeg", "gif", "png"});
	private static final List<String> validFlashExt = Arrays.asList(new String[]{"swf", "fla"});
	private static final List<String> validMobileExt = Arrays.asList(new String[]{"apk", "ipa"});
	private static final List<String> validSportExt = Arrays.asList(new String[]{"zip"});
	public static final String UPLOADTYPE_PIC = "pic";
	public static final String UPLOADTYPE_FLASH = "flash";
	public static final String UPLOADTYPE_ALL = "all";
	public static final String UPLOADTYPE_MOBILE = "mobile";
	public static final String UPLOADTYPE_SPORT = "sport";

	public static boolean isValidPicExt(String file) {
		return validPicExt.contains(StringUtil.getFilenameExtension(file));
	}

	public static boolean isValidFlashExt(String file) {
		return validFlashExt.contains(StringUtil.getFilenameExtension(file));
	}

	public static boolean isValidExtension(String file, String type) {
		String ext = StringUtil.getFilenameExtension(file);
		return "pic".equals(type) ? validPicExt.contains(ext) : ("flash".equals(type)
				? validFlashExt.contains(ext)
				: ("mobile".equals(type) ? validMobileExt.contains(ext) : ("sport".equals(type)
						? validSportExt.contains(ext)
						: validPicExt.contains(ext) || validFlashExt.contains(ext))));
	}

	public static String getPicFormat(File f) {
		try {
			ImageInputStream e = ImageIO.createImageInputStream(f);
			Iterator iter = ImageIO.getImageReaders(e);
			if (!iter.hasNext()) {
				return null;
			} else {
				ImageReader reader = (ImageReader) iter.next();
				e.close();
				String result = StringUtils.lowerCase(reader.getFormatName());
				return StringUtils.equals("jpeg", result) ? "jpg" : result;
			}
		} catch (Exception arg4) {
			dbLogger.error("", arg4);
			return null;
		}
	}

	public static boolean resize(String srcFile, int maxWidth, int maxHeight, boolean crop) {
		boolean success = false;
		if (crop) {
			success = resizeCrop(srcFile, srcFile + ".tmp", maxWidth, maxHeight);
		} else {
			success = resize(srcFile, srcFile + ".tmp", maxWidth, maxHeight);
		}

		if (success) {
			File file = new File(srcFile);
			TmpFileUtil.deleteFile(file);
			File file2 = new File(srcFile + ".tmp");
			if (file2.exists() && file2.isFile()) {
				file2.renameTo(new File(srcFile));
			}
		}

		return true;
	}

	public static boolean resizeOrCrop(File from, File to, int maxWidth, int maxHeight, boolean crop) {
		try {
			return crop
					? resizeCrop(from.getCanonicalPath(), to.getCanonicalPath(), maxWidth, maxHeight)
					: resize(from.getCanonicalPath(), to.getCanonicalPath(), maxWidth, maxHeight);
		} catch (IOException arg5) {
			return false;
		}
	}

	public static boolean resize(String from, String to, int maxWidth, int maxHeight) {
		try {
			Info convert = new Info(from, true);
			int op = convert.getImageHeight();
			int e = convert.getImageWidth();
			dbLogger.warn(from + op + "," + e + "--->" + maxWidth + "," + maxHeight);
			if (op < maxHeight && e < maxWidth) {
				FileUtils.copyFile(new File(from), new File(to));
				return true;
			}
		} catch (Exception arg7) {
			return false;
		}

		ConvertCmd convert1 = new ConvertCmd();
		IMOperation op1 = new IMOperation();
		op1.resize(Integer.valueOf(maxWidth), Integer.valueOf(maxHeight));
		op1.addImage(new String[]{from});
		op1.addImage(new String[]{to});

		try {
			convert1.run(op1, new Object[0]);
			return true;
		} catch (Exception arg6) {
			dbLogger.error("", arg6);
			return false;
		}
	}

	public static boolean addWaterMark(File src, File dst, File maskPath) {
		try {
			Info e = new Info(src.getCanonicalPath(), true);
			return e.getImageHeight() >= 240 && e.getImageWidth() >= 240
					? addWaterMark(src.getCanonicalPath(), dst.getCanonicalPath(), maskPath.getCanonicalPath())
					: false;
		} catch (Exception arg3) {
			dbLogger.error("", arg3);
			return false;
		}
	}

	public static boolean addWaterMark(String src, String dst, String maskPath) {
		CompositeCmd cmd = new CompositeCmd();
		IMOperation op = new IMOperation();
		op.gravity("southeast");
		op.dissolve(Integer.valueOf(80));
		op.addImage(new String[]{maskPath, src, dst});

		try {
			cmd.run(op, new Object[0]);
			return true;
		} catch (Exception arg5) {
			dbLogger.error("", arg5);
			return false;
		}
	}

	public static boolean limitSize(String filePath, int maxwidth, int maxheight) {
		return limitSize(filePath, filePath, maxwidth, maxheight);
	}

	public static boolean limitSize(String src, String dst, int maxwidth, int maxheight) {
		ConvertCmd convert = new ConvertCmd();
		IMOperation op = new IMOperation();
		op.resize(Integer.valueOf(maxwidth), Integer.valueOf(maxheight), ">");
		op.addImage(new String[]{src});
		op.addImage(new String[]{dst});

		try {
			convert.run(op, new Object[0]);
			return true;
		} catch (Exception arg6) {
			dbLogger.error("", arg6);
			return false;
		}
	}

	public static boolean resizeCrop(String src, String dst, int width, int height) {
		try {
			Info e = new Info(src, true);
			int srcHeight = e.getImageHeight();
			int srcWidth = e.getImageWidth();
			dbLogger.warn(src + srcHeight + "," + srcWidth + "--->" + width + "," + height);
			if (srcHeight * width == srcWidth * height) {
				dbLogger.warn("identity scale:" + src + "--->dst");
				return resize(src, dst, width, height);
			} else if (srcHeight < height && srcWidth < width) {
				FileUtils.copyFile(new File(src), new File(dst));
				return true;
			} else {
				String tmpSrc = src;
				int x = 0;
				int y = 0;
				if (srcHeight > height && srcWidth < width) {
					y = (srcHeight - height) / 2;
				} else if (srcHeight < height && srcWidth > width) {
					x = (srcWidth - width) / 2;
				} else {
					int maxWidth = width;
					int maxHeight = height;
					if ((double) srcHeight * 1.0D / (double) srcWidth >= (double) height * 1.0D / (double) width) {
						maxHeight = srcHeight;
						y = (srcHeight * width / srcWidth - height) / 2;
					} else {
						maxWidth = srcWidth;
						x = (srcWidth * height / srcHeight - width) / 2;
					}

					tmpSrc = StringUtil.getFilepath(src) + "/scale_" + StringUtil.getFilename(src);
					boolean result = resize(src, tmpSrc, maxWidth, maxHeight);
					if (!result) {
						return false;
					}
				}

				return crop(tmpSrc, dst, width, height, x, y);
			}
		} catch (Exception arg12) {
			return false;
		}
	}

	public static String getPicDim(String src) {
		try {
			Info e = new Info(src, true);
			int srcWidth = e.getImageWidth();
			int srcHeight = e.getImageHeight();
			return srcWidth + ":" + srcHeight;
		} catch (Exception arg3) {
			return null;
		}
	}

	public static boolean crop(String src, String dst, int width, int height, int x, int y) {
		ConvertCmd convert = new ConvertCmd();
		IMOperation op = new IMOperation();
		op.crop(Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(x), Integer.valueOf(y));
		op.addImage(new String[]{src});
		op.addImage(new String[]{dst});

		try {
			convert.run(op, new Object[0]);
			return true;
		} catch (Exception arg8) {
			dbLogger.error("", arg8);
			return false;
		}
	}

	public static void compressPic(String srcFilePath, String dstFilePath, int quality, CompressCallback callback) {
		if (StringUtils.containsIgnoreCase(System.getProperty("os.name"), "linux")) {
			compressPicUsingJpegOptim(srcFilePath, dstFilePath, callback);
		} else {
			compressPicUsingJava(srcFilePath, dstFilePath, quality, callback);
		}

	}

	public static void compressPicUsingJpegOptim(String srcFilename, String destPath, final CompressCallback callback) {
		CommandLine cmd = new CommandLine("/usr/local/bin/jpegoptim");
		File srcFile = new File(srcFilename);
		final File destFile = new File(destPath, StringUtil.getFilename(srcFilename));
		cmd.addArgument("--dest=" + destPath);
		cmd.addArgument("--strip-all");
		cmd.addArgument("--max=90");
		cmd.addArgument(srcFilename);
		DefaultExecutor executor = new DefaultExecutor();
		final long oldsize = srcFile.length();
		ExecuteResultHandler resultHandler = new ExecuteResultHandler() {
			public void onProcessComplete(int exitCode) {
				if (callback != null) {
					long newsize = destFile.length();
					callback.onComplete(destFile, oldsize, newsize);
				}

			}

			public void onProcessFailed(ExecuteException e) {
				PictureUtil.dbLogger.error("", e);
				callback.onFailure();
			}
		};

		try {
			executor.execute(cmd, resultHandler);
		} catch (Exception arg10) {
			dbLogger.error("", arg10);
		}

	}

	public static double compressPicUsingJava(String srcFilename, String descPath, int quality,
			CompressCallback callback) {
		File srcFile = null;
		File destFile = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier = (ImageWriter) ImageIO.getImageWritersByFormatName("jpg").next();
		JPEGImageWriteParam imgWriteParams = new JPEGImageWriteParam((Locale) null);
		imgWriteParams.setCompressionMode(2);
		imgWriteParams.setCompressionQuality((float) quality * 0.01F);
		imgWriteParams.setProgressiveMode(0);
		ColorModel colorModel = ColorModel.getRGBdefault();
		imgWriteParams
				.setDestinationType(new ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

		try {
			srcFile = new File(srcFilename);
			destFile = new File(descPath, StringUtil.getFilename(srcFilename));
			long e = srcFile.length();
			src = ImageIO.read(srcFile);
			out = new FileOutputStream(destFile);
			imgWrier.reset();
			imgWrier.setOutput(ImageIO.createImageOutputStream(out));
			imgWrier.write((IIOMetadata) null, new IIOImage(src, (List) null, (IIOMetadata) null), imgWriteParams);
			out.flush();
			out.close();
			long newLen = destFile.length();
			double r = (double) newLen * 1.1D / ((double) e * 1.1D);
			if (callback != null) {
				callback.onComplete(destFile, e, newLen);
			}

			return r;
		} catch (Exception arg16) {
			dbLogger.error("", arg16);
			return 1.0D;
		}
	}

	public static void compressPic(File from, File to, int quality, CompressCallback callback) {
		try {
			compressPic(from.getCanonicalPath(), to.getCanonicalPath(), quality, callback);
		} catch (IOException arg4) {
			dbLogger.error("", arg4);
		}

	}

	public static boolean isValidPicType(String fileType) {
		return validPicExt.contains(fileType);
	}

	public static boolean isValidFlashType(String fileType) {
		return validFlashExt.contains(fileType);
	}

	public static void addWarterMarkUsingJava(String distPath, String warterPath, int x, int y, float alpha) {
		try {
			File e = new File(distPath);
			File warterFile = new File(warterPath);
			BufferedImage img = ImageIO.read(e);
			BufferedImage image = new BufferedImage(img.getWidth((ImageObserver) null),
					img.getHeight((ImageObserver) null), 1);
			Graphics2D g = image.createGraphics();
			g.drawImage(img, 0, 0, (ImageObserver) null);
			BufferedImage src_biao = ImageIO.read(warterFile);
			g.setComposite(AlphaComposite.getInstance(10, alpha));
			g.drawImage(src_biao, x, y, (ImageObserver) null);
			g.dispose();
			FileOutputStream out = new FileOutputStream(e);
			ImageIO.write(image, "jpeg", out);
			out.close();
		} catch (Exception arg11) {
			dbLogger.error("", arg11);
		}

	}

	public static String getCommuPicpath() {
		return "images/" + DateUtil.format(new Date(), "yyyyMM") + "/commu/";
	}

	public static String getAlbumPicpath() {
		return "images/" + DateUtil.format(new Date(), "yyyyMM") + "/album/";
	}

	public static String getHeadPicpath() {
		return "images/" + DateUtil.format(new Date(), "yyyyMM") + "/headpic/";
	}

	public static boolean convertPng2Jpg(String pngPath, String jpgPath) {
		if (StringUtils.endsWith(pngPath, ".png")) {
			ConvertCmd convert = new ConvertCmd();
			IMOperation op = new IMOperation();
			op.addImage(new String[]{pngPath});
			op.addImage(new String[]{jpgPath});

			try {
				convert.run(op, new Object[0]);
				return true;
			} catch (Exception arg4) {
				dbLogger.error("", arg4);
				return false;
			}
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		String src = "D:\\pictest\\a.png";
		String des = "D:\\pictest\\b.jpg";
		convertPng2Jpg(src, des);
	}
}