package com.gini.template;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Template {

    public static final String PROMPT_TEMPLATE_SPRING2 = """
            Respond with exact information about the Spring Boot.
            Use the information from the DOCUMENTS section to provide the answers.
            If unsure or if the answer isn't found in the DOCUMENTS section,
            simply respond with: --- I don't know the answer. ---


            QUESTION:
            {question}

            DOCUMENTS:
            {documents}

            """;

    public static final String PROMPT_CAR = """
            Respond with exact information about the car {car}.

            If unsure or if the answer isn't found,
            simply respond with:  <<<Unknown>>>>.
            On all fields

            FORMAT:
            {format}

            ###### FORMAT EXAMPLE START #######

            manufacturer: who build the car,
            carModels: list of all the different models of that version
            modelType: variant of that car -> a car might come in different models (ex: Dacia Logan Ambience, or Dacia Loan Laureate)
            topSpeed: top speed of that car in km/h -> ex: 160 km/m
            engineType: petrol or diesel or electric etc.
            startProductionYear: year when production of the model started

            ###### FORMAT EXAMPLE END #######

            """;

    public static final String PROMPT_INFO = """
            Respond with exact information about this question {question}.

            If unsure or if the answer isn't found,
            simply respond with:  <<<Unknown>>>>.
       
            """;
}
