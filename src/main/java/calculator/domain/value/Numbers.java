package calculator.domain.value;

import java.util.List;

public final class Numbers {
    private final List<PositiveNumber> values;

    private Numbers(List<PositiveNumber> values) {
        this.values = List.copyOf(values);
    }

    public static Numbers fromTokens(List<String> tokens) {
        if (tokens == null || tokens.isEmpty()) return new Numbers(List.of());
        return new Numbers(tokens.stream().map(PositiveNumber::parse).toList());
    }

    public int sum() {
        return values.stream().mapToInt(PositiveNumber::value).sum();
    }

    public List<PositiveNumber> values() {
        return values;
    }
}
