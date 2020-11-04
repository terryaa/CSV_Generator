package modules;

import java.util.List;

import model.Data;
import model.Devices_Module;
import model.Devices_Strings;
import model.Gateway;
import model.Inverter;
import model.Modules;
import model.Strings;


//Data객체에 업데이트가 필요한 부분을 일정한값 or Random한 값으로 업데이트한다.
public class DataUpdater {
    
    private RandomGenerator rg;


    private String gt_query;
    private String st_query;
    private String md_query;
    public DataUpdater(){
        rg=new RandomGenerator();
    }

    //모든 업데이트를 지시하는 업데이트 메소드. 
    //1개만 따로 실험 가능
    public Data update(Data dat){
        update_strings(dat.getStrings());
        update_gateway(dat.getGateway(),dat.getStrings());
        update_inverters(dat.getInverters());
        return dat;
    }

    //업데이트할 Data를 리스트로 받아 업데이트를 진행한다.
    public List<Data> update(List<Data> ary_data){
        for(Data dat: ary_data){
            update(dat);
        }
        return ary_data;
    }

    private void update_gateway(Gateway gt,Strings str){

        rg.gen_TS(gt.getDevices().get(0).getStartTs());
        gt.getDevices().get(0).setStartTs(rg.getStartTS());
        gt.getDevices().get(0).setEndTs(rg.getEndTS());
        Integer.parseInt(gt.getDevices().get(0).getId());
        

        
    }
    private void update_inverters(Inverter iv){
        rg.gen_TS(iv.getStartTS());
        iv.setStartTS(rg.getStartTS());
        iv.setEndTS(rg.getEndTS());
    }
    private void update_strings(Strings str){
        rg.gen_TS(str.getStartTS());
        str.setStartTS(rg.getStartTS());
        str.setEndTS(rg.getEndTS());
        for(Devices_Strings ds: str.getDevices()){
            update_device_strings(ds);
        }
        
    }
    private void update_device_strings(Devices_Strings ds){
        rg.gen_Strings_Devices(ds.getTotalWh());
        ds.setStringVoltage(rg.getStr_devc_volt());
        ds.setStringCurrent(rg.getStr_devc_cur());
        ds.setTemperature(rg.getStr_devc_temp());
        ds.setTotalWh(rg.getStr_devc_totalWh());
        update_modules(ds.getModules());

    }
    private void update_modules(Modules md){
        rg.gen_TS(md.getStartTs());
        md.setStartTs(rg.getStartTS());
        md.setEndTs(rg.getEndTS());
        update_device_modules(md.getDevices());
    }

    private void update_device_modules(List<Devices_Module> ary_dm){
        for(Devices_Module dm:ary_dm){
            rg.gen_Module_Dev();
            dm.setModuleTemperature(rg.getModule_temp());
            dm.setModuleVoltage(rg.getModule_volt());
            dm.setModuleWatt(rg.getModule_watt());
            dm.setModuleCurrent(rg.getModule_current());
        }
    }
}