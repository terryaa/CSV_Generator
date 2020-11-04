package modules;

import model.Ioboard;
import model.Modules;
import model.Strings;
import model.Version_Software;


import java.util.ArrayList;
import java.util.List;

import model.Data;
import model.Devices_Gateway;
import model.Devices_Module;
import model.Devices_Strings;
import model.Gateway;
import model.Information;
import model.Inverter;


//Test에 사용될 Data객체를 생성하는 Generator.
public class DataGenerator {

    public RandomGenerator rg;

    //숫자가 순차적으로 올라가는 데이터들은 DataGenerator에서 관리한다.
    private int gate_id=0;
    private int gate_sn=0;

    private int str_devc_id=0;
    private int str_devc_sn=1111;

    private int module_sn=0;
    
    
    public DataGenerator(){
        rg=new RandomGenerator();
    }

    //데이터 한개 만들어보기
    public Data Make_Data(){
        return new Data(Make_Gateway(),Make_Inverter(),Make_Strings(2,3));
    }

    //몇개의 장치(data개수)인지, 장치의 string의 device개수는 몇개인지, string->device의 module은 몇개인지
    //입력받아 해당 개수만큼 Data를 만들어낸뒤 리스트로 리턴한다.
    public List<Data> Make_Data(int devices,int strings_devcs,int modules){
        List<Data> ary_data=new ArrayList<>();
        for(int i=0;i<devices;i++){
            ary_data.add(new Data(Make_Gateway(),Make_Inverter(),Make_Strings(strings_devcs,modules)));
        }
        return ary_data;
    }

    //데이터 1개를 String형태로 확인하기

    private Gateway Make_Gateway(){
        Version_Software vs=new Version_Software();
        //vs.setVersion("1.0.0");
        Ioboard io=new Ioboard();
        //io.setFirmware("3");
        Devices_Gateway dg=new Devices_Gateway();
        rg.gen_Gateway();
        dg.setStartTs(rg.getStartTS());
        dg.setEndTs(rg.getEndTS());
        dg.setMac(rg.getMac());
        dg.setId(Integer.toString(++gate_id));
        dg.setSn("7.2."+String.format("%06d",(++gate_sn)));
        dg.setSoftware(vs);
        dg.setIoboard(io);
        Gateway gw=new Gateway();
        ArrayList<Devices_Gateway> ary_dg=new ArrayList<>();
        ary_dg.add(dg);
        gw.setDevices(ary_dg);
        return gw;
    }


    private Inverter Make_Inverter(){
        Inverter iv=new Inverter();
        rg.gen_Inverters();
        iv.setStartTS(rg.getStartTS());
        iv.setEndTS(rg.getEndTS());
        iv.setError("null");
        iv.setDevices(new ArrayList<>());
        return iv;
    }

    private Strings Make_Strings(int strings_devcs,int modules){
        Strings strs=new Strings();
        rg.gen_Strings();
        strs.setStartTS(rg.getStartTS());
        strs.setEndTS(rg.getEndTS());
        strs.setDevices(Make_Strings_Devices(strings_devcs,modules));
        return strs;
    }
    private List<Devices_Strings> Make_Strings_Devices(int strings_devcs,int modules){
        Devices_Strings ds;
        ArrayList<Devices_Strings> ary_ds=new ArrayList<>();
        for(int i=0;i<strings_devcs;i++){
            rg.gen_Strings_Devices();
            ds=new Devices_Strings();
            ds.setInfo(Make_Information());
            ds.setError("null");
            ds.setStringVoltage(rg.getStr_devc_volt());
            ds.setStringCurrent(rg.getStr_devc_cur());
            ds.setTemperature(rg.getStr_devc_temp());
            ds.setTotalWh(rg.getStr_devc_totalWh());
            ds.setModules(Make_Modules(modules));
            ary_ds.add(ds);
        }
        return ary_ds;
    }
    

    private Information Make_Information(){
        Information info =new Information();
        info.setPortError("null");
        info.setHost("127.0.0.1");
        info.setPort(10002);
        info.setId(++str_devc_id);
        info.setName("1-String-C");
        info.setSerialNo(++str_devc_sn);
        info.setFwVersion(2.33);
        info.setComparator(9);
        info.setDivider(0);
        info.setRawPulsesCounter(7270);
        return info;
    }

    private Modules Make_Modules(int modules){
        Modules modl=new Modules();
        rg.gen_Module();
        modl.setStartTs(rg.getStartTS());
        modl.setEndTs(rg.getEndTS());
        ArrayList<Devices_Module> ary_dm=new ArrayList<>();
        for(int i=0;i<modules;i++){
            rg.gen_Module_Dev();
            ary_dm.add(new Devices_Module(Integer.toString(20000000+(++module_sn)), rg.getModule_volt(),
            rg.getModule_temp(),rg.getModule_watt(),rg.getModule_current()));
        }
        modl.setDevices(ary_dm);
        return modl;
    }
}