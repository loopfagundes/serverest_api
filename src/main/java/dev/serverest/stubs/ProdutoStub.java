package dev.serverest.stubs;

import dev.serverest.dto.ProdutoDTO;

public class ProdutoStub {
    public static ProdutoDTO cadastrarProdutoDto() {
        return new ProdutoDTO(
            "LG Ultragear 24 180hz",
            "1000",
            "Monitor",
            "200"
        );
    }
}