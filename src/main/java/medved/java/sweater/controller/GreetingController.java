package medved.java.sweater.controller;

import medved.java.sweater.entity.Message;
import medved.java.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("/")
    public String addMessage(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        messageRepository.save(new Message(text, tag));
        main(model);
        return "main";
    }
}
