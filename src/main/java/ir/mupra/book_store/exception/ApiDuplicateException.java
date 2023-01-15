package ir.mupra.book_store.exception;

public class ApiDuplicateException extends RuntimeException {
    public ApiDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiDuplicateException(String message) {
        super(message);
    }
}
