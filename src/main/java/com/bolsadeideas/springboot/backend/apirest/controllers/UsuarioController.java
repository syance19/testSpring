package com.bolsadeideas.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.backend.apirest.entity.Usuario;
import com.bolsadeideas.springboot.backend.apirest.service.IUsuarioService;

import java.util.Map;

import javax.validation.Valid;

@Controller
public class UsuarioController {

	
	@Autowired
	private IUsuarioService usuarioService;
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuario", usuarioService.findAll());
		return "listar";
	}
	

	@RequestMapping("/form")
	public String crear (Map<String,Object> model) {
		Usuario usuario= new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario clientes");
		return "form";
	}
	
	@RequestMapping(value="/form" ,method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Cliente");
			return "form";
		}
		String mensajeFlash= (usuario.getUsrid() !=null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar (@PathVariable(value="id") Long id, Map<String,Object> model, RedirectAttributes flash) {
	Usuario usuario= null;
		if(id>0) {
		usuario=usuarioService.findOne(id);
		if(usuario ==null) {
			flash.addFlashAttribute("error", "El id del usuario no existe");
			return "redirect:/listar";
		}
	} else {
		flash.addFlashAttribute("error", "El id del cliente no existe");
		return "redirect:/listar";
	}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id , RedirectAttributes flash) {
		if(id>0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("success", "Usuario eliminado con éxito!");
		}
		return "redirect:/listar";
	}
	
}
