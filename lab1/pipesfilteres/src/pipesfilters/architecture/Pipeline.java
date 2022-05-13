package pipesfilters.architecture;

import java.util.ArrayList;

public abstract class Pipeline {
    private ArrayList<Filter> filters;
    private Pipe[] pipes;
    private DataSink sink;

    private void addFilters(ArrayList<Filter> filters){
        this.filters = filters;
    }

    private void setup(){
        sink = new DataSink();
        pipes = new Pipe[filters.size()];
        for (int i = 0; i < filters.size(); i++){
            pipes[i] = new Pipe();
        }
    }

    private void doFilterWork(Filter f, int index) throws InterruptedException {
        f.start();
        f.join();
        if (f.isDone()) {
            pipes[index].openForWrite().writeData(f.newData).close();
        }
    }

    private void handleStart() throws FilterFailedException, InterruptedException {
        int index = 0;
        for (Filter f : filters) {
            if (index == 0) {
                doFilterWork(f, index);
                //System.out.println("INDEX = " + index + ": "+ pipes[index].toString());
            }
            else {
                f.oldData = pipes[index-1].openForRead().readData();
                pipes[index-1].close();
                doFilterWork(f, index);
                //System.out.println("INDEX = " + index + ": "+ pipes[index].toString());
            }
            index++;
        }

        sink.setData(pipes[index-1].openForRead().readData());
        pipes[index-1].close();
    }

    protected void startPipeline(ArrayList<Filter> filters) throws InterruptedException {
        addFilters(filters);
        setup();
        System.out.println("Pipeline setup done - starting");
        handleStart();
        sink.publishData();
    }
}

class FilterFailedException extends RuntimeException{
    FilterFailedException(String msg){
        super(msg);
    }
}