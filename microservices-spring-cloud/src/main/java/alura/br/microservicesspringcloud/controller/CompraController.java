package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.dto.CompraDTO;
import alura.br.microservicesspringcloud.service.CompraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value="v1")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping(value = "/compra")
    public String realizaCompra(@RequestBody CompraDTO compra) {

       String estado =  compraService.realizaCompra(compra);

       return estado;

    }
}

