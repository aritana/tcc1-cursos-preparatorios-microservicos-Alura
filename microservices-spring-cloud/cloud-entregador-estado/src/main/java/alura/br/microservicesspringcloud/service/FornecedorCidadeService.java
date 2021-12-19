package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.dto.InfoFornecedorCidadeDto;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.networking.service.FornecedorCidadeServiceCore;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorCidadeService {
    
    private FornecedorCidadeServiceCore fornecedorCidadeServiceCore;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @Autowired
    public FornecedorCidadeService(FornecedorCidadeServiceCore fornecedorCidadeServiceCore) {
        this.fornecedorCidadeServiceCore = fornecedorCidadeServiceCore;
    }

    public InfoFornecedorCidadeDto getDados(String cidade) {
        logger.info("Buscando informações do fornecedor de {}", cidade);

        InfoFornecedorCidadeDto infoFornecedorCidadeDto = fornecedorCidadeServiceCore.getFornecedor(cidade);
        return infoFornecedorCidadeDto;
    }
}
