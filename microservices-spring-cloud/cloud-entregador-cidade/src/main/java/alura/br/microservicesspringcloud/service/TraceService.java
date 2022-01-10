package alura.br.microservicesspringcloud.service;

import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;

@Service
public class TraceService {
    Tracer tracer;

    public TraceService(Tracer tracer) {
        this.tracer = tracer;
    }

    public void printTraceId() {
        Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
        System.out.println(traceId);
    }

    public String getTraceId() {
        Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
        return traceId;
    }
}
