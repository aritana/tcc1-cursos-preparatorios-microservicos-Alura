package alura.br.microservicesspringcloud.controller;

import alura.br.microservicesspringcloud.config.MongoDb;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.swagger.annotations.Api;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @GetMapping(value = "/{firstname}/{lastname}")
    public String hello(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {

        MongoDatabase database = MongoDb.client.getDatabase("exceptionHandlerDB");
        MongoCollection<Document> alunos = database.getCollection("alunos");
        Document aluno = alunos.find().first();
        System.out.println(aluno);

       /* Document novoALuno = new Document("nome", "João")
                .append("cidade", "belo horizonte")
                .append("data_nascimento", new Date(1987, 10, 10))
                .append("curso", new Document("nome", "Historia"))
                .append("notas", Arrays.asList(10, 9))
                .append("habilidades", Arrays.asList(new Document()
                        .append("nome", "Ingles")
                        .append("nome", "Basico")));
        alunos.insertOne(novoALuno);


        Document aluno2 = alunos.find(eq("nome","Aritana"))
                .first();
        System.out.println(aluno2);
*/
        try {
            method1();
        } catch (Exception exception) {
            System.out.println("--------------------------------------------------------------");

            Gson gson = new Gson();
            Map<String, Throwable> exc_map = new HashMap<>();
            exc_map.put("root cause", exception.getCause());
            gson.toJson(exc_map);
            System.out.println(gson.toJson(exc_map));

            Document novoALuno = new Document("nome", "Exception1")
                    .append("cause",gson.toJson(exc_map));
            alunos.insertOne(novoALuno);
//          StackTraceElement[] traceElements = exception.getStackTrace();
//         for (StackTraceElement element : traceElements) {
//                System.out.printf("%s\t", element.getClassName());
//                System.out.printf("%s\t", element.getLineNumber());
//                System.out.printf("%s%n", element.getMethodName());
//
//            }
            System.out.println("--------------------------------------------------------------");

        }


        return String.format("\"message\": \"Hello %s %s\" ", firstname, lastname);
        //MongoDb.client.close();

    }

    public void method1() throws Exception {
        try {
            method2();
        }catch (Exception exception) {
            throw new Exception("Exception thrown in method2", exception);
        }
    }

    public void method2() throws Exception {
        try {
            method3();

        } catch (Exception exception) {
            throw new Exception("Exception thrown in method2", exception);
        }
    }

    public void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
}
