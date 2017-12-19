package apiResources;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.concurrent.atomic.AtomicLong;


@Path("/api")
public class GetCountResource {
    private static AtomicLong c = new AtomicLong(0);

    @GET
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
        long resultLong = c.incrementAndGet();
        String result = Long.toString(resultLong);

//        Logger log = Logger.getLogger(GetCountResource.class);
//        PropertyConfigurator.configure("resources/log4j.properties");
//        log.info("Sending: " + result);

        asyncResponse.resume(result);
    }
}