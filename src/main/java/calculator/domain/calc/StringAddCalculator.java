package calculator.domain.calc;

public final class StringAddCalculator {
    private StringAddCalculator() {}

    public static int calculate(String raw) {
        // TODO: Expression, Tokenizer, Numbers 등 연결 예정
        if (raw == null || raw.isBlank()) return 0;
        // 임시 구현 (테스트용)
        return 0;
    }
}
