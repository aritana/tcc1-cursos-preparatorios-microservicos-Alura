package alura.br.microservicesspringcloud.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoFornecedorDto {

    private String nomeFornecedorEstado;
    private String estado;
    private String nomeFornecedorCidade;
    private String cidade;
}
