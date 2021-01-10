package com.mocasystem.exceptions;

import java.util.Locale;

import com.mocasystem.util.MensajesUtil;
import com.sun.istack.NotNull;


public class RestClientException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Locale localeDefault = new Locale("es", "EC");
	private String codeMessage;
	private Object[] messageParametersValues;
	private Object data;

	public RestClientException() {
		super();
	}

	public RestClientException(String codeMessage, Throwable cause) {
		super(MensajesUtil.getMensaje(codeMessage, localeDefault), cause);
		this.codeMessage  = codeMessage;
	}

	public RestClientException(String codeMessage) {
		super(MensajesUtil.getMensaje(codeMessage, localeDefault));
		this.codeMessage  = codeMessage;
	}

	public RestClientException(Throwable cause) {
		super(cause);
	}
	
	public RestClientException(String codeMessage, @NotNull Object data) {
		super(MensajesUtil.getMensaje(codeMessage, localeDefault));
		this.codeMessage  = codeMessage;
		this.data = data;
	}
	
	public RestClientException(String codeMessage,  @NotNull Object[] messageParametersValues, Throwable cause) {
		super(MensajesUtil.getMensaje(codeMessage, messageParametersValues, localeDefault), cause);
		this.codeMessage  = codeMessage;
		this.messageParametersValues = messageParametersValues;
	}
	
	public RestClientException(String codeMessage, @NotNull Object[] messageParametersValues) {
		super(MensajesUtil.getMensaje(codeMessage, messageParametersValues, localeDefault));
		this.codeMessage  = codeMessage;
		this.messageParametersValues = messageParametersValues;
	}
	
	public RestClientException(String codeMessage, @NotNull Object[] messageParametersValues, @NotNull Object data) {
		super(MensajesUtil.getMensaje(codeMessage, messageParametersValues, localeDefault));
		this.codeMessage  = codeMessage;
		this.messageParametersValues = messageParametersValues;
		this.data = data;
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
	
}
