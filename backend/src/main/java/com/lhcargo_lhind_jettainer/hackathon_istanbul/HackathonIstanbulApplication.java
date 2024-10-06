package com.lhcargo_lhind_jettainer.hackathon_istanbul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {"com.lhcargo_lhind_jettainer.hackathon_istanbul"})
@ConfigurationPropertiesScan("com.lhcargo_lhind_jettainer.hackathon_istanbul.config")
public class HackathonIstanbulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonIstanbulApplication.class, args);
	}

}
