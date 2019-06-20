package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAO usuarioDao;
	
	@RequestMapping("/loginForm")
	public String formulario() {
		return "usuario/login";
	}
	
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		
		this.usuarioDao = new UsuarioDAO();
		boolean existeUsuario = this.usuarioDao.existeUsuario(usuario);
		
		if(existeUsuario) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		
		return "redirect:loginForm";
	}
}
