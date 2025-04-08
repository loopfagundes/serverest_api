package dev.serverest.testcases.contrato.produtos;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import dev.serverest.bases.ProdutosBaseTest; 
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;

public class ProdutosTestCase extends ProdutosBaseTest {

    @Epic("Teste de Produtos")
    @Feature("[GET] - Teste para buscar a lista dos produtos cadastrados.")
    @Description("Deve retornar 200 e a lista completa dos produtos cadastrados.")
    @Test(priority = 1)
    public void buscarAListaDosProdutos200() {
        RestAssured.given()
                    .spec(pathProdutosRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all();
    }
}
