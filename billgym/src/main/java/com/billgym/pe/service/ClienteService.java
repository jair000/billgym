package com.billgym.pe.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Cliente;
import com.billgym.pe.exeption.DniDuplicadoExeption;
import com.billgym.pe.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
	//CONSTRUCTOR DE CLASES 
	public ClienteService(ClienteRepository clienteRepository){      //(ClienteRepository clienteRepository) <--ES UNA INSTANCIA
		this.clienteRepository = clienteRepository;
	}
	
	//DEVULEVE LA LISTA DE TODO LOS CLIENTES
	public  List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	//PARA OBTENER USUARIO POR ID
	
	public Cliente obtenerCliente(Integer id) {
		return clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID invalido: "+id));
	}
	
	//METODO PARA ACTUALIZAR CLIENTES
	 public void guardarCliente(Cliente cliente) {
		 try {
			clienteRepository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw  new DniDuplicadoExeption("EL DNI :"+ cliente.getDni()+" Ya existe");
			// TODO: handle exception
		}
		
		
	}
	//METODO PARA ELIMINAR CLIENTES
	 
	 public void eliminarCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
	//PARA BUSCAR CLIENTE POR SU DNI
	 
	 public List<Cliente> buscar(String termino){
		 return clienteRepository.findByDniContainingIgnoreCase(termino);
	 }
}
