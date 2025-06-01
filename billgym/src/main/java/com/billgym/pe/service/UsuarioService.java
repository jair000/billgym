package com.billgym.pe.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Usuario;
import com.billgym.pe.exception.DniDuplicadoException;
import com.billgym.pe.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
	
	//CONSTRUCTOR DE CLASES
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;		
	}
	
	//DEVULEVE LA LISTA DE TODO LOS USUARIOS
	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
	}
	
	//PARA OBTENER  USUARIO POR ID
	public Usuario obtenerUsuario(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID Invalido :"+id));
	}
	
	//METODO PARA ACTIALIZAR USUARIO
	public void guardarUsuario(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
		} catch (DataIntegrityViolationException e) {
			throw new DniDuplicadoException("El DNI: "+usuario.getDni()+"Ya Existe :");
		}		
	}
	
	//METODO PARA ELIMINAR
	public void eliminarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
		
	}
	//METODO PARA BUSCAR USUARIO
	 
	public List<Usuario> buscar(String termino){
		return usuarioRepository.findByDniContainingIgnoreCase(termino);
	}

}
