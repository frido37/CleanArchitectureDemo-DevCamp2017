package com.unic.lab;

import java.util.List;

/**
 * Created by fridolin.jackstadt on 04.05.17.
 */
public interface ChatService {

    List<ChatReply> getReplies(ChatParticipant participant);

}
