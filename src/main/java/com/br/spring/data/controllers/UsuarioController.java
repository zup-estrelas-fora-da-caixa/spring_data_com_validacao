package com.br.spring.data.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	public ModelAndView salvarUsuario(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("usuarios.html");

		if (bindingResult.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("usuarios", usuarioService.pegarTodosUsuarios());
			modelAndView.addObject("xablau", erros);
			return modelAndView;

		} else {
			usuarioService.salvarUsuario(user);
			modelAndView.addObject("usuarios", usuarioService.pegarTodosUsuarios());
			return modelAndView;
		}

	}

}
