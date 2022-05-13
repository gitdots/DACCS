package pipesfilters.architecture;

import pipesfilters.bussiness.Job;

public abstract class Filter extends Thread {

    protected Status status = Status.SETUP;

    protected String oldData = "";
    protected String newData = null;

    @Override
    public void run() {}

    public synchronized Status getStatus() {
        return status;
    }

    public synchronized boolean isDone() {
        return status == Status.DONE;
    }

    public Job getJob() {
        return null;
    }
}