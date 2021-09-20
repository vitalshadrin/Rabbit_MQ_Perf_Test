[
   {
      "name":"spec-results",
      "uri" : "amqp://localhost",
      "type":"simple",
      "params":[
         {
            "time-limit": 300,
            "queue-names":[
               "Simple_Q"
            ],
            "auto-delete" : false,
            "json-body" : true,
            "body-field-count" : 7,
            "queue-arguments" : {
                "x-single-active-consumer" : false
            }
         }
      ]
   }
]