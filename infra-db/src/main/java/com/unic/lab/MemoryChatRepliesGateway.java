package com.unic.lab;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Named
public class MemoryChatRepliesGateway implements ChatRepliesGateway {

    private List<ChatReply> replies = new ArrayList<>();

    @Override public void save(ChatReply reply) {
        replies.add(reply);
    }

    @Override public List<ChatReply> getReplies() {
        return replies;
    }

}
