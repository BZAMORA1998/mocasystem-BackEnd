package com.mocasystem.bo.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mocasystem.bo.IEmpresaBO;
import com.mocasystem.dao.DatosEmpresaDAO;
import com.mocasystem.dao.EmpresasDAO;
import com.mocasystem.dto.EmpresaDTO;
import com.mocasystem.dto.InfoEmpresaDTO;
import com.mocasystem.exceptions.BOException;
import com.mocasystem.model.Empresas;

@Service
public class EmpresaBOImp implements IEmpresaBO{
	
	@Autowired
	private DatosEmpresaDAO objDatosEmpresaDAO;
	@Autowired
	private EmpresasDAO objEmpresasDAO;
	
	@Override
	public List<InfoEmpresaDTO> infoEmpresa(Integer intCodigoEmpresa, String strVariable) throws BOException {
		// Valida que el campo CodigoEmpresas diferente a null.
		if (ObjectUtils.isEmpty(intCodigoEmpresa)){
			throw new BOException("moc.warn.campoObligatorio", new Object[] { "moc.campos.secuenciaEmpresa" });
		}
		
		// Valida que el campo strVariable diferente a null.
		if (ObjectUtils.isEmpty(strVariable)) {
			throw new BOException("moc.warn.campoObligatorio", new Object[] { "moc.campos.variable" });
		}
		
		String [] items = strVariable.toUpperCase().split(",");
		List<String> container = Arrays.asList(items);
				
		
		List<InfoEmpresaDTO> lsInfoEmpresaDTO= objDatosEmpresaDAO.infoEmpresa(intCodigoEmpresa,container);
		
		return lsInfoEmpresaDTO;
	}

	@Override
	public EmpresaDTO consultarEmpresa(Integer intCodigoEmpresa) throws BOException {
		
		// Valida que el campo CodigoEmpresas diferente a null.
		if (ObjectUtils.isEmpty(intCodigoEmpresa)){
			throw new BOException("moc.warn.campoObligatorio", new Object[] { "moc.campos.secuenciaEmpresa" });
		}
		
		EmpresaDTO objEmpresaDTO=null;
		Optional<Empresas> objEmpresas=objEmpresasDAO.find(intCodigoEmpresa);
		if(objEmpresas.isPresent()) {
			objEmpresaDTO=new EmpresaDTO();
			objEmpresaDTO.setSecuenciaEmpresa(objEmpresas.get().getSecuenciaEmpresa());
			objEmpresaDTO.setNombre(objEmpresas.get().getNombre());
			objEmpresaDTO.setDescripcion(objEmpresas.get().getDescripcion());
			objEmpresaDTO.setLogo(objEmpresas.get().getLogo());
		}
		return objEmpresaDTO;
	}

}
