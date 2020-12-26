package com.mocasystem.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mocasystem.bo.pruebaBO;
import com.mocasystem.dto.ResponseOk;
import com.mocasystem.exceptions.BOException;
import com.mocasystem.exceptions.CustomExceptionHandler;
import com.mocasystem.util.MensajesUtil;

@RestController
@RequestMapping("/prueba")
public class prueba {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(prueba.class.getName());
	
	@Autowired
	private pruebaBO objprueba;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> prueba(@RequestHeader(	
			value = "Accept-Language", 	required = false) String strLanguage
			) throws BOException {
		
		try {

			objprueba.prueba();

			return new ResponseEntity<>(new ResponseOk(
														MensajesUtil.getMensaje("moca.response.ok", 
																MensajesUtil.validateSupportedLocale(strLanguage)),
														null)
										, HttpStatus.OK);
			
		} catch (BOException be) {
			logger.error(" ERROR => " + be.getTranslatedMessage(strLanguage));
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
		
	}
}
