package com.mocasystem.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mocasystem.bo.IFotoBO;
import com.mocasystem.dao.FotosDAO;
import com.mocasystem.dto.FotosDTO;
import com.mocasystem.exceptions.BOException;

@Service
public class FotoBOImpl implements IFotoBO{
	
	@Autowired
	private FotosDAO objFotosDAO;
	
	@Override
	public List<FotosDTO> consultarFotos(Integer intCodigoEmpresa,String strNemonico,String strNombre) throws BOException {
		// Valida que el campo CodigoEmpresas diferente a null.
		if (ObjectUtils.isEmpty(intCodigoEmpresa)){
			throw new BOException("moc.warn.campoObligatorio", new Object[] { "moc.campos.secuenciaEmpresa" });
		}
		return objFotosDAO.consultarFotos(intCodigoEmpresa,strNemonico,strNombre);
	}
}
