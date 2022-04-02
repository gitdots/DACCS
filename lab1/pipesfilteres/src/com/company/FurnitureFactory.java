package com.company;

import java.util.ArrayList;
import java.util.HashMap;


public class FurnitureFactory {
    public String name;
    private ArrayList<WorkingLine> workingLines;
    private HashMap<String, String> workers;

    FurnitureFactory(String name){
        this.name = name;
        workers = new HashMap<>();
        workingLines = new ArrayList<>();
    }

    public void hireWorker(String name, String workLine) {
        workers.put(name, workLine);
    }

    public void moveWorker(String name, String workLine, String toWorkLine) {
        workers.replace(name, workLine, toWorkLine);
    }

    public void fireWorker(String name, ChairProcess workLine) {
        workers.remove(name, workLine);
    }

    public void openWorkingLine(String name, WorkingLine workingLine) {
        workingLines.add(workingLine);
    }

    public void startLine(String name) {
        for (WorkingLine line : workingLines) {
            String lineName = line.getLineName();
            if(lineName.equals(name)) {
                System.out.println("WorkLine " + name + " started producing.");
                line.startWork();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "FurnitureFactory{" +
                "name='" + name + '\'' +
                ", workingLines=" + workingLines +
                ", workers=" + workers +
                '}';
    }
}
