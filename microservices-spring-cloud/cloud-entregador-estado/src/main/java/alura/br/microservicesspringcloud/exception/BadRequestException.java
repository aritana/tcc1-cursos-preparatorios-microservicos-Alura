package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.networking.config.ResponseError;

public class BadRequestException extends Exception {
    ResponseError responseError;
    public BadRequestException() {
    }
    public BadRequestException(ResponseError responseError) {

        this.responseError =  responseError;
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
