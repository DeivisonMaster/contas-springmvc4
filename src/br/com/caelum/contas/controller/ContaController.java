package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	private ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/form")
	public String formulario() {
		return "formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formulario";
		}
		
		System.out.println("Conta adicionada é: " + conta.getDescricao());
		this.dao.adiciona(conta);
		
		return "redirect:listaContas";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		List<Conta> contas = this.dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("listaContas", contas);
		
		return mv;
	}
	
	@RequestMapping("/removeConta")
	public String removeConta(Conta conta) {
		this.dao.remove(conta);
		
		//return "forward:listaContas"; // redireciona no servidor e mantem a url = 1 requisição mantendo o mesmo objeto populado
		return "redirect:listaContas"; // redireciona no lado cliente e altera a url = 2 requisições com perca do objeto populado
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Conta conta, HttpServletResponse response) {
		this.dao.paga(conta.getId());
		
		response.setStatus(200);
	}
}













