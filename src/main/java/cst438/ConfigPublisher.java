package cst438;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//hw notes
// IMPORTANT. The configuration class MUST be in the SAME PACKAGE as the
//SpringBootApplication class. This is the class that is generated when you created the
//eclipse project, and the class that you select to start the spring server.
// Other classes (Controllers, Entities, Services) must in in the same or a sub package.
@Configuration
public class ConfigPublisher {
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("city-reservation");
	}
}
