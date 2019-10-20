package com.budlee.talk.server.controller;

import com.budlee.talk.server.model.SimpleUser;
import com.budlee.talk.server.store.UserStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserStore userStore;

    @GetMapping("/users/{id}")
    public ResponseEntity<SimpleUser> getUser(@PathVariable(value = "id") String id) {
        final var user = this.userStore.getUser(id);
        log.info("A Client has requested user id {}. Returning user {}", id, user);
        return ResponseEntity.of(Optional.ofNullable(user));
    }

}
