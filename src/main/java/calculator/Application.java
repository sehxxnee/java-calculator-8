package calculator;

import calculator.adapter.console.ConsoleController;
import calculator.app.StringAddService;
import calculator.support.ExceptionHandler;

public class Application {
    public static void main(String[] args) {
        ExceptionHandler.handle(() -> {
            new ConsoleController(new StringAddService()).run();
        });
    }
}
