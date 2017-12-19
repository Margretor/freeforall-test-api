import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import apiResources.GetCountResource;


public class App {
    public static void main(final String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(8443, "0.0.0.0");
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplicationClass(GetCountResource.class.getName());
        DeploymentInfo di = server.undertowDeployment(deployment, "/api");
        server.start(serverBuilder);

        server.start(
                Undertow.builder()
                        .addHttpListener(8443, "0.0.0.0")

        );


        Logger log = Logger.getLogger(App.class);
        PropertyConfigurator.configure("resources/log4j.properties");

        log.info("JAX-RS based micro-service running!");
    }
}
