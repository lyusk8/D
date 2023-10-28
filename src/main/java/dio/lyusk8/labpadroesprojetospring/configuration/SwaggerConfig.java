package dio.lyusk8.labpadroesprojetospring.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() throws RuntimeException{
        return GroupedOpenApi.builder().group("springlabpadroesprojetospring")
                .pathsToMatch("/enderecos/**", "/clientes/**")
                .build();
    }
}

