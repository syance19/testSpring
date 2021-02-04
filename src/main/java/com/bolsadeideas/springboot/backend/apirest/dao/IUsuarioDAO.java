package com.bolsadeideas.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.entity.Usuario;



public interface IUsuarioDAO  extends  CrudRepository<Usuario, Long>{

}
