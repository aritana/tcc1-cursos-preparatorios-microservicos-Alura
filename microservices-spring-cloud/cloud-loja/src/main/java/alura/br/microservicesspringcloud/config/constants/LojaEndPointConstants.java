package alura.br.microservicesspringcloud.config.constants;

public class LojaEndPointConstants {
    private LojaEndPointConstants() {
    }

    public static final String FORNECEDOR_GET_INFO = "/v1/info/{estado}/{cidade}";
    public static final String FORNECEDOR_GENERATE_EXCEPTION = "/exception/{exceptioncode}/{service}";

}
