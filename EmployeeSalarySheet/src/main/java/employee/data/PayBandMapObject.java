package  employee.data;
import employee.data.SalaryData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayBandMapObject {

    public static Map<String,int[]> payBandLevelArrayMaping =new HashMap();
    public static Map<String,String> paybandMapWithLevels =new HashMap();
    public static String[] payBandList={"1S-4440-7440-1300","1S-4440-7440-1400","1S-4440-7440-1600","1S-4440-7440-1650","1S-4440-7440-1700","PB-1 5200-20200-1800","PB-1 5200-20200-1900","PB-1 5200-20200-2000","PB-1 5200-20200-2400","PB-1 5200-20200-2500","PB-1 5200-20200-2800",
            "PB-1 5200-20200-2900","PB-1 5200-20200-3000","PB-1 5200-20200-3500","PB-2 9300-34800-4100","PB-2 9300-34800-4200","PB-2 9300-34800-4300","PB-2 9300-34800-4400","PB-2 9300-34800-4500","PB-2 9300-34800-4600","PB-2 9300-34800-4800",
            "PB-2 9300-34800-4900","PB-2 9300-34800-5000","PB-2 9300-34800-5400","PB-3 15600-39100-5000","PB-3 15600-39100-5400","PB-3 15600-39100-5500","PB-3 15600-39100-5700","PB-3 15600-39100-5800","PB-3 15600-39100-6600","PB-3 15600-39100-6900",
            "PB-3 15600-39100-7600","PB-3 15600-39100-7900","PB-4 37400-67000-8700","PB-4 37400-67000-8800","PB-4 37400-67000-8900","PB-4 37400-67000-10000","67000 - 79000"};

    public static Map<String, List> levelList=new HashMap<>();
    static {

        payBandLevelArrayMaping.put("1S-4440-7440-1300", SalaryData.s1);
        payBandLevelArrayMaping.put("1S-4440-7440-1400",SalaryData.s2);
        payBandLevelArrayMaping.put("1S-4440-7440-1600",SalaryData.s3);
        payBandLevelArrayMaping.put("1S-4440-7440-1650",SalaryData.s4);
        payBandLevelArrayMaping.put("1S-4440-7440-1700",SalaryData.s4);
        payBandLevelArrayMaping.put("PB-1 5200-20200-1800",SalaryData.s5);
        payBandLevelArrayMaping.put("PB-1 5200-20200-1900",SalaryData.s6);
        payBandLevelArrayMaping.put("PB-1 5200-20200-2000",SalaryData.s7);
        payBandLevelArrayMaping.put("PB-1 5200-20200-2400",SalaryData.s8);
        payBandLevelArrayMaping.put("PB-1 5200-20200-2500",SalaryData.s9);
        payBandLevelArrayMaping.put("PB-1 5200-20200-2800",SalaryData.s10);
        payBandLevelArrayMaping.put("PB-1 5200-20200-2900",SalaryData.s11);
        payBandLevelArrayMaping.put("PB-1 5200-20200-3000",SalaryData.s11);
        payBandLevelArrayMaping.put("PB-1 5200-20200-3500",SalaryData.s12);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4100",SalaryData.s13);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4200",SalaryData.s13);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4300",SalaryData.s14);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4400",SalaryData.s15);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4500",SalaryData.s16);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4600",SalaryData.s16);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4800",SalaryData.s17);
        payBandLevelArrayMaping.put("PB-2 9300-34800-4900",SalaryData.s18);
        payBandLevelArrayMaping.put("PB-2 9300-34800-5000",SalaryData.s18);
        payBandLevelArrayMaping.put("PB-3 15600-39100-5000",SalaryData.s19);
        payBandLevelArrayMaping.put("PB-2 9300-34800-5400",SalaryData.s20);
        payBandLevelArrayMaping.put("PB-3 15600-39100-5400",SalaryData.s20);
        payBandLevelArrayMaping.put("PB-3 15600-39100-5500",SalaryData.s21);
        payBandLevelArrayMaping.put("PB-3 15600-39100-5700",SalaryData.s22);
        payBandLevelArrayMaping.put("PB-3 15600-39100-5800",SalaryData.s22);
        payBandLevelArrayMaping.put("PB-3 15600-39100-6600",SalaryData.s23);
        payBandLevelArrayMaping.put("PB-3 15600-39100-6900",SalaryData.s24);
        payBandLevelArrayMaping.put("PB-3 15600-39100-7600",SalaryData.s25);
        payBandLevelArrayMaping.put("PB-3 15600-39100-7900",SalaryData.s26);
        payBandLevelArrayMaping.put("PB-3 15600-39100-7900",SalaryData.s26);
        payBandLevelArrayMaping.put("PB-4 37400-67000-8700",SalaryData.s27);
        payBandLevelArrayMaping.put("PB-4 37400-67000-8800",SalaryData.s28);
        payBandLevelArrayMaping.put("PB-4 37400-67000-8900",SalaryData.s29);
        payBandLevelArrayMaping.put("PB-4 37400-67000-10000",SalaryData.s30);
        payBandLevelArrayMaping.put("67000 - 79000",SalaryData.s31);


        paybandMapWithLevels.put("1S-4440-7440-1300","S-1");
        paybandMapWithLevels.put("1S-4440-7440-1400","S-2");
        paybandMapWithLevels.put("1S-4440-7440-1600","S-3");
        paybandMapWithLevels.put("1S-4440-7440-1650","S-4");
        paybandMapWithLevels.put("1S-4440-7440-1700","S-4");
        paybandMapWithLevels.put("PB-1 5200-20200-1800","S-5");
        paybandMapWithLevels.put("PB-1 5200-20200-1900","S-6");
        paybandMapWithLevels.put("PB-1 5200-20200-2000","S-7");
        paybandMapWithLevels.put("PB-1 5200-20200-2400","S-8");
        paybandMapWithLevels.put("PB-1 5200-20200-2500","S-9");
        paybandMapWithLevels.put("PB-1 5200-20200-2800","S-10");
        paybandMapWithLevels.put("PB-1 5200-20200-2900","S-11");
        paybandMapWithLevels.put("PB-1 5200-20200-3000","S-11");
        paybandMapWithLevels.put("PB-1 5200-20200-3500","S-12");
        paybandMapWithLevels.put("PB-2 9300-34800-4100","S-13");
        paybandMapWithLevels.put("PB-2 9300-34800-4200","S-13");
        paybandMapWithLevels.put("PB-2 9300-34800-4300","S-14");
        paybandMapWithLevels.put("PB-2 9300-34800-4400","S-15");
        paybandMapWithLevels.put("PB-2 9300-34800-4500","S-16");
        paybandMapWithLevels.put("PB-2 9300-34800-4600","S-16");
        paybandMapWithLevels.put("PB-2 9300-34800-4800","S-17");
        paybandMapWithLevels.put("PB-2 9300-34800-4900","S-18");
        paybandMapWithLevels.put("PB-2 9300-34800-5000","S-18");
        paybandMapWithLevels.put("PB-3 15600-39100-5000","S-19");
        paybandMapWithLevels.put("PB-2 9300-34800-5400","S-20");
        paybandMapWithLevels.put("PB-3 15600-39100-5400","S-20");
        paybandMapWithLevels.put("PB-3 15600-39100-5500","S-21");
        paybandMapWithLevels.put("PB-3 15600-39100-5700","S-22");
        paybandMapWithLevels.put("PB-3 15600-39100-5800","S-22");
        paybandMapWithLevels.put("PB-3 15600-39100-6600","S-23");
        paybandMapWithLevels.put("PB-3 15600-39100-6900","S-24");
        paybandMapWithLevels.put("PB-3 15600-39100-7600","S-25");
        paybandMapWithLevels.put("PB-3 15600-39100-7900","S-26");
        paybandMapWithLevels.put("PB-4 37400-67000-8700","S-27");
        paybandMapWithLevels.put("PB-4 37400-67000-8800","S-28");
        paybandMapWithLevels.put("PB-4 37400-67000-8900","S-29");
        paybandMapWithLevels.put("PB-4 37400-67000-10000","S-30");
        paybandMapWithLevels.put("67000 - 79000","S-31");

    }


}
