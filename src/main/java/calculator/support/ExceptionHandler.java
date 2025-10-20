package calculator.support;

public final class ExceptionHandler {
    private ExceptionHandler() {}

    public static void handle(Runnable task) {
        try {
            task.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[UNEXPECTED ERROR] " + e.getMessage());
        }
    }
}
