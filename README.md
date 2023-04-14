# Lojinha API Automação
Esse é um repositório que contém alguns testes de API Rest de um software denominado lojinha. Esse sub-tópicos descreve algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java - https://www.oracle.com/java/technologies/javase-jdk8-doc-downloads.html
- JUnit - https://mvnrepository.com/artifact/org.junit/junit5-engine/5.0.0-ALPHA
- Rest Assured - https://mvnrepository.com/artifact/io.rest-assured
- Maven - https://maven.apache.org/

## Testes automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na lojinha que estão diretamente vinculadas as regras de negócio do produto que diz que o valor deve estar entre R$ 0,01 e R$ 7000,00.

## Notas Gerais

- Foi utilizado a notação Before Each para capturar o token que é utilizado nos métodos de testes.
- Armazenado os dados que são enviados para API através de uso de classes POJO.
- Criamos dados inicais através de uso de classes Data Factory, para facilitar a criação e controle dos mesmos.
- O Junit 5 nos dá possibilidade de utilizar a notação Display Name para dar descrições em português para os testes. 


