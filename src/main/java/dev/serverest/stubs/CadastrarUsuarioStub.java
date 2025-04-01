package dev.serverest.stubs;

import dev.serverest.dto.UsuarioDTO;

public class CadastrarUsuarioStub {
    public static UsuarioDTO usuarioDto() {
        return new UsuarioDTO(
                "Luciano",
                "test@testng.com",
                "secret123",
                "true"
        );
    }
}