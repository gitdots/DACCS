package com.company;

import java.util.LinkedList;
import java.util.List;

public class ChairProcess {

    private static ChairProcess instance = null;

    static private Pair processes[] = {
            new Pair("CutSeat", 1),
            new Pair("AssembleFeet", 2),
            new Pair("AssembleBackrest", 3),
            new Pair("AssembleStabilizer", 4),
            new Pair("Package", 5) };

    private static LinkedList<Pair<String, Integer>> list = new LinkedList(List.of(processes));

    private ChairProcess(){}

    public static ChairProcess getInstance() {
        if (instance == null) {
            instance = new ChairProcess();
        }
        return instance;
    }

    public void addProcess(String process, int time){
        list.add(new Pair(process, time));
    }

    public  Pair<String, Integer> process(String process) {
        for (Pair p : list) {
            if (p.getActivity().equals(process))
                return p;
        }
        return null;//exception?!
    }

}

class Pair<R,T>{
    private R activity;
    private T time;

    Pair(R activity, T time){
        this.activity = activity;
        this.time = time;
    }

    public R getActivity() {
        return activity;
    }

    public T getTime() {
        return time;
    }

    @Override
    public String toString() {
        return
                "{" + activity +
                "," + time +
                "}";
    }
}
