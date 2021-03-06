package com.jxh;
/**
 * spring 运行入口
 * @author jingxiaohu
 *
 */
import java.util.Arrays;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationProperties
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /**
     * 文件处理
     * @return
     */
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        factory.setMaxFileSize("20480KB");  
        factory.setMaxRequestSize("20480KB");  
        return factory.createMultipartConfig();  
    }
    /**
     * 错误处理
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8080);
            }
        };
    }
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub

		            System.out.println("Let's inspect the beans provided by Spring Boot:");

		            String[] beanNames = ctx.getBeanDefinitionNames();
		            Arrays.sort(beanNames);
		            for (String beanName : beanNames) {
		                System.out.println(beanName);
		            }
		     };
        };
    }
}