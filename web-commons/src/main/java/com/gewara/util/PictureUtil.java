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
		if (UPLOADTYPE_PIC.equals(type)) {
            return validPicExt.contains(ext);
        }
		if (UPLOADTYPE_FLASH.equals(type)) {
            return validFlashExt.contains(ext);
        }
		if (UPLOADTYPE_MOBILE.equals(type)) {
            return validMobileExt.contains(ext);
        }
		if (UPLOADTYPE_SPORT.equals(type)) {
            return validSportExt.contains(ext);
        }
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
			if (StringUtils.equals("jpeg", result)) {
                return "jpg";
            }
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
	 * @param crop 鏄惁浠庝腑鎴彇
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
	 * 缂╂斁鍥剧墖
	 * 
	 * @param from
	 * @param to
	 * @param maxWidth
	 * @param maxHeight
	 * @param crop 鏄惁浠庝腑鎴彇
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
				//鐩存帴copy鑷硉o
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
			if(info.getImageHeight()<240 || info.getImageWidth() <240) {
                return false;//澶皬鐨勫浘鐗囦笉鍔犳按鍗�
            }
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
	 * 浠庡浘鐗囦腑閮ㄦ埅鍙�
	 * 1锛夊師鍥惧搴︺�侀珮搴﹁�呭皬浜庣洰鏍囷紝鐩存帴杩斿洖鍘熷浘
	 * 2锛夊師鍥惧搴�<鐩爣瀹藉害锛岄珮搴�>鐩爣瀹藉害锛屽瀭鐩存埅鍙栦腑閮�
	 * 3锛夊師鍥惧搴�>鐩爣瀹藉害锛岄珮搴�<鐩爣瀹藉害锛屾按骞虫埅鍙栦腑閮�
	 * 4锛夊師鍥惧搴︺�侀珮搴﹁�呭ぇ浜庣洰鏍囷紝缂╂斁鍚庡啀鎵ц2锛夊拰3锛�
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
			if(srcHeight*width==srcWidth*height){	//绛夋瘮
				dbLogger.warn("identity scale:" + src + "--->dst");
				return resize(src, dst, width, height);
			}
			if(srcHeight < height && srcWidth < width){
				//鐩存帴copy鑷硉o
				FileUtils.copyFile(new File(src), new File(dst));
				return true;
			}
			String tmpSrc = src;
			int x=0, y=0;
			if(srcHeight > height && srcWidth < width){
				y = (srcHeight - height)/2;
			}else if(srcHeight < height && srcWidth > width){
				x = (srcWidth - width)/2;
			}else{//鍋氱缉鏀�
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
				if(!result) {
                    return false;
                }
			}
			return crop(tmpSrc, dst, width, height, x, y);
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * 鑾峰彇鍥剧墖鐨勯暱瀹�
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
	 * 浠庡彧鎴彇閮ㄥ垎
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
	 * 杩斿洖鍘嬬缉姣� 鏂板ぇ灏�/鍘熷ぇ灏�
	 * 
	 * @param srcFilePath
	 * @param descFilePath
	 * @param quality
	 *           杩欓噷鎸囧畾鍘嬬缉鐨勭▼搴︼紝鍙傛暟qality鏄彇鍊�0~1鑼冨洿鍐�
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

		// 鎸囧畾鍐欏浘鐗囩殑鏂瑰紡涓� jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new JPEGImageWriteParam(null);
		// 瑕佷娇鐢ㄥ帇缂╋紝蹇呴』鎸囧畾鍘嬬缉鏂瑰紡涓篗ODE_EXPLICIT
		imgWriteParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
		imgWriteParams.setCompressionQuality(quality * 0.01f);
		imgWriteParams.setProgressiveMode(JPEGImageWriteParam.MODE_DISABLED);
		ColorModel colorModel = ColorModel.getRGBdefault();
		// 鎸囧畾鍘嬬缉鏃朵娇鐢ㄧ殑鑹插僵妯″紡
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		try {
			srcFile = new File(srcFilename);
			destFile = new File(descPath, StringUtil.getFilename(srcFilename));
			long oldLen = srcFile.length();
			src = ImageIO.read(srcFile);
			out = new FileOutputStream(destFile);

			imgWrier.reset();
			// 蹇呴』鍏堟寚瀹� out鍊硷紝鎵嶈兘璋冪敤write鏂规硶, ImageOutputStream鍙互閫氳繃浠讳綍 OutputStream鏋勯��
			imgWrier.setOutput(ImageIO.createImageOutputStream(out));
			// 璋冪敤write鏂规硶锛屽氨鍙互鍚戣緭鍏ユ祦鍐欏浘鐗�
			imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
			out.flush();
			out.close();
			long newLen = destFile.length();
			double r = newLen * 1.1 / (oldLen * 1.1);
			if (callback != null) {
                callback.onComplete(destFile, oldLen, newLen);
            }
			return r;
		} catch (Exception e) {
			dbLogger.error("", e);
			return 1;
		}
	}

	/**
	 * 杩斿洖鍘嬬缉姣� 鏂板ぇ灏�/鍘熷ぇ灏�
	 * 
	 * @param from
	 * @param to
	 * @param quality
	 *           杩欓噷鎸囧畾鍘嬬缉鐨勭▼搴︼紝鍙傛暟qality鏄彇鍊�0~1鑼冨洿鍐�
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
			// 鍔犺浇寰呭鐞嗗浘鐗囨枃浠�
			Image img = ImageIO.read(distFile);
			BufferedImage image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(img, 0, 0, null);
			// 鍔犺浇姘村嵃鍥剧墖鏂囦欢
			Image src_biao = ImageIO.read(warterFile);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, x, y, null);
			g.dispose();
			// 淇濆瓨澶勭悊鍚庣殑鏂囦欢
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
	 * 灏唒ng鍥剧墖杞崲涓簀pg鍥剧墖<br>
	 * 鐩墠鍙畝鍗曞垽鏂璸ngPath鏄惁浠�".png"缁撳熬鏉ョ‘瀹氭槸鍚︽槸png鍥剧墖<br>
	 * 濡傛灉鏄痯ng鍥剧墖锛屽垯杞崲涓簀pg鍥剧墖<br>
	 * 濡傛灉涓嶆槸png鍥剧墖锛岀洿鎺ヨ烦杩囦笉澶勭悊
	 * @param pngPath 寰呰浆鎹㈢殑png鍥剧墖璺緞
	 * @param jpgPath 杞崲鍚庣殑jpg鍥剧墖璺緞
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
