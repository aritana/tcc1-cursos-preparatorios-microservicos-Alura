package alura.br.microservicesspringcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDaCompraDto {

    private long id;
    private int quantidade;
}
