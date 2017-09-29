## Hub Fintech - Teste para desenvolvedor - Sitema para controle de contas

- Autor: Giovanni Gonçalves Braga de Sousa

#### Pré requisitos

- Java 8
- Maven 3.3.9
- MySQL Server (J/Connector)

#### Configurações

Crie uma base de dados com o seguinte nome `hub_project`

Script: create database hub_project;

Abra o arquivo `application.properties` e insira os dados sobre o acesso ao SGBD.

### Build and run

Faça o build da aplicação e faça o start da classe `Application.java`

### Uso

- acesse o endereço http://localhost:8080/swagger-ui.html para acessar a página do Swagger da aplicação, onde serão listados os métodos da aplicação.

- Para as seguintes URL's use os seguintes metodos:

		* /pessoa/fisica/create - POST - Criar pessoa física:
			{
			  "cpf": "422.422.422-22",
			  "dtNascimento": "2017-09-29",
			  "nome": "Teste"
			}
			
		* /pessoa/juridica/create - POST - Criar pessoa jurídica:
			{
			  "cnpj": "01.001.001/0001-63",
			  "nome": "Pessoa Juridica",
			  "razaoSocial": "Razao Social"
			}

	   * /conta/conta - POST - Conta sem filha:
	   {
					  "contasFilhas": [
					    {}
					  ],
					  "dataCriacao": "2017-09-29",
					  "nome": "Conta Matriz",
					  "pessoa": {
					    "id": 1,
					    "name": "Teste"
					  },
					  "saldo": 500.00,
					  "situacao": "ATIVA"
					}
		* /conta/conta - POST - Conta com filha:
		{
		  "contasFilhas": [
		    {
		
		  "dataCriacao": "2017-09-29",
		  "nome": "Conta Filial 2",
		  "pessoa": {
		    "id": 1,
		    "nome": "Tese"
		  },
		  "saldo": 100.00,
		  "situacao": "ATIVA"
		
		
		    }
		  ],
		  "dataCriacao": "2017-09-29",
		  "nome": "Conta Filial",
		  "pessoa": {
		    "id": 1,
		    "nome": "Tese"
		  },
		  "saldo": 150.00,
		  "situacao": "ATIVA"
		}
			
		* /conta/conta/{id}/remover - Remoção de conta passar o id 2. E após passar o id 7
