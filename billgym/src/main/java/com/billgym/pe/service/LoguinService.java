package com.billgym.pe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Loguin;
import com.billgym.pe.repository.LoguinRepository;

@Service
public class LoguinService {
	//
    private final LoguinRepository loguinRepository;
	public LoguinService(LoguinRepository loguinRepository) {
		this.loguinRepository = loguinRepository;
	}
	
	//PARA DEVOLVER TODA LISTA DE LOGUIN
	public List<Loguin> listarLoguin(){
		return loguinRepository.findAll();
	}
	
	//PARA OBTENER LOGUIN POR ID
	public Loguin obtenerLoguin(Integer id_loguin) {
		return loguinRepository.findById(id_loguin).orElseThrow(()-> new IllegalArgumentException("ID invalido"+id_loguin));
		
	}	
	
	//METODO PARA ACTUALISAR lOGUIN
	public void guardarLoguin(Loguin loguin) {
		loguinRepository.save(loguin);
		
	}
	
	//METODO PARA BUSCAR USUARIO POR SU DNI
	
	public List<Loguin> buscar (String termino){
		return loguinRepository.buscarPorDniUsuario(termino);
	}
	
	// METODO PARA ELIMINAR USER DE LOGUIN
	 public void eliminar(Integer id_loguin) {
		 loguinRepository.deleteById(id_loguin);		
	}
	
	 
	//VALIDAR USUARIO Y CONTRASEÑA
	 public Loguin validarCredenciales(String usuario, String password) {
		 return loguinRepository.findByUsuarioAndPassword(usuario, password);
	 }

}
