package com.mocasystem.bo;

import java.util.List;

import com.mocasystem.dto.FotosDTO;
import com.mocasystem.exceptions.BOException;

public interface IFotoBO {

	public List<FotosDTO>  consultarFotos(Integer intCodigoEmpresa, String strNemonico, String strNombre)throws BOException;
}
