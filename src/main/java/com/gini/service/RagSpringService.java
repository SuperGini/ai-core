package com.gini.service;

import com.gini.dto.Request;
import com.gini.dto.SpringResponse;
import com.gini.repository.RagRepository;
import com.gini.template.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RagSpringService {

    private final RagRepository ragRepository;
    private final ChatClient chatClient;

    public SpringResponse getAnswer(Request request) {

        var documents = ragRepository.getDocuments(request.question());

        PromptTemplate promptTemplate = new PromptTemplate(Template.PROMPT_TEMPLATE_SPRING2);
        promptTemplate.add("question", request.question());
        promptTemplate.add("documents", String.join("\n", documents));

        var response =  chatClient.call(promptTemplate.render());

        return new SpringResponse(response);
    }


}
