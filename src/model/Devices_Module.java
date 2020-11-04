package model;
//Data객체 구성
public class Devices_Module {
    private String moduleSerial;
    private float moduleVoltage;
    private float moduleTemperature;
    private int moduleWatt;
    private float moduleCurrent;

    public float getModuleCurrent() {
        return this.moduleCurrent;
    }

    public void setModuleCurrent(float moduleCurrent) {
        this.moduleCurrent = moduleCurrent;
    }

    public Devices_Module(String moduleSerial, float moduleVoltage, float moduleTemperature, int moduleWatt, float moduleCurrent) {
        this.moduleSerial = moduleSerial;
        this.moduleVoltage = moduleVoltage;
        this.moduleTemperature = moduleTemperature;
        this.moduleWatt = moduleWatt;
        this.moduleCurrent = moduleCurrent;
    }

    public int getModuleWatt() {
        return this.moduleWatt;
    }

    public void setModuleWatt(int moduleWatt) {
        this.moduleWatt = moduleWatt;
    }




    public String getModuleSerial() {
        return this.moduleSerial;
    }

    public void setModuleSerial(String moduleSerial) {
        this.moduleSerial = moduleSerial;
    }

    public float getModuleVoltage() {
        return this.moduleVoltage;
    }

    public void setModuleVoltage(float moduleVoltage) {
        this.moduleVoltage = moduleVoltage;
    }

    public float getModuleTemperature() {
        return this.moduleTemperature;
    }

    public void setModuleTemperature(float moduleTemperature) {
        this.moduleTemperature = moduleTemperature;
    }

}