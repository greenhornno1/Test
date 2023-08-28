package exception;

public class TestException extends RuntimeException {
    private static final long serialVersionUID = -8681065545415598632L;
    private int errorCode;

    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }


}
