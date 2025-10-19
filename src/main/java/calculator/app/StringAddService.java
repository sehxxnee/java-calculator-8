package calculator.app;

import calculator.domain.calc.StringAddCalculator;

public final class StringAddService implements AddNumbersUseCase {
    @Override
    public int add(String input) {
        return StringAddCalculator.calculate(input);
    }
}
