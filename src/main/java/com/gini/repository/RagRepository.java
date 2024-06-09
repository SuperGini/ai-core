package com.gini.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RagRepository {

    private final VectorStore vectorStore;

    public List<String> getDocuments(String searchQuestion) {
        var query = SearchRequest.query(searchQuestion).withTopK(2);
        return vectorStore
                .similaritySearch(query)
                .stream()
                .peek(x -> get(x.getMetadata()))
                .map(Document::getContent)
                .toList();
    }


//    public List<String> getDocuments2(String searchQuestion, String queryParameter) {
//        FilterExpressionBuilder b = new FilterExpressionBuilder();
//       var exp = b.eq(queryParameter, "").build();
//
//        var query = SearchRequest.defaults()
//                .withTopK(1)
//                .query(searchQuestion)
//                .withSimilarityThreshold(0.2)
//                .withFilterExpression(exp);
//
//        return vectorStore
//                .similaritySearch(query)
//                .stream()
//                .peek(x -> get(x.getMetadata()))
//                .map(Document::getContent)
//                .toList();
//
//    }



    private void get(Map<String, Object> x) {
        x.forEach((k,v) -> log.info("{} {}", k, v));
    }


}
