package dev.serverest.stubs;

import dev.serverest.dto.LoginDTO;

public class LoginStub {
    public static LoginDTO loginUsuarioStub() {
        return new LoginDTO(
                "test@testng.com",
                "secret123");
    }
}