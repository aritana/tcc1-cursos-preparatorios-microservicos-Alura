package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.dto.CompraDTO;
import alura.br.microservicesspringcloud.dto.InfoFornecedorDto;
import alura.br.microservicesspringcloud.service.CompraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@RestController
@RequestMapping(value="v1")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping(value = "/compra")
    public  ResponseEntity<InfoFornecedorDto> realizaCompra(@RequestBody @Valid CompraDTO compra) {

        InfoFornecedorDto infoFornecedorDto =  compraService.realizaCompra(compra);
        return new ResponseEntity(infoFornecedorDto, HttpStatus.OK);
    }
}

