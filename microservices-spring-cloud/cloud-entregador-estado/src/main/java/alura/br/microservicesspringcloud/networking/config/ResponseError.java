package alura.br.microservicesspringcloud.networking.config;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseError {

    private String timestamp;
    private String status;
    private String error;
    private String message;
    private String trace_id;

}
