package com.gridge.GridgeTest;

import com.gridge.GridgeTest.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class GridgeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridgeTestApplication.class, args);
	}

}
