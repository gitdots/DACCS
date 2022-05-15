package pipesfilters.bussiness;

import java.util.LinkedList;
import java.util.List;

public class ChairProcess {

    private static ChairProcess instance = null;

    static private final Job[] processes = {
            new Job("CutSeat", 1),
            new Job("AssembleFeet", 2),
            new Job("AssembleBackrest", 3),
            new Job("AssembleStabilizer", 4),
            new Job("Package", 5) };

    private static LinkedList<Job> list = new LinkedList(List.of(processes));

    private ChairProcess(){}

    public static ChairProcess getInstance() {
        if (instance == null) {
            instance = new ChairProcess();
        }
        return instance;
    }

    public void addProcess(String process, int time){
        list.add(new Job(process, time));
    }

    public Job process(String process) {
        for (Job p : list) {
            if (p.getActivity().equals(process))
                return p;
        }
        return null;
    }

    public LinkedList<Job> getProcessList(){
        return list;
    }

}

