package br.com.hub.project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hub.project.dao.PessoaDAO;
import br.com.hub.project.dao.impl.PessoaDAOImpl;
import br.com.hub.project.entity.Pessoa;
import br.com.hub.project.entity.PessoaFisica;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController_old {
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
//	@Produces("application/json; charset=UTF-8")
	@RequestMapping(value = "/fisica", method = RequestMethod.GET)
	public Pessoa create() {
		pessoaDAO = new PessoaDAOImpl();
		PessoaFisica p = new PessoaFisica();
		
		p.setNome("Teste");
		p.setDtNascimento(new Date());
		p.setCpf("422.165.988-28");
		
		pessoaDAO.create(p);
		
		return p;
	}
	
}
