# Projeto Spring Boot 3 com OpenFeign

Este é um projeto Spring Boot 3 que utiliza o OpenFeign para comunicação de serviços RESTful. O projeto inclui configurações para três ambientes: Desenvolvimento, Homologação e Produção.

## Ambientes

### Desenvolvimento

- **URL Base do Serviço**: `http://localhost:8181/swagger-ui/index.html`
- Configurações específicas do ambiente de desenvolvimento, como banco de dados local e logs detalhados, podem ser encontradas no arquivo `application-dev.yml`.

### Homologação

- **URL Base do Serviço**: `http://localhost:8282/swagger-ui/index.html`
- Configurações específicas do ambiente de homologação estão no arquivo `application-hml.yml`.

### Produção

- **URL Base do Serviço**: `http://localhost:8282/swagger-ui/index.html`
- Configurações específicas do ambiente de produção estão no arquivo `application-prd.yml`.

## Configurações

As configurações gerais do aplicativo podem ser encontradas no arquivo `application.properties`. Aqui estão algumas das principais configurações:

- **spring.profiles.active: Variavel de ambiente (APPLICATION.AMBIENTE = dev, hml ou prd).

## OpenFeign

Este projeto utiliza o OpenFeign para realizar chamadas a serviços RESTful. As interfaces de cliente para esses serviços podem ser encontradas no pacote `br.com.deltatgn.endereco.infrastructure.client`.

## Como Executar

Para executar o projeto localmente, você pode usar o Maven. Execute o seguinte comando na raiz do projeto:

```bash
mvn spring-boot:run
