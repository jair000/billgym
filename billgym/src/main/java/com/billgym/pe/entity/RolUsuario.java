package com.billgym.pe.entity;

public enum RolUsuario {
	
	PRESIDENTE_FUNDADOR("PRESIDENTE_FUNDADOR"),
	GERENTE_GENERAL("GERENTE_GENERAL"),
	GERENTE_OPRACIONES("GERENTE_OPRACIONES"),
	OPERARIO("OPERARIO"),
	ENCARGADO("ENCARGADO"),
	AYUDANTE("AYUDANTE"),
	SEGURIDAD("SEGURIDAD"),
	LIMPIEZA("LIMPIEZA"),
	SUPERVISOR("SUPERVISOR");
	

	private final String nombreRol;
	
	 RolUsuario(String nombreRol) {
	        this.nombreRol = nombreRol;
	    }

	public String getNombreRol() {
		return nombreRol;
	}

	public static RolUsuario fromNombreRol(String nombreRol) {
        for (RolUsuario rol : RolUsuario.values()) {
            if (rol.nombreRol.equalsIgnoreCase(nombreRol)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("No se encontró un RolUsuario para: " + nombreRol);
    }

}
