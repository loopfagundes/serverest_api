package dev.serverest.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDTO {
    private List<ProdutoNoCarrinhoDTO> produtos;
}