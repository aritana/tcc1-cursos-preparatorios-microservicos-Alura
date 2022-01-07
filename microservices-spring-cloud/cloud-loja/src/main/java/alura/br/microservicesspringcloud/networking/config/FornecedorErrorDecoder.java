package alura.br.microservicesspringcloud.networking.config;

import alura.br.microservicesspringcloud.exception.BadRequestException;
import alura.br.microservicesspringcloud.exception.NotFoundException;
import alura.br.microservicesspringcloud.exception.ServerErrorException;
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
    public Exception decode(String methodKey, Response response) throws RuntimeException {
        String[] body = {null};
        String bodyError;
        ResponseError responseError = null;
        if (response.body() != null) {
            try {
                InputStream inputStream = response.body().asInputStream();
                body[0] = IOUtils.toString(inputStream);
                bodyError = body[0];

                ObjectMapper objectMapper = new ObjectMapper();
                responseError = objectMapper.readValue(bodyError, ResponseError.class);
            } catch (IOException e) {
                logger.error("IOException {}", "Erro ao fazer o parse do response.body de outro serviço no ErrorDecoder");
                throw new ServerErrorException("Internal Error");
            }
        }

        switch (response.status()) {
            case 400:
                return new BadRequestException(responseError);
            case 404:
                return new NotFoundException(responseError);
            case 500:
                return new ServerErrorException(responseError);
            default:
                return new Exception("Generic error");
        }
    }
}
