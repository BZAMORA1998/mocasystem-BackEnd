package com.mocasystem.exceptions;

import java.util.Locale;

import com.mocasystem.util.MensajesUtil;

public class BOException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final Locale localeDefault = new Locale("es", "EC");
	private String codeMessage;
	private Object[] messageParametersValues;
	private Object data;

	public BOException() {
		super();
	}

	public BOException(String codeMessage) {
		super(MensajesUtil.getMensaje(codeMessage, localeDefault));
		this.codeMessage  = codeMessage;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String getTranslatedMessage(String strLanguage) {
		Locale locale = MensajesUtil.validateSupportedLocale(strLanguage);
		if (localeDefault.equals(locale)) {
			return super.getMessage();
		} else {
			if (messageParametersValues != null && messageParametersValues.length > 0)
				return MensajesUtil.getMensaje(codeMessage, messageParametersValues, locale);
			else
				return MensajesUtil.getMensaje(codeMessage, locale);
		}
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public Object[] getMessageParametersValues() {
		return messageParametersValues;
	}
}
