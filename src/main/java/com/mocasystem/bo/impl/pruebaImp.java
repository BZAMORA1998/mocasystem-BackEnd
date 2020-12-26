package com.mocasystem.bo.impl;

import org.springframework.stereotype.Service;

import com.mocasystem.bo.pruebaBO;
import com.mocasystem.exceptions.BOException;

@Service
public class pruebaImp implements pruebaBO{

	@Override
	public void prueba() throws BOException {
		throw new BOException("moca.response.ok");
	}

}
