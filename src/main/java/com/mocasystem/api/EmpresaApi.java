package com.mocasystem.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mocasystem.bo.IEmpresaBO;
import com.mocasystem.dto.ResponseOk;
import com.mocasystem.exceptions.BOException;
import com.mocasystem.exceptions.CustomExceptionHandler;
import com.mocasystem.util.MensajesUtil;

@RestController
@RequestMapping("/empresa")
public class EmpresaApi {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(EmpresaApi.class.getName());
	
	@Autowired
	private IEmpresaBO objEmpresaBO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> infoEmpresa(@RequestHeader(	
			value = "Accept-Language", 	required = false) String strLanguage,
			@RequestParam(value="variable", required = false)  String  strVariable,
			@RequestParam(value="secuenciaEmpresa", required = false)  Integer  intCodigoEmpresa
			) throws BOException {
		
		try {
			return new ResponseEntity<>(new ResponseOk(MensajesUtil.getMensaje("ven.response.ok", 
										MensajesUtil.validateSupportedLocale(strLanguage)),objEmpresaBO.infoEmpresa(intCodigoEmpresa,strVariable))
										, HttpStatus.OK);
		} catch (BOException be) {
			logger.error(" ERROR => " + be.getTranslatedMessage(strLanguage));
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
		
	}
}
