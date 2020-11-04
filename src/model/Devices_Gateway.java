package model;

//Data객체 구성
public class Devices_Gateway {
    private long startTs;
    private long endTs;
    private String mac;
    private String id;
    private String sn;
    private Version_Software software;
    private Ioboard ioboard;

    public long getStartTs() {
        return this.startTs;
    }

    public void setStartTs(long startTs) {
        this.startTs = startTs;
    }

    public long getEndTs() {
        return this.endTs;
    }

    public void setEndTs(long endTs) {
        this.endTs = endTs;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Version_Software getSoftware() {
        return this.software;
    }

    public void setSoftware(Version_Software software) {
        this.software = software;
    }

    public Ioboard getIoboard() {
        return this.ioboard;
    }

    public void setIoboard(Ioboard ioboard) {
        this.ioboard = ioboard;
    }
    
}