package dev.serverest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"nome", "preco", "descricao", "quantidade"})
public class ProdutoDTO {
    private String nome;
    private String preco;
    private String descricao;
    private String quantidade;
}
