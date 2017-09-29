## Hub Fintech - Teste para desenvolvedor - Sitema para controle de contas

- Autor: Giovanni Gonçalves Braga de Sousa

### Uso

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/user/save?email=[email]&name=[name]`: create a new user with an 
      auto-generated id and email and name as passed values.
    * `/user/delete?id=[id]`: delete the user with the passed id.
    * `/user/get-by-email?email=[email]`: retrieve the id for the user with the
      passed email address.

### Build and run

#### Configurações

Open the `application.properties` file and set your own configurations for the
database connection.

#### Pré requisitos

- Java 8
- Maven 3.3.9
- MySQL Server (J/Connector)

