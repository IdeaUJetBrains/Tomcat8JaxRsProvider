package example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by Olga Pavlova on 1/28/2016.
 */
public class HelloWorldClientNotOk {
    public static void main(String[] argv) {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/helloworld");
        target.register(Empty.class);
        System.out.println(target.request().get().readEntity(String.class));
    }
}
