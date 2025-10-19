package calculator.domain.parse;

import java.util.Arrays;
import java.util.List;

/**
 * 표현식과 정책에 따라 본문을 토큰 리스트로 변환한다.
 * - 공백은 trim
 * - 빈 토큰("")은 제거
 */
public final class Tokenizer {
    private final Expression expression;
    private final DelimiterPolicy policy;

    private Tokenizer(Expression expression, DelimiterPolicy policy) {
        this.expression = expression;
        this.policy = policy;
    }

    public static Tokenizer of(Expression expression) {
        return new Tokenizer(expression, DelimiterPolicy.of(expression));
    }

    public List<String> tokens() {
        String body = expression.body();
        if (body.isEmpty()) return List.of();
        return Arrays.stream(policy.split(body))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}
