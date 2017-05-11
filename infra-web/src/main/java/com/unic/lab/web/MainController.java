package com.unic.lab.web;

import com.unic.lab.ChatParticipant;
import com.unic.lab.ChatReply;
import com.unic.lab.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Controller
public class MainController {

    private final ChatService chat;

    @Inject
    public MainController(ChatService chat) {
        this.chat = chat;
    }

    @GetMapping("/replies")
    public ModelAndView getAllReplies(Model model) {
        ChatParticipant me = new ChatParticipant("Anonymous");
        Message message = new Message(me.getName());

        return new ModelAndView("chat")
                .addObject("replies", chat.getReplies(me))
                .addObject("message", message);
    }

    @PostMapping(value = "/replies")
    public ModelAndView sendMessage(@ModelAttribute("message") Message message) {
        ChatParticipant me = new ChatParticipant(message.getFromName());
        if (message.isNotEmpty()) {
            ChatParticipant to = getParticipant(message.getToName());
            chat.sendReply(new ChatReply(me, to, message.getText()));
            message.reset();
        }

        return new ModelAndView("chat")
                .addObject("replies", chat.getReplies(me))
                .addObject("message", message);
    }

    private ChatParticipant getParticipant(String name) {
        return name.isEmpty() ? null : new ChatParticipant(name);
    }

}
