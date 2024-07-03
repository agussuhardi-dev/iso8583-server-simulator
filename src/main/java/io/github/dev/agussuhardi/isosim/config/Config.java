package io.github.dev.agussuhardi.isosim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

/**
 * @author agussuhardi
 * {@code @created} 6/23/24 4:07 PM
 * {@code @project} dashboard
 */
@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class Config {
}
