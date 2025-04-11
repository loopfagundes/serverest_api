package dev.serverest.stubs;

import com.github.javafaker.Faker;

import dev.serverest.dto.CarrinhoDTO;
import dev.serverest.managers.PropertiesManager;

public class CarrinhoStub {
    public static CarrinhoDTO carrinhoStub() {
        return new CarrinhoDTO(
            PropertiesManager.loadProperties("properites", "idProduto"),
            Faker.instance().number().numberBetween(1, 150)
        );
    }
}