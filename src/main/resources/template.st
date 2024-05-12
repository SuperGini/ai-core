Respond with exact information about the car {car}.

            If unsure or if the answer isn't found,
            simply respond with:  I don't know the answer.


            FORMAT:
            {format}

            ###### FORMAT EXAMPLE START #######

            manufacturer: who build the car,
            carModel: list of all the different models of that version
            modelType: variant of that car -> a car might come in different models (ex: Dacia Logan Ambience, or Dacia Loan Laureate)
            topSpeed: top speed of that car in km/h -> ex: 160 km/m
            engineType: petrol or diesel or electric etc.

            -----------------------------------
            {\\"manufacturer\\":\\"Ford\\"
            ,\\"carModel\\":[
            {\\"modelType\\":\\"Focus RS\\",
            \\"topSpeed\\":\\"150 km/h\\",
            \\"engineType\\":\\"petrol\\"},
            {\\"modelType\\":\\"Focus ST\\",
            \\"topSpeed\\":\\"220 km/h\\",
            \\"engineType\\":\\"petrol\\"}
            ]}
            -----------------------------------

            ###### FORMAT EXAMPLE END #######
