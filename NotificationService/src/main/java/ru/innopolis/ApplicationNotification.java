package ru.innopolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;


@SpringBootApplication
public class ApplicationNotification {

    @Bean
    NotificationClient notificationClient() {
        return new NotificationClientImpl();
    }

    @Bean
    RmiServiceExporter rmiServiceExporter(NotificationClient implementation) {
        Class<NotificationClient> serviceInterface = NotificationClient.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getSimpleName());
        exporter.setRegistryPort(1099);
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationNotification.class, args);
    }
}
