package com.company;

import java.util.ArrayList;

public class WorkingLine {

    private String lineName;
    private ArrayList<Pair<String, Integer>> process;

    public WorkingLine(String lineName, ArrayList<Pair<String, Integer>> process) {
        this.lineName = lineName;
        this.process = process;
    }

    public String getLineName(){
        return lineName;
    }

    public ArrayList<String> getProcess() {
        ArrayList<String> b = new ArrayList<String>();
        for (Pair p:
             process) {
            b.add(p.getActivity().toString());
        }

        return b;
    }

    public void startWork() {
        for (Pair p : process) {
            DoProcess work = new DoProcess(p);
            work.start();
        }
    }


    @Override
    public String toString() {
        return "WorkingLine{" +
                "lineName='" + lineName + '\'' +
                ", process=" + process +
                '}';
    }
}
