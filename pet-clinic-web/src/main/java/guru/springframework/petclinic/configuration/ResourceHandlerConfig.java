package guru.springframework.petclinic.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceHandlerConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.js", "/*.css", "/*.eot", "/*.svg", "/*.ttf", "/*.woff", "/*.gif", "/*.png")
                .addResourceLocations("classpath:/static/resources/")
                .resourceChain(false);
    }
}
