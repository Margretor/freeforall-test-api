import org.apache.log4j.Logger;
import java.net.URI;
import java.io.IOException;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.PropertyConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class App {



    public static void main(final String[] args) throws IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig resourceConfig = new ResourceConfig(apiResources.GetCountResource.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
        server.start();
        Logger log = Logger.getLogger(App.class);
        PropertyConfigurator.configure("resources/log4j.properties");
        log.info("JAX-RS based micro-service running!");
    }
}
