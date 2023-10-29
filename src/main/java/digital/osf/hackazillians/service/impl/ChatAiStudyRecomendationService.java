package digital.osf.hackazillians.service.impl;

import com.theokanning.openai.completion.chat.ChatMessage;
import digital.osf.hackazillians.constant.TypeQuestion;
import digital.osf.hackazillians.service.ChatAIAbstractService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatAiStudyRecomendationService extends ChatAIAbstractService {

    public List<String> askStudyRecomendationToAI(String question, TypeQuestion typeQuestion) {
        String initialQuestion = typeQuestion.getDescription() + question;
        ChatMessage responseMessage = super.askAI(initialQuestion);
        List<String> responseList = Arrays.asList(responseMessage.getContent().replaceAll("\n\n", "\n")
                .split("\n"));
        return responseList;
    }
}
