package model;

import java.util.List;
//Data객체 구성
public class Gateway {
    private List<Devices_Gateway> devices;


    public List<Devices_Gateway> getDevices() {
        return this.devices;
    }

    public void setDevices(List<Devices_Gateway> devices) {
        this.devices = devices;
    }

}