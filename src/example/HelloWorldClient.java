package example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by Olga Pavlova on 1/20/2016.
 */
public class HelloWorldClient {

  public static void main(String[] argv) {
    Client client = ClientBuilder.newClient().register(GZIPWriterInterceptor.class);
    WebTarget target = client.target("http://localhost:8080/helloworld");
    target.register(GZIPWriterInterceptor.class);
      System.out.println(target.request().get().readEntity(String.class));
  }

  /*public static void main(String[] argv) {
    //Client client = ClientBuilder.newBuilder().register(GZIPWriterInterceptor.class).build();
    Client client = ClientBuilder.newClient().register(GZIPWriterInterceptor.class);
    WebTarget target = client.target("http://localhost:8080/helloworld");
    //target.register(GZIPWriterInterceptor.class);
    System.out.println(target.request().get().readEntity(String.class));
    System.out.println("end");
  }*/




}
