package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoDto {

    String rua;
    int numero;
    String estado;
}
