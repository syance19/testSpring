package com.bolsadeideas.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.dao.IUsuarioDAO;
import com.bolsadeideas.springboot.backend.apirest.entity.Usuario;



@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}
	
	

}
