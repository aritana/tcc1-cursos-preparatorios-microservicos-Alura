package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.networking.config.ResponseError;

public class NotFoundException extends Exception{

    ResponseError responseError;

    public NotFoundException() {
    }

    public NotFoundException(ResponseError responseError) {

        this.responseError =  responseError;

    }
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
