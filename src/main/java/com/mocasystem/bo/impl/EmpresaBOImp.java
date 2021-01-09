package com.mocasystem.bo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mocasystem.bo.IEmpresaBO;
import com.mocasystem.dto.InfoEmpresaDTO;
import com.mocasystem.exceptions.BOException;

@Service
public class EmpresaBOImp implements IEmpresaBO{

	@Override
	public List<InfoEmpresaDTO> infoEmpresa(Integer intCodigoEmpresa, String strVariable) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

}
