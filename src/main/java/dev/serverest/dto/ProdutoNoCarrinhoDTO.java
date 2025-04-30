package dev.serverest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"idProduto", "quantidade"})
public class ProdutoNoCarrinhoDTO {
    private String idProduto;
    private String quantidade;
}