package dev.serverest.stubs;

import dev.serverest.dto.UsuarioDTO;

public class CadastrarUsuarioStub {
    private static final UsuarioDTO dto = new UsuarioDTO();

    public static UsuarioDTO usuarioDto() {
        dto.setNome("Luciano");
        dto.setEmail("test@testng.com");
        dto.setPassword("secret123");
        dto.setAdministrador("true");
        return dto;
    }
}