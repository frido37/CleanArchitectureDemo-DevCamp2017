package com.unic.lab.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unic.lab.ChatParticipant;
import com.unic.lab.ChatReply;
import com.unic.lab.ChatService;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Scope("session")
@Controller
public class MainController {

    private final ChatService chat;
    private ChatParticipant me = new ChatParticipant("Anonymous");

    @Inject
    public MainController(ChatService chat) {
        this.chat = chat;
    }

    @GetMapping("/replies")
    public ModelAndView getAllReplies(Model model) {
        // model.addAttribute("message", new Message().withFromName(me.getName()));
        List<ChatReply> replies = chat.getReplies(me);

        // model.addAttribute("replies", replies);

        ModelAndView modelAndView = new ModelAndView().addObject("replies", replies).addObject("message", new Message().withFromName(me.getName()));
        modelAndView.setViewName("chat");

        return modelAndView;
    }

    @PostMapping(value = "/replies")
    public ModelAndView sendMessage(@ModelAttribute("message") Message message) {
        me = new ChatParticipant(message.getFromName());
        ChatReply reply = new ChatReply(me, new ChatParticipant(message.getToName()), message.getText());

        chat.sendReply(reply);

        ModelAndView modelAndView = new ModelAndView().addObject("replies", chat.getReplies(me)).addObject("message", new Message().withFromName(me.getName()));
        modelAndView.setViewName("chat");

        return modelAndView;
    }

}
