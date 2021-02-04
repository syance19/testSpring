package com.bolsadeideas.springboot.backend.apirest.service;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.entity.Usuario;




public interface IUsuarioService {

	
	public List <Usuario> findAll();

	public void save(Usuario cliente);
	
	public Usuario findOne(Long id);
	
	public void delete (Long id);


}
