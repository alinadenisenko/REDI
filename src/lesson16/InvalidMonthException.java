package lesson16;

public class InvalidMonthException extends RuntimeException {
    public InvalidMonthException() {
        super("The month should be between 1 and 12");
    }
}
