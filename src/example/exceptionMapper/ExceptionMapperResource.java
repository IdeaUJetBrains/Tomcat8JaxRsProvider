package example.exceptionMapper;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Olga Pavlova on 2/2/2016.
 */
@Path("/helloworld/ExceptionMapperResource")
public class ExceptionMapperResource {
    @Path("/user")
    public Response getUser(@QueryParam("id") String id) throws UserNotFoundException{
        //Some user validation code with DB hit, if not found then
        throw new UserNotFoundException();
    }
}
