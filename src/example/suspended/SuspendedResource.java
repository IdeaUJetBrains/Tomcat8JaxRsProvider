package example.suspended;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.concurrent.TimeUnit;

/**
 * Created by Olga Pavlova on 2/2/2016.
 */
@Path("SuspendedResource")
public class SuspendedResource {

    @GET
    public void longRunningOperation(@Suspended AsyncResponse ar) throws InterruptedException {
        ar.setTimeoutHandler(new MyTimeoutHandler());
        ar.setTimeout(10, TimeUnit.SECONDS);
        final String result = executeLongRunningOperation();
        ar.resume(result);
    }

    private String executeLongRunningOperation() throws InterruptedException {
        Thread.sleep(5000);
        return "The end";
    }

    @GET
    @Path("wrongType")  //  SuspendedResource/wrongType?str=4&str1=5
    public String TTT(@Suspended @QueryParam("str") String str) {
        System.out.print("Value str: " + str);
        return str;
    }
}
