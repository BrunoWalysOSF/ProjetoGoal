package digital.osf.hackazillians.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatFunction;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.FunctionExecutor;
import com.theokanning.openai.service.OpenAiService;


import digital.osf.hackazillians.dto.chat.Weather;
import digital.osf.hackazillians.dto.chat.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public abstract class ChatAIAbstractService {

    @Value("${openai.apiKey}")
    private String token;

    @Value("${openai.model}")
    private String  aiModel;

    protected ChatMessage askAI(String question) {
        OpenAiService openAiService = new OpenAiService(token);
        ChatMessage msg = new ChatMessage(ChatMessageRole.USER.value(), question);
        return chatWithAI(Arrays.asList(msg));
    }


    private FunctionExecutor createFunctionExecutor() {
        return new FunctionExecutor(Collections.singletonList(ChatFunction.builder()
                .name("get_weather")
                .description("Get the current weather of a location")
                .executor(Weather.class, w -> new WeatherResponse(w.location, w.unit, new Random().nextInt(50), "sunny"))
                .build()));
    }

    private ChatCompletionRequest createChatCompletionRequest(List<ChatMessage> messages) {
        return ChatCompletionRequest
                .builder()
                .model(aiModel)
                .messages(messages)
                .functions(createFunctionExecutor().getFunctions())
                .functionCall(ChatCompletionRequest.ChatCompletionRequestFunctionCall.of("auto"))
                .maxTokens(500)
                .logitBias(new HashMap<>())
                .build();
    }

    private ChatMessage chatWithAI (List<ChatMessage> messages) {
        OpenAiService openAiService = new OpenAiService(token);
        return openAiService.createChatCompletion(createChatCompletionRequest(messages))
                .getChoices().get(0).getMessage();
    }
}
