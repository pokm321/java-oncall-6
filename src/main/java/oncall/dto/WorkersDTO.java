package oncall.dto;

import java.util.List;

public record WorkersDTO(List<String> workers) {

    public static WorkersDTO of(List<String> workers) {
        return new WorkersDTO(workers);
    }
}
