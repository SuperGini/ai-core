package com.gini.service;

import com.gini.dto.Response;
import com.gini.template.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final ChatClient chatClient;

    public Response getInfoResponse(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(Template.PROMPT_INFO);
        promptTemplate.add("question", question);

        var response = chatClient.call(promptTemplate.render());

        return new Response(response);

    }


}
