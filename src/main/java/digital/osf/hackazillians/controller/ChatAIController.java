package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.ChatAIDto;
import digital.osf.hackazillians.service.impl.ChatAIAchievesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ask")
@AllArgsConstructor
public class ChatAIController {


    public final ChatAIAchievesService chatAIService;

    @PostMapping
    public void ask(@RequestBody ChatAIDto chatAIDto) {
        chatAIService.askGoalToAI(chatAIDto.getQuestion());
    }



}
