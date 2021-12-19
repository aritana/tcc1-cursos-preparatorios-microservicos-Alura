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

public class InfoFornecedorDto {

    private String nomeFornecedorEstado;
    private String estado;
    private String nomeFornecedorCidade;
    private String cidade;

    public static InfoFornecedorDto map(InfoFornecedor infoFornecedor,InfoFornecedorCidadeDto infoFornecedorCidadeDto) {


        return new InfoFornecedorDto(infoFornecedor.getNome(), infoFornecedor.getEstado(),infoFornecedorCidadeDto.getNome(), infoFornecedorCidadeDto.getCidade());
    }
}
