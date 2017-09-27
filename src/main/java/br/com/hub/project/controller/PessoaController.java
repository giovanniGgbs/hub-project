package br.com.hub.project.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.hub.project.dao.PessoaDAO;
import br.com.hub.project.dao.impl.PessoaDAOImpl;
import br.com.hub.project.entity.PessoaFisica;

/**
 * Class UserController
 */
@Controller
public class PessoaController {


	// Wire the UserDao used inside this controller.
	@Autowired
	private PessoaDAO pessoaDAO;

	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/fisica")
	@ResponseBody
	public String create() {
		pessoaDAO = new PessoaDAOImpl();
		try {
			PessoaFisica p = new PessoaFisica();
			
			p.setNome("Teste");
			p.setDtNascimento(new Date());
			p.setCpf("422.165.988-28");
			
			pessoaDAO.create(p);
			
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "Person succesfully created!";
	}

} 
