package calculator.adapter.console;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {}

    public static String readInput() {
        return Console.readLine();
    }
}
