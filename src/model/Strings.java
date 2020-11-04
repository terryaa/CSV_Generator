package model;

import java.util.List;
//Data객체 구성
public class Strings {
    private Long startTs;
    private Long endTs;
    private List<Devices_Strings> devices;

    public Long getStartTS() {
        return this.startTs;
    }

    public void setStartTS(Long startTS) {
        this.startTs = startTS;
    }

    public Long getEndTS() {
        return this.endTs;
    }

    public void setEndTS(Long endTS) {
        this.endTs = endTS;
    }

   
    public List<Devices_Strings> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Devices_Strings> devices) {
        this.devices = devices;
    }
    
}