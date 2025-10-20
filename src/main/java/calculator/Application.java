package calculator;

import calculator.adapter.console.ConsoleController;
import calculator.app.StringAddService;

public class Application {
    public static void main(String[] args) {
        new ConsoleController(new StringAddService()).run();
    }
}
