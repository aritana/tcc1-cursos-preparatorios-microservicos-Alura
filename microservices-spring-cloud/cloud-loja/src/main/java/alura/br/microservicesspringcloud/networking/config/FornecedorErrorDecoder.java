package alura.br.microservicesspringcloud.networking.config;

import alura.br.microservicesspringcloud.exception.BadRequestException;
import alura.br.microservicesspringcloud.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FornecedorErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

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
