package model;

//Data객체 구성

public class Devices_Strings {
    private Information info;
    private String error="null";
    private int stringVoltage;
    private float stringCurrent;
    private float temperature;
    private int totalWh;
    private Modules Modules;

    public Information getInfo() {
        return this.info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStringVoltage() {
        return this.stringVoltage;
    }

    public void setStringVoltage(int stringVoltage) {
        this.stringVoltage = stringVoltage;
    }

    public float getStringCurrent() {
        return this.stringCurrent;
    }

    public void setStringCurrent(float stringCurrent) {
        this.stringCurrent = stringCurrent;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getTotalWh() {
        return this.totalWh;
    }

    public void setTotalWh(int totalWh) {
        this.totalWh = totalWh;
    }

    public Modules getModules() {
        return this.Modules;
    }

    public void setModules(Modules Modules) {
        this.Modules = Modules;
    }

}