package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorDto {

    //private String endereco;
    private long id;
    private String nome;
    private String estado;
    private String endereco;
}
