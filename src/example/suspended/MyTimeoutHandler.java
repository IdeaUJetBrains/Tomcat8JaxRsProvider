package example.suspended;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.TimeoutHandler;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Olga Pavlova on 2/2/2016.
 */
public class MyTimeoutHandler implements TimeoutHandler {
    public void handleTimeout(AsyncResponse ar) {
            ar.setTimeout(10, SECONDS);

    }
}
