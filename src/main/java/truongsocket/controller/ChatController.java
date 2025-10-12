package truongsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import truongsocket.service.ChatService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public String index() {
        return "chat";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
