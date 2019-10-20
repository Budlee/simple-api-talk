package com.budlee.talk.client;

import com.budlee.talk.client.model.ClientUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class ClientApplication {

    private int userId = 1;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Scheduled(fixedDelay = 10000l)
    public void requestUserInfo() {
        WebClient.create("http://localhost:12345")
                .get()
                .uri("/users/{id}", userId)
                .retrieve()
                .bodyToMono(ClientUser.class)
                .map(this::printOutReturnedUser)
                .doOnError(this::anErrorOccured)
                .subscribe();
        userId++;
        if (userId > 5) {
            userId = 1;
        }
    }

    private void anErrorOccured(Throwable throwable) {
        log.error("On no! An Error occured. The message is: {}", throwable.getMessage());
    }

    private ClientUser printOutReturnedUser(ClientUser clientUser) {
        log.info("The user returned is {}", clientUser);
        return clientUser;
    }
}
