package com.unic.lab;

import org.springframework.stereotype.Service;

/**
 * Created by fridolin.jackstadt on 06/04/2017.
 */
@Service
public class MemoryChatService {

    private final ChatRepliesRepository repository = new MemoryChatRepliesRepository();

}
