package errorsAndExceptions.universityExceptions;

public class NoStudentWithIdException extends Exception {
    public NoStudentWithIdException() {
    }

    public NoStudentWithIdException(String message) {
        super(message);
    }

    public NoStudentWithIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentWithIdException(Throwable cause) {
        super(cause);
    }
}
