package fintech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fintech.dao.interfaces.PessoaDAO;
import fintech.models.PessoaJuridica;

@Controller()
@RequestMapping("/pessoa")
public class PessoaJuridicaController {

	// Wire the PessoaDAO used inside this controller.
	@Autowired
	private PessoaDAO pessoaDAO;

	@RequestMapping(value = "/juridica")
	@ResponseBody
	public String create(
			@RequestParam(value = "razaoSocial")String razaoSocial,
			@RequestParam(value = "cnpj") String cnpj) {
		try {
			PessoaJuridica pj = new PessoaJuridica();
			
			pj.setRazaoSocial(razaoSocial);
			pj.setCnpj(cnpj);
			
			pessoaDAO.create(pj);
			
		} catch (Exception ex) {
			return "Error creating the person: " + ex.toString();
		}
		return "Person succesfully created!";
	}
	

}
