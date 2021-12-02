package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.model.InfoFornecedor;
import alura.br.microservicesspringcloud.service.Infoservice;
import io.swagger.annotations.Api;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "v1/info")
public class InfoController {

    @Autowired
    Infoservice infoservice;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @GetMapping(value = "/{estado}")
    public ResponseEntity<InfoFornecedor> getInfoPorEstado(@PathVariable("estado") String estado) {

        logger.info("Recebido pedido de informações do fornecedor de {}",estado);
        InfoFornecedor infoFornecedor = infoservice.getInfoPorEstado(estado);
        return new ResponseEntity(infoFornecedor, HttpStatus.OK);


    }
}

