package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.networking.service.FornecedorServiceCore;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionComunicator {

    private FornecedorServiceCore fornecedorServiceCore;
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);

    @Autowired
    public ExceptionComunicator(FornecedorServiceCore fornecedorServiceCore){
        this.fornecedorServiceCore =fornecedorServiceCore;
    }

    public void sendSignalOfExceptiorToBeGenerate( String exceptionCodeInitCause, String service){
        fornecedorServiceCore.generateException(exceptionCodeInitCause,service);
    }

}
