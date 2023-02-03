package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException {
    String message;

    public ArgumentLengthsDifferException( int size1, int size2) {
        this.message = "error: too few command line arguments";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
