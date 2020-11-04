package model;

import java.util.List;
//Data객체 구성
public class Modules {
    private Long startTs;
    private long endTs;
    private List<Devices_Module> devices;

    public Long getStartTs() {
        return this.startTs;
    }

    public void setStartTs(Long startTs) {
        this.startTs = startTs;
    }

    public long getEndTs() {
        return this.endTs;
    }

    public void setEndTs(long endTs) {
        this.endTs = endTs;
    }

    public List<Devices_Module> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Devices_Module> devices) {
        this.devices = devices;
    }

    
    
}