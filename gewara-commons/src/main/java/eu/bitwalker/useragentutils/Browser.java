/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package eu.bitwalker.useragentutils;

import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.Manufacturer;
import eu.bitwalker.useragentutils.RenderingEngine;
import eu.bitwalker.useragentutils.Utils;
import eu.bitwalker.useragentutils.Version;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Browser {
	OUTLOOK(Manufacturer.MICROSOFT, (Browser) null, 100, "Outlook", new String[] { "MSOffice" }, (String[]) null,
			BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, "MSOffice (([0-9]+))"), OUTLOOK2007(Manufacturer.MICROSOFT,
					OUTLOOK, 107, "Outlook 2007", new String[] { "MSOffice 12" }, (String[]) null,
					BrowserType.EMAIL_CLIENT, RenderingEngine.WORD, (String) null), OUTLOOK2013(Manufacturer.MICROSOFT,
							OUTLOOK, 109, "Outlook 2013", new String[] { "Microsoft Outlook 15" }, (String[]) null,
							BrowserType.EMAIL_CLIENT, RenderingEngine.WORD,
							(String) null), OUTLOOK2010(Manufacturer.MICROSOFT, OUTLOOK, 108, "Outlook 2010",
									new String[] { "MSOffice 14", "Microsoft Outlook 14" }, (String[]) null,
									BrowserType.EMAIL_CLIENT, RenderingEngine.WORD,
									(String) null), IE(Manufacturer.MICROSOFT, (Browser) null, 1, "Internet Explorer",
											new String[] { "MSIE", "Trident", "IE " },
											new String[] { "BingPreview", "Xbox", "Xbox One" }, BrowserType.WEB_BROWSER,
											RenderingEngine.TRIDENT,
											"MSIE (([\\d]+)\\.([\\w]+))"), OUTLOOK_EXPRESS7(Manufacturer.MICROSOFT, IE,
													110, "Windows Live Mail", new String[] { "Outlook-Express/7.0" },
													(String[]) null, BrowserType.EMAIL_CLIENT, RenderingEngine.TRIDENT,
													(String) null), IEMOBILE11(Manufacturer.MICROSOFT, IE, 125,
															"IE Mobile 11", new String[] { "IEMobile/11" },
															(String[]) null, BrowserType.MOBILE_BROWSER,
															RenderingEngine.TRIDENT, (String) null), IEMOBILE10(
																	Manufacturer.MICROSOFT, IE, 124, "IE Mobile 10",
																	new String[] { "IEMobile/10" }, (String[]) null,
																	BrowserType.MOBILE_BROWSER, RenderingEngine.TRIDENT,
																	(String) null), IEMOBILE9(Manufacturer.MICROSOFT,
																			IE, 123, "IE Mobile 9",
																			new String[] { "IEMobile/9" },
																			(String[]) null, BrowserType.MOBILE_BROWSER,
																			RenderingEngine.TRIDENT,
																			(String) null), IEMOBILE7(
																					Manufacturer.MICROSOFT, IE, 121,
																					"IE Mobile 7",
																					new String[] { "IEMobile 7" },
																					(String[]) null,
																					BrowserType.MOBILE_BROWSER,
																					RenderingEngine.TRIDENT,
																					(String) null), IEMOBILE6(
																							Manufacturer.MICROSOFT, IE,
																							120, "IE Mobile 6",
																							new String[] {
																									"IEMobile 6" },
																							(String[]) null,
																							BrowserType.MOBILE_BROWSER,
																							RenderingEngine.TRIDENT,
																							(String) null), IE_XBOX(
																									Manufacturer.MICROSOFT,
																									IE, 360, "Xbox",
																									new String[] {
																											"xbox" },
																									new String[0],
																									BrowserType.WEB_BROWSER,
																									RenderingEngine.TRIDENT,
																									(String) null), IE11(
																											Manufacturer.MICROSOFT,
																											IE, 95,
																											"Internet Explorer 11",
																											new String[] {
																													"Trident/7",
																													"IE 11." },
																											new String[] {
																													"MSIE 7",
																													"BingPreview" },
																											BrowserType.WEB_BROWSER,
																											RenderingEngine.TRIDENT,
																											"(?:Trident\\/7|IE)(?:\\.[0-9]*;)?(?:.*rv:| )(([0-9]+)\\.?([0-9]+))"), IE10(
																													Manufacturer.MICROSOFT,
																													IE,
																													92,
																													"Internet Explorer 10",
																													new String[] {
																															"MSIE 10" },
																													(String[]) null,
																													BrowserType.WEB_BROWSER,
																													RenderingEngine.TRIDENT,
																													(String) null), IE9(
																															Manufacturer.MICROSOFT,
																															IE,
																															90,
																															"Internet Explorer 9",
																															new String[] {
																																	"MSIE 9" },
																															(String[]) null,
																															BrowserType.WEB_BROWSER,
																															RenderingEngine.TRIDENT,
																															(String) null), IE8(
																																	Manufacturer.MICROSOFT,
																																	IE,
																																	80,
																																	"Internet Explorer 8",
																																	new String[] {
																																			"MSIE 8" },
																																	(String[]) null,
																																	BrowserType.WEB_BROWSER,
																																	RenderingEngine.TRIDENT,
																																	(String) null), IE7(
																																			Manufacturer.MICROSOFT,
																																			IE,
																																			70,
																																			"Internet Explorer 7",
																																			new String[] {
																																					"MSIE 7" },
																																			(String[]) null,
																																			BrowserType.WEB_BROWSER,
																																			RenderingEngine.TRIDENT,
																																			(String) null), IE6(
																																					Manufacturer.MICROSOFT,
																																					IE,
																																					60,
																																					"Internet Explorer 6",
																																					new String[] {
																																							"MSIE 6" },
																																					(String[]) null,
																																					BrowserType.WEB_BROWSER,
																																					RenderingEngine.TRIDENT,
																																					(String) null), IE5_5(
																																							Manufacturer.MICROSOFT,
																																							IE,
																																							55,
																																							"Internet Explorer 5.5",
																																							new String[] {
																																									"MSIE 5.5" },
																																							(String[]) null,
																																							BrowserType.WEB_BROWSER,
																																							RenderingEngine.TRIDENT,
																																							(String) null), IE5(
																																									Manufacturer.MICROSOFT,
																																									IE,
																																									50,
																																									"Internet Explorer 5",
																																									new String[] {
																																											"MSIE 5" },
																																									(String[]) null,
																																									BrowserType.WEB_BROWSER,
																																									RenderingEngine.TRIDENT,
																																									(String) null), EDGE(
																																											Manufacturer.MICROSOFT,
																																											(Browser) null,
																																											300,
																																											"Microsoft Edge",
																																											new String[] {
																																													"Edge" },
																																											(String[]) null,
																																											BrowserType.WEB_BROWSER,
																																											RenderingEngine.EDGE_HTML,
																																											"(?:Edge\\/((12)\\.([0-9]*)))"), EDGE12(
																																													Manufacturer.MICROSOFT,
																																													EDGE,
																																													301,
																																													"Microsoft Edge",
																																													new String[] {
																																															"Edge/12" },
																																													new String[] {
																																															"Mobile" },
																																													BrowserType.WEB_BROWSER,
																																													RenderingEngine.EDGE_HTML,
																																													"(?:Edge\\/((12)\\.([0-9]*)))"), EDGE_MOBILE12(
																																															Manufacturer.MICROSOFT,
																																															EDGE,
																																															302,
																																															"Microsoft Edge Mobile",
																																															new String[] {
																																																	"Mobile Safari",
																																																	"Edge/12" },
																																															(String[]) null,
																																															BrowserType.MOBILE_BROWSER,
																																															RenderingEngine.EDGE_HTML,
																																															"(?:Edge\\/((12)\\.([0-9]*)))"), CHROME(
																																																	Manufacturer.GOOGLE,
																																																	(Browser) null,
																																																	1,
																																																	"Chrome",
																																																	new String[] {
																																																			"Chrome",
																																																			"CrMo",
																																																			"CriOS" },
																																																	new String[] {
																																																			"OPR/",
																																																			"Web Preview",
																																																			"Vivaldi" },
																																																	BrowserType.WEB_BROWSER,
																																																	RenderingEngine.WEBKIT,
																																																	"Chrome\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), CHROME_MOBILE(
																																																			Manufacturer.GOOGLE,
																																																			CHROME,
																																																			100,
																																																			"Chrome Mobile",
																																																			new String[] {
																																																					"CrMo",
																																																					"CriOS",
																																																					"Mobile Safari" },
																																																			new String[] {
																																																					"OPR/" },
																																																			BrowserType.MOBILE_BROWSER,
																																																			RenderingEngine.WEBKIT,
																																																			"(?:CriOS|CrMo|Chrome)\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), CHROME46(
																																																					Manufacturer.GOOGLE,
																																																					CHROME,
																																																					51,
																																																					"Chrome 46",
																																																					new String[] {
																																																							"Chrome/46" },
																																																					new String[] {
																																																							"OPR/",
																																																							"Web Preview",
																																																							"Vivaldi" },
																																																					BrowserType.WEB_BROWSER,
																																																					RenderingEngine.WEBKIT,
																																																					(String) null), CHROME45(
																																																							Manufacturer.GOOGLE,
																																																							CHROME,
																																																							50,
																																																							"Chrome 45",
																																																							new String[] {
																																																									"Chrome/45" },
																																																							new String[] {
																																																									"OPR/",
																																																									"Web Preview",
																																																									"Vivaldi" },
																																																							BrowserType.WEB_BROWSER,
																																																							RenderingEngine.WEBKIT,
																																																							(String) null), CHROME44(
																																																									Manufacturer.GOOGLE,
																																																									CHROME,
																																																									49,
																																																									"Chrome 44",
																																																									new String[] {
																																																											"Chrome/44" },
																																																									new String[] {
																																																											"OPR/",
																																																											"Web Preview",
																																																											"Vivaldi" },
																																																									BrowserType.WEB_BROWSER,
																																																									RenderingEngine.WEBKIT,
																																																									(String) null), CHROME43(
																																																											Manufacturer.GOOGLE,
																																																											CHROME,
																																																											48,
																																																											"Chrome 43",
																																																											new String[] {
																																																													"Chrome/43" },
																																																											new String[] {
																																																													"OPR/",
																																																													"Web Preview",
																																																													"Vivaldi" },
																																																											BrowserType.WEB_BROWSER,
																																																											RenderingEngine.WEBKIT,
																																																											(String) null), CHROME42(
																																																													Manufacturer.GOOGLE,
																																																													CHROME,
																																																													47,
																																																													"Chrome 42",
																																																													new String[] {
																																																															"Chrome/42" },
																																																													new String[] {
																																																															"OPR/",
																																																															"Web Preview",
																																																															"Vivaldi" },
																																																													BrowserType.WEB_BROWSER,
																																																													RenderingEngine.WEBKIT,
																																																													(String) null), CHROME41(
																																																															Manufacturer.GOOGLE,
																																																															CHROME,
																																																															46,
																																																															"Chrome 41",
																																																															new String[] {
																																																																	"Chrome/41" },
																																																															new String[] {
																																																																	"OPR/",
																																																																	"Web Preview",
																																																																	"Vivaldi" },
																																																															BrowserType.WEB_BROWSER,
																																																															RenderingEngine.WEBKIT,
																																																															(String) null), CHROME40(
																																																																	Manufacturer.GOOGLE,
																																																																	CHROME,
																																																																	45,
																																																																	"Chrome 40",
																																																																	new String[] {
																																																																			"Chrome/40" },
																																																																	new String[] {
																																																																			"OPR/",
																																																																			"Web Preview",
																																																																			"Vivaldi" },
																																																																	BrowserType.WEB_BROWSER,
																																																																	RenderingEngine.WEBKIT,
																																																																	(String) null), CHROME39(
																																																																			Manufacturer.GOOGLE,
																																																																			CHROME,
																																																																			44,
																																																																			"Chrome 39",
																																																																			new String[] {
																																																																					"Chrome/39" },
																																																																			new String[] {
																																																																					"OPR/",
																																																																					"Web Preview" },
																																																																			BrowserType.WEB_BROWSER,
																																																																			RenderingEngine.WEBKIT,
																																																																			(String) null), CHROME38(
																																																																					Manufacturer.GOOGLE,
																																																																					CHROME,
																																																																					43,
																																																																					"Chrome 38",
																																																																					new String[] {
																																																																							"Chrome/38" },
																																																																					new String[] {
																																																																							"OPR/",
																																																																							"Web Preview" },
																																																																					BrowserType.WEB_BROWSER,
																																																																					RenderingEngine.WEBKIT,
																																																																					(String) null), CHROME37(
																																																																							Manufacturer.GOOGLE,
																																																																							CHROME,
																																																																							42,
																																																																							"Chrome 37",
																																																																							new String[] {
																																																																									"Chrome/37" },
																																																																							new String[] {
																																																																									"OPR/",
																																																																									"Web Preview" },
																																																																							BrowserType.WEB_BROWSER,
																																																																							RenderingEngine.WEBKIT,
																																																																							(String) null), CHROME36(
																																																																									Manufacturer.GOOGLE,
																																																																									CHROME,
																																																																									41,
																																																																									"Chrome 36",
																																																																									new String[] {
																																																																											"Chrome/36" },
																																																																									new String[] {
																																																																											"OPR/",
																																																																											"Web Preview" },
																																																																									BrowserType.WEB_BROWSER,
																																																																									RenderingEngine.WEBKIT,
																																																																									(String) null), CHROME35(
																																																																											Manufacturer.GOOGLE,
																																																																											CHROME,
																																																																											40,
																																																																											"Chrome 35",
																																																																											new String[] {
																																																																													"Chrome/35" },
																																																																											new String[] {
																																																																													"OPR/",
																																																																													"Web Preview" },
																																																																											BrowserType.WEB_BROWSER,
																																																																											RenderingEngine.WEBKIT,
																																																																											(String) null), CHROME34(
																																																																													Manufacturer.GOOGLE,
																																																																													CHROME,
																																																																													39,
																																																																													"Chrome 34",
																																																																													new String[] {
																																																																															"Chrome/34" },
																																																																													new String[] {
																																																																															"OPR/",
																																																																															"Web Preview" },
																																																																													BrowserType.WEB_BROWSER,
																																																																													RenderingEngine.WEBKIT,
																																																																													(String) null), CHROME33(
																																																																															Manufacturer.GOOGLE,
																																																																															CHROME,
																																																																															38,
																																																																															"Chrome 33",
																																																																															new String[] {
																																																																																	"Chrome/33" },
																																																																															new String[] {
																																																																																	"OPR/",
																																																																																	"Web Preview" },
																																																																															BrowserType.WEB_BROWSER,
																																																																															RenderingEngine.WEBKIT,
																																																																															(String) null), CHROME32(
																																																																																	Manufacturer.GOOGLE,
																																																																																	CHROME,
																																																																																	37,
																																																																																	"Chrome 32",
																																																																																	new String[] {
																																																																																			"Chrome/32" },
																																																																																	new String[] {
																																																																																			"OPR/",
																																																																																			"Web Preview" },
																																																																																	BrowserType.WEB_BROWSER,
																																																																																	RenderingEngine.WEBKIT,
																																																																																	(String) null), CHROME31(
																																																																																			Manufacturer.GOOGLE,
																																																																																			CHROME,
																																																																																			36,
																																																																																			"Chrome 31",
																																																																																			new String[] {
																																																																																					"Chrome/31" },
																																																																																			new String[] {
																																																																																					"OPR/",
																																																																																					"Web Preview" },
																																																																																			BrowserType.WEB_BROWSER,
																																																																																			RenderingEngine.WEBKIT,
																																																																																			(String) null), CHROME30(
																																																																																					Manufacturer.GOOGLE,
																																																																																					CHROME,
																																																																																					35,
																																																																																					"Chrome 30",
																																																																																					new String[] {
																																																																																							"Chrome/30" },
																																																																																					new String[] {
																																																																																							"OPR/",
																																																																																							"Web Preview" },
																																																																																					BrowserType.WEB_BROWSER,
																																																																																					RenderingEngine.WEBKIT,
																																																																																					(String) null), CHROME29(
																																																																																							Manufacturer.GOOGLE,
																																																																																							CHROME,
																																																																																							34,
																																																																																							"Chrome 29",
																																																																																							new String[] {
																																																																																									"Chrome/29" },
																																																																																							new String[] {
																																																																																									"OPR/",
																																																																																									"Web Preview" },
																																																																																							BrowserType.WEB_BROWSER,
																																																																																							RenderingEngine.WEBKIT,
																																																																																							(String) null), CHROME28(
																																																																																									Manufacturer.GOOGLE,
																																																																																									CHROME,
																																																																																									33,
																																																																																									"Chrome 28",
																																																																																									new String[] {
																																																																																											"Chrome/28" },
																																																																																									new String[] {
																																																																																											"OPR/",
																																																																																											"Web Preview" },
																																																																																									BrowserType.WEB_BROWSER,
																																																																																									RenderingEngine.WEBKIT,
																																																																																									(String) null), CHROME27(
																																																																																											Manufacturer.GOOGLE,
																																																																																											CHROME,
																																																																																											32,
																																																																																											"Chrome 27",
																																																																																											new String[] {
																																																																																													"Chrome/27" },
																																																																																											new String[] {
																																																																																													"OPR/",
																																																																																													"Web Preview" },
																																																																																											BrowserType.WEB_BROWSER,
																																																																																											RenderingEngine.WEBKIT,
																																																																																											(String) null), CHROME26(
																																																																																													Manufacturer.GOOGLE,
																																																																																													CHROME,
																																																																																													31,
																																																																																													"Chrome 26",
																																																																																													new String[] {
																																																																																															"Chrome/26" },
																																																																																													new String[] {
																																																																																															"OPR/",
																																																																																															"Web Preview" },
																																																																																													BrowserType.WEB_BROWSER,
																																																																																													RenderingEngine.WEBKIT,
																																																																																													(String) null), CHROME25(
																																																																																															Manufacturer.GOOGLE,
																																																																																															CHROME,
																																																																																															30,
																																																																																															"Chrome 25",
																																																																																															new String[] {
																																																																																																	"Chrome/25" },
																																																																																															new String[] {
																																																																																																	"OPR/",
																																																																																																	"Web Preview" },
																																																																																															BrowserType.WEB_BROWSER,
																																																																																															RenderingEngine.WEBKIT,
																																																																																															(String) null), CHROME24(
																																																																																																	Manufacturer.GOOGLE,
																																																																																																	CHROME,
																																																																																																	29,
																																																																																																	"Chrome 24",
																																																																																																	new String[] {
																																																																																																			"Chrome/24" },
																																																																																																	new String[] {
																																																																																																			"OPR/",
																																																																																																			"Web Preview" },
																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																	RenderingEngine.WEBKIT,
																																																																																																	(String) null), CHROME23(
																																																																																																			Manufacturer.GOOGLE,
																																																																																																			CHROME,
																																																																																																			28,
																																																																																																			"Chrome 23",
																																																																																																			new String[] {
																																																																																																					"Chrome/23" },
																																																																																																			new String[] {
																																																																																																					"OPR/",
																																																																																																					"Web Preview" },
																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																			RenderingEngine.WEBKIT,
																																																																																																			(String) null), CHROME22(
																																																																																																					Manufacturer.GOOGLE,
																																																																																																					CHROME,
																																																																																																					27,
																																																																																																					"Chrome 22",
																																																																																																					new String[] {
																																																																																																							"Chrome/22" },
																																																																																																					new String[] {
																																																																																																							"OPR/",
																																																																																																							"Web Preview" },
																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																					RenderingEngine.WEBKIT,
																																																																																																					(String) null), CHROME21(
																																																																																																							Manufacturer.GOOGLE,
																																																																																																							CHROME,
																																																																																																							26,
																																																																																																							"Chrome 21",
																																																																																																							new String[] {
																																																																																																									"Chrome/21" },
																																																																																																							new String[] {
																																																																																																									"OPR/",
																																																																																																									"Web Preview" },
																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																							RenderingEngine.WEBKIT,
																																																																																																							(String) null), CHROME20(
																																																																																																									Manufacturer.GOOGLE,
																																																																																																									CHROME,
																																																																																																									25,
																																																																																																									"Chrome 20",
																																																																																																									new String[] {
																																																																																																											"Chrome/20" },
																																																																																																									new String[] {
																																																																																																											"OPR/",
																																																																																																											"Web Preview" },
																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																									RenderingEngine.WEBKIT,
																																																																																																									(String) null), CHROME19(
																																																																																																											Manufacturer.GOOGLE,
																																																																																																											CHROME,
																																																																																																											24,
																																																																																																											"Chrome 19",
																																																																																																											new String[] {
																																																																																																													"Chrome/19" },
																																																																																																											new String[] {
																																																																																																													"OPR/",
																																																																																																													"Web Preview" },
																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																											RenderingEngine.WEBKIT,
																																																																																																											(String) null), CHROME18(
																																																																																																													Manufacturer.GOOGLE,
																																																																																																													CHROME,
																																																																																																													23,
																																																																																																													"Chrome 18",
																																																																																																													new String[] {
																																																																																																															"Chrome/18" },
																																																																																																													(String[]) null,
																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																													RenderingEngine.WEBKIT,
																																																																																																													(String) null), CHROME17(
																																																																																																															Manufacturer.GOOGLE,
																																																																																																															CHROME,
																																																																																																															22,
																																																																																																															"Chrome 17",
																																																																																																															new String[] {
																																																																																																																	"Chrome/17" },
																																																																																																															(String[]) null,
																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																															RenderingEngine.WEBKIT,
																																																																																																															(String) null), CHROME16(
																																																																																																																	Manufacturer.GOOGLE,
																																																																																																																	CHROME,
																																																																																																																	21,
																																																																																																																	"Chrome 16",
																																																																																																																	new String[] {
																																																																																																																			"Chrome/16" },
																																																																																																																	(String[]) null,
																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																	(String) null), CHROME15(
																																																																																																																			Manufacturer.GOOGLE,
																																																																																																																			CHROME,
																																																																																																																			20,
																																																																																																																			"Chrome 15",
																																																																																																																			new String[] {
																																																																																																																					"Chrome/15" },
																																																																																																																			(String[]) null,
																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																			(String) null), CHROME14(
																																																																																																																					Manufacturer.GOOGLE,
																																																																																																																					CHROME,
																																																																																																																					19,
																																																																																																																					"Chrome 14",
																																																																																																																					new String[] {
																																																																																																																							"Chrome/14" },
																																																																																																																					(String[]) null,
																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																					(String) null), CHROME13(
																																																																																																																							Manufacturer.GOOGLE,
																																																																																																																							CHROME,
																																																																																																																							18,
																																																																																																																							"Chrome 13",
																																																																																																																							new String[] {
																																																																																																																									"Chrome/13" },
																																																																																																																							(String[]) null,
																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																							(String) null), CHROME12(
																																																																																																																									Manufacturer.GOOGLE,
																																																																																																																									CHROME,
																																																																																																																									17,
																																																																																																																									"Chrome 12",
																																																																																																																									new String[] {
																																																																																																																											"Chrome/12" },
																																																																																																																									(String[]) null,
																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																									(String) null), CHROME11(
																																																																																																																											Manufacturer.GOOGLE,
																																																																																																																											CHROME,
																																																																																																																											16,
																																																																																																																											"Chrome 11",
																																																																																																																											new String[] {
																																																																																																																													"Chrome/11" },
																																																																																																																											(String[]) null,
																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																											RenderingEngine.WEBKIT,
																																																																																																																											(String) null), CHROME10(
																																																																																																																													Manufacturer.GOOGLE,
																																																																																																																													CHROME,
																																																																																																																													15,
																																																																																																																													"Chrome 10",
																																																																																																																													new String[] {
																																																																																																																															"Chrome/10" },
																																																																																																																													(String[]) null,
																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																													RenderingEngine.WEBKIT,
																																																																																																																													(String) null), CHROME9(
																																																																																																																															Manufacturer.GOOGLE,
																																																																																																																															CHROME,
																																																																																																																															10,
																																																																																																																															"Chrome 9",
																																																																																																																															new String[] {
																																																																																																																																	"Chrome/9" },
																																																																																																																															(String[]) null,
																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																															RenderingEngine.WEBKIT,
																																																																																																																															(String) null), CHROME8(
																																																																																																																																	Manufacturer.GOOGLE,
																																																																																																																																	CHROME,
																																																																																																																																	5,
																																																																																																																																	"Chrome 8",
																																																																																																																																	new String[] {
																																																																																																																																			"Chrome/8" },
																																																																																																																																	(String[]) null,
																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																																	(String) null), OMNIWEB(
																																																																																																																																			Manufacturer.OTHER,
																																																																																																																																			(Browser) null,
																																																																																																																																			2,
																																																																																																																																			"Omniweb",
																																																																																																																																			new String[] {
																																																																																																																																					"OmniWeb" },
																																																																																																																																			(String[]) null,
																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																			(String) null), SAFARI(
																																																																																																																																					Manufacturer.APPLE,
																																																																																																																																					(Browser) null,
																																																																																																																																					1,
																																																																																																																																					"Safari",
																																																																																																																																					new String[] {
																																																																																																																																							"Safari" },
																																																																																																																																					new String[] {
																																																																																																																																							"bot",
																																																																																																																																							"preview",
																																																																																																																																							"OPR/",
																																																																																																																																							"Coast/",
																																																																																																																																							"Vivaldi",
																																																																																																																																							"CFNetwork" },
																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																					"Version\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"), BLACKBERRY10(
																																																																																																																																							Manufacturer.BLACKBERRY,
																																																																																																																																							SAFARI,
																																																																																																																																							10,
																																																																																																																																							"BlackBerry",
																																																																																																																																							new String[] {
																																																																																																																																									"BB10" },
																																																																																																																																							(String[]) null,
																																																																																																																																							BrowserType.MOBILE_BROWSER,
																																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																																							(String) null), MOBILE_SAFARI(
																																																																																																																																									Manufacturer.APPLE,
																																																																																																																																									SAFARI,
																																																																																																																																									2,
																																																																																																																																									"Mobile Safari",
																																																																																																																																									new String[] {
																																																																																																																																											"Mobile Safari",
																																																																																																																																											"Mobile/" },
																																																																																																																																									new String[] {
																																																																																																																																											"bot",
																																																																																																																																											"preview",
																																																																																																																																											"OPR/",
																																																																																																																																											"Coast/",
																																																																																																																																											"Vivaldi",
																																																																																																																																											"CFNetwork" },
																																																																																																																																									BrowserType.MOBILE_BROWSER,
																																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																																									(String) null), SILK(
																																																																																																																																											Manufacturer.AMAZON,
																																																																																																																																											SAFARI,
																																																																																																																																											15,
																																																																																																																																											"Silk",
																																																																																																																																											new String[] {
																																																																																																																																													"Silk/" },
																																																																																																																																											(String[]) null,
																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																											RenderingEngine.WEBKIT,
																																																																																																																																											"Silk\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\-[\\w]+)?)"), SAFARI9(
																																																																																																																																													Manufacturer.APPLE,
																																																																																																																																													SAFARI,
																																																																																																																																													9,
																																																																																																																																													"Safari 9",
																																																																																																																																													new String[] {
																																																																																																																																															"Version/9" },
																																																																																																																																													new String[] {
																																																																																																																																															"Applebot" },
																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																													RenderingEngine.WEBKIT,
																																																																																																																																													(String) null), SAFARI8(
																																																																																																																																															Manufacturer.APPLE,
																																																																																																																																															SAFARI,
																																																																																																																																															8,
																																																																																																																																															"Safari 8",
																																																																																																																																															new String[] {
																																																																																																																																																	"Version/8" },
																																																																																																																																															new String[] {
																																																																																																																																																	"Applebot" },
																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																															RenderingEngine.WEBKIT,
																																																																																																																																															(String) null), SAFARI7(
																																																																																																																																																	Manufacturer.APPLE,
																																																																																																																																																	SAFARI,
																																																																																																																																																	7,
																																																																																																																																																	"Safari 7",
																																																																																																																																																	new String[] {
																																																																																																																																																			"Version/7" },
																																																																																																																																																	new String[] {
																																																																																																																																																			"bing" },
																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																																																	(String) null), SAFARI6(
																																																																																																																																																			Manufacturer.APPLE,
																																																																																																																																																			SAFARI,
																																																																																																																																																			6,
																																																																																																																																																			"Safari 6",
																																																																																																																																																			new String[] {
																																																																																																																																																					"Version/6" },
																																																																																																																																																			(String[]) null,
																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																																			(String) null), SAFARI5(
																																																																																																																																																					Manufacturer.APPLE,
																																																																																																																																																					SAFARI,
																																																																																																																																																					3,
																																																																																																																																																					"Safari 5",
																																																																																																																																																					new String[] {
																																																																																																																																																							"Version/5" },
																																																																																																																																																					new String[] {
																																																																																																																																																							"Google Web Preview" },
																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																																					(String) null), SAFARI4(
																																																																																																																																																							Manufacturer.APPLE,
																																																																																																																																																							SAFARI,
																																																																																																																																																							4,
																																																																																																																																																							"Safari 4",
																																																																																																																																																							new String[] {
																																																																																																																																																									"Version/4" },
																																																																																																																																																							new String[] {
																																																																																																																																																									"Googlebot-Mobile" },
																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																																																							(String) null), COAST(
																																																																																																																																																									Manufacturer.OPERA,
																																																																																																																																																									(Browser) null,
																																																																																																																																																									500,
																																																																																																																																																									"Opera",
																																																																																																																																																									new String[] {
																																																																																																																																																											" Coast/" },
																																																																																																																																																									(String[]) null,
																																																																																																																																																									BrowserType.MOBILE_BROWSER,
																																																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																																																									"Coast\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), COAST1(
																																																																																																																																																											Manufacturer.OPERA,
																																																																																																																																																											COAST,
																																																																																																																																																											501,
																																																																																																																																																											"Opera",
																																																																																																																																																											new String[] {
																																																																																																																																																													" Coast/1." },
																																																																																																																																																											(String[]) null,
																																																																																																																																																											BrowserType.MOBILE_BROWSER,
																																																																																																																																																											RenderingEngine.WEBKIT,
																																																																																																																																																											"Coast\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA(
																																																																																																																																																													Manufacturer.OPERA,
																																																																																																																																																													(Browser) null,
																																																																																																																																																													1,
																																																																																																																																																													"Opera",
																																																																																																																																																													new String[] {
																																																																																																																																																															" OPR/",
																																																																																																																																																															"Opera" },
																																																																																																																																																													(String[]) null,
																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																													RenderingEngine.PRESTO,
																																																																																																																																																													"[o][p][e]?[r][a]?\\/(([\\d]+)\\.([\\w]+)(\\.([\\w]+))?(\\.([\\w]+))?)"), OPERA_MOBILE(
																																																																																																																																																															Manufacturer.OPERA,
																																																																																																																																																															OPERA,
																																																																																																																																																															100,
																																																																																																																																																															"Opera Mobile",
																																																																																																																																																															new String[] {
																																																																																																																																																																	"Mobile Safari" },
																																																																																																																																																															(String[]) null,
																																																																																																																																																															BrowserType.MOBILE_BROWSER,
																																																																																																																																																															RenderingEngine.BLINK,
																																																																																																																																																															"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA_MINI(
																																																																																																																																																																	Manufacturer.OPERA,
																																																																																																																																																																	OPERA,
																																																																																																																																																																	20,
																																																																																																																																																																	"Opera Mini",
																																																																																																																																																																	new String[] {
																																																																																																																																																																			"Opera Mini" },
																																																																																																																																																																	(String[]) null,
																																																																																																																																																																	BrowserType.MOBILE_BROWSER,
																																																																																																																																																																	RenderingEngine.PRESTO,
																																																																																																																																																																	(String) null), OPERA34(
																																																																																																																																																																			Manufacturer.OPERA,
																																																																																																																																																																			OPERA,
																																																																																																																																																																			34,
																																																																																																																																																																			"Opera 34",
																																																																																																																																																																			new String[] {
																																																																																																																																																																					"OPR/34." },
																																																																																																																																																																			(String[]) null,
																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																																																			"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA33(
																																																																																																																																																																					Manufacturer.OPERA,
																																																																																																																																																																					OPERA,
																																																																																																																																																																					33,
																																																																																																																																																																					"Opera 33",
																																																																																																																																																																					new String[] {
																																																																																																																																																																							"OPR/33." },
																																																																																																																																																																					(String[]) null,
																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																																																					"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA32(
																																																																																																																																																																							Manufacturer.OPERA,
																																																																																																																																																																							OPERA,
																																																																																																																																																																							32,
																																																																																																																																																																							"Opera 32",
																																																																																																																																																																							new String[] {
																																																																																																																																																																									"OPR/32." },
																																																																																																																																																																							(String[]) null,
																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																																																																							"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA31(
																																																																																																																																																																									Manufacturer.OPERA,
																																																																																																																																																																									OPERA,
																																																																																																																																																																									31,
																																																																																																																																																																									"Opera 31",
																																																																																																																																																																									new String[] {
																																																																																																																																																																											"OPR/31." },
																																																																																																																																																																									(String[]) null,
																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																																																																									"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA30(
																																																																																																																																																																											Manufacturer.OPERA,
																																																																																																																																																																											OPERA,
																																																																																																																																																																											30,
																																																																																																																																																																											"Opera 30",
																																																																																																																																																																											new String[] {
																																																																																																																																																																													"OPR/30." },
																																																																																																																																																																											(String[]) null,
																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																											RenderingEngine.WEBKIT,
																																																																																																																																																																											"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA29(
																																																																																																																																																																													Manufacturer.OPERA,
																																																																																																																																																																													OPERA,
																																																																																																																																																																													29,
																																																																																																																																																																													"Opera 29",
																																																																																																																																																																													new String[] {
																																																																																																																																																																															"OPR/29." },
																																																																																																																																																																													(String[]) null,
																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																													RenderingEngine.WEBKIT,
																																																																																																																																																																													"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA28(
																																																																																																																																																																															Manufacturer.OPERA,
																																																																																																																																																																															OPERA,
																																																																																																																																																																															28,
																																																																																																																																																																															"Opera 28",
																																																																																																																																																																															new String[] {
																																																																																																																																																																																	"OPR/28." },
																																																																																																																																																																															(String[]) null,
																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																															RenderingEngine.WEBKIT,
																																																																																																																																																																															"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA27(
																																																																																																																																																																																	Manufacturer.OPERA,
																																																																																																																																																																																	OPERA,
																																																																																																																																																																																	27,
																																																																																																																																																																																	"Opera 27",
																																																																																																																																																																																	new String[] {
																																																																																																																																																																																			"OPR/27." },
																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																																																																																	"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA26(
																																																																																																																																																																																			Manufacturer.OPERA,
																																																																																																																																																																																			OPERA,
																																																																																																																																																																																			26,
																																																																																																																																																																																			"Opera 26",
																																																																																																																																																																																			new String[] {
																																																																																																																																																																																					"OPR/26." },
																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																																																																			"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA25(
																																																																																																																																																																																					Manufacturer.OPERA,
																																																																																																																																																																																					OPERA,
																																																																																																																																																																																					25,
																																																																																																																																																																																					"Opera 25",
																																																																																																																																																																																					new String[] {
																																																																																																																																																																																							"OPR/25." },
																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																																																																					"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA24(
																																																																																																																																																																																							Manufacturer.OPERA,
																																																																																																																																																																																							OPERA,
																																																																																																																																																																																							24,
																																																																																																																																																																																							"Opera 24",
																																																																																																																																																																																							new String[] {
																																																																																																																																																																																									"OPR/24." },
																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																																																																																							"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA23(
																																																																																																																																																																																									Manufacturer.OPERA,
																																																																																																																																																																																									OPERA,
																																																																																																																																																																																									23,
																																																																																																																																																																																									"Opera 23",
																																																																																																																																																																																									new String[] {
																																																																																																																																																																																											"OPR/23." },
																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																																																																																									"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA20(
																																																																																																																																																																																											Manufacturer.OPERA,
																																																																																																																																																																																											OPERA,
																																																																																																																																																																																											21,
																																																																																																																																																																																											"Opera 20",
																																																																																																																																																																																											new String[] {
																																																																																																																																																																																													"OPR/20." },
																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																											RenderingEngine.WEBKIT,
																																																																																																																																																																																											"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA19(
																																																																																																																																																																																													Manufacturer.OPERA,
																																																																																																																																																																																													OPERA,
																																																																																																																																																																																													19,
																																																																																																																																																																																													"Opera 19",
																																																																																																																																																																																													new String[] {
																																																																																																																																																																																															"OPR/19." },
																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																													RenderingEngine.WEBKIT,
																																																																																																																																																																																													"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA18(
																																																																																																																																																																																															Manufacturer.OPERA,
																																																																																																																																																																																															OPERA,
																																																																																																																																																																																															18,
																																																																																																																																																																																															"Opera 18",
																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																	"OPR/18." },
																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																															RenderingEngine.WEBKIT,
																																																																																																																																																																																															"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA17(
																																																																																																																																																																																																	Manufacturer.OPERA,
																																																																																																																																																																																																	OPERA,
																																																																																																																																																																																																	17,
																																																																																																																																																																																																	"Opera 17",
																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																			"OPR/17." },
																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																																																																																																	"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA16(
																																																																																																																																																																																																			Manufacturer.OPERA,
																																																																																																																																																																																																			OPERA,
																																																																																																																																																																																																			16,
																																																																																																																																																																																																			"Opera 16",
																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																					"OPR/16." },
																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																																																																																			"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA15(
																																																																																																																																																																																																					Manufacturer.OPERA,
																																																																																																																																																																																																					OPERA,
																																																																																																																																																																																																					15,
																																																																																																																																																																																																					"Opera 15",
																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																							"OPR/15." },
																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																																																																																					"OPR\\/(([\\d]+)\\.([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), OPERA12(
																																																																																																																																																																																																							Manufacturer.OPERA,
																																																																																																																																																																																																							OPERA,
																																																																																																																																																																																																							12,
																																																																																																																																																																																																							"Opera 12",
																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																									"Opera/12",
																																																																																																																																																																																																									"Version/12." },
																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																							RenderingEngine.PRESTO,
																																																																																																																																																																																																							"Version\\/(([\\d]+)\\.([\\w]+))"), OPERA11(
																																																																																																																																																																																																									Manufacturer.OPERA,
																																																																																																																																																																																																									OPERA,
																																																																																																																																																																																																									11,
																																																																																																																																																																																																									"Opera 11",
																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																											"Version/11." },
																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																									RenderingEngine.PRESTO,
																																																																																																																																																																																																									"Version\\/(([\\d]+)\\.([\\w]+))"), OPERA10(
																																																																																																																																																																																																											Manufacturer.OPERA,
																																																																																																																																																																																																											OPERA,
																																																																																																																																																																																																											10,
																																																																																																																																																																																																											"Opera 10",
																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																													"Opera/9.8" },
																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																											RenderingEngine.PRESTO,
																																																																																																																																																																																																											"Version\\/(([\\d]+)\\.([\\w]+))"), OPERA9(
																																																																																																																																																																																																													Manufacturer.OPERA,
																																																																																																																																																																																																													OPERA,
																																																																																																																																																																																																													5,
																																																																																																																																																																																																													"Opera 9",
																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																															"Opera/9" },
																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																													RenderingEngine.PRESTO,
																																																																																																																																																																																																													(String) null), KONQUEROR(
																																																																																																																																																																																																															Manufacturer.OTHER,
																																																																																																																																																																																																															(Browser) null,
																																																																																																																																																																																																															1,
																																																																																																																																																																																																															"Konqueror",
																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																	"Konqueror" },
																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																	"Exabot" },
																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																															RenderingEngine.KHTML,
																																																																																																																																																																																																															"Konqueror\\/(([0-9]+)\\.?([\\w]+)?(-[\\w]+)?)"), DOLFIN2(
																																																																																																																																																																																																																	Manufacturer.SAMSUNG,
																																																																																																																																																																																																																	(Browser) null,
																																																																																																																																																																																																																	1,
																																																																																																																																																																																																																	"Samsung Dolphin 2",
																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																			"Dolfin/2" },
																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																	BrowserType.MOBILE_BROWSER,
																																																																																																																																																																																																																	RenderingEngine.WEBKIT,
																																																																																																																																																																																																																	(String) null), APPLE_WEB_KIT(
																																																																																																																																																																																																																			Manufacturer.APPLE,
																																																																																																																																																																																																																			(Browser) null,
																																																																																																																																																																																																																			50,
																																																																																																																																																																																																																			"Apple WebKit",
																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																					"AppleWebKit" },
																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																					"bot",
																																																																																																																																																																																																																					"preview",
																																																																																																																																																																																																																					"OPR/",
																																																																																																																																																																																																																					"Coast/",
																																																																																																																																																																																																																					"Vivaldi" },
																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																			RenderingEngine.WEBKIT,
																																																																																																																																																																																																																			(String) null), APPLE_ITUNES(
																																																																																																																																																																																																																					Manufacturer.APPLE,
																																																																																																																																																																																																																					APPLE_WEB_KIT,
																																																																																																																																																																																																																					52,
																																																																																																																																																																																																																					"iTunes",
																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																							"iTunes" },
																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																					BrowserType.APP,
																																																																																																																																																																																																																					RenderingEngine.WEBKIT,
																																																																																																																																																																																																																					(String) null), APPLE_APPSTORE(
																																																																																																																																																																																																																							Manufacturer.APPLE,
																																																																																																																																																																																																																							APPLE_WEB_KIT,
																																																																																																																																																																																																																							53,
																																																																																																																																																																																																																							"App Store",
																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																									"MacAppStore" },
																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																							BrowserType.APP,
																																																																																																																																																																																																																							RenderingEngine.WEBKIT,
																																																																																																																																																																																																																							(String) null), ADOBE_AIR(
																																																																																																																																																																																																																									Manufacturer.ADOBE,
																																																																																																																																																																																																																									APPLE_WEB_KIT,
																																																																																																																																																																																																																									1,
																																																																																																																																																																																																																									"Adobe AIR application",
																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																											"AdobeAIR" },
																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																									BrowserType.APP,
																																																																																																																																																																																																																									RenderingEngine.WEBKIT,
																																																																																																																																																																																																																									(String) null), LOTUS_NOTES(
																																																																																																																																																																																																																											Manufacturer.OTHER,
																																																																																																																																																																																																																											(Browser) null,
																																																																																																																																																																																																																											3,
																																																																																																																																																																																																																											"Lotus Notes",
																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																													"Lotus-Notes" },
																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																											BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																											RenderingEngine.OTHER,
																																																																																																																																																																																																																											"Lotus-Notes\\/(([\\d]+)\\.([\\w]+))"), CAMINO(
																																																																																																																																																																																																																													Manufacturer.OTHER,
																																																																																																																																																																																																																													(Browser) null,
																																																																																																																																																																																																																													5,
																																																																																																																																																																																																																													"Camino",
																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																															"Camino" },
																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																													"Camino\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"), CAMINO2(
																																																																																																																																																																																																																															Manufacturer.OTHER,
																																																																																																																																																																																																																															CAMINO,
																																																																																																																																																																																																																															17,
																																																																																																																																																																																																																															"Camino 2",
																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																	"Camino/2" },
																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																															(String) null), FLOCK(
																																																																																																																																																																																																																																	Manufacturer.OTHER,
																																																																																																																																																																																																																																	(Browser) null,
																																																																																																																																																																																																																																	4,
																																																																																																																																																																																																																																	"Flock",
																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																			"Flock" },
																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																	"Flock\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"), FIREFOX(
																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																			(Browser) null,
																																																																																																																																																																																																																																			10,
																																																																																																																																																																																																																																			"Firefox",
																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																					"Firefox" },
																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																					"ggpht.com",
																																																																																																																																																																																																																																					"WordPress.com mShots" },
																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																			"Firefox\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), FIREFOX3MOBILE(
																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																					31,
																																																																																																																																																																																																																																					"Firefox 3 Mobile",
																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																							"Firefox/3.5 Maemo" },
																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																					BrowserType.MOBILE_BROWSER,
																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																					(String) null), FIREFOX_MOBILE(
																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																							200,
																																																																																																																																																																																																																																							"Firefox Mobile",
																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																									"Mobile" },
																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																							BrowserType.MOBILE_BROWSER,
																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																							(String) null), FIREFOX_MOBILE23(
																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																									FIREFOX_MOBILE,
																																																																																																																																																																																																																																									223,
																																																																																																																																																																																																																																									"Firefox Mobile 23",
																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																											"Firefox/23" },
																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																									BrowserType.MOBILE_BROWSER,
																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																									(String) null), FIREFOX42(
																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																											219,
																																																																																																																																																																																																																																											"Firefox 42",
																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																													"Firefox/42" },
																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																											(String) null), FIREFOX41(
																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																													218,
																																																																																																																																																																																																																																													"Firefox 41",
																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																															"Firefox/41" },
																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																													(String) null), FIREFOX40(
																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																															FIREFOX,
																																																																																																																																																																																																																																															217,
																																																																																																																																																																																																																																															"Firefox 40",
																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																	"Firefox/40" },
																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																															(String) null), FIREFOX39(
																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																	FIREFOX,
																																																																																																																																																																																																																																																	216,
																																																																																																																																																																																																																																																	"Firefox 39",
																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																			"Firefox/39" },
																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																	(String) null), FIREFOX38(
																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																			FIREFOX,
																																																																																																																																																																																																																																																			215,
																																																																																																																																																																																																																																																			"Firefox 38",
																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																					"Firefox/38" },
																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																			(String) null), FIREFOX37(
																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																																					214,
																																																																																																																																																																																																																																																					"Firefox 37",
																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																							"Firefox/37" },
																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																					(String) null), FIREFOX36(
																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																																							213,
																																																																																																																																																																																																																																																							"Firefox 36",
																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																									"Firefox/36" },
																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																							(String) null), FIREFOX35(
																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																									FIREFOX,
																																																																																																																																																																																																																																																									212,
																																																																																																																																																																																																																																																									"Firefox 35",
																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																											"Firefox/35" },
																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																									(String) null), FIREFOX34(
																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																																											211,
																																																																																																																																																																																																																																																											"Firefox 34",
																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																													"Firefox/34" },
																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																											(String) null), FIREFOX33(
																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																																													210,
																																																																																																																																																																																																																																																													"Firefox 33",
																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																															"Firefox/33" },
																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																													(String) null), FIREFOX32(
																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																															FIREFOX,
																																																																																																																																																																																																																																																															109,
																																																																																																																																																																																																																																																															"Firefox 32",
																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																	"Firefox/32" },
																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																															(String) null), FIREFOX31(
																																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																	FIREFOX,
																																																																																																																																																																																																																																																																	310,
																																																																																																																																																																																																																																																																	"Firefox 31",
																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																			"Firefox/31" },
																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																	(String) null), FIREFOX30(
																																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																			FIREFOX,
																																																																																																																																																																																																																																																																			300,
																																																																																																																																																																																																																																																																			"Firefox 30",
																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																					"Firefox/30" },
																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																			(String) null), FIREFOX29(
																																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																																																					290,
																																																																																																																																																																																																																																																																					"Firefox 29",
																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																							"Firefox/29" },
																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																					(String) null), FIREFOX28(
																																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																																																							280,
																																																																																																																																																																																																																																																																							"Firefox 28",
																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																									"Firefox/28" },
																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																							(String) null), FIREFOX27(
																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																									FIREFOX,
																																																																																																																																																																																																																																																																									108,
																																																																																																																																																																																																																																																																									"Firefox 27",
																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																											"Firefox/27" },
																																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																									(String) null), FIREFOX26(
																																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																																																											107,
																																																																																																																																																																																																																																																																											"Firefox 26",
																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																													"Firefox/26" },
																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																											(String) null), FIREFOX25(
																																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																																																													106,
																																																																																																																																																																																																																																																																													"Firefox 25",
																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																															"Firefox/25" },
																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																													(String) null), FIREFOX24(
																																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																															FIREFOX,
																																																																																																																																																																																																																																																																															105,
																																																																																																																																																																																																																																																																															"Firefox 24",
																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																	"Firefox/24" },
																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																															(String) null), FIREFOX23(
																																																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																	FIREFOX,
																																																																																																																																																																																																																																																																																	104,
																																																																																																																																																																																																																																																																																	"Firefox 23",
																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																			"Firefox/23" },
																																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																	(String) null), FIREFOX22(
																																																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																			FIREFOX,
																																																																																																																																																																																																																																																																																			103,
																																																																																																																																																																																																																																																																																			"Firefox 22",
																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																					"Firefox/22" },
																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																			(String) null), FIREFOX21(
																																																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																																																																					102,
																																																																																																																																																																																																																																																																																					"Firefox 21",
																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																							"Firefox/21" },
																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																							"WordPress.com mShots" },
																																																																																																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																					(String) null), FIREFOX20(
																																																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																																																																							101,
																																																																																																																																																																																																																																																																																							"Firefox 20",
																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																									"Firefox/20" },
																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																							(String) null), FIREFOX19(
																																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																									FIREFOX,
																																																																																																																																																																																																																																																																																									100,
																																																																																																																																																																																																																																																																																									"Firefox 19",
																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																											"Firefox/19" },
																																																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																									(String) null), FIREFOX18(
																																																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																																																																											99,
																																																																																																																																																																																																																																																																																											"Firefox 18",
																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																													"Firefox/18" },
																																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																											(String) null), FIREFOX17(
																																																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																																																																													98,
																																																																																																																																																																																																																																																																																													"Firefox 17",
																																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																																															"Firefox/17" },
																																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																													(String) null), FIREFOX16(
																																																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																															FIREFOX,
																																																																																																																																																																																																																																																																																															97,
																																																																																																																																																																																																																																																																																															"Firefox 16",
																																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																																	"Firefox/16" },
																																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																															(String) null), FIREFOX15(
																																																																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																	FIREFOX,
																																																																																																																																																																																																																																																																																																	96,
																																																																																																																																																																																																																																																																																																	"Firefox 15",
																																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																																			"Firefox/15" },
																																																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																	(String) null), FIREFOX14(
																																																																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																			FIREFOX,
																																																																																																																																																																																																																																																																																																			95,
																																																																																																																																																																																																																																																																																																			"Firefox 14",
																																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																																					"Firefox/14" },
																																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																			(String) null), FIREFOX13(
																																																																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																																																																																					94,
																																																																																																																																																																																																																																																																																																					"Firefox 13",
																																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																																							"Firefox/13" },
																																																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																					(String) null), FIREFOX12(
																																																																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																																																																																							93,
																																																																																																																																																																																																																																																																																																							"Firefox 12",
																																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																																									"Firefox/12" },
																																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																							(String) null), FIREFOX11(
																																																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																									FIREFOX,
																																																																																																																																																																																																																																																																																																									92,
																																																																																																																																																																																																																																																																																																									"Firefox 11",
																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																											"Firefox/11" },
																																																																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																									(String) null), FIREFOX10(
																																																																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																																																																																											91,
																																																																																																																																																																																																																																																																																																											"Firefox 10",
																																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																																													"Firefox/10" },
																																																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																											(String) null), FIREFOX9(
																																																																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																																																																																													90,
																																																																																																																																																																																																																																																																																																													"Firefox 9",
																																																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																																																															"Firefox/9" },
																																																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																													(String) null), FIREFOX8(
																																																																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																															FIREFOX,
																																																																																																																																																																																																																																																																																																															80,
																																																																																																																																																																																																																																																																																																															"Firefox 8",
																																																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																																																	"Firefox/8" },
																																																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																																																															BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																															(String) null), FIREFOX7(
																																																																																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																	FIREFOX,
																																																																																																																																																																																																																																																																																																																	70,
																																																																																																																																																																																																																																																																																																																	"Firefox 7",
																																																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																																																			"Firefox/7" },
																																																																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																	(String) null), FIREFOX6(
																																																																																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																			FIREFOX,
																																																																																																																																																																																																																																																																																																																			60,
																																																																																																																																																																																																																																																																																																																			"Firefox 6",
																																																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																																																					"Firefox/6" },
																																																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																			(String) null), FIREFOX5(
																																																																																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																					FIREFOX,
																																																																																																																																																																																																																																																																																																																					50,
																																																																																																																																																																																																																																																																																																																					"Firefox 5",
																																																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																																																							"Firefox/5" },
																																																																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																																																																					BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																					(String) null), FIREFOX4(
																																																																																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																							FIREFOX,
																																																																																																																																																																																																																																																																																																																							40,
																																																																																																																																																																																																																																																																																																																							"Firefox 4",
																																																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																																																									"Firefox/4" },
																																																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																																																							BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																							(String) null), FIREFOX3(
																																																																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																									FIREFOX,
																																																																																																																																																																																																																																																																																																																									30,
																																																																																																																																																																																																																																																																																																																									"Firefox 3",
																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																											"Firefox/3" },
																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																											"ggpht.com" },
																																																																																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																									(String) null), FIREFOX2(
																																																																																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																											FIREFOX,
																																																																																																																																																																																																																																																																																																																											20,
																																																																																																																																																																																																																																																																																																																											"Firefox 2",
																																																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																																																													"Firefox/2" },
																																																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																																																													"WordPress.com mShots" },
																																																																																																																																																																																																																																																																																																																											BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																											(String) null), FIREFOX1_5(
																																																																																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																													FIREFOX,
																																																																																																																																																																																																																																																																																																																													15,
																																																																																																																																																																																																																																																																																																																													"Firefox 1.5",
																																																																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																																																																															"Firefox/1.5" },
																																																																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																																																																													BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																													(String) null), THUNDERBIRD(
																																																																																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																															(Browser) null,
																																																																																																																																																																																																																																																																																																																															110,
																																																																																																																																																																																																																																																																																																																															"Thunderbird",
																																																																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																																																																	"Thunderbird" },
																																																																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																																																																															BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																															"Thunderbird\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?(\\.[\\w]+)?)"), THUNDERBIRD12(
																																																																																																																																																																																																																																																																																																																																	Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																	THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																	185,
																																																																																																																																																																																																																																																																																																																																	"Thunderbird 12",
																																																																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																																																																			"Thunderbird/12" },
																																																																																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																																																																																	BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																	RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																	(String) null), THUNDERBIRD11(
																																																																																																																																																																																																																																																																																																																																			Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																			THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																			184,
																																																																																																																																																																																																																																																																																																																																			"Thunderbird 11",
																																																																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																																																																					"Thunderbird/11" },
																																																																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																																																																			BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																			(String) null), THUNDERBIRD10(
																																																																																																																																																																																																																																																																																																																																					Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																					THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																					183,
																																																																																																																																																																																																																																																																																																																																					"Thunderbird 10",
																																																																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																																																																							"Thunderbird/10" },
																																																																																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																																																																																					BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																					RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																					(String) null), THUNDERBIRD8(
																																																																																																																																																																																																																																																																																																																																							Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																							THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																							180,
																																																																																																																																																																																																																																																																																																																																							"Thunderbird 8",
																																																																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																																																																									"Thunderbird/8" },
																																																																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																																																																							BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																							RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																							(String) null), THUNDERBIRD7(
																																																																																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																									THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																									170,
																																																																																																																																																																																																																																																																																																																																									"Thunderbird 7",
																																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																																											"Thunderbird/7" },
																																																																																																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																																																																																																									BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																									RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																									(String) null), THUNDERBIRD6(
																																																																																																																																																																																																																																																																																																																																											Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																											THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																											160,
																																																																																																																																																																																																																																																																																																																																											"Thunderbird 6",
																																																																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																																																																													"Thunderbird/6" },
																																																																																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																																																																																											BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																											RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																											(String) null), THUNDERBIRD3(
																																																																																																																																																																																																																																																																																																																																													Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																													THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																													130,
																																																																																																																																																																																																																																																																																																																																													"Thunderbird 3",
																																																																																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																																																																																															"Thunderbird/3" },
																																																																																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																																																																																													BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																													RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																													(String) null), THUNDERBIRD2(
																																																																																																																																																																																																																																																																																																																																															Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																															THUNDERBIRD,
																																																																																																																																																																																																																																																																																																																																															120,
																																																																																																																																																																																																																																																																																																																																															"Thunderbird 2",
																																																																																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																																																																																	"Thunderbird/2" },
																																																																																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																																																																																															BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																															RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																															(String) null), VIVALDI(
																																																																																																																																																																																																																																																																																																																																																	Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																	(Browser) null,
																																																																																																																																																																																																																																																																																																																																																	108338,
																																																																																																																																																																																																																																																																																																																																																	"Vivaldi",
																																																																																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																																																																																			"Vivaldi" },
																																																																																																																																																																																																																																																																																																																																																	new String[0],
																																																																																																																																																																																																																																																																																																																																																	BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																																																	RenderingEngine.BLINK,
																																																																																																																																																																																																																																																																																																																																																	"Vivaldi/(([\\d]+).([\\d]+).([\\d]+).([\\d]+))"), SEAMONKEY(
																																																																																																																																																																																																																																																																																																																																																			Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																			(Browser) null,
																																																																																																																																																																																																																																																																																																																																																			15,
																																																																																																																																																																																																																																																																																																																																																			"SeaMonkey",
																																																																																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																																																																																					"SeaMonkey" },
																																																																																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																																																																																			BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																																																			RenderingEngine.GECKO,
																																																																																																																																																																																																																																																																																																																																																			"SeaMonkey\\/(([0-9]+)\\.?([\\w]+)?(\\.[\\w]+)?)"), BOT(
																																																																																																																																																																																																																																																																																																																																																					Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																					(Browser) null,
																																																																																																																																																																																																																																																																																																																																																					12,
																																																																																																																																																																																																																																																																																																																																																					"Robot/Spider",
																																																																																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																																																																																							"Googlebot",
																																																																																																																																																																																																																																																																																																																																																							"Mediapartners-Google",
																																																																																																																																																																																																																																																																																																																																																							"Web Preview",
																																																																																																																																																																																																																																																																																																																																																							"bot",
																																																																																																																																																																																																																																																																																																																																																							"Applebot",
																																																																																																																																																																																																																																																																																																																																																							"spider",
																																																																																																																																																																																																																																																																																																																																																							"crawler",
																																																																																																																																																																																																																																																																																																																																																							"Feedfetcher",
																																																																																																																																																																																																																																																																																																																																																							"Slurp",
																																																																																																																																																																																																																																																																																																																																																							"Twiceler",
																																																																																																																																																																																																																																																																																																																																																							"Nutch",
																																																																																																																																																																																																																																																																																																																																																							"BecomeBot",
																																																																																																																																																																																																																																																																																																																																																							"bingbot",
																																																																																																																																																																																																																																																																																																																																																							"BingPreview",
																																																																																																																																																																																																																																																																																																																																																							"Google Web Preview",
																																																																																																																																																																																																																																																																																																																																																							"WordPress.com mShots",
																																																																																																																																																																																																																																																																																																																																																							"Seznam",
																																																																																																																																																																																																																																																																																																																																																							"facebookexternalhit",
																																																																																																																																																																																																																																																																																																																																																							"YandexMarket",
																																																																																																																																																																																																																																																																																																																																																							"Teoma",
																																																																																																																																																																																																																																																																																																																																																							"ThumbSniper",
																																																																																																																																																																																																																																																																																																																																																							"Phantom.js" },
																																																																																																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																																																																																																					BrowserType.ROBOT,
																																																																																																																																																																																																																																																																																																																																																					RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																					(String) null), BOT_MOBILE(
																																																																																																																																																																																																																																																																																																																																																							Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																							BOT,
																																																																																																																																																																																																																																																																																																																																																							20,
																																																																																																																																																																																																																																																																																																																																																							"Mobil Robot/Spider",
																																																																																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																																																																																									"Googlebot-Mobile" },
																																																																																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																																																																																							BrowserType.ROBOT,
																																																																																																																																																																																																																																																																																																																																																							RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																							(String) null), MOZILLA(
																																																																																																																																																																																																																																																																																																																																																									Manufacturer.MOZILLA,
																																																																																																																																																																																																																																																																																																																																																									(Browser) null,
																																																																																																																																																																																																																																																																																																																																																									1,
																																																																																																																																																																																																																																																																																																																																																									"Mozilla",
																																																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																																																											"Mozilla",
																																																																																																																																																																																																																																																																																																																																																											"Moozilla" },
																																																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																																																											"ggpht.com" },
																																																																																																																																																																																																																																																																																																																																																									BrowserType.WEB_BROWSER,
																																																																																																																																																																																																																																																																																																																																																									RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																									(String) null), CFNETWORK(
																																																																																																																																																																																																																																																																																																																																																											Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																											(Browser) null,
																																																																																																																																																																																																																																																																																																																																																											6,
																																																																																																																																																																																																																																																																																																																																																											"CFNetwork",
																																																																																																																																																																																																																																																																																																																																																											new String[] {
																																																																																																																																																																																																																																																																																																																																																													"CFNetwork" },
																																																																																																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																																																																																																											BrowserType.UNKNOWN,
																																																																																																																																																																																																																																																																																																																																																											RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																											"CFNetwork/(([\\d]+)(?:\\.([\\d]))?(?:\\.([\\d]+))?)"), EUDORA(
																																																																																																																																																																																																																																																																																																																																																													Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																													(Browser) null,
																																																																																																																																																																																																																																																																																																																																																													7,
																																																																																																																																																																																																																																																																																																																																																													"Eudora",
																																																																																																																																																																																																																																																																																																																																																													new String[] {
																																																																																																																																																																																																																																																																																																																																																															"Eudora",
																																																																																																																																																																																																																																																																																																																																																															"EUDORA" },
																																																																																																																																																																																																																																																																																																																																																													(String[]) null,
																																																																																																																																																																																																																																																																																																																																																													BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																																													RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																													(String) null), POCOMAIL(
																																																																																																																																																																																																																																																																																																																																																															Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																															(Browser) null,
																																																																																																																																																																																																																																																																																																																																																															8,
																																																																																																																																																																																																																																																																																																																																																															"PocoMail",
																																																																																																																																																																																																																																																																																																																																																															new String[] {
																																																																																																																																																																																																																																																																																																																																																																	"PocoMail" },
																																																																																																																																																																																																																																																																																																																																																															(String[]) null,
																																																																																																																																																																																																																																																																																																																																																															BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																																															RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																															(String) null), THEBAT(
																																																																																																																																																																																																																																																																																																																																																																	Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																	(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																	9,
																																																																																																																																																																																																																																																																																																																																																																	"The Bat!",
																																																																																																																																																																																																																																																																																																																																																																	new String[] {
																																																																																																																																																																																																																																																																																																																																																																			"The Bat" },
																																																																																																																																																																																																																																																																																																																																																																	(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																	BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																																																	RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																	(String) null), NETFRONT(
																																																																																																																																																																																																																																																																																																																																																																			Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																			(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																			10,
																																																																																																																																																																																																																																																																																																																																																																			"NetFront",
																																																																																																																																																																																																																																																																																																																																																																			new String[] {
																																																																																																																																																																																																																																																																																																																																																																					"NetFront" },
																																																																																																																																																																																																																																																																																																																																																																			(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																			BrowserType.MOBILE_BROWSER,
																																																																																																																																																																																																																																																																																																																																																																			RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																			(String) null), EVOLUTION(
																																																																																																																																																																																																																																																																																																																																																																					Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																					(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																					11,
																																																																																																																																																																																																																																																																																																																																																																					"Evolution",
																																																																																																																																																																																																																																																																																																																																																																					new String[] {
																																																																																																																																																																																																																																																																																																																																																																							"CamelHttpStream" },
																																																																																																																																																																																																																																																																																																																																																																					(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																					BrowserType.EMAIL_CLIENT,
																																																																																																																																																																																																																																																																																																																																																																					RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																					(String) null), LYNX(
																																																																																																																																																																																																																																																																																																																																																																							Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																							(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																							13,
																																																																																																																																																																																																																																																																																																																																																																							"Lynx",
																																																																																																																																																																																																																																																																																																																																																																							new String[] {
																																																																																																																																																																																																																																																																																																																																																																									"Lynx" },
																																																																																																																																																																																																																																																																																																																																																																							(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																							BrowserType.TEXT_BROWSER,
																																																																																																																																																																																																																																																																																																																																																																							RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																							"Lynx\\/(([0-9]+)\\.([\\d]+)\\.?([\\w-+]+)?\\.?([\\w-+]+)?)"), DOWNLOAD(
																																																																																																																																																																																																																																																																																																																																																																									Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																									(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																									16,
																																																																																																																																																																																																																																																																																																																																																																									"Downloading Tool",
																																																																																																																																																																																																																																																																																																																																																																									new String[] {
																																																																																																																																																																																																																																																																																																																																																																											"cURL",
																																																																																																																																																																																																																																																																																																																																																																											"wget",
																																																																																																																																																																																																																																																																																																																																																																											"ggpht.com",
																																																																																																																																																																																																																																																																																																																																																																											"Apache-HttpClient" },
																																																																																																																																																																																																																																																																																																																																																																									(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																									BrowserType.TOOL,
																																																																																																																																																																																																																																																																																																																																																																									RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																									(String) null), UNKNOWN(
																																																																																																																																																																																																																																																																																																																																																																											Manufacturer.OTHER,
																																																																																																																																																																																																																																																																																																																																																																											(Browser) null,
																																																																																																																																																																																																																																																																																																																																																																											14,
																																																																																																																																																																																																																																																																																																																																																																											"Unknown",
																																																																																																																																																																																																																																																																																																																																																																											new String[0],
																																																																																																																																																																																																																																																																																																																																																																											(String[]) null,
																																																																																																																																																																																																																																																																																																																																																																											BrowserType.UNKNOWN,
																																																																																																																																																																																																																																																																																																																																																																											RenderingEngine.OTHER,
																																																																																																																																																																																																																																																																																																																																																																											(String) null),

	@Deprecated APPLE_MAIL(Manufacturer.APPLE, (Browser) null, 51, "Apple Mail", new String[0], (String[]) null,
			BrowserType.EMAIL_CLIENT, RenderingEngine.WEBKIT, (String) null);

	private final short id;
	private final String name;
	private final String[] aliases;
	private final String[] excludeList;
	private final BrowserType browserType;
	private final Manufacturer manufacturer;
	private final RenderingEngine renderingEngine;
	private final Browser parent;
	private List<Browser> children;
	private Pattern versionRegEx;
	private static List<Browser> topLevelBrowsers;

	private Browser(Manufacturer manufacturer, Browser parent, int versionId, String name, String[] aliases,
			String[] exclude, BrowserType browserType, RenderingEngine renderingEngine, String versionRegexString) {
		this.id = (short) ((manufacturer.getId() << 8) + (byte) versionId);
		this.name = name;
		this.parent = parent;
		this.children = new ArrayList();
		this.aliases = Utils.toLowerCase(aliases);
		this.excludeList = Utils.toLowerCase(exclude);
		this.browserType = browserType;
		this.manufacturer = manufacturer;
		this.renderingEngine = renderingEngine;
		if (versionRegexString != null) {
			this.versionRegEx = Pattern.compile(versionRegexString, 2);
		}

		if (this.parent == null) {
			addTopLevelBrowser(this);
		} else {
			this.parent.children.add(this);
		}

	}

	private static void addTopLevelBrowser(Browser browser) {
		if (topLevelBrowsers == null) {
			topLevelBrowsers = new ArrayList();
		}

		topLevelBrowsers.add(browser);
	}

	public short getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	private Pattern getVersionRegEx() {
		return this.versionRegEx == null ? (this.getGroup() != this ? this.getGroup().getVersionRegEx() : null)
				: this.versionRegEx;
	}

	public Version getVersion(String userAgentString) {
		Pattern pattern = this.getVersionRegEx();
		if (userAgentString != null && pattern != null) {
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String fullVersionString = matcher.group(1);
				String majorVersion = matcher.group(2);
				String minorVersion = "0";
				if (matcher.groupCount() > 2) {
					minorVersion = matcher.group(3);
				}

				return new Version(fullVersionString, majorVersion, minorVersion);
			}
		}

		return null;
	}

	public BrowserType getBrowserType() {
		return this.browserType;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public RenderingEngine getRenderingEngine() {
		return this.renderingEngine;
	}

	public Browser getGroup() {
		return this.parent != null ? this.parent.getGroup() : this;
	}

	public boolean isInUserAgentString(String agentString) {
		if (agentString == null) {
			return false;
		} else {
			String agentStringLowerCase = agentString.toLowerCase();
			return this.isInUserAgentLowercaseString(agentStringLowerCase);
		}
	}

	private boolean isInUserAgentLowercaseString(String agentStringLowerCase) {
		return Utils.contains(agentStringLowerCase, this.aliases);
	}

	private Browser checkUserAgentLowercase(String agentLowercaseString) {
		if (this.isInUserAgentLowercaseString(agentLowercaseString)) {
			if (this.children.size() > 0) {
				Iterator arg1 = this.children.iterator();

				while (arg1.hasNext()) {
					Browser childBrowser = (Browser) arg1.next();
					Browser match = childBrowser.checkUserAgentLowercase(agentLowercaseString);
					if (match != null) {
						return match;
					}
				}
			}

			if (!Utils.contains(agentLowercaseString, this.excludeList)) {
				return this;
			}
		}

		return null;
	}

	public static Browser parseUserAgentString(String agentString) {
		return parseUserAgentString(agentString, topLevelBrowsers);
	}

	public static Browser parseUserAgentLowercaseString(String agentString) {
		return agentString == null ? UNKNOWN : parseUserAgentLowercaseString(agentString, topLevelBrowsers);
	}

	public static Browser parseUserAgentString(String agentString, List<Browser> browsers) {
		if (agentString != null) {
			String agentLowercaseString = agentString.toLowerCase();
			return parseUserAgentLowercaseString(agentLowercaseString, browsers);
		} else {
			return UNKNOWN;
		}
	}

	private static Browser parseUserAgentLowercaseString(String agentLowercaseString, List<Browser> browsers) {
		Iterator arg1 = browsers.iterator();

		Browser match;
		do {
			if (!arg1.hasNext()) {
				return UNKNOWN;
			}

			Browser browser = (Browser) arg1.next();
			match = browser.checkUserAgentLowercase(agentLowercaseString);
		} while (match == null);

		return match;
	}

	public static Browser valueOf(short id) {
		Browser[] arg0 = values();
		int arg1 = arg0.length;

		for (int arg2 = 0; arg2 < arg1; ++arg2) {
			Browser browser = arg0[arg2];
			if (browser.getId() == id) {
				return browser;
			}
		}

		throw new IllegalArgumentException("No enum const for id " + id);
	}
}