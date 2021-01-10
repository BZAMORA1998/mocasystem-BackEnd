package com.mocasystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mocasystem.model.DatosEmpresa;
import com.mocasystem.model.DatosEmpresaCPK;


@Repository
public interface IDatosEmpresaDAO extends JpaRepository<DatosEmpresa,DatosEmpresaCPK>{

	
}
