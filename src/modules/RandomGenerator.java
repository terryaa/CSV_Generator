package modules;
import java.util.Random;

//Data 객체에 Random한 값이 필요한 필드에 값을 올바르게 넣기 위하여 쓰이는 클래스.
//생성자에 System.Currentmil..  메소드로 유의미한 Random상태를 유지한다.


public class RandomGenerator {
    //General
    private Long TS_seed;
    private Long startTS;
    private Long endTS;
    private String mac;
    //Gateway
    private int gate_sn_seed=0;
    //Strings-> devices
    private int str_devc_volt;
    private float str_devc_cur;
    private int str_devc_temp;
    private int str_devc_totalWh;
    //Strings->devices->modules
    private float module_volt;
    private float module_temp;
    private int module_watt;
    private float module_current;
    private int strings_totalwh;

    public float getModule_current() {
        return this.module_current;
    }

    public void setModule_current(float module_current) {
        this.module_current = module_current;
    }

    public int getStrings_totalwh() {
        return this.strings_totalwh;
    }

    public void setStrings_totalwh(int strings_totalwh) {
        this.strings_totalwh = strings_totalwh;
    }

    public int getModule_watt() {
        return this.module_watt;
    }

    public void setModule_watt(int module_watt) {
        this.module_watt = module_watt;
    }


    private Random rand;
    public RandomGenerator(){
        rand=new Random(System.currentTimeMillis());
    }
    public void gen_Gateway(){
        mac=gen_mac();
        gen_TS();

    }
    public void gen_Inverters(){
        gen_TS();
    }
    public void gen_Strings(){
        gen_TS();
    }
    public void gen_Strings_Devices(){
        str_devc_volt=rand.nextInt(1000);
        str_devc_cur=rand.nextInt(5)+ (float) Math.round(rand.nextFloat()*1000) / (float)1000;
        str_devc_temp=rand.nextInt(50)+20;
        str_devc_totalWh=3840487;
    }
    public void gen_Strings_Devices(int totalWh){
        str_devc_volt=rand.nextInt(1000);
        str_devc_cur=rand.nextInt(5)+ (float) Math.round(rand.nextFloat()*1000) / (float)1000;
        str_devc_temp=rand.nextInt(50)+20;
        str_devc_totalWh=1000+rand.nextInt(1000)+totalWh;
    }
    public void gen_Module(){
        gen_TS();
    }
    public void gen_Module_Dev(){
        module_volt=rand.nextInt(20)+20+(float) Math.round(rand.nextFloat()*10)/(float)10;
        module_temp=rand.nextInt(20)+20+(float) Math.round(rand.nextFloat()*10)/(float)10;
        module_watt=rand.nextInt(100);
        module_current=rand.nextInt(5)+ (float) Math.round(rand.nextFloat()*1000) / (float)1000;
    }
    //mac address를 만들어내기위한 메소드
    public String gen_mac(){
            byte[] macAddr = new byte[6];
            rand.nextBytes(macAddr);
        
            macAddr[0] = (byte)(macAddr[0] & (byte)254);  //zeroing last 2 bytes to make it unicast and locally adminstrated
        
            StringBuilder sb = new StringBuilder(18);
            for(byte b : macAddr){
        
                if(sb.length() > 0)
                    sb.append(":");
        
                sb.append(String.format("%02x", b));
            }
        
        
            return sb.toString();
    }
    public void gen_TS(){
        //시스템 정상작동시 당시 시간을 불러와서 저장
        TS_seed=1580392680000L;
        
        //원래 시스템에서 사용해야할 시간
        //TS_seed=System.currentTimeMillis();
        startTS=TS_seed+rand.nextInt(10000);
        endTS=startTS+rand.nextInt(10000);
    }
    public void gen_TS(Long start){
        TS_seed=start+60000;
        startTS=TS_seed+rand.nextInt(10000);
        endTS=startTS+rand.nextInt(10000);
    }



    public Long getTS_seed() {
        return this.TS_seed;
    }

    public void setTS_seed(Long TS_seed) {
        this.TS_seed = TS_seed;
    }

    public Long getStartTS() {
        return this.startTS;
    }

    public void setStartTS(Long startTS) {
        this.startTS = startTS;
    }

    public Long getEndTS() {
        return this.endTS;
    }

    public void setEndTS(Long endTS) {
        this.endTS = endTS;
    }


    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getGate_sn_seed() {
        return this.gate_sn_seed;
    }

    public void setGate_sn_seed(int gate_sn_seed) {
        this.gate_sn_seed = gate_sn_seed;
    }

    public int getStr_devc_volt() {
        return this.str_devc_volt;
    }

    public void setStr_devc_volt(int str_devc_volt) {
        this.str_devc_volt = str_devc_volt;
    }

    public float getStr_devc_cur() {
        return this.str_devc_cur;
    }

    public void setStr_devc_cur(float str_devc_cur) {
        this.str_devc_cur = str_devc_cur;
    }

    public int getStr_devc_temp() {
        return this.str_devc_temp;
    }

    public void setStr_devc_temp(int str_devc_temp) {
        this.str_devc_temp = str_devc_temp;
    }

    public int getStr_devc_totalWh() {
        return this.str_devc_totalWh;
    }

    public void setStr_devc_totalWh(int str_devc_totalWh) {
        this.str_devc_totalWh = str_devc_totalWh;
    }


    public float getModule_volt() {
        return this.module_volt;
    }

    public void setModule_volt(float module_volt) {
        this.module_volt = module_volt;
    }

    public float getModule_temp() {
        return this.module_temp;
    }

    public void setModule_temp(float module_temp) {
        this.module_temp = module_temp;
    }

    public Random getRand() {
        return this.rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }


}