package com.mocasystem.dto;

import lombok.Data;

@Data
public class EmpresaDTO {
	 private Integer secuenciaEmpresa;
	 private String nombre;
	 private String descripcion;
	 private String esActivo;
	 private byte[] logo;
}
