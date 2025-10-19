package calculator.domain.parse;

import java.util.regex.Pattern;

/**
 * 구분자 정책을 split 패턴으로 캡슐화한다.
 * 기본: 쉼표(,), 콜론(:)
 * 커스텀 선언이 있으면 기본 + 커스텀 1문자를 모두 허용한다.
 */
public final class DelimiterPolicy {
    private final Pattern splitPattern;

    private DelimiterPolicy(Pattern splitPattern) {
        this.splitPattern = splitPattern;
    }

    public static DelimiterPolicy of(Expression exp) {
        if (exp.hasCustom()) {
            String escaped = Pattern.quote(String.valueOf(exp.customDelimiterOrThrow()));
            return new DelimiterPolicy(Pattern.compile("[,:]|" + escaped));
        }
        return new DelimiterPolicy(Pattern.compile("[,:]"));
    }

    public String[] split(String s) {
        return splitPattern.split(s, -1); // 빈 토큰 유지 (후단에서 걸러냄)
    }
}
