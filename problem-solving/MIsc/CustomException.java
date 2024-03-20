package MIsc;

public class CustomException extends RuntimeException{
    public CustomException(String customException) {
        super(customException);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
