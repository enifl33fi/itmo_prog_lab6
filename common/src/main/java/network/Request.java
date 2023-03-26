package network;

import java.io.Serializable;

public class Request implements Serializable {
    private String requestLine;
    private int[] data;

    public String getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(String requestLine) {
        this.requestLine = requestLine;
    }

    public int[] getData() {

        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }


    public boolean hasData(){
        return this.data != null;
    }
}
