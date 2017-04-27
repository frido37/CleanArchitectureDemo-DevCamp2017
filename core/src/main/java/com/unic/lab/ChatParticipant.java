package com.unic.lab;

import java.util.Objects;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
public class ChatParticipant {

    private final String name;

    public ChatParticipant(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ChatParticipant that = (ChatParticipant) o;
        return Objects.equals(name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }

    boolean isRecipient(ChatReply reply) {
        return reply.getTo().map(this::equals).orElse(true);
    }
}
