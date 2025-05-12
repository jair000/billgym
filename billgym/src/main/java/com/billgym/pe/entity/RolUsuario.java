package com.billgym.pe.entity;

public enum RolUsuario {
	
	GERENTE_GENERAL("GERENTE_GENERAL"),
	RECEPCIONISTA("RECEPCIONISTA"),
	ENTRENADOR("ENTRENADOR"),
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
