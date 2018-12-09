package race;

public class NotSubscribedException extends Exception {
    public NotSubscribedException() {
    }

    public NotSubscribedException(String message) {
        super(message);
    }

    public NotSubscribedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSubscribedException(Throwable cause) {
        super(cause);
    }

    public NotSubscribedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
