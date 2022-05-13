package pipesfilters.architecture;

public class WrongActivityException extends RuntimeException{
    WrongActivityException(String msg){
        super(msg);
    }
}
