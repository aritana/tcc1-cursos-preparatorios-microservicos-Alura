package alura.br.microservicesspringcloud.dto.responseError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorListErrorDto {

    List<InfoFornecedorErrorDto> infoFornecedorErrorDtoList;

}
