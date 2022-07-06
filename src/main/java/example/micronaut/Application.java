package example.micronaut;


import io.micronaut.openapi.annotation.OpenAPIInclude;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(info = @Info(title = "${api.title}", version = "${api.version}"))
@OpenAPIInclude(
    classes = { io.micronaut.security.endpoints.LoginController.class, io.micronaut.security.endpoints.LogoutController.class },
    tags = @Tag(name = "Security")
)
@OpenAPIInclude(
    classes = {
        io.micronaut.management.endpoint.env.EnvironmentEndpoint.class,
        io.micronaut.management.endpoint.routes.RoutesEndpoint.class,
        io.micronaut.management.endpoint.loggers.LoggersEndpoint.class,
        io.micronaut.management.endpoint.threads.ThreadDumpEndpoint.class,
        io.micronaut.management.endpoint.refresh.RefreshEndpoint.class,
        io.micronaut.management.endpoint.beans.BeansEndpoint.class
    },
    tags = @Tag(name = "Management Endpoints"),
    security = @SecurityRequirement(name = "BEARER", scopes = {"ADMIN"})
)
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
