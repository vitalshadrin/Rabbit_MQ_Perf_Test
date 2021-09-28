package spec;

import lombok.Data;

import java.util.List;

@Data
public class Spec {
    private String name;
    private String uri;
    private String type;
    private List<Param> params;
}
