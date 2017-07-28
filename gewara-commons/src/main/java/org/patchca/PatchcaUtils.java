/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import org.patchca.CaptchaUtil;
import org.patchca.background.ComplexBackgroundFactory;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.text.renderer.RandomBestFitTextRenderer;
import org.patchca.word.RandomWordFactory;

public class PatchcaUtils implements CaptchaUtil {
	private ConfigurableCaptchaService cs;
	private static final String defaultCapChar = "ABCDEFGHKLMNPRSTUVXYZacdefhkmnprstuwvxz345789";

	public static PatchcaUtils getSimpleUtils() {
		return new PatchcaUtils(80, 40, 4, 4);
	}

	public static PatchcaUtils getComplexUtils() {
		PatchcaUtils util = new PatchcaUtils(80, 40, 4, 4);
		CurvesRippleFilterFactory crf = new CurvesRippleFilterFactory();
		crf.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		util.cs.addFilterFactory(crf);
		util.cs.setBackgroundFactory(new ComplexBackgroundFactory());
		util.cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		return util;
	}

	public PatchcaUtils(int width, int height, int minLen, int maxLen) {
		this(width, height, minLen, maxLen, "ABCDEFGHKLMNPRSTUVXYZacdefhkmnprstuwvxz345789");
	}

	public PatchcaUtils(int width, int height, int minLen, int maxLen, String capchar) {
		RandomFontFactory ff = new RandomFontFactory();
		this.init(width, height, minLen, maxLen, capchar, ff);
	}

	public PatchcaUtils(int width, int height, int minLen, int maxLen, String capchar, RandomFontFactory ff) {
		this.init(width, height, minLen, maxLen, capchar, ff);
	}

	private void init(int width, int height, int minLen, int maxLen, String capchar, RandomFontFactory ff) {
		this.cs = new ConfigurableCaptchaService();
		this.cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
		RandomWordFactory rwf = new RandomWordFactory();
		rwf.setCharacters(capchar);
		rwf.setMinLength(minLen);
		rwf.setMaxLength(maxLen);
		this.cs.setWordFactory(rwf);
		this.cs.setWidth(width);
		this.cs.setHeight(height);
		ff.setMinSize(30);
		ff.setMaxSize(30);
		this.cs.setFontFactory(ff);
		this.cs.setTextRenderer(new RandomBestFitTextRenderer());
		WobbleRippleFilterFactory filter = new WobbleRippleFilterFactory();
		this.cs.addFilterFactory(filter);
	}

	public Captcha createCaptcha() {
		Captcha captcha = this.cs.getCaptcha();
		return captcha;
	}

	public static void printImage(OutputStream os, BufferedImage bi) throws IOException {
		JPEGImageWriteParam imgWriteParams = new JPEGImageWriteParam((Locale) null);
		imgWriteParams.setCompressionMode(2);
		imgWriteParams.setCompressionQuality(0.6F);
		imgWriteParams.setProgressiveMode(0);
		ColorModel colorModel = ColorModel.getRGBdefault();
		imgWriteParams
				.setDestinationType(new ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));
		ImageWriter imgWrier = (ImageWriter) ImageIO.getImageWritersByFormatName("png").next();
		imgWrier.setOutput(ImageIO.createImageOutputStream(os));
		imgWrier.write((IIOMetadata) null, new IIOImage(bi, (List) null, (IIOMetadata) null), imgWriteParams);
		os.flush();
		os.close();
	}
}