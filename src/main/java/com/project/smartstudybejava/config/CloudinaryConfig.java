package com.project.smartstudybejava.config;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Component
@ConfigurationProperties(prefix = "cloudinary")
public class CloudinaryConfig {

    @Value("${cloudinary.cloud-name}")
    String cloudName;
    @Value("${cloudinary.api-key}")
    String apiKey;
    @Value("${cloudinary.api-secret}")
    String apiSecret;

}
