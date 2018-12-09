package booking.system;

public class IrregularHourException extends Exception {
    public IrregularHourException() {
    }

    public IrregularHourException(String message) {
        super(message);
    }

    public IrregularHourException(String message, Throwable cause) {
        super(message, cause);
    }

    public IrregularHourException(Throwable cause) {
        super(cause);
    }

    public IrregularHourException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}