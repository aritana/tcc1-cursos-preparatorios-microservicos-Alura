package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.dto.CompraDTO;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.networking.service.FornecedorServiceCore;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private FornecedorServiceCore fornecedorServiceCore;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @Autowired
    public CompraService(FornecedorServiceCore fornecedorServiceCore){
        this.fornecedorServiceCore =fornecedorServiceCore;
    }
    public InfoFornecedorDto realizaCompra(CompraDTO compra) {

        String estado = compra.getEndereco().getEstado();
        logger.info("Buscando informações do fornecedor de {}",estado);

        InfoFornecedorDto infoFornecedorDto= fornecedorServiceCore.getFornecedorList(estado);
        return infoFornecedorDto;
    }
}
