import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Devices_Module;

import model.Modules;

import model.Information;

import model.Devices_Strings;

import model.Devices_Gateway;
import model.Strings;
import model.Data;
import modules.DataUpdater;
import modules.Data_Generate;

public class App {


    public static void main(String[] args) throws Exception {
        List<Data> ary_data=gengen();
        DataUpdater du=new DataUpdater();


  
        BufferedWriter bf_wr_gt=null;
        BufferedWriter bf_wr_st=null;
        BufferedWriter bf_wr_md=null;

        Date date1=new Date();
        Date date2=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String gt_query;
        String st_query;
        String md_query;
        String strDate1,strDate2;


        bf_wr_gt=new BufferedWriter(new FileWriter(new File("gateway_log.csv")));
        bf_wr_st=new BufferedWriter(new FileWriter(new File("strings_log.csv")));
        bf_wr_md=new BufferedWriter(new FileWriter(new File("modules_log.csv")));
        bf_wr_gt.append("gt_id,startts,endts,mac_fix,sn_fix,software_version_fix,ioboard_fix");
        bf_wr_gt.newLine();
        bf_wr_st.append("gt_id,st_id,startts,endts,porterror,host_fix,port_fix,name_fix,serialno_fix,fwversion_fix,comparator_fix,devider_fix,rawpulsescounter_fix,error,stringvoltage,stringcurrent,temperature,totalwh");
        bf_wr_st.newLine();
        bf_wr_md.append("md_sn,st_id,gt_id,startts,endts,modulevoltage,moduletemperature,modulewatt,modulecurrent");
        bf_wr_md.newLine();
        Calendar cal=Calendar.getInstance();



        while(ary_data.get(0).getGateway().getDevices().get(0).getEndTs()<1582990020000L){
            du.update(ary_data);

            for( Data dat : ary_data){
                Devices_Gateway gt=dat.getGateway().getDevices().get(0);
                date1=new Date(gt.getStartTs());
                strDate1=format.format(date1);
                date2=new Date(gt.getEndTs());
                strDate2=format.format(date2);
                /*
                gt_query="insert into gateway_log values("+gt.getId()
                +",to_timestamp("+gt.getStartTs()+"/1000),to_timestamp("+gt.getEndTs()+"/1000)"+",'"+gt.getMac()+"','"+gt.getSn()
                +"','"+gt.getSoftware().getVersion()+"','"
                +gt.getIoboard().getFirmware()+"');";
                */
                gt_query=gt.getId()+","+strDate1+","+strDate2+","+gt.getMac()+","+gt.getSn()+","+gt.getSoftware().getVersion()+","
                +gt.getIoboard().getFirmware();
                bf_wr_gt.append(gt_query);
                bf_wr_gt.newLine();

                Strings str=dat.getStrings();

                for (Devices_Strings dvst : str.getDevices()){
                    Information info=dvst.getInfo();
                    /*
                    st_query="insert into strings_log values("+gt.getId()+","+info.getId()+","
                    +"to_timestamp("+str.getStartTS()+"/1000),to_timestamp("+str.getEndTS()+"/1000),"
                    +"'null','127.0.0.1',10002,'1-String-C',"+info.getSerialNo()+",2.33,9,0,7270,"
                    +"'null',"+dvst.getStringVoltage()+","+dvst.getStringCurrent()+","
                    +dvst.getTemperature()+","+dvst.getTotalWh()+");";
                    */
                    date1=new Date(str.getStartTS());
                    strDate1=format.format(date1);
                    date2=new Date(str.getEndTS());
                    strDate2=format.format(date2);
                    st_query=gt.getId()+","+info.getId()+","+strDate1+","+strDate2+","+"null"+","+"127.0.0.1"+","+"10002"+","+"1-String-C"
                    +","+info.getSerialNo()+","+"2.33"+","+"9"+","+"0"+","+"7270"+","+"null"+","+dvst.getStringVoltage()+","+
                    dvst.getStringCurrent()+","+dvst.getTemperature()+","+dvst.getTotalWh();
                    bf_wr_st.append(st_query);
                    bf_wr_st.newLine();
                    Modules md=dvst.getModules();

                    for(Devices_Module dm : md.getDevices()){

                        /*
                        md_query="insert into modules_log values("+dm.getModuleSerial()+","
                        +info.getId()+","+gt.getId()+","+"to_timestamp("+md.getStartTs()+"/1000),"+
                        "to_timestamp("+md.getEndTs()+"/1000),"+dm.getModuleVoltage()+","+dm.getModuleTemperature()
                        +","+dm.getModuleWatt()+","+dm.getModuleCurrent()+");";
                        */

   
                        date1=new Date(md.getStartTs());
                        strDate1=format.format(date1);
                        
                        double temp = Math.exp((Math.pow( (date1.getHours() - 12),2) * -1) / (2 * 6.25));
                        double temp2 = 1 / (2.5 * (Math.sqrt(2*Math.PI))) * 12;
                        double temp3 = temp * temp2;
                        double temp4=dm.getModuleWatt();
                        temp4=temp3*temp4*( 99D/390D);
                        date2=new Date(md.getEndTs());
                        strDate2=format.format(date2);
                        /*
                        md_query=dm.getModuleSerial()+","+info.getId()+","+gt.getId()+","+strDate1+","+strDate2+","+
                        dm.getModuleVoltage()+","+dm.getModuleTemperature()+","+dm.getModuleWatt()+","+dm.getModuleCurrent();
                        bf_wr_md.append(md_query);*/

                        md_query=dm.getModuleSerial()+","+info.getId()+","+gt.getId()+","+strDate1+","+strDate2+","+
                        dm.getModuleVoltage()+","+dm.getModuleTemperature()+","+(int)temp4+","+dm.getModuleCurrent();
                        bf_wr_md.append(md_query);


                        bf_wr_md.newLine();
                    }

                }

                


            }
        }
        bf_wr_gt.flush();
        bf_wr_gt.close();
        bf_wr_st.flush();
        bf_wr_st.close();
        bf_wr_md.flush();
        bf_wr_md.close();
        System.out.println("end");
    }

    public static List<Data> gengen(){
        Data_Generate dg=new Data_Generate();
        return dg.generate_data(3, 5, 30);
    
    }
}

