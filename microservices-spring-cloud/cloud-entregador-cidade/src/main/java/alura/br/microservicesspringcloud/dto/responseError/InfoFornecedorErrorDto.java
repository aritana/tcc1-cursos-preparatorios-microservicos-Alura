package alura.br.microservicesspringcloud.dto.responseError;

import alura.br.microservicesspringcloud.model.InfoFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorErrorDto {

    private String message;

}
