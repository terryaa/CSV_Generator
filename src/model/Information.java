package model;
//Data객체 구성
public class Information {
    private String portError="null";
    private String host;
    private int port;
    private int id;
    private String name;
    private int serialNo;
    private Double fwVersion;
    private int comparator;
    private int divider;
    private int rawPulsesCounter;


    public String getPortError() {
        return this.portError;
    }

    public void setPortError(String portError) {
        this.portError = portError;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public Double getFwVersion() {
        return this.fwVersion;
    }

    public void setFwVersion(double d) {
        this.fwVersion = d;
    }

    public int getComparator() {
        return this.comparator;
    }

    public void setComparator(int comparator) {
        this.comparator = comparator;
    }

    public int getDivider() {
        return this.divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public int getRawPulsesCounter() {
        return this.rawPulsesCounter;
    }

    public void setRawPulsesCounter(int rawPulsesCounter) {
        this.rawPulsesCounter = rawPulsesCounter;
    }
    
}