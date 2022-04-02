package com.company;

public class DoProcess extends Thread {

    private String workload;
    private int workTime;

    public DoProcess(Pair<String, Integer> p) {
        this.workload = p.getActivity();
        this.workTime = p.getTime();
    }

    public void run() {
        System.out.println("Workload " + workload + " done.");
        try {
            Thread.sleep(workTime * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
