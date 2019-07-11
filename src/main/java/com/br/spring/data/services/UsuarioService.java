package com.br.spring.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.data.models.Usuario;
import com.br.spring.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario user) {
		usuarioRepository.save(user);
	}
	
	public Iterable<Usuario> pegarTodosUsuarios(){
		return usuarioRepository.findAll();
	}
}
