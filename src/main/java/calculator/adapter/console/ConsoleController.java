package calculator.adapter.console;

import calculator.app.AddNumbersUseCase;

public class ConsoleController {
    private final AddNumbersUseCase useCase;

    public ConsoleController(AddNumbersUseCase useCase) {
        this.useCase = useCase;
    }

    public void run() {
        OutputView.printGuide();
        String input = InputView.readInput();
        int result = useCase.add(input);
        OutputView.printResult(result);
    }
}
