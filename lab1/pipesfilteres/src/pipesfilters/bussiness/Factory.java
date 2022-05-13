package pipesfilters.bussiness;

import pipesfilters.architecture.Filter;
import java.util.ArrayList;
import java.util.HashSet;

public class Factory {

    private HashSet<Filter> workers;
    private ArrayList<Workline> worklines;

    public Factory(){
        workers = new HashSet<>();
        worklines = new ArrayList<>();
    }

    public Factory addWorker(Worker worker){
        workers.add(worker);
        return this;
    }

    public void addWorkers(ArrayList<Filter> workers){
        this.workers.addAll(workers);
    }

    void openWorklineWithWorkers(int[] ids, long worklineId, String worklineName) {
        ArrayList<Filter> ws = new ArrayList<>();

        for (int id : ids) {

            for (Filter w : workers) {
                if (w.getId() == id) {
                    ws.add(w);
                }
            }

            Workline workline = new Workline(worklineId, worklineName, ws);
            worklines.add(workline);
        }
    }

    void startWorkline(int worklineId) throws InterruptedException {
        for (Workline w : worklines){
            if (w.getId() == worklineId){
                System.out.println("WORKLINE " + worklineId + " STARTED WORKING");
                w.startWork();
                break;
            }
        }
    }
}

class WorklineExistsException extends RuntimeException{
    WorklineExistsException(String msg) {
        super(msg);
    }
}