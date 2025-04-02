package dev.serverest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"nome", "email", "password", "administrador"})
public class UsuarioDTO {
    private String nome;
    private String email;
    private String password;
    private String administrador;
}