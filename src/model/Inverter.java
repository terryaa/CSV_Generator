package model;

import java.util.List;
//Data객체 구성
public class Inverter {
    private Long startTS;
    private Long endTS;
    private String error="null";
    private List<Devices_Gateway> devices;

    public Long getStartTS() {
        return this.startTS;
    }

    public void setStartTS(Long startTS) {
        this.startTS = startTS;
    }

    public Long getEndTS() {
        return this.endTS;
    }

    public void setEndTS(Long endTS) {
        this.endTS = endTS;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Devices_Gateway> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Devices_Gateway> devices) {
        this.devices = devices;
    }
    
}