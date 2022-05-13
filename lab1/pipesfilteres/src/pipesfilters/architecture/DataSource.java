package pipesfilters.architecture;

import java.util.ArrayList;

public class DataSource {
    private ArrayList<String> data;

    public void setData(ArrayList<String> data){
        this.data = data;
    }

    public ArrayList<String> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "data=" + data +
                '}';
    }
}
