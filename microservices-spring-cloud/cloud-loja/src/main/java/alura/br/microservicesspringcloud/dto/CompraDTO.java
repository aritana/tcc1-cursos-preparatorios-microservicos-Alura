package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class CompraDTO {

    private List<ItemDaCompraDto> itens;
    @Valid private EnderecoDto endereco;

}
