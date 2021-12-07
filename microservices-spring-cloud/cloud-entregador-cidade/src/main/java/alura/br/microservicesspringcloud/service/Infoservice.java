package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.model.InfoFornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Infoservice {

    @Autowired
    private InfoRepository infoRepository;
    public InfoFornecedor getInfoPorEstado(String cidade) {
        InfoFornecedor infoFornecedor = infoRepository.findByCidade(cidade);
        return infoFornecedor;
    }
}
