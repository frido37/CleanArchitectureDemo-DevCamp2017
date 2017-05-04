package com.unic.lab;

import java.util.List;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
public interface ChatRepliesGateway {

    void save(ChatReply reply);

    List<ChatReply> getReplies();

}
