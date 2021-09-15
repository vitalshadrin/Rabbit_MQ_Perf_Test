[
   {
      "name":"spec-results",
      "type":"simple",
      "params":[
         {
            "time-limit": 60,
            "queue-names":[
               "A1",
               "A2",
               "A3",
               "A4"
            ],
            "json-body" : true,
            "body-field-count" : 3,
            "queue-arguments" : {
                "x-single-active-consumer" : true
            }
         }
      ],
      "variables":[
         {
            "name":"min-msg-size",
            "values":[
               0,
               100,
               200,
               500,
               1000,
               2000
            ]
         }
      ]
   }
]