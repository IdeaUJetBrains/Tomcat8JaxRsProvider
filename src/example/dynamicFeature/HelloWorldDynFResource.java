package example.dynamicFeature;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("HelloWorldDynFResource")
public class HelloWorldDynFResource {

    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello World!";
    }

    @GET
    @Path("too-much-data")  //HelloWorldDynFResource/too-much-data
    public String getVeryLongString() {
        String str = "Hello World!Hello World!Hello World!"; // very long string
        return str;
    }
}
