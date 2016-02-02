package example.dynamicFeature;


import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("HelloWorldDynFResource")
public class HelloWorldDynFResource {

    private String str;

    @NotNull
    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {

        return str;
    }

    @NotNull
    public HelloWorldDynFResource() {

    }

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
