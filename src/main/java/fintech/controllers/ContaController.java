package fintech.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fintech.dao.interfaces.ContaDAO;
import fintech.models.Conta;
import fintech.utils.MensagemErro;

@RestController
@RequestMapping("/conta")
public class ContaController {

	public static final Logger LOG = LoggerFactory.getLogger(ContaController.class);
	
	@Autowired
	private ContaDAO contaDAO;

	@RequestMapping(value = "/conta", method = RequestMethod.POST)
	public ResponseEntity<?> criar(@Validated @RequestBody Conta conta) {
		try {
			LOG.info("Criando conta : {}", conta);			
			contaDAO.criar(conta);			
			return new ResponseEntity<>(new MensagemErro("Conta criada com sucesso!"), HttpStatus.CREATED);	
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na crição de uma conta: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@RequestMapping(value = "/contas", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listar() {
		LOG.info("Listando contas");			
		List<Conta> contas = contaDAO.listarTodos();
		return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);		
	}	

	@RequestMapping(value = "/contaOrigem/{origem}/contaDestino/{destino}/transferencia/{valor}", method = RequestMethod.PUT)
	public ResponseEntity<?> transferencia(@PathVariable(value = "origem") Long origem,
										  @PathVariable(value = "destino") Long destino,
										  @PathVariable(value = "valor") Double valor) {
		try {	
			if(origem.equals(destino))
				return new ResponseEntity<>(new MensagemErro("Conta de origem não pode ser igual a de destino"), HttpStatus.OK);
				
			contaDAO.transferirValor(origem, destino, valor);
			return new ResponseEntity<>(new MensagemErro("Transferencia realizada com sucesso!"), HttpStatus.OK);	
		} catch (Exception ex) {
			LOG.error("Erro na tranferência: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.BAD_REQUEST);
		}		
	}
	
	@RequestMapping(value = "/conta/{destino}/transacao/{valor}", method = RequestMethod.PUT)
	public ResponseEntity<?> transacaoAporte(@PathVariable(value = "destino")  Long destino, @PathVariable(value = "valor") Double valor) {
		try {
			LOG.info("Conta destino: {}", destino);			
			contaDAO.transacaoAporte(destino, valor);	
			return new ResponseEntity<>(new MensagemErro("Transação realizada com sucesso!"), HttpStatus.OK);	
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro na transação de valor para a conta: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.BAD_REQUEST);
		}		
	}	
	
	@RequestMapping(value = "/conta/{codigoTransacao}/estorno", method = RequestMethod.PUT)
	public ResponseEntity<?> estornoTransacao(@PathVariable(value = "codigoTransacao")  Long codigoTransacao) {
		try {
			LOG.info("Código transacao: {}", codigoTransacao);			
			contaDAO.transacaoEstorno(codigoTransacao);	
			return new ResponseEntity<>(new MensagemErro("Estorno realizado com sucesso!"), HttpStatus.OK);	
		} catch (Exception ex) {
			LOG.error("Ocorreu um erro no estorno: " + ex.getMessage());
			return new ResponseEntity<>(new MensagemErro(ex.getMessage()), HttpStatus.BAD_REQUEST);
		}		
	}
	
}
