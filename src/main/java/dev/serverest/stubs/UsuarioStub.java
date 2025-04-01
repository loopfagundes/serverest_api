package dev.serverest.stubs;

import dev.serverest.dto.UsuarioDTO;

public class UsuarioStub {
    public static UsuarioDTO cadastrarUsuarioDto() {
        return new UsuarioDTO(
                "Luciano",
                "test@testng.com",
                "secret123",
                "true"
        );
    }

    public static UsuarioDTO editarUsuarioDto() {
        return new UsuarioDTO(
                "Luciano Rest Assured",
                "test@testng.com",
                "secret123",
                "true"
        );
    }
}