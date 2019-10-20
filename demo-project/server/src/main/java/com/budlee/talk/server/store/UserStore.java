package com.budlee.talk.server.store;

import com.budlee.talk.server.model.Name;
import com.budlee.talk.server.model.SimpleUser;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserStore {

    private final Map<String, SimpleUser> mapUserStore;

    public UserStore() {
        mapUserStore = new ConcurrentHashMap<>();
        mapUserStore.putAll(nameField());
//        mapUserStore.putAll(nameObject());

    }

    private Map<? extends String, ? extends SimpleUser> nameField() {
        return Map.of(
                "1", new SimpleUser(1, "Matthew Auburn", "my@email.com"),
                "2", new SimpleUser(2, "Jane Temple", "jt@email.com"),
                "3", new SimpleUser(3, "Sandra Hackney", "sh@email.com"),
                "4", new SimpleUser(4, "Oli Street", "os@email.com"),
                "5", new SimpleUser(5, "Emma Junction", "ej@email.com")
        );
    }

//    private Map<? extends String, ? extends SimpleUser> nameObject() {
//        return Map.of(
//                "1", new SimpleUser(1, new Name("Matthew", "Auburn"), "my@email.com"),
//                "2", new SimpleUser(2, new Name("Jane", " Temple"), "jt@email.com"),
//                "3", new SimpleUser(3, new Name("Sandra ", "Hackney"), "sh@email.com"),
//                "4", new SimpleUser(4, new Name("Oli ", "Street"), "os@email.com"),
//                "5", new SimpleUser(5, new Name("Emma", " Junction"), "ej@email.com")
//        );
//    }

    public SimpleUser getUser(String id) {
        return this.mapUserStore.get(id);
    }
}
