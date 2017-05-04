package com.unic.lab;

import java.time.Instant;
import java.util.Optional;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
public class ChatReply {

    private final Instant time = Instant.now();
    private final ChatParticipant from;
    private final ChatParticipant to;
    private final String text;

    public ChatReply(ChatParticipant from, String text) {
        this.from = from;
        this.to = null;
        this.text = text;
    }

    public ChatReply(ChatParticipant from, ChatParticipant to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public Instant getTime() {
        return time;
    }

    public ChatParticipant getFrom() {
        return from;
    }

    public Optional<ChatParticipant> getTo() {
        return Optional.ofNullable(to);
    }

    public String getText() {
        return text;
    }

}
