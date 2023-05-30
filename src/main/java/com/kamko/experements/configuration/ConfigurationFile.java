package com.kamko.experements.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.kamko.experements")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigurationFile {
}
