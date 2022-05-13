package pipesfilters.bussiness;

public class Job {
    private String activity;
    private int time;

    public Job(String activity, int time) {
        this.activity = activity;
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "{" + activity + "," + time + "}";
    }
}
