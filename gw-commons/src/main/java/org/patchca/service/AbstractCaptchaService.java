/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.service;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.patchca.background.BackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.filter.FilterFactory;
import org.patchca.font.FontFactory;
import org.patchca.service.Captcha;
import org.patchca.text.renderer.TextRenderer;
import org.patchca.word.WordFactory;

public abstract class AbstractCaptchaService {
	protected FontFactory fontFactory;
	protected WordFactory wordFactory;
	protected ColorFactory colorFactory;
	protected BackgroundFactory backgroundFactory;
	protected TextRenderer textRenderer;
	protected List<FilterFactory> filterFactoryList = new ArrayList();
	protected int width;
	protected int height;

	public void setFontFactory(FontFactory fontFactory) {
		this.fontFactory = fontFactory;
	}

	public void setWordFactory(WordFactory wordFactory) {
		this.wordFactory = wordFactory;
	}

	public void setColorFactory(ColorFactory colorFactory) {
		this.colorFactory = colorFactory;
	}

	public void setBackgroundFactory(BackgroundFactory backgroundFactory) {
		this.backgroundFactory = backgroundFactory;
	}

	public void setTextRenderer(TextRenderer textRenderer) {
		this.textRenderer = textRenderer;
	}

	public void addFilterFactory(FilterFactory filterFactory) {
		this.filterFactoryList.add(filterFactory);
	}

	public FontFactory getFontFactory() {
		return this.fontFactory;
	}

	public WordFactory getWordFactory() {
		return this.wordFactory;
	}

	public ColorFactory getColorFactory() {
		return this.colorFactory;
	}

	public BackgroundFactory getBackgroundFactory() {
		return this.backgroundFactory;
	}

	public TextRenderer getTextRenderer() {
		return this.textRenderer;
	}

	public List<FilterFactory> getFilterFactory() {
		return this.filterFactoryList;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Captcha getCaptcha() {
		BufferedImage bufImage = new BufferedImage(this.width, this.height, 1);
		this.backgroundFactory.fillBackground(bufImage);
		String word = this.wordFactory.getNextWord();
		this.textRenderer.draw(word, bufImage, this.fontFactory, this.colorFactory);

		FilterFactory factory;
		for (Iterator arg2 = this.filterFactoryList.iterator(); arg2
				.hasNext(); bufImage = factory.applyFilters(bufImage)) {
			factory = (FilterFactory) arg2.next();
		}

		return new Captcha(word, bufImage);
	}
}