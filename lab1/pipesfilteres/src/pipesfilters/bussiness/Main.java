package pipesfilters.bussiness;

import pipesfilters.architecture.Filter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        ChairProcess c = ChairProcess.getInstance();

        ArrayList<Filter> workers = new ArrayList<>();
        workers.add(new Worker(1, "Name_0001", c.process("CutSeat")));
        workers.add(new Worker(2, "Name_0002", c.process("AssembleFeet")));
        workers.add(new Worker(3, "Name_0003", c.process("AssembleBackrest")));
        workers.add(new Worker(4, "Name_0004", c.process("AssembleStabilizer")));
        workers.add(new Worker(5, "Name_0005", c.process("Package")));
        factory.addWorkers(workers);

        int[] workersLine1 = {1,2,3,4,5};

        c.addProcess("AssembleMassage",6);
        //System.out.println(c.getProcessList());

        Worker w = new Worker(6, "Name_0006", c.process("AssembleMassage"));
        workers.add(w);
        factory.addWorker(w);

        int[] workersLine2 = {1,2,4,6,5};

        try {
            //factory.openWorklineWithWorkers(workersLine1, 1, "workline1");
            //factory.startWorkline(1);

            factory.openWorklineWithWorkers(workersLine2, 2, "workline2");
            factory.startWorkline(2);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}