package fintech.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import fintech.dao.interfaces.PessoaDAO;
import fintech.models.Pessoa;
import fintech.models.PessoaFisica;
import fintech.models.PessoaJuridica;
import fintech.utils.MensagemErro;
import io.swagger.annotations.Api;

@Controller()
@RequestMapping("/pessoa")
@Api(value = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	public static final Logger LOG = LoggerFactory.getLogger(PessoaController.class);

	@RequestMapping(value = "/fisica/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> create(@RequestParam(value = "nome") String nome, @RequestParam(value = "data") String data,
			@RequestParam(value = "cpf") String cpf) {
		try {
			
			PessoaFisica pf = new PessoaFisica();

			pf.setNome(nome);

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date strToDate = format.parse(data);

			pf.setDtNascimento(strToDate);
			pf.setCpf(cpf);
			
			LOG.info("Criando pessoa física : {}", pf);
			pessoaDAO.criar(pf);

		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na crição de uma pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar o cadastro da pessoa física!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Cadastro de pessoa física realizado com sucesso!"), HttpStatus.OK);
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
	
	@RequestMapping(value = "/fisica/find/by/name")
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
			pessoaDAO.remover(nome);
			
		} catch (Exception ex) {
			return "Error deleting the person: " + ex.toString();
		}
		return "Person succesfully deleted!";
	}
	

	@RequestMapping(value = "/juridica/create")
	@ResponseBody
	public String createJuridica(
			@RequestParam(value = "razaoSocial")String razaoSocial,
			@RequestParam(value = "cnpj") String cnpj) {
		try {
			PessoaJuridica pj = new PessoaJuridica();
			
			pj.setRazaoSocial(razaoSocial);
			pj.setCnpj(cnpj);
			
			pessoaDAO.criar(pj);
			
		} catch (Exception ex) {
			return "Error creating the person: " + ex.toString();
		}
		return "Person succesfully created!";
	}
	
	@RequestMapping(value = "/juridica/update")
	@ResponseBody
	public String updateJuridica(@RequestParam(value = "nome") String nome, @RequestParam(value = "data") String data,
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
	
	@RequestMapping(value = "/juridica/find/by/name")
	@ResponseBody
	public String findJuridicaByName(@RequestParam(value = "nome")String nome){
		
		PessoaFisica pf;
		
		try {

			pf = (PessoaFisica) pessoaDAO.getByName(nome);
			
		} catch (Exception ex) {
			return "Error finding the person: " + ex.toString();
		}
		return "Person succesfully founded! \n" + pf;
	}
	
	@RequestMapping(value = "/juridica/find")
	@ResponseBody
	public String findAllJuridica(){
		
		List<Pessoa> pessoas;
		
		try {

			pessoas = pessoaDAO.getAllJuridica();
			
		} catch (Exception ex) {
			return "Error finding the person: " + ex.toString();
		}
		return "Person succesfully founded! \n" + pessoas;
	}
	

	@RequestMapping(value = "/juridica/remove")
	@ResponseBody
	public String removeJuridica(String nome){
		
		try {
			pessoaDAO.remover(nome);
			
		} catch (Exception ex) {
			return "Error deleting the person: " + ex.toString();
		}
		return "Person succesfully deleted!";
	}
	
	
}
