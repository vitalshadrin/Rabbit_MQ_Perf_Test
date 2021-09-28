package spec;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Param {
    @JsonProperty("time-limit")
    public int timeLimit;
    @JsonProperty("queue-names")
    public List<String> queueNames;
    @JsonProperty("auto-delete")
    public boolean autoDelete;
    @JsonProperty("json-body")
    public boolean jsonBody;
    @JsonProperty("body-field-count")
    public int bodyFieldCount;
    @JsonProperty("queue-arguments")
    public QueueArguments queueArguments;
}
