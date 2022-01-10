package alura.br.microservicesspringcloud.config.constants;

public class EndPointConstants {
    private EndPointConstants() {
    }

    public static final String FORNECEDOR_GET_INFO = "/v1/info/{cidade}";
    public static final String FORNECEDOR_GENERATE_EXCEPTION = "/exception/{exceptioncode}/{service}";

}
