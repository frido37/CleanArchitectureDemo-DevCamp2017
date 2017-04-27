package com.unic.lab;

import java.util.List;

/**
 * Created by fridolin.jackstadt on 27.04.17.
 */
public interface ChatUseCase {

    List<ChatReply> getReplies(ChatParticipant participant);
}
