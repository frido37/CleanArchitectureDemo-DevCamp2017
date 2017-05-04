package com.unic.lab.web;

import com.unic.lab.ChatParticipant;
import com.unic.lab.ChatReply;
import com.unic.lab.ChatService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Scope("session")
@Controller public class MainController {

    private final ChatService chat;
    private ChatParticipant me = new ChatParticipant("Anonymous");

    @Inject public MainController(ChatService chat) {
        this.chat = chat;
    }

    @RequestMapping("/") public String getAllReplies(Model model) {
        List<ChatReply> replies = chat.getReplies(me);
        return "hello";
    }

}
