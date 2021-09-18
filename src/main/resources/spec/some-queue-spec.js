[
   {
      "name":"spec-results",
      "type":"simple",
      "params":[
         {
            "time-limit": 300,
            "queue-names":[
               "A1",
               "A2",
               "A3",
               "A4"
            ],
            "json-body" : true,
            "body-field-count" : 7,
            "queue-arguments" : {
                "x-single-active-consumer" : false
            }
         }
      ]
   }
]