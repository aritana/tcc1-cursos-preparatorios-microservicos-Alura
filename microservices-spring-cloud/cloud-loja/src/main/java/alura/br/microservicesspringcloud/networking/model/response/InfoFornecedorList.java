package alura.br.microservicesspringcloud.networking.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoFornecedorList {

    List<InfoFornecedor> infoFornecedorList;
}
