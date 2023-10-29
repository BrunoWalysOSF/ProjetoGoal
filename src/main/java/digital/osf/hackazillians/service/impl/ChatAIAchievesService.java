package digital.osf.hackazillians.service.impl;

import com.theokanning.openai.completion.chat.*;


import digital.osf.hackazillians.constant.TypeQuestion;

import digital.osf.hackazillians.service.ChatAIAbstractService;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatAIAchievesService extends ChatAIAbstractService {


   // private static final String NO_NUMERATION_RESPONSE = "Remove numbering and dash of the following text: ";

    public List<String> askGoalToAI(String question) {
        String initialQuestion = TypeQuestion.ACHIEVE.getDescription() + question;
        ChatMessage responseMessage = super.askAI(initialQuestion);
//        ChatMessage msgWithouNumbers = super.askAI( NO_NUMERATION_RESPONSE+ responseMessage.getContent());
        List<String> responseList = Arrays.asList(responseMessage.getContent().replaceAll("\n\n", "\n").split("\n"));
        return responseList;
    }



}
