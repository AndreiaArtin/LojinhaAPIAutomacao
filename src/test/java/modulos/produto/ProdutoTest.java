package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Teste de API rest do modulo produto")
public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach() {
        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";


        // Obter token do usuário admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.acessarcomUsuarioAdministrador())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("Validar que o valor 0.00 do produto não é permitido")
    public void testValidarValoresZeradoProibido(){

        // Tentar inserir um produto com valor 0.00 e validar se a mensagem de erro foi apresentada
        // e o status code é 422


        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(0.00))
        .when()
                .post("/v2/produtos")

        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00") )
                    .statusCode(422);


    }
    @Test
    @DisplayName("Validar que o valor 7000.01 do produto não é permitido")
    public void testValidarValoresMaiorSeteMilProibido(){
        // Tentar inserir um produto com valor 0.00 e validar se a mensagem de erro foi apresentada
        // e o status code é 422
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComunComValorIgualA(7000.01))
            .when()
                .post("/v2/produtos")

            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00") )
                    .statusCode(422);
    }

}
