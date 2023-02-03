package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException{
    private String message;

    public TooFewArgumentsException() {
        this.message = "error: too few command line arguments";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
