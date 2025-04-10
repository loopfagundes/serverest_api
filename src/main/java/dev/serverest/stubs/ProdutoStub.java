package dev.serverest.stubs;

import dev.serverest.dto.ProdutoDTO;

public class ProdutoStub {
    public static ProdutoDTO cadastrarProdutoStub() {
        return new ProdutoDTO(
                "LG Ultragear 24 180hz",
                "1000",
                "Monitor Gamer",
                "200");
    }

    public static ProdutoDTO editarProdutoStub() {
        return new ProdutoDTO(
                "LG Ultragear 24 180hz - PROMOÇÂO 50%",
                "500",
                "Monitor Gamer",
                "200");
    }
}