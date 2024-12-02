package oncall.dto;

import java.util.List;

public class WorkersDTO {
    private final List<String> workers;

    private WorkersDTO(List<String> workers) {
        this.workers = workers;
    }

    public static WorkersDTO of(List<String> workers) {
        return new WorkersDTO(workers);
    }

    public List<String> getWorkers() {
        return workers;
    }
}
