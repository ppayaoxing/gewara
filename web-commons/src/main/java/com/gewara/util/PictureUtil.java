package com.gewara.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
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
	private static final List<String> validPicExt = Arrays.asList("jpg", "jpeg", "gif", "png");
	private static final List<String> validFlashExt = Arrays.asList("swf", "fla");
	private static final List<String> validMobileExt = Arrays.asList("apk","ipa");
	private static final List<String> validSportExt = Arrays.asList("zip");
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
		if (UPLOADTYPE_PIC.equals(type))
			return validPicExt.contains(ext);
		if (UPLOADTYPE_FLASH.equals(type))
			return validFlashExt.contains(ext);
		if (UPLOADTYPE_MOBILE.equals(type))
			return validMobileExt.contains(ext);
		if (UPLOADTYPE_SPORT.equals(type))
			return validSportExt.contains(ext);
		return validPicExt.contains(ext) || validFlashExt.contains(ext);
	}

	public static String getPicFormat(File f) {
		try {
			ImageInputStream iis = ImageIO.createImageInputStream(f);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				return null;
			}
			ImageReader reader = iter.next();
			iis.close();
			String result = StringUtils.lowerCase(reader.getFormatName());
			if (StringUtils.equals("jpeg", result))
				return "jpg";
			return result;
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return null;
	}

	/**
	 * @param srcFile
	 * @param maxWidth
	 * @param maxHeight
	 * @param crop 是否从中截取
	 * @return
	 */
	public static boolean resize(String srcFile, int maxWidth, int maxHeight, boolean crop) {
		boolean success = false;
		if(crop){
			success = resizeCrop(srcFile, srcFile + ".tmp", maxWidth, maxHeight);
		}else{
			success = resize(srcFile, srcFile + ".tmp", maxWidth, maxHeight);
		}
		if (success) {
			File file = new File(srcFile);
			TmpFileUtil.deleteFile(file);
			File file2 = new File(srcFile + ".tmp");
			if(file2.exists() && file2.isFile()){
				file2.renameTo(new File(srcFile));
			}
		}
		return true;
	}

	/**
	 * 缩放图片
	 * 
	 * @param from
	 * @param to
	 * @param maxWidth
	 * @param maxHeight
	 * @param crop 是否从中截取
	 * @return
	 */
	public static boolean resizeOrCrop(File from, File to, int maxWidth, int maxHeight, boolean crop) {
		try {
			if(crop){
				return resizeCrop(from.getCanonicalPath(), to.getCanonicalPath(), maxWidth, maxHeight);
			}
			return resize(from.getCanonicalPath(), to.getCanonicalPath(), maxWidth, maxHeight);
		} catch (IOException e) {
			return false;
		}
	}

	public static boolean resize(String from, String to, int maxWidth, int maxHeight) {
		try{
			Info imageInfo = new Info(from, true);
			int srcHeight = imageInfo.getImageHeight();
			int srcWidth = imageInfo.getImageWidth();
			dbLogger.warn(from + srcHeight + "," + srcWidth + "--->" + maxWidth + "," + maxHeight);
			if(srcHeight < maxHeight && srcWidth < maxWidth){
				//直接copy至to
				FileUtils.copyFile(new File(from), new File(to));
				return true;
			}
		}catch(Exception e){
			return false;
		}
		ConvertCmd convert = new ConvertCmd();
		IMOperation op = new IMOperation();
		op.resize(maxWidth, maxHeight);
		op.addImage(from);
		op.addImage(to);
		try {
			convert.run(op);
			return true;
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return false;
	}
	public static boolean addWaterMark(File src, File dst, File maskPath) {
		try {
			Info info = new Info(src.getCanonicalPath(), true);
			if(info.getImageHeight()<240 || info.getImageWidth() <240) return false;//太小的图片不加水印
			return addWaterMark(src.getCanonicalPath(), dst.getCanonicalPath(), maskPath.getCanonicalPath());
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return false;
	}

	public static boolean addWaterMark(String src, String dst, String maskPath) {
		CompositeCmd cmd = new CompositeCmd();
		IMOperation op = new IMOperation();
		op.gravity("southeast");
		op.dissolve(80);
		op.addImage(maskPath, src, dst);
		try {
			cmd.run(op);
			return true;
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return false;
	}

	/**
	 * @param filePath
	 * @param width
	 * @param height
	 * @param onlyScallBig
	 */
	public static boolean limitSize(String filePath, int maxwidth, int maxheight) {
		return limitSize(filePath, filePath, maxwidth, maxheight);
	}

	public static boolean limitSize(String src, String dst, int maxwidth, int maxheight) {
		ConvertCmd convert = new ConvertCmd();
		IMOperation op = new IMOperation();
		op.resize(maxwidth, maxheight, ">");
		op.addImage(src);
		op.addImage(dst);
		try {
			convert.run(op);
			return true;
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return false;
	}
	/**
	 * 从图片中部截取
	 * 1）原图宽度、高度者小于目标，直接返回原图
	 * 2）原图宽度<目标宽度，高度>目标宽度，垂直截取中部
	 * 3）原图宽度>目标宽度，高度<目标宽度，水平截取中部
	 * 4）原图宽度、高度者大于目标，缩放后再执行2）和3）
	 * @param src
	 * @param dst
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean resizeCrop(String src, String dst, int width, int height) {
		try{
			Info imageInfo = new Info(src, true);
			int srcHeight = imageInfo.getImageHeight();
			int srcWidth = imageInfo.getImageWidth();
			dbLogger.warn(src + srcHeight + "," + srcWidth + "--->" + width + "," +  height);
			if(srcHeight*width==srcWidth*height){	//等比
				dbLogger.warn("identity scale:" + src + "--->dst");
				return resize(src, dst, width, height);
			}
			if(srcHeight < height && srcWidth < width){
				//直接copy至to
				FileUtils.copyFile(new File(src), new File(dst));
				return true;
			}
			String tmpSrc = src;
			int x=0, y=0;
			if(srcHeight > height && srcWidth < width){
				y = (srcHeight - height)/2;
			}else if(srcHeight < height && srcWidth > width){
				x = (srcWidth - width)/2;
			}else{//做缩放
				int maxWidth = width, maxHeight = height;
				if(srcHeight*1.0/srcWidth >= height*1.0/width){
					maxHeight = srcHeight;
					y = (srcHeight*width/srcWidth - height)/2;
				}else{
					maxWidth = srcWidth;
					x = (srcWidth*height/srcHeight - width)/2;
				}
				tmpSrc = StringUtil.getFilepath(src) + "/scale_" + StringUtil.getFilename(src); 
				boolean result = resize(src, tmpSrc, maxWidth, maxHeight);
				if(!result) return false;
			}
			return crop(tmpSrc, dst, width, height, x, y);
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * 获取图片的长宽
	 * @param src
	 * @return
	 */
	public static String getPicDim(String src){
		try{
			Info imageInfo = new Info(src, true);
			int srcWidth = imageInfo.getImageWidth();
			int srcHeight = imageInfo.getImageHeight();
			return srcWidth + ":" + srcHeight;
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 从只截取部分
	 * @param src
	 * @param dst
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean crop(String src, String dst, int width, int height, int x, int y) {
		ConvertCmd convert = new ConvertCmd();
		IMOperation op = new IMOperation();
		op.crop(width, height, x, y);
		op.addImage(src);
		op.addImage(dst);
		try {
			convert.run(op);
			return true;
		} catch (Exception e) {
			dbLogger.error("", e);
		}
		return false;
	}

	/**
	 * 返回压缩比 新大小/原大小
	 * 
	 * @param srcFilePath
	 * @param descFilePath
	 * @param quality
	 *           这里指定压缩的程度，参数qality是取值0~1范围内
	 * @return
	 */
	public static void compressPic(String srcFilePath, String dstFilePath, int quality, CompressCallback callback) {
		if (StringUtils.containsIgnoreCase(System.getProperty("os.name"), "linux")) {
			compressPicUsingJpegOptim(srcFilePath, dstFilePath, callback);// ignore quality
		} else {
			compressPicUsingJava(srcFilePath, dstFilePath, quality, callback);
		}

	}

	public static void compressPicUsingJpegOptim(String srcFilename, String destPath, final CompressCallback callback) {
		CommandLine cmd = new CommandLine("/usr/local/bin/jpegoptim");
		final File srcFile = new File(srcFilename);
		final File destFile = new File(destPath, StringUtil.getFilename(srcFilename));
		cmd.addArgument("--dest=" + destPath);
		cmd.addArgument("--strip-all");
		cmd.addArgument("--max=90");
		cmd.addArgument(srcFilename);
		DefaultExecutor executor = new DefaultExecutor();
		final long oldsize = srcFile.length();
		ExecuteResultHandler resultHandler = new ExecuteResultHandler() {
			@Override
			public void onProcessComplete(int exitCode) {
				if (callback != null) {
					long newsize = destFile.length();
					callback.onComplete(destFile, oldsize, newsize);
				}
			}

			@Override
			public void onProcessFailed(ExecuteException e) {
				dbLogger.error("", e);
				callback.onFailure();
			}
		};
		try {
			executor.execute(cmd, resultHandler);
		} catch (Exception e) {
			dbLogger.error("", e);
		}
	}

	public static double compressPicUsingJava(String srcFilename, String descPath, int quality, CompressCallback callback) {
		File srcFile = null, destFile = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;

		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
		imgWriteParams.setCompressionQuality(quality * 0.01f);
		imgWriteParams.setProgressiveMode(JPEGImageWriteParam.MODE_DISABLED);
		ColorModel colorModel = ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		try {
			srcFile = new File(srcFilename);
			destFile = new File(descPath, StringUtil.getFilename(srcFilename));
			long oldLen = srcFile.length();
			src = ImageIO.read(srcFile);
			out = new FileOutputStream(destFile);

			imgWrier.reset();
			// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
			imgWrier.setOutput(ImageIO.createImageOutputStream(out));
			// 调用write方法，就可以向输入流写图片
			imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
			out.flush();
			out.close();
			long newLen = destFile.length();
			double r = newLen * 1.1 / (oldLen * 1.1);
			if (callback != null)
				callback.onComplete(destFile, oldLen, newLen);
			return r;
		} catch (Exception e) {
			dbLogger.error("", e);
			return 1;
		}
	}

	/**
	 * 返回压缩比 新大小/原大小
	 * 
	 * @param from
	 * @param to
	 * @param quality
	 *           这里指定压缩的程度，参数qality是取值0~1范围内
	 * @return
	 */
	public static void compressPic(File from, File to, int quality, CompressCallback callback) {
		try {
			compressPic(from.getCanonicalPath(), to.getCanonicalPath(), quality, callback);
		} catch (IOException e) {
			dbLogger.error("", e);
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
			File distFile = new File(distPath);
			File warterFile = new File(warterPath);
			// 加载待处理图片文件
			Image img = ImageIO.read(distFile);
			BufferedImage image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(img, 0, 0, null);
			// 加载水印图片文件
			Image src_biao = ImageIO.read(warterFile);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, x, y, null);
			g.dispose();
			// 保存处理后的文件
			FileOutputStream out = new FileOutputStream(distFile);
			ImageIO.write(image, "jpeg", out);
			out.close();
		} catch (Exception e) {
			dbLogger.error("", e);
		}
	}
	public static String getCommuPicpath() {
		return "images/"+ DateUtil.format(new Date(), "yyyyMM") +"/commu/";
	}
	public static String getAlbumPicpath() {
		return "images/"+ DateUtil.format(new Date(), "yyyyMM") +"/album/";
	}
	public static String getHeadPicpath() {
		return "images/"+ DateUtil.format(new Date(), "yyyyMM") +"/headpic/";
	}
	
	/**
	 * 将png图片转换为jpg图片<br>
	 * 目前只简单判断pngPath是否以".png"结尾来确定是否是png图片<br>
	 * 如果是png图片，则转换为jpg图片<br>
	 * 如果不是png图片，直接跳过不处理
	 * @param pngPath 待转换的png图片路径
	 * @param jpgPath 转换后的jpg图片路径
	 * @return true/false
	 */
	public static boolean convertPng2Jpg(String pngPath, String jpgPath){
		if(StringUtils.endsWith(pngPath, ".png")){
			ConvertCmd convert = new ConvertCmd();
			IMOperation op = new IMOperation();
			op.addImage(pngPath);
			op.addImage(jpgPath);
			try {
				convert.run(op);
				return true;
			} catch (Exception e) {
				dbLogger.error("", e);
			}
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String src = "D:\\pictest\\a.png";
		String des = "D:\\pictest\\b.jpg";
		convertPng2Jpg(src, des);
	}

}
