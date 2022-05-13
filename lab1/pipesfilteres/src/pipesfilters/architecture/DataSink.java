package pipesfilters.architecture;

public class DataSink {
    private String data;

    public void setData(String data){
        this.data = data;
    }

    public void publishData(){
        System.out.println(data);
    }

    @Override
    public String toString() {
        return "DataSink{" +
                "data='" + data + '\'' +
                '}';
    }
}
