package pipesfilters.bussiness;

import pipesfilters.architecture.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Factory {

    private HashMap<Long, Filter> workers;
    private ArrayList<Workline> worklines;

    public Factory(){
        workers = new HashMap<>();
        worklines = new ArrayList<>();
    }

    public Factory addWorker(Worker worker){
        //workers.add(worker);
        workers.put(worker.getId(), worker);
        return this;
    }

    public void addWorkers(ArrayList<Filter> workers){
        //this.workers.addAll(workers);
        for (Filter w :
                workers) {
            this.workers.put(w.getId(), w);
        }
    }

    void openWorklineWithWorkers(int[] ids, long worklineId, String worklineName) {
        ArrayList<Filter> ws = new ArrayList<>();

        for (long id : ids) {
            ws.add(this.workers.get(id));
            System.out.println(this.workers.get(id));
//            for (Filter w : workers) {
//                if (w.getId() == id) {
//                    ws.add(w);
//                }
//            }
        }
        Workline workline = new Workline(worklineId, worklineName, ws);
        worklines.add(workline);
        System.out.println(workline);
    }

    void startWorkline(int worklineId) throws InterruptedException {
        for (Workline w : worklines){
            if (w.getId() == worklineId){
                //System.out.println("WORKLINE " + worklineId + " STARTED WORKING");
                //System.out.println(w);
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