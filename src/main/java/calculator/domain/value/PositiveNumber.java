package calculator.domain.value;

public record PositiveNumber(int value) {
    public PositiveNumber {
        if (value < 0) throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
    }

    public static PositiveNumber parse(String token) {
        try {
            return new PositiveNumber(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다: " + token);
        }
    }
}
