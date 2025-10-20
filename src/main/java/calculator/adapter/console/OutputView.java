package calculator.adapter.console;

public final class OutputView {
    private OutputView() {}

    public static void printGuide() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.flush();
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
