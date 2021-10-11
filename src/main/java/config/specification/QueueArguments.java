package config.specification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueueArguments {
    @JsonProperty("x-single-active-consumer")
    public boolean xSingleActiveConsumer;
}
