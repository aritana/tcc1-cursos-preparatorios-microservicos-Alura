package alura.br.microservicesspringcloud.dto;

import alura.br.microservicesspringcloud.model.InfoFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorCidadeDto {

    private String nome;
    private String cidade;

    public static InfoFornecedorCidadeDto map(InfoFornecedor infoFornecedor) {
        return new InfoFornecedorCidadeDto(infoFornecedor.getNome(), infoFornecedor.getEstado());
    }
}
