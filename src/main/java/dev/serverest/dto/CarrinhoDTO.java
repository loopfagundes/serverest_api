package dev.serverest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.Properties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"idProduto", "quantidade"})
public class CarrinhoDTO {
    private Properties idProduto;
    private int quantidade;
}