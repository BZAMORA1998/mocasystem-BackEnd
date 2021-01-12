package com.mocasystem.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.mocasystem.dto.InfoEmpresaDTO;
import com.mocasystem.model.DatosEmpresa;
import com.mocasystem.model.DatosEmpresaCPK;

import lombok.NonNull;

@Service
public class DatosEmpresaDAO extends BaseDAO<DatosEmpresa, DatosEmpresaCPK>{

	@PersistenceContext
	EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	protected DatosEmpresaDAO() {
		super(DatosEmpresa.class);
	}

	@Override
	public void persist(DatosEmpresa t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(DatosEmpresa t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<DatosEmpresa> find(@NonNull DatosEmpresaCPK id) {
		return super.find(id);
	}

	public List<InfoEmpresaDTO> infoEmpresa(Integer intCodigoEmpresa, List<String> lsNemonicos) {
		 
		StringBuilder strJPQL = new StringBuilder();

		try {
			strJPQL.append(" SELECT de.datosEmpresaCPK.nemonico as nemonico, ");
			strJPQL.append("    	de.nombre as nombre,");
			strJPQL.append("    	de.descripcion as descripcion");
			strJPQL.append(" FROM 	DatosEmpresa de");
			strJPQL.append(" WHERE 	de.datosEmpresaCPK.secuenciaEmpresa=:secuenciaEmpresa");
			strJPQL.append(" AND  	de.datosEmpresaCPK.nemonico in (:nemonicos)");
			strJPQL.append(" AND  	de.esActivo ='S'");
			
			TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createQuery(strJPQL.toString(), Tuple.class);
			query.setParameter("secuenciaEmpresa", intCodigoEmpresa);
			query.setParameter("nemonicos", lsNemonicos);
			
			return query	
					.getResultList()
					.stream()
					.map(tuple -> {return InfoEmpresaDTO.builder()
					.nemonico(tuple.get("nemonico",String.class))
					.nombre(tuple.get("nombre",String.class))
					.descripcion(tuple.get("descripcion",String.class))
					.build();})
					.collect(Collectors.toList());

		} catch (NoResultException e) {
			return null;
		}
	}
}
