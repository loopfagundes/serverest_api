package dev.serverest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"email", "password"})
public class LoginDTO {
    private String email;
    private String password;
}