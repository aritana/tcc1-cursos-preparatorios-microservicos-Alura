package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoDto {

    @NotEmpty @NotNull
    String estado;

    String cidade;
    String rua;
    int numero;

}
