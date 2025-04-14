package dev.serverest.testcases.contrato;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import dev.serverest.bases.ProdutosBaseTest;
import dev.serverest.helpers.JsonSchemaValidatorHelper;
import dev.serverest.managers.PropertiesManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;

public class ProdutosTestCase extends ProdutosBaseTest {

    @Epic("Teste de Produtos")
    @Feature("[DELETE] - Teste para exculir o ID de produto cadastrado.")
    @Description("Deve retornar 200 e confirmar que o produto foi deletado.")
    @Test(priority = 1)
    public void deleteProduto200() {
        RestAssured.given()
                    .spec(deleteProdutoRequest)
                .when()
                    .delete("/" + ID_PRODUTO)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("produtos/delete_produto"));
    }

    @Epic("Teste de Produtos")
    @Feature("[POST] - Teste para cadastrar um produto.")
    @Description("Deve retornar 201 e o produto cadastrado.")
    @Test(priority = 2)
    public void cadastrarUmProduto201() {
        idProduto =
            RestAssured.given()
                        .spec(cadastrarProdutoRequest)
                    .when()
                        .post()
                    .then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .log().all()
                        .body(JsonSchemaValidatorHelper.validateJson("produtos/cadastrar_produto"))
                        .extract().path("_id");
            PropertiesManager.setProperty("properties", "idProduto", "ID_PRODUTO", idProduto);
    }

    @Epic("Teste de Produtos")
    @Feature("[GET] - Teste para buscar a lista dos produtos cadastrados.")
    @Description("Deve retornar 200 e a lista completa dos produtos cadastrados.")
    @Test(priority = 3)
    public void buscarAListaDosProdutos200() {
        RestAssured.given()
                    .spec(pathProdutosRequest)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("produtos/buscar_todos_produtos"));
    }

    @Epic("Teste de Produtos")
    @Feature("[PUT] - Teste para fazer editar um produto cadastrado.")
    @Description("Deve retornar 200 e um produto cadastrado foi editado.")
    @Test(priority = 5)
    public void editarProduto200() {
        RestAssured.given()
                    .spec(editarProdutoRequest)
                .when()
                    .put("/" + idProduto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("produtos/editar_id_produto"));
    }

    @Epic("Teste de Produtos")
    @Feature("[GET] - Teste para buscar o ID do produto cadastrado.")
    @Description("Deve retornar 200 e a lista o ID do produto cadastrado.")
    @Test(priority = 6)
    public void buscarIDDoProduto200() {
        RestAssured.given()
                    .spec(pathProdutosRequest)
                .when()
                    .get("/" + idProduto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body(JsonSchemaValidatorHelper.validateJson("produtos/buscar_id_produto"));
    }
}
