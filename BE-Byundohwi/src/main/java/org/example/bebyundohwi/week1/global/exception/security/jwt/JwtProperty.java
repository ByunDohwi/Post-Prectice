package org.example.bebyundohwi.week1.global.exception.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "spring.jwt")
@AllArgsConstructor
@Getter
    public class JwtProperty {
    private final String jwtSecret;
    private final Long accessExp;
    private final Long refreshExp;
    private final String header;
    private final String prefix;

}
