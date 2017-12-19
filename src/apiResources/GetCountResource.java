package apiResources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.concurrent.atomic.AtomicInteger;


@Path("/api")
public class GetCountResource {
    private AtomicInteger c = new AtomicInteger(0);

    @GET
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
        String result = Integer.toString(c.incrementAndGet());
        asyncResponse.resume(result);
    }
}