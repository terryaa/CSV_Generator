package model;


//Data객체 구성
public class Data {
    private Gateway Gateway;
    private Inverter Inverters;
    private Strings Strings;
    public Data(){

    }
    public Data(Gateway Gateway, Inverter Inverters, Strings Strings) {
        this.Gateway = Gateway;
        this.Inverters = Inverters;
        this.Strings = Strings;
    }

    public Gateway getGateway() {
        return this.Gateway;
    }

    public void setGateway(Gateway Gateway) {
        this.Gateway = Gateway;
    }

    public Inverter getInverters() {
        return this.Inverters;
    }

    public void setInverters(Inverter Inverters) {
        this.Inverters = Inverters;
    }

    public Strings getStrings() {
        return this.Strings;
    }

    public void setStrings(Strings Strings) {
        this.Strings = Strings;
    }

}