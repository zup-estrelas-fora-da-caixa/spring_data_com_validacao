package com.br.spring.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.data.models.Usuario;
import com.br.spring.data.services.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public ModelAndView exibirUsuarios() {
		ModelAndView modelAndView = new ModelAndView("usuarios.html");
		modelAndView.addObject("usuarios", usuarioService.pegarTodosUsuarios());
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView salvarUsuario(Usuario user) {
		usuarioService.salvarUsuario(user);
		ModelAndView modelAndView = new ModelAndView("usuarios.html");
		modelAndView.addObject("usuarios", usuarioService.pegarTodosUsuarios());
		return modelAndView;	
	}
	
}
