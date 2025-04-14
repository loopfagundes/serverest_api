package dev.serverest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"produtos"})
public class CarrinhoDTO {
    private List<ProdutoNoCarrinhoDTO> produtos;
}