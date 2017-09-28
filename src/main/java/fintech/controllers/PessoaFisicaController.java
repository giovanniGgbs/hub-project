package fintech.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fintech.dao.interfaces.PessoaDAO;
import fintech.models.Pessoa;
import fintech.models.PessoaFisica;

@Controller()
@RequestMapping("/pessoa")
public class PessoaFisicaController {

	// Wire the PessoaDAO used inside this controller.
	@Autowired
	private PessoaDAO pessoaDAO;

	@RequestMapping(value = "/fisica/create")
	@ResponseBody
	public String create(@RequestParam(value = "nome") String nome, @RequestParam(value = "data") String data,
			@RequestParam(value = "cpf") String cpf) {
		try {
			PessoaFisica pf = new PessoaFisica();

			pf.setNome(nome);

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date strToDate = format.parse(data);

			pf.setDtNascimento(strToDate);
			pf.setCpf(cpf);

			pessoaDAO.create(pf);

		} catch (Exception ex) {
			return "Error creating the person: " + ex.toString();
		}
		return "Person succesfully created!";
	}
	
	@RequestMapping(value = "/fisica/update")
	@ResponseBody
	public String update(@RequestParam(value = "nome") String nome, @RequestParam(value = "data") String data,
			@RequestParam(value = "cpf") String cpf) {
		try {
			PessoaFisica pf = new PessoaFisica();

			pf.setNome(nome);

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date strToDate = format.parse(data);

			pf.setDtNascimento(strToDate);
			pf.setCpf(cpf);

			pessoaDAO.update(pf);

		} catch (Exception ex) {
			return "Error creating the person: " + ex.toString();
		}
		return "Person succesfully created!";
	}
	
	@RequestMapping(value = "/fisica/find-by-name")
	@ResponseBody
	public String findByName(@RequestParam(value = "nome")String nome){
		
		PessoaFisica pf;
		
		try {

			pf = (PessoaFisica) pessoaDAO.getByName(nome);
			
		} catch (Exception ex) {
			return "Error finding the person: " + ex.toString();
		}
		return "Person succesfully founded! \n" + pf;
	}
	
	@RequestMapping(value = "/fisica/find")
	@ResponseBody
	public String findAll(){
		
		List<Pessoa> pessoas;
		
		try {

			pessoas = pessoaDAO.getAll();
			
		} catch (Exception ex) {
			return "Error finding the person: " + ex.toString();
		}
		return "Person succesfully founded! \n" + pessoas;
	}
	

	@RequestMapping(value = "/fisica/remove")
	@ResponseBody
	public String remove(String nome){
		
		try {
			pessoaDAO.delete(nome);
			
		} catch (Exception ex) {
			return "Error deleting the person: " + ex.toString();
		}
		return "Person succesfully deleted!";
	}
}
