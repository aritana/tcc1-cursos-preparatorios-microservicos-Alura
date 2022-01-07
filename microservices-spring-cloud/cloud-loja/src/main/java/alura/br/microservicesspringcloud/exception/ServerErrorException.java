package alura.br.microservicesspringcloud.exception;

import alura.br.microservicesspringcloud.networking.config.ResponseError;

public class ServerErrorException extends RuntimeException {
    ResponseError responseError;

    public ServerErrorException() {
    }

    public ServerErrorException(ResponseError responseError) {
        this.responseError = responseError;
    }

    public ServerErrorException(String message) {
        super(message);
    }

    public ServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerErrorException(Throwable cause) {
        super(cause);
    }

    public ServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
