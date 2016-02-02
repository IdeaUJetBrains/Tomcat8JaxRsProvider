package example.constraints;


import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@Path("HelloResource")
public class HelloResource {

    private String str;

   /* @NotNull
    public void setStr(@NotNull @MatrixParam("str") String str) {

        System.out.print(str);
        this.str = str;
    }*/

    public String getStr() {

        return str;
    }

    @NotNull  //  HelloResource/foo;str=constr
    public HelloResource(@NotNull @MatrixParam("str") String str) {
        System.out.print(str);

    }

    @GET
    @Path("foo")  //  HelloResource/foo;str=constr?;str1=foo
    @Produces("text/plain")
    public String foo(@NotNull @QueryParam("str1") String str1) {
        return "Hello World!";
    }

    @GET
    @Produces("text/plain") // HelloResource?str=constr?str1=foo
    public String listQueryParamNames(@Context UriInfo info) {
        StringBuilder buf = new StringBuilder();
        for (String param : info.getQueryParameters().keySet()) {
            buf.append(param);
            buf.append("\n");
            buf.append("0");
        }
        return buf.toString();
    }



}
