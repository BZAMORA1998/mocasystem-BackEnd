package com.mocasystem.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mocasystem.bo.IFotoBO;
import com.mocasystem.dto.ResponseOk;
import com.mocasystem.exceptions.BOException;
import com.mocasystem.exceptions.CustomExceptionHandler;
import com.mocasystem.util.MensajesUtil;

@RestController
@RequestMapping("/foto")
public class FotoApi {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(EmpresaApi.class.getName());
	
	@Autowired
	private IFotoBO objFotoBO;

	@RequestMapping(value="/{secuenciaEmpresa}",method = RequestMethod.GET)
	public ResponseEntity<?> consultarFotos(@RequestHeader(	
			value = "Accept-Language", 	required = false) String strLanguage,
			@RequestParam(name = "nemonico", required = false) String strNemonico,
			@RequestParam(name = "nombre", required = false) String strNombre,
			@PathVariable(value="secuenciaEmpresa", required = false)  Integer  intCodigoEmpresa
			) throws BOException {
		
		try {
			return new ResponseEntity<>(new ResponseOk(MensajesUtil.getMensaje("moc.response.ok", 
										MensajesUtil.validateSupportedLocale(strLanguage)),objFotoBO.consultarFotos(intCodigoEmpresa,strNemonico,strNombre))
										, HttpStatus.OK);
		} catch (BOException be) {
			logger.error(" ERROR => " + be.getTranslatedMessage(strLanguage));
			throw new CustomExceptionHandler(be.getTranslatedMessage(strLanguage), be.getData());
		}
		
	}
}

