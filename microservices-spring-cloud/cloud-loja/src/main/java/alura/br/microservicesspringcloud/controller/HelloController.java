package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.service.TraceService;
import io.swagger.annotations.Api;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    TraceService traceService;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @GetMapping(value="/{firstname}/{lastname}")
    public  String hello(@PathVariable("firstname")String firstname, @PathVariable("lastname")String lastname){
        traceService.printTraceId();
        logger.info("Buscando informações do fornecedor de {}","estado");
        return String.format("\"message\": \"Hello %s %s\" ", firstname, lastname);
    }
}
