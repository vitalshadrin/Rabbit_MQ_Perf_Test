[
   {
      "name":"one-queue-single-active-consumers-spec",
      "uri" : "amqp://localhost",
      "type":"simple",
      "params":[
         {
            "time-limit": 300,
            "queue-names":[
               "Single_Q"
            ],
            "auto-delete" : false,
            "json-body" : true,
            "body-field-count" : 7,
            "queue-arguments" : {
                "x-single-active-consumer" : true
            }
         }
      ]
   }
]