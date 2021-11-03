package com.afortuna.helpers;

import com.afortuna.exceptions.DangerException;
import com.afortuna.exceptions.InfoException;

public class PRG {
	public static void info(final String mensaje, final String link) throws InfoException {
		throw new InfoException(mensaje + "@" + link);
	}

	public static void info(final String mensaje) throws InfoException {
		throw new InfoException(mensaje + "@" + "/");
	}

	public static void error(final String mensaje, final String link) throws DangerException {
		throw new DangerException(mensaje + "@" + link);
	}

	public static void error(final String mensaje) throws DangerException {
		throw new DangerException(mensaje + "@" + "/");
	}
}
