package cs5500.project.spring;

import cs5500.project.db.Assignment;
import cs5500.project.db.Submission;
import cs5500.project.db.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestDataConfig extends RepositoryRestMvcConfiguration {
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
    {
        config.exposeIdsFor(Assignment.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Submission.class);
    }
}