package com.mocasystem.util;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class MensajesUtil {

	private static ResourceBundle bundle;
	private static String ficheroMensajes = "mensajes_ventas";
	public static final Locale Locale = new Locale("es", "EC");
	private static final String LOCALE_ES="es-EC";
	private static final String LOCALE_ING="en-US";

	public static String getMensaje(String strKey, Locale locale) {
		bundle = ResourceBundle.getBundle(ficheroMensajes, locale);	
		return new String(bundle.getString(strKey)
				.getBytes(StandardCharsets.ISO_8859_1)
				, StandardCharsets.UTF_8);
	}

	public static String getMensaje(String strKey, Object[] arrParametros, Locale locale) {
		bundle = ResourceBundle.getBundle(ficheroMensajes, locale);
		String strMensaje = new String(bundle.getString(strKey).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		return strMensaje;
	}
	
	public static Locale validateSupportedLocale(String strLanguage) {
		if(strLanguage == null || (!LOCALE_ES.equals(strLanguage) && !LOCALE_ING.equals(strLanguage)))
			strLanguage=LOCALE_ES;
		String[] arrLang = strLanguage.split("-");
    	return new Locale(arrLang[0], arrLang[1]);
	}

}
