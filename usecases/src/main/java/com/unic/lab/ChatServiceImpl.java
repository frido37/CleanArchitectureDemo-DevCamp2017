package com.unic.lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Named
public class ChatServiceImpl implements ChatService {

    private final ChatRepliesGateway repository;
    private final Map<ChatParticipant, Sender> participants = new HashMap<>();
    private final Sender allSender = reply -> participants.values().forEach(participant -> participant.send(reply));

    @Inject
    public ChatServiceImpl(ChatRepliesGateway repository) {
        this.repository = repository;
    }

    void subscribe(ChatParticipant participant, Sender sender) {
        participants.put(participant, sender);
    }

    @Override
    public void sendReply(ChatReply reply) {
        if (reply.getText().isEmpty())
            return;
        reply.getTo().map(participants::get).orElse(allSender).send(reply);
        repository.save(reply);
    }

    @Override
    public List<ChatReply> getReplies(ChatParticipant participant) {
        return repository.getReplies().stream().filter(participant::isRecipient).collect(Collectors.toList());
    }

}
