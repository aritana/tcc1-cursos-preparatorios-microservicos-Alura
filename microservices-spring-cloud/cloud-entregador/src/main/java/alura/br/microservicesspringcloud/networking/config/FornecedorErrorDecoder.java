package alura.br.microservicesspringcloud.networking.config;

import alura.br.microservicesspringcloud.exception.BadRequestException;
import alura.br.microservicesspringcloud.exception.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;


public class FornecedorErrorDecoder implements ErrorDecoder {
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);
    @Override
    public Exception decode(String methodKey, Response response) {
        String[]body={null};
        String bodyError = null;
        ResponseError responseError = null;
        if(response.body()!=null){
            try{
                InputStream inputStream =  response.body().asInputStream();
                body[0]= IOUtils.toString(inputStream);
                bodyError = body[0];

                ObjectMapper objectMapper = new ObjectMapper();
                responseError = objectMapper.readValue(bodyError, ResponseError.class);
             }
            catch (IOException exception){
                logger.error("IOException {}","Erro ao coletar body da resposta de outro serviço no ErrorDecoder");
            }


        }

        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException();
            default:
                return new Exception("Generic error");
        }
    }
}
//para capturar o body
//string body = readBody(response.body())
//nececssita fazer a funcao redbody
//depois se passar o body para a exception. ...como response error.
//usar o jasonNOde, mapeamento stringTo error..
//