package com.unic.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Scope("session")
@Controller public class MainController {

    public static ChatUseCase chat;

    @RequestMapping("/") public List<ChatReply> getAllReplies(Model model) {
        System.out.println(chat.toString());
        return chat.getReplies(null);

    }

}
