package pipesfilters.architecture;

public class Pipe {

    private boolean isOpenForWrite = false;
    private boolean isOpenForRead = false;

    private boolean hasData = false;
    private String data;

    public synchronized Pipe writeData(String data) throws PipeNotOpenedForWritingException {
        if (isOpenForWrite) {
            this.data = data;
            hasData = true;
        } else throw new PipeNotOpenedForWritingException();
        return this;
    }

    public synchronized String readData() throws PipeNotOpenedForReadingException {
        if (isOpenForRead && hasData)
            return data;
        else throw new PipeNotOpenedForReadingException();
    }

    public Pipe openForRead() {
        isOpenForRead = true;
        return this;
    }

    public Pipe openForWrite() {
        isOpenForWrite = true;
        return this;
    }

    public boolean isOpenForRead() {
        return isOpenForRead;
    }

    public boolean isOpenForWrite() {
        return isOpenForWrite;
    }

    public boolean hasData() {
        return hasData;
    }

    public void close() {
        if (isOpenForWrite)
            isOpenForWrite = false;
        if (isOpenForRead)
            isOpenForRead = false;
    }

    public synchronized void waitForData() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "isOpenForWrite=" + isOpenForWrite +
                ", isOpenForRead=" + isOpenForRead +
                ", hasData=" + hasData +
                ", data='" + data + '\'' +
                '}';
    }
}