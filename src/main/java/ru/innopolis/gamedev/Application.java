package ru.innopolis.gamedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.innopolis.NotificationClient;


@SpringBootApplication
@ComponentScan(basePackages = "ru.innopolis")
@EnableJpaRepositories(basePackages = "ru.innopolis.repositories")
@EntityScan(basePackages = "ru.innopolis.models")

public class Application  {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    RmiProxyFactoryBean service(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/NotificationClient");
        rmiProxyFactoryBean.setServiceInterface(NotificationClient.class);
        return rmiProxyFactoryBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}

