package pipesfilters.bussiness;

import pipesfilters.architecture.Filter;
import pipesfilters.architecture.Status;

import java.util.Objects;

public class Worker extends Filter {

    private final long id;
    private final String name;
    private Job job;

    public Worker(long id, String name, Job job) {
        this.id = id;
        this.name = name;
        this.job = job;
        status = Status.SETUP;
    }

    @Override
    public void run() {
        System.out.println(this + "started work.");
        try {
            status = Status.PROCESS;
            sleep(job.getTime()* 10L);
            newData = oldData + job.getActivity() + " DONE; ";
            status = Status.DONE;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "job done.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void changeJob(Job newJob) {
        this.job = newJob;
    }

    public long getId() {
        return id;
    }

    public String getWorkerName() {
        return name;
    }

    public Job getJob() {
        return job;
    }

}
