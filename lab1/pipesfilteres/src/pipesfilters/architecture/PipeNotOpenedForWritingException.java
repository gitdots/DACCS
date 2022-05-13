package pipesfilters.architecture;

public class PipeNotOpenedForWritingException extends RuntimeException {

    PipeNotOpenedForWritingException() {
        super("PipeNotOpenedForWritingException");
    }
}
