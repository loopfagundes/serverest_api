package dev.serverest.stubs;

import java.util.Collections;
import com.github.javafaker.Faker;
import dev.serverest.dto.CarrinhoDTO;
import dev.serverest.dto.ProdutoNoCarrinhoDTO;
import dev.serverest.managers.PropertiesManager;

public class CarrinhoStub {
    public static CarrinhoDTO carrinhoStub() {
        ProdutoNoCarrinhoDTO produto = new ProdutoNoCarrinhoDTO(
                PropertiesManager.loadProperties("properties", "idProduto").getProperty("ID_PRODUTO"),
                String.valueOf(Faker.instance().number().numberBetween(1, 150)));
        return new CarrinhoDTO(Collections.singletonList(produto));
    }
}