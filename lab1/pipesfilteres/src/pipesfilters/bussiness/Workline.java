package pipesfilters.bussiness;
import pipesfilters.architecture.Filter;
import pipesfilters.architecture.Pipeline;

import java.util.ArrayList;

public class Workline extends Pipeline {

    private final long id;
    private final String name;
    private ArrayList<Filter> workers;

    public Workline(long id, String name, ArrayList<Filter> workers) {
        this.id = id;
        this.name = name;
        this.workers = workers;
        ArrayList<String> data = new ArrayList<>();
        for (Filter w : workers) {
            data.add(w.getJob().getActivity());
        }
    }

    public void startWork() throws InterruptedException {
        //System.out.println("workline " + id + " starting");
        startPipeline(workers);
    }

    @Override
    public String toString() {
        return "Workline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workers=" + workers +
                '}';
    }

    public long getId() {
        return id;
    }
}