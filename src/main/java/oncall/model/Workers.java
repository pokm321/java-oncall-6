package oncall.model;

import java.util.List;
import java.util.Objects;

public class Workers {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_WORKER_COUNT = 5;
    private static final int MAX_WORKER_COUNT = 35;

    private final List<String> names;

    private Workers(List<String> names) {
        this.names = names;
    }

    public static Workers of(List<String> workers) {
        validate(workers);
        return new Workers(workers);
    }

    private static void validate(List<String> workers) {
        validateNotNull(workers);
        validateNotEmpty(workers);
        validateNameLengths(workers);
        validateDuplicates(workers);
        validateWorkerCount(workers);
    }

    private static void validateNotNull(List<String> workers) {
        if (workers.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEmpty(List<String> workers) {
        if (workers.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameLengths(List<String> workers) {
        if (workers.stream().anyMatch(worker -> worker.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicates(List<String> workers) {
        if (workers.stream().distinct().count() != workers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateWorkerCount(List<String> workers) {
        if (workers.size() < MIN_WORKER_COUNT || workers.size() > MAX_WORKER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNames() {
        return names;
    }
}
