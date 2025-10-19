package calculator.domain.parse;

/**
 * 원본 입력을 보관하고, 커스텀 구분자 선언부(//x\n)와 본문을 분리한다.
 */
public final class Expression {
    private final String raw;

    private Expression(String raw) {
        this.raw = raw;
    }

    public static Expression of(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("입력이 null 입니다.");
        }
        return new Expression(raw);
    }

    public boolean isEmpty() {
        return raw.isEmpty();
    }

    /** //x\n 형태의 선언부가 있는지 */
    public boolean hasCustom() {
        return raw.startsWith("//");
    }

    /** 커스텀 구분자 단일 문자 추출 (형식 위반 시 예외) */
    public char customDelimiterOrThrow() {
        int idx = raw.indexOf('\n');
        if (!hasCustom() || idx < 0) {
            throw new IllegalArgumentException("커스텀 구분자 선언 형식이 올바르지 않습니다. 예: //;\\n1;2;3");
        }
        // // + (1문자) + \n  → 인덱스 3이어야 단일 문자
        if (idx != 3) {
            throw new IllegalArgumentException("커스텀 구분자는 단일 문자만 허용됩니다.");
        }
        return raw.charAt(2);
    }

    /** 계산 대상으로 사용할 본문을 반환 */
    public String body() {
        if (!hasCustom()) return raw;
        return raw.substring(raw.indexOf('\n') + 1);
    }
}
