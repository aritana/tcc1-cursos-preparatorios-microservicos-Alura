package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.dto.InfoFornecedorCidadeDto;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.model.InfoFornecedor;
import alura.br.microservicesspringcloud.service.FornecedorCidadeService;
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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Api
@RestController
@RequestMapping(value = "v1/info")
public class InfoController {

    @Autowired
    Infoservice infoservice;
    @Autowired
    FornecedorCidadeService fornecedorCidadeService;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @GetMapping(value = "/{estado}/{cidade}")
    public ResponseEntity<InfoFornecedorDto> getInfoPorEstado(@PathVariable("estado")  @NotEmpty @NotNull String estado, @PathVariable("cidade") String cidade) throws Exception {

        logger.info("Recebido pedido de informações do fornecedor de {}",estado);
        InfoFornecedor infoFornecedor = infoservice.getInfoPorEstado(estado);
        InfoFornecedorCidadeDto infoFornecedorCidadeDto = fornecedorCidadeService.getDados(cidade);
       /* try{
            if(infoFornecedor != null){
                throw new Exception("Erro ao consultar estado");

            }
        }
        catch (Exception exception){
            logger.info("Exception exception occured: {}",exception.getMessage());
        }
        */
        InfoFornecedorDto infoFornecedorDto =   InfoFornecedorDto.map(infoFornecedor,infoFornecedorCidadeDto);
        return new ResponseEntity(infoFornecedorDto, HttpStatus.OK);


    }
}

