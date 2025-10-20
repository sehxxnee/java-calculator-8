package calculator.domain.calc;

import calculator.domain.parse.Expression;
import calculator.domain.parse.Tokenizer;
import calculator.domain.value.Numbers;

public final class StringAddCalculator {
    private StringAddCalculator() {}

    public static int calculate(String raw) {
        var expression = Expression.of(raw);
        if (expression.isEmpty()) return 0;
        var tokens = Tokenizer.of(expression).tokens();
        return Numbers.fromTokens(tokens).sum();
    }
}
