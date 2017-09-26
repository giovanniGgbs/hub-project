package br.com.hub.project.controller;

import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hub.project.entity.Pessoa;
import br.com.hub.project.entity.PessoaFisica;


@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Produces("application/json; charset=UTF-8")
	@RequestMapping(value = "/fisica", method = RequestMethod.GET)
	public Pessoa create() {
		
		Pessoa p = new PessoaFisica();
	
		return p;
	}
	
}
