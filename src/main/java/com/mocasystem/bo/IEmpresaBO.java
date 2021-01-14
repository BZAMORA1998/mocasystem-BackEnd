package com.mocasystem.bo;

import java.util.List;

import com.mocasystem.dto.EmpresaDTO;
import com.mocasystem.dto.InfoEmpresaDTO;
import com.mocasystem.exceptions.BOException;

public interface IEmpresaBO {

	public List<InfoEmpresaDTO> infoEmpresa(Integer intCodigoEmpresa, String strVariable) throws BOException ;

	public EmpresaDTO consultarEmpresa(Integer intCodigoEmpresa)throws BOException ;

}
