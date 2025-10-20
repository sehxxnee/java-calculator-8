package calculator.support;

public final class InputValidator {
    private InputValidator() {}

    public static void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다.");
        }
    }

    public static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }
    }
}
