package modules;

import java.util.List;

import model.Data;


//DataGenerator을 통하여 Data를 만들어낸뒤, Local파일시스템에 데이터를 저장한다.
public class Data_Generate {

    private DataGenerator data_gen;

    //Exception handling이 안되있긴함.
    public List<Data> generate_data(int devices, int strings_devcs,int modules){
        data_gen=new DataGenerator();
        List<Data> ary_data=data_gen.Make_Data(devices, strings_devcs, modules);
        return ary_data;
    }
}