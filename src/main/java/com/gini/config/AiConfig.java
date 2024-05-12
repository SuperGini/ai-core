package com.gini.config;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.OllamaEmbeddingClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(OllamaOptions ollamaOptions) {
        return new OllamaChatClient(new OllamaApi())
                .withDefaultOptions(ollamaOptions);
    }

    @Bean
    public PgVectorStore pgVectorStore(JdbcTemplate jdbcTemplate, OllamaOptions ollamaOptions) {
        var embeddingClient = new OllamaEmbeddingClient(new OllamaApi())
                .withDefaultOptions(ollamaOptions);

        return new PgVectorStore(jdbcTemplate, embeddingClient, 4096);

    }

    @Bean
    public OllamaOptions ollamaOptions() {
        return OllamaOptions.create()
                .withModel("llama3")
                .withTemperature(0.2F)
                .withTopK(2)
                .withTopP(0.5F);
    }


}
