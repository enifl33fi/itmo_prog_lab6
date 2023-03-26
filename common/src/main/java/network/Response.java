package network;

import java.io.Serializable;
import java.util.Arrays;

public class Response implements Serializable {
    private String responseLine;
    private int[] data;


    public String getResponseLine() {

        return responseLine;
    }

    public void setResponseLine(String responseLine) {
        this.responseLine = responseLine;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

}