package fintech.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fintech.dao.interfaces.PessoaDAO;
import fintech.models.Pessoa;
import fintech.models.PessoaFisica;
import fintech.models.PessoaJuridica;
import fintech.utils.MensagemErro;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	public static final Logger LOG = LoggerFactory.getLogger(PessoaController.class);

	@RequestMapping(value = "/fisica/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody PessoaFisica pessoa) {
		try {
			
			LOG.info("Criando pessoa física : {}", pessoa);
			pessoaDAO.criar(pessoa);

		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na criação de uma pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar o cadastro da pessoa física!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Cadastro de pessoa física realizado com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fisica/update", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody PessoaFisica pessoa) {
		try {
			LOG.info("Atualizando pessoa física : {}", pessoa);
			pessoaDAO.update(pessoa);

		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na atualização de uma pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a atualização da pessoa física!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Atualização de pessoa física realizada com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fisica/find/by/name", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findByName(@RequestParam(value = "nome")String nome){
		
		PessoaFisica pf;
		
		try {
			LOG.info("Procurando pessoa física : {}", nome);
			pf = (PessoaFisica) pessoaDAO.getByName(nome);
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na busca de uma pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a busca da pessoa física!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(pf, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fisica/find", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findAll(){
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			LOG.info("Procurando todas as pessoas físicas : {}", pessoas);
			pessoas = pessoaDAO.getAll();
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na busca de todas as pessoas física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a busca de todas as pessoas físicas!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/fisica/remove", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@RequestParam(value="nome") String nome){
		
		try {
			LOG.info("Removendo pessoa física : {}", nome);
			pessoaDAO.remover(nome);
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro ao remover a pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao remover a pessoa física!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Remoção de pessoa física realizada com sucesso!"), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/juridica/create", method = RequestMethod.POST)
	public ResponseEntity<?> createJuridica(@RequestBody PessoaJuridica pessoa) {
		try {
			
			LOG.info("Criando pessoa juridica : {}", pessoa);
			pessoaDAO.criar(pessoa);

		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na criação de uma pessoa juridica: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar o cadastro da pessoa juridica!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Cadastro de pessoa juridica realizada com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/juridica/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateJuridica(@RequestBody PessoaJuridica pessoa) {
		try {
			LOG.info("Atualizando pessoa juridica : {}", pessoa);
			pessoaDAO.update(pessoa);

		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na atualização de uma pessoa juridica: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a atualização da pessoa juridica!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Atualização de pessoa física realizada com sucesso!"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/juridica/find/by/name", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findJuridicaByName(@RequestParam(value = "nome")String nome){
		
		PessoaJuridica pf;
		
		try {
			LOG.info("Procurando pessoa juridica : {}", nome);
			pf = (PessoaJuridica) pessoaDAO.getByName(nome);
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na busca de uma pessoa juridica: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a busca da pessoa juridica!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(pf, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/juridica/find", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findAllJuridica(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			LOG.info("Procurando todas as pessoas físicas : {}", pessoas);
			pessoas = pessoaDAO.getAll();
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na busca de todas as pessoas juridicas: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao realizar a busca de todas as pessoas físicas!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}

	@RequestMapping(value = "/juridica/remove", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeJuridica(@RequestParam(value="nome") String nome){
		
		try {
			LOG.info("Removendo pessoa juridica : {}", nome);
			pessoaDAO.remover(nome);
			
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro ao remover a pessoa física: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro("Ocorreu um erro ao remover a pessoa juridica!"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new MensagemErro("Remoção de pessoa juridica realizada com sucesso!"), HttpStatus.OK);
	}
	
	
}
