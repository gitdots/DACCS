package pipesfilters.architecture;

public class PipeNotOpenedForReadingException extends RuntimeException {
    PipeNotOpenedForReadingException() {
        super("PipeNotOpenedForReadingException");
    }
}
