package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CompraDTO {

    private List<ItemDaCompraDto> itens;
    private EnderecoDto endereco;
}
