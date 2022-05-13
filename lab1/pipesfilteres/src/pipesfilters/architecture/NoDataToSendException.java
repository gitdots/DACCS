package pipesfilters.architecture;

public class NoDataToSendException extends RuntimeException {
    NoDataToSendException(){
        super("NoDataToSendException");
    }
}
