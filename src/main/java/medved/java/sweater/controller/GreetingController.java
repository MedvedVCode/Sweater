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

    @GetMapping("/")
    public String greeting(
//            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model) {
//        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(
            @RequestParam String tag,
            @RequestParam String text,
            Map<String, Object> model
    ) {
        messageRepository.save(new Message(tag, text));
        main(model);
        return "main";
    }

    @PostMapping("/filter")
    public String filterByTag(
            @RequestParam String filter,
            Map<String, Object> model
    ) {
        if (filter != null && !filter.isEmpty()) {
            model.put("messages", messageRepository.findByTag(filter));
        } else {
            model.put("messages", messageRepository.findAll());
        }
        return "main";
    }
}
