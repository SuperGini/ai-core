package com.gini.service;

import com.gini.dto.CarResponse;
import com.gini.template.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final PgVectorStore vectorStore;
    private final ChatClient chatClient;

    @Value("classpath:/template.st")
    private Resource resource;


    public CarResponse getResponse(String car) {

        BeanOutputParser<CarResponse> parser = new BeanOutputParser<>(CarResponse.class);

        PromptTemplate promptTemplate = new PromptTemplate(Template.PROMPT_CAR);
//        PromptTemplate promptTemplate = new PromptTemplate(resource);
        promptTemplate.add("format", parser.getFormat());
        promptTemplate.add("car", car);

        return parser.parse(chatClient.call(promptTemplate.render()));

    }

}
