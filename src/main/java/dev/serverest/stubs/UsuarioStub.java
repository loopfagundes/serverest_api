package dev.serverest.stubs;

import dev.serverest.dto.UsuarioDTO;

public class UsuarioStub {
    public static UsuarioDTO cadastrarUsuarioStub() {
        return new UsuarioDTO(
                "Luciano",
                "test@testng.com",
                "secret123",
                "true");
    }

    public static UsuarioDTO editarUsuarioStub() {
        return new UsuarioDTO(
                "Luciano Rest Assured",
                "test@testng.com",
                "secret123",
                "true");
    }
}