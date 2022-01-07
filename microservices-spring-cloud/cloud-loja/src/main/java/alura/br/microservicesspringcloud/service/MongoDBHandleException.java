package alura.br.microservicesspringcloud.service;

import alura.br.microservicesspringcloud.config.MongoDb;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDBHandleException {

    @Autowired
    TraceService traceService;


    @Value("${service.name}")
    private String serviceName;

    public void saveException(Exception exception) {

        //selecionando mongo database
        MongoDatabase database = MongoDb.client.getDatabase("exceptionHandlerDB");
        MongoCollection<Document> exceptionCollection = database.getCollection("exceptions");

        List<String> causesString = new ArrayList<String>();
        Throwable cause = exception.getCause();

        Document exceptionDocument = new Document("Service", serviceName);
        exceptionDocument.append("TraceId", traceService.getTraceId());
        exceptionDocument.append("Exception", exception.toString());

        while (cause != null) {
            String[] className = cause.getStackTrace()[0].getClassName().split("\\.");
            int classNamePosition = className.length - 1;

            String message = cause.toString()
                    + " - Class: " + className[classNamePosition]
                    + " - Method: " + cause.getStackTrace()[0].getMethodName()
                    + "- Line: " + cause.getStackTrace()[0].getLineNumber();

            causesString.add(message);
            cause = cause.getCause();//proxima Exceçao encadeada
        }
        //adiciona array de execoes encadeadas no documento  e insere na coleção
        exceptionDocument.append("Caused by", causesString);
        exceptionCollection.insertOne(exceptionDocument);
    }

    //Todo lembre se fechar o banco
}
