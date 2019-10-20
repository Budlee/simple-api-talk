package com.budlee.talk.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser {
    private int id;
    private String name;
//    private Name name;
    private String email;
}
