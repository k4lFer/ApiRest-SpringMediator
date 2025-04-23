package kalfer.apis_pring.Presentation.Swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "APIs Pring",
        version = "1.0",
        description = "APIs Pring"
    )
)
public class OpenApiConf {
    
}
