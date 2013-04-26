package config

import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.context.annotation.{ComponentScan, Configuration}

@EnableWebMvc
@Configuration
@ComponentScan(value = Array("com.jyc.crud"))
class AppConfig {

}
