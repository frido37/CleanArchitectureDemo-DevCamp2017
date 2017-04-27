package com.unic.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Controller public class MainController {

    private final MemoryChatService chatService;

    @Autowired public MainController(MemoryChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping("/") public String greeting(Model model) {
        System.out.println(chatService.toString());
        return "hello";

    }

}
