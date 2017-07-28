/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package eu.bitwalker.useragentutils;

import eu.bitwalker.useragentutils.ApplicationType;
import eu.bitwalker.useragentutils.Manufacturer;
import eu.bitwalker.useragentutils.Utils;

public enum Application {
	HOTMAIL(Manufacturer.MICROSOFT, 1, "Windows Live Hotmail", new String[] { "mail.live.com", "hotmail.msn" },
			ApplicationType.WEBMAIL), GMAIL(Manufacturer.GOOGLE, 5, "Gmail", new String[] { "mail.google.com" },
					ApplicationType.WEBMAIL), YAHOO_MAIL(Manufacturer.YAHOO, 10, "Yahoo Mail",
							new String[] { "mail.yahoo.com" }, ApplicationType.WEBMAIL), COMPUSERVE(
									Manufacturer.COMPUSERVE, 20, "Compuserve", new String[] { "csmail.compuserve.com" },
									ApplicationType.WEBMAIL), AOL_WEBMAIL(Manufacturer.AOL, 30, "AOL webmail",
											new String[] { "webmail.aol.com" }, ApplicationType.WEBMAIL), MOBILEME(
													Manufacturer.APPLE, 40, "MobileMe", new String[] { "www.me.com" },
													ApplicationType.WEBMAIL), MAIL_COM(Manufacturer.MMC, 50, "Mail.com",
															new String[] { ".mail.com" },
															ApplicationType.WEBMAIL), HORDE(Manufacturer.OTHER, 50,
																	"horde", new String[] { "horde" },
																	ApplicationType.WEBMAIL), OTHER_WEBMAIL(
																			Manufacturer.OTHER, 60,
																			"Other webmail client",
																			new String[] { "webmail", "webemail" },
																			ApplicationType.WEBMAIL), UNKNOWN(
																					Manufacturer.OTHER, 0, "Unknown",
																					new String[0],
																					ApplicationType.UNKNOWN);

	private final short id;
	private final String name;
	private final String[] aliases;
	private final ApplicationType applicationType;
	private final Manufacturer manufacturer;

	private Application(Manufacturer manufacturer, int versionId, String name, String[] aliases,
			ApplicationType applicationType) {
		this.id = (short) ((manufacturer.getId() << 8) + (byte) versionId);
		this.name = name;
		this.aliases = Utils.toLowerCase(aliases);
		this.applicationType = applicationType;
		this.manufacturer = manufacturer;
	}

	public short getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public ApplicationType getApplicationType() {
		return this.applicationType;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public boolean isInReferrerString(String referrerString) {
		String referrerStringLowercase = referrerString.toLowerCase();
		return this.isInReferrerStringLowercase(referrerStringLowercase);
	}

	private boolean isInReferrerStringLowercase(String referrerStringLowercase) {
		return Utils.contains(referrerStringLowercase, this.aliases);
	}

	public static Application parseReferrerString(String referrerString) {
		if (referrerString != null && referrerString.length() > 1) {
			String referrerStringLowercase = referrerString.toLowerCase();
			Application[] arg1 = values();
			int arg2 = arg1.length;

			for (int arg3 = 0; arg3 < arg2; ++arg3) {
				Application applicationInList = arg1[arg3];
				if (applicationInList.isInReferrerStringLowercase(referrerStringLowercase)) {
					return applicationInList;
				}
			}
		}

		return UNKNOWN;
	}

	public static Application valueOf(short id) {
		Application[] arg0 = values();
		int arg1 = arg0.length;

		for (int arg2 = 0; arg2 < arg1; ++arg2) {
			Application application = arg0[arg2];
			if (application.getId() == id) {
				return application;
			}
		}

		throw new IllegalArgumentException("No enum const for id " + id);
	}
}