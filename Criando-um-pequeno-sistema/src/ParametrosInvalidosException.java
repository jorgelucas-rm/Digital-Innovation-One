public class ParametrosInvalidosException extends Throwable {
    private final String message;
    public ParametrosInvalidosException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
