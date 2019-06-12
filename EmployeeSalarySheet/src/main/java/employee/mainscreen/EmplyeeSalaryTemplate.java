package employee.mainscreen;
import javax.swing.*;

import employee.data.PayBandMapObject;
import employee.models.Employee;
import employee.models.SalaryCalculatonDuraton;
import employee.steps.StepButtons;
import employee.styling.UtilForJanIncrement;
import employee.styling.UtilForJulyIncrement;
import employee.utility.ExcelSheetCreator;
import employee.utility.Util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;


public class EmplyeeSalaryTemplate implements ActionListener{

    JLabel Name, Basic,GP,TA,WA,DCPS, HRA6,HRA7,CA_OtherA,NPA,FromDate,ToDate,DOJ,PAY_BAND,NPA7,PROMO,INCRE,RECOVERED_AMOUNT;
    JTextField TName, TBasic,TGP,TDOJD,TDOJY,TSLEVEL,JRECOVERED;
    JComboBox JTA,JCA_OtherA,JWA,JDCPS ,JHRA6,JHRA7,JNPA,FMonth,FYear,TMonth,TYear,JDOJM,JNcrement,JPAY_BAND,JNPA7,JFROMD,JTOD,JPROMO,JINCRE,Normal_Or_Dr;
    JFrame f;
    JButton WithoutIncrement,increment;
    JButton inProgress,done,refresh,BJULYPROM,AUTO_PB;
    JButton steps;
    List<Employee> employeeList =new ArrayList<>();
    int lastGradPay   =0;
    boolean doIncrement = false;
    boolean isBeforejulyIncrement = false;
    boolean suddenncrement = false;
    boolean firstTimeIcre = false;
    int IncrementTime  = 0;
    int firstTimeAdmissible  = 0;
    

    public static final int height=45;
    public static void main(String[] args) {
        new EmplyeeSalaryTemplate();
    	
    }

    
   
    public EmplyeeSalaryTemplate() {

        f=new JFrame("Employee Salary Detail");
        f.setResizable(false);
        Point p =new Point(10,0);
        f.setLocation(p);
        Name= new JLabel("Name : ");
        Name.setBounds(50,50-height, 100,30);
        Basic = new JLabel("Basic : ");
        Basic.setBounds(50, 90-height, 100, 30);
        GP= new JLabel("Grade Pay : ");
        GP.setBounds(50,130-height, 100,30);
        AUTO_PB=new JButton("Auto PB");
        AUTO_PB.setBounds(350,130-height, 100,30);
        AUTO_PB.addActionListener(this);
        PAY_BAND=new JLabel("Pay Band");
        PAY_BAND.setBounds(50,170-height, 100,30);

        TA= new JLabel("T.A : ");
        TA.setBounds(50, 210-height, 100, 30);
        CA_OtherA= new JLabel("C.A./Other A. : ");
        CA_OtherA.setBounds(50,250-height, 100,30);
        f.add(CA_OtherA);
        WA= new JLabel("W.A. : ");
        WA.setBounds(50,290-height, 100,30);

        DCPS= new JLabel("D.C.P.S. : ");
        DCPS.setBounds(50,330-height, 100,30);
        HRA6 = new JLabel("HRA6 : ");
        HRA6.setBounds(50, 370-height, 50, 30);
        HRA7 = new JLabel("HRA7 : ");
        HRA7.setBounds(200, 370-height, 50, 30);

        PROMO = new JLabel("PROMOTION : ");
        PROMO.setBounds(340, 370-height, 80, 30);
        f.add(PROMO);

        NPA = new JLabel("NPA : ");
        NPA.setBounds(50, 410-height, 50, 30);
        NPA7 = new JLabel("NPA7: ");
        NPA7.setBounds(200, 410-height, 50, 30);

        INCRE = new JLabel("INCREMENT: ");
        INCRE.setBounds(340, 410-height, 80, 30);
        f.add(INCRE);

        DOJ = new JLabel("DOJ : ");
        DOJ.setBounds(50, 450-height, 100, 30);
        FromDate= new JLabel("FromDate : ");
        FromDate.setBounds(50,490-height, 100,30);
        ToDate= new JLabel("ToDate : ");
        ToDate.setBounds(50,530-height, 100,30);
        f.add(Name);f.add(Basic);f.add(GP);f.add(TA);f.add(WA);f.add(DCPS);f.add(HRA6);f.add(HRA7);f.add(FromDate);f.add(ToDate);f.add(NPA);f.add(DOJ);f.add(PAY_BAND);f.add(NPA7) ;f.add(AUTO_PB);

        // TEST FIELDS
        TName = new JTextField();
        TName.setBounds(130,50-height, 200,30);
        TBasic = new JTextField();
        TBasic.setBounds(130, 90-height, 200, 30);
        String DCPSLinRupees []={"Jan","July"};
        JNcrement =new JComboBox(DCPSLinRupees);
        JNcrement.setBounds(350, 90-height, 50, 30);
        f.add(JNcrement);

        String list []={"Normal","Doctor"};
        Normal_Or_Dr =new JComboBox(list);
        Normal_Or_Dr.setBounds(410, 90-height, 80, 30);
        f.add(Normal_Or_Dr);

        RECOVERED_AMOUNT=new JLabel("RECOVERY :");
        RECOVERED_AMOUNT.setBounds(340, 450-height, 80, 30);
        f.add(RECOVERED_AMOUNT);

        JRECOVERED = new JTextField("0");
        JRECOVERED.setBounds(430, 450-height, 100, 30);
        f.add(JRECOVERED);

        TGP = new JTextField();
        TGP.setBounds(130,130-height, 200,30);
        
        f.add(TName);f.add(TGP);f.add(TBasic);

        JPAY_BAND=new JComboBox(PayBandMapObject.payBandList);
        JPAY_BAND.setBounds(130, 170-height, 200, 30);
        JPAY_BAND.addActionListener(this);
        f.add(JPAY_BAND);

        TSLEVEL = new JTextField("LEVEL WILL DISPLAY HERE");
        TSLEVEL.setBounds(350,170-height, 200,30);
        Font font = new Font("SansSerif", Font.BOLD,12);
        TSLEVEL.setFont(font);
        f.add(TSLEVEL);

        String taList []={"0","400","600","1000","1200","2000"};
        JTA=new JComboBox(taList);
        JTA.setBounds(130, 210-height, 100, 30);
        f.add(JTA);

        String otherAList []={"0","60","120","130","170","180","220","230","240","270","300","460","630"};
        JCA_OtherA=new JComboBox(otherAList);
        JCA_OtherA.setBounds(130, 250-height, 100, 30);
        f.add(JCA_OtherA);

        String waList []={"0","50","60"};
        JWA =new JComboBox(waList);
        JWA.setBounds(130, 290-height, 100, 30);
        f.add(JWA);

        String yesNoLst []={"No","Yes"};
        JDCPS =new JComboBox(yesNoLst);
        JDCPS.setBounds(130, 330-height, 100, 30);
        f.add(JDCPS);


        String hra6lList []={"0","10","20","30"};
        JHRA6=new JComboBox(hra6lList);
        JHRA6.setBounds(130,370-height, 50,30);
        f.add(JHRA6);

        String hra7lList []={"0","8","16","24","25"};
        JHRA7=new JComboBox(hra7lList);
        JHRA7.setBounds(250,370-height, 70,30);
        f.add(JHRA7);

        String promotionList []={"BEFORE JULY","AFTER JULY"};
        JPROMO=new JComboBox(promotionList);
        JPROMO.setBounds(430,370-height, 110,30);
        JPROMO.addActionListener(this);
        f.add(JPROMO);

        String napList []={"same","0","20","25","30","35"};
        JNPA7=new JComboBox(napList);
        JNPA7.setBounds(250,410-height, 70,30);
        f.add(JNPA7);

        String incrementList []={"DOUBLE","TRIPLE","SIX TIME"};
        JINCRE=new JComboBox(incrementList);
        JINCRE.setBounds(430, 410-height, 110, 30);
        JINCRE.addActionListener(this);
        f.add(JINCRE);


        JNPA =new JComboBox(yesNoLst);
        JNPA.setBounds(130, 410-height, 50, 30);

        f.add(JNPA);

        TDOJD = new JTextField();
        TDOJD.setBounds(130, 450-height, 50, 30);
        f.add(TDOJD) ;
        String monthList []={"01","02","03","04","05","06","07","08","09","10","11","12"};
        JDOJM=new JComboBox(monthList);
        JDOJM.setBounds(190, 450-height, 50, 30);
        f.add(JDOJM);

        String yearList []={"2016","2017","2018","2019","2020"};
        TDOJY = new JTextField();
        TDOJY.setBounds(250, 450-height, 70, 30);
        f.add(TDOJY);

        String dayList []={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JFROMD =new JComboBox(dayList);
        JFROMD.setBounds(130, 490-height, 50, 30);
        f.add(JFROMD);

        FMonth=new JComboBox(monthList);
        FMonth.setBounds(190, 490-height, 50, 30);
        FMonth.addActionListener(this);
        f.add(FMonth);


        FYear = new JComboBox(yearList);
        FYear.setBounds(250, 490-height, 70, 30);
        f.add(FYear);

        JTOD =new JComboBox(dayList);
        JTOD.setBounds(130, 530-height, 50, 30);
        f.add(JTOD);

        TMonth=new JComboBox(monthList);
        TMonth.setBounds(190, 530-height, 50, 30);
        TMonth.addActionListener(this);
        f.add(TMonth);

        TYear = new JComboBox(yearList);
        TYear.setBounds(250, 530-height, 70, 30);
        f.add(TYear);

        inProgress=new JButton("PROGRESS");
        inProgress.setBounds(30, 580-height, 143, 40);
        f.add(inProgress);
        inProgress.addActionListener(this);

        done=new JButton("DONE");
        done.setBounds(207, 580-height, 143, 40);
        f.add(done);
        done.addActionListener(this);

        WithoutIncrement=new JButton("NO-INCREMENT");
        WithoutIncrement.setBounds(382, 580-height, 143, 40);
        f.add(WithoutIncrement);
        WithoutIncrement.addActionListener(this);


        BJULYPROM=new JButton("PROMOTION");
        BJULYPROM.setBounds(30, 640-height, 143, 40);
        BJULYPROM.addActionListener(this);
        f.add(BJULYPROM);

        refresh=new JButton("REFRESH");
        refresh.setBounds(207, 640-height, 143, 40);
        f.add(refresh);

        increment=new JButton("INCREMENT");
        increment.setBounds(382, 640-height, 143, 40);
        f.add(increment);
        increment.addActionListener(this);
        refresh.addActionListener(this);
        
        steps=new JButton("CLICK FOR STEPS");
        steps.setBounds(30, 690-height, 499, 40);
        steps.setFont(new Font("Courier New", Font.ITALIC, 18));
        steps.addActionListener(this);
        f.add(steps);


        f.setSize(580, 800);
        f.setLayout(null);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            creatSheetCaller(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void creatSheetCaller(ActionEvent e) throws Exception {

        if(e.getSource() == WithoutIncrement) {

           noIncrement();

        }else if(e.getSource() == increment)
        {

            List<Employee> list = null;

            if("Jan".equalsIgnoreCase((String) JNcrement.getItemAt(JNcrement.getSelectedIndex())))
            {
                 list = getlistOnBbasisOfJanIncrement();
            }else{
                list = getListOnBasisOfJulyIncrement();
            }

            //DCPS
            String dcps = (String)JDCPS.getItemAt(JDCPS.getSelectedIndex());
            boolean isDSCP =Util.isDSCP(dcps);
            int recoveredAmt=Integer.parseInt((String)JRECOVERED.getText());
            ExcelSheetCreator.createExcelSheetFromDiffValues(list,isDSCP,TName.getText(),recoveredAmt);
            // no global properties get affected by increment
            JRECOVERED.setText("0");
        }
        else if(e.getSource() == inProgress)
        {
            if("Normal".equalsIgnoreCase((String) Normal_Or_Dr.getItemAt(Normal_Or_Dr.getSelectedIndex()))){
                if("Jan".equalsIgnoreCase((String) JNcrement.getItemAt(JNcrement.getSelectedIndex())))
                {
                    employeeList.addAll(getlistOnBbasisOfJanIncrement());
                }else{
                    employeeList.addAll(getListOnBasisOfJulyIncrement());
                }
            }else{
                if("Jan".equalsIgnoreCase((String) JNcrement.getItemAt(JNcrement.getSelectedIndex())))
                {
                    employeeList.addAll(getlistOnBbasisOfJanIncrementForDoctors());
                }else{
                    employeeList.addAll(getListOnBasisOfJulyIncrementForDoctor());
                }
            }



        }else if(e.getSource() == done)
        {
            //DCPS
            String dcps = (String)JDCPS.getItemAt(JDCPS.getSelectedIndex());
            boolean isDSCP =Util.isDSCP(dcps);
            int recoveredAmt=Integer.parseInt((String)JRECOVERED.getText());
            ExcelSheetCreator.createExcelSheetFromDiffValues(employeeList,isDSCP,(String)TName.getText(),recoveredAmt);
            employeeList.clear();
            resetGlobalProperties();
        }else if(e.getSource() == refresh)
        {
            employeeList.clear();
            resetGlobalProperties();
        }else if(e.getSource() == JPAY_BAND)
        {
            setPaybandLevel();
        }else if(e.getSource() == JPROMO)
        {
           doPromotion();
        }else if(e.getSource() == FMonth)
        {
            JFROMD.setSelectedItem("0"+1);
        }
        else if(e.getSource() == TMonth)
        {
            int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));
            int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
            int noOfDaysInMonth=YearMonth.of(toYear,toMonth).lengthOfMonth();
            JTOD.setSelectedItem(""+noOfDaysInMonth);
        }else if(e.getSource() == JINCRE)
        {
            doIncrement();
        }else if(e.getSource() == BJULYPROM)
        {
            if("Jan".equalsIgnoreCase((String) JNcrement.getItemAt(JNcrement.getSelectedIndex())))
            {
                employeeList.addAll(getlistOnBbasisOfIncrementForPromotion());
            }else{
                employeeList.addAll(getListOnBasisOfJulyIncrementAfterPromoton());
            }
        }else if(e.getSource() == steps)
        {
        	new StepButtons();
        }else if(e.getSource() == AUTO_PB)
        {
            setPBDropdownValue();
        }
    }

    private void setPBDropdownValue() {
        String payBand=TGP.getText();

        String payband="";
        int counter=0;
        int counterForDuplicateGp=0;
        for(String key : PayBandMapObject.payBandList){
            counter++;
            String[] payBandSplit= key.split("-");
            if(payBandSplit[payBandSplit.length-1].equals(payBand)){
                payband=key;
                counterForDuplicateGp++;
            }
            if(counter==PayBandMapObject.payBandList.length-1){
                if((67000<=Integer.parseInt(TGP.getText()) && Integer.parseInt(TGP.getText())<=79000)){
                    payband="67000 - 79000";
                }
            }
        }

        String band=payband;
        if(counterForDuplicateGp==1 && (Util.gradePayMap.containsKey(Integer.parseInt(TGP.getText())) || (67000<=Integer.parseInt(TGP.getText()) && Integer.parseInt(TGP.getText())<=79000)))
        {
            if(!(67000<=Integer.parseInt(TGP.getText()) && Integer.parseInt(TGP.getText())<=79000))
            {
                String s_level = PayBandMapObject.paybandMapWithLevels.get(payband);
                String[] payBandSplit= (payband).split("-");
                if(payBandSplit[payBandSplit.length-1].equalsIgnoreCase( TGP.getText()))
                {
                    int level = Util.getLevelFor7thPay(Integer.parseInt(TBasic.getText()), Integer.parseInt(TGP.getText()), payband);
                    TSLEVEL.setText(s_level + " => (" + level + ")");
                    Font font = new Font("SansSerif", Font.BOLD,12);
                    TSLEVEL.setFont(font);
                    TSLEVEL.setBackground(null);
                }else{
                    TSLEVEL.setText("INVALID GP ENTRY");
                    TSLEVEL.setBackground(Color.pink);
                    Font font = new Font("SansSerif", Font.BOLD,12);
                    TSLEVEL.setFont(font);
                }
                JPAY_BAND.setSelectedItem(band);
            } else{
                int level = Util.getLevelFor7thPay(Integer.parseInt(TBasic.getText()), Integer.parseInt(TGP.getText()), "67000 - 79000");
                TSLEVEL.setText("S-31" + " => (" + level + ")");
                TSLEVEL.setBackground(null);
                JPAY_BAND.setSelectedItem(band);
            }

        }else{
            if(counterForDuplicateGp>1){
                TSLEVEL.setText("SELECT  GP  MANUALLY");
                TSLEVEL.setBackground(Color.orange);
                Font font = new Font("SansSerif", Font.BOLD,12);
                TSLEVEL.setFont(font);
            }else{
                TSLEVEL.setText("INVALID  GP  ENTRY");
                TSLEVEL.setBackground(Color.pink);
                Font font = new Font("SansSerif", Font.BOLD,12);
                TSLEVEL.setFont(font);
            }

        }
    }

    private void setTheFilteredList() {
		// TODO Auto-generated method stub
    	
    	String gradePay=TGP.getText();
    	String[] filteredList=new String[PayBandMapObject.payBandList.length-1];
    	int count=0;
    	for(String x:PayBandMapObject.payBandList)
    	{
    		if(x.contains(gradePay))
    		{
    			filteredList[count++]=x;
    				
    		}
    	}
    	JPAY_BAND=new JComboBox(filteredList);
		
	}



	// reset all loball properties
    private void resetGlobalProperties() {
        lastGradPay =0;
        doIncrement =false;
        isBeforejulyIncrement=false;
        firstTimeIcre=false;
        IncrementTime =0;
        JRECOVERED.setText("0");
    }

    private void doPromotion() {
        String selectedIncrement =(String)JPROMO.getItemAt(JPROMO.getSelectedIndex());
        if("BEFORE JULY".equalsIgnoreCase(selectedIncrement))
        {
            int basicAtthisTime=employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
            TBasic.setText(basicAtthisTime+"");
            lastGradPay = employeeList.get(employeeList.size()-1).getDrawnSalary().getGradepay();
            isBeforejulyIncrement = true;
        }else{
            int basicAtthisTime=employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
            int gradePay=employeeList.get(employeeList.size()-1).getDrawnSalary().getGradepay();
            int incrementedBasic=basicAtthisTime+Util.roundOffIncrement((int)(Math.round((basicAtthisTime+gradePay)*3/100.0)));
            TBasic.setText(incrementedBasic+"");
        }
    }


    private List<Employee> getListOnBasisOfJulyIncrementAfterPromoton()
    {
        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJulyIncrement.getListOnBasisOfJulyIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;

        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

           // ADMISSIBLE BASIC PAY
        int lastAdmissibleBasic =0;
        if(firstTimeIcre)
        {
            lastAdmissibleBasic  = firstTimeAdmissible;
        }else{
            lastAdmissibleBasic =employeeList.get(employeeList.size()-1).getAdmissibleSalary().getBasicPay();
        }
        int newAdmissibleBasic =0;

        if(isBeforejulyIncrement || suddenncrement)
        {
            newAdmissibleBasic =Util.doLookupAndGetTheAdmiissibleBasicPay(lastAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()),IncrementTime);

        }   else{
            newAdmissibleBasic =Util.getAdmissibleBasicForPromotion(lastAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), doIncrement) ;
        }
        resetGlobalProperties();
        List<Employee> employees1 = new ArrayList();
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));
                newAdmissibleBasic =Util.getAdmissibleBasicForPromotion(newAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), doIncrement) ;
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            employee.getAdmissibleSalary().setBasicPay(newAdmissibleBasic);
            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }

    private List<Employee> getlistOnBbasisOfIncrementForPromotion() throws Exception {

        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJanIncrement.getListOnBasisOfJanIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;
        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

        // ADMISSIBLE BASIC PAY
        int lastAdmissibleBasic =0;
        if(firstTimeIcre)
        {
            lastAdmissibleBasic  = firstTimeAdmissible;
        }else{
            lastAdmissibleBasic =employeeList.get(employeeList.size()-1).getAdmissibleSalary().getBasicPay();
        }
        int   newAdmissibleBasic =0;
        if(isBeforejulyIncrement  || suddenncrement)
        {
            newAdmissibleBasic =Util.doLookupAndGetTheAdmiissibleBasicPay(lastAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()),IncrementTime);

        }   else{
            newAdmissibleBasic =Util.getAdmissibleBasicForPromotion(lastAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), doIncrement) ;
        }
        resetGlobalProperties();
        List<Employee> employees1 = new ArrayList();
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));
                newAdmissibleBasic =Util.getAdmissibleBasicForPromotion(newAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), doIncrement) ;
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            employee.getAdmissibleSalary().setBasicPay(newAdmissibleBasic);
            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }

    private void noIncrement() throws Exception {

        int basic =0;
        int admissible=0;
        // BASIC FOR ADMISSIBLE, DRAWN  AND DIFFERENCE
        if(employeeList.size()>0)
        {
            basic =employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
            admissible=employeeList.get(employeeList.size()-1).getAdmissibleSalary().getBasicPay();
        } else{
            basic =  Integer.parseInt(TBasic.getText());
        }

        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJanIncrement.getListOnBasisOfJanIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;

        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            if(admissible==0){
                employee.getAdmissibleSalary().setBasicPay(Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex())));
            }else{
                employee.getAdmissibleSalary().setBasicPay(admissible);
            }

            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employeeList.add(employee);
        }


    }

    private List<Employee> getlistOnBbasisOfJanIncrement(){

        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJanIncrement.getListOnBasisOfJanIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;
        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

        List<Employee> employees1 = new ArrayList();
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            employee.getAdmissibleSalary().setBasicPay(Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex())));
            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }


    private List<Employee> getListOnBasisOfJulyIncrement()
    {
        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJulyIncrement.getListOnBasisOfJulyIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;

        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

        List<Employee> employees1 = new ArrayList();
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            employee.getAdmissibleSalary().setBasicPay(Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex())));
            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }

    private List<Employee> getlistOnBbasisOfJanIncrementForDoctors(){

        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJanIncrement.getListOnBasisOfJanIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;
        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

        List<Employee> employees1 = new ArrayList();

        int oldAdmissibleBasic=0;
        boolean isFirstAdmissibleAmt=true;  // for first time we will take the admissible amt on the basis of basic pay
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic); // for other than first or no increment state
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));

                oldAdmissibleBasic =Util.getAdmissibleBasicForPromotion(oldAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), false) ; //false for singel increment indication
                employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic);
                    // new admissible directly setting in oldAdmissibleBasic

            }
            if(isFirstAdmissibleAmt){
                oldAdmissibleBasic=Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic);
                isFirstAdmissibleAmt=false;
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));
            //employee.getAdmissibleSalary().setBasicPay(Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex())));
            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }
    private List<Employee> getListOnBasisOfJulyIncrementForDoctor()
    {
        int joiningYear=Integer.parseInt(TDOJY.getText());
        int JoiningMonth=Integer.parseInt((String) JDOJM.getItemAt(JDOJM.getSelectedIndex()));
        int joningDay=Integer.parseInt(TDOJD.getText());
        int fromDay =Integer.parseInt((String) JFROMD.getItemAt(JFROMD.getSelectedIndex()));
        int fromMonth=Integer.parseInt((String) FMonth.getItemAt(FMonth.getSelectedIndex()));
        int toMonth=  Integer.parseInt((String) TMonth.getItemAt(TMonth.getSelectedIndex()));
        int toDay =Integer.parseInt((String) JTOD.getItemAt(JTOD.getSelectedIndex()));
        int fromYear= Integer.parseInt((String) FYear.getItemAt(FYear.getSelectedIndex())) ;
        int toYear=  Integer.parseInt((String) TYear.getItemAt(TYear.getSelectedIndex()));

        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = UtilForJulyIncrement.getListOnBasisOfJulyIncrementYeary(joningDay, JoiningMonth, joiningYear, fromDay, fromMonth, fromYear, toDay, toMonth, toYear) ;

        int basic =Integer.parseInt(TBasic.getText());
        int gradePay =Integer.parseInt(TGP.getText());

        List<Employee> employees1 = new ArrayList();

        int oldAdmissibleBasic=0;
        boolean isFirstAdmissibleAmt=true;  // for first time we will take the admissible amt on the basis of basic pay
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            Employee employee = new Employee();
            employee.setInComplete(salaryCalculatonDuraton.isInComplete());
            employee.setStartMonthNotCompelete(salaryCalculatonDuraton.isStartMonthNotCompelete());
            employee.setEndMonthNotCompelete(salaryCalculatonDuraton.isEndMonthNotCompelete());
            employee.setFromDay(salaryCalculatonDuraton.getFromDay());
            employee.setFromMonth(salaryCalculatonDuraton.getFromMonth());
            employee.setFromYear(salaryCalculatonDuraton.getFromYear());
            employee.setToDay(salaryCalculatonDuraton.getToDay());
            employee.setToMonth(salaryCalculatonDuraton.getToMonth());
            employee.setToYear(salaryCalculatonDuraton.getToYear());
            employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic);
            if(salaryCalculatonDuraton.isIncrement())
            {
                basic  = basic+Util.roundOffIncrement((int)(Math.round((basic+gradePay)*3/100.0)));

                oldAdmissibleBasic =Util.getAdmissibleBasicForPromotion(oldAdmissibleBasic,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()), false) ; //false for singel increment indication
                employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic);
                    // new admissible directly setting in oldAdmissibleBasic
            }

            if(isFirstAdmissibleAmt){
                oldAdmissibleBasic=Util.getAdmissibleBasicPay(basic,Integer.parseInt(TGP.getText()),(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                employee.getAdmissibleSalary().setBasicPay(oldAdmissibleBasic);
                isFirstAdmissibleAmt=false;
            }
            employee.getDrawnSalary().setBasicPay(basic);
            employee.getDrawnSalary().setGradepay(Integer.parseInt(TGP.getText()));

            employee.getAdmissibleSalary().setGradepay(0);
            employee.getDiff().setBasicPay(employee.getAdmissibleSalary().getBasicPay()- (employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay()));
            employee.getDiff().setGradepay(employee.getAdmissibleSalary().getGradepay()-employee.getDrawnSalary().getGradepay());

            // TRAVEL ALLOWANCES
            employee.getAdmissibleSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDrawnSalary().setTa(Integer.parseInt((String)JTA.getItemAt(JTA.getSelectedIndex())));
            employee.getDiff().setTa(0);

            //OTHER ALLOWANCES
            employee.getAdmissibleSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDrawnSalary().setCaAndOtherA(Integer.parseInt((String) JCA_OtherA.getItemAt(JCA_OtherA.getSelectedIndex())));
            employee.getDiff().setCaAndOtherA(0);

            // WASHING ALLOWANCES
            employee.getAdmissibleSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDrawnSalary().setWa(Integer.parseInt((String)JWA.getItemAt(JWA.getSelectedIndex())));
            employee.getDiff().setWa(0);


            //HRA
            employee.getAdmissibleSalary().setHra(Util.getHRA7(Integer.parseInt((String)JHRA7.getItemAt(JHRA7.getSelectedIndex())),employee.getAdmissibleSalary().getBasicPay()));
            employee.getDrawnSalary().setHra(Util.getHRA(Integer.parseInt((String)JHRA6.getItemAt(JHRA6.getSelectedIndex())),(employee.getDrawnSalary().getBasicPay()+employee.getDrawnSalary().getGradepay())));
            employee.getDiff().setHra(employee.getAdmissibleSalary().getHra()-employee.getDrawnSalary().getHra());

            //NPA
            int[] npa  =Util.calculateNPA((String)JNPA.getItemAt(JNPA.getSelectedIndex()),basic,Integer.parseInt(TGP.getText()),employee.getAdmissibleSalary().getBasicPay(),(String)JNPA7.getItemAt(JNPA7.getSelectedIndex()));
            employee.getAdmissibleSalary().setNpa(npa[1]);
            employee.getDrawnSalary().setNpa(npa[0]);
            employee.getDiff().setNpa(npa[1]-npa[0]);
            employees1.add(employee);
        }
        return employees1;

    }

    public void setPaybandLevel()
    {
        try{
            if(Util.gradePayMap.containsKey(Integer.parseInt(TGP.getText())) || (67000<=Integer.parseInt(TGP.getText()) && Integer.parseInt(TGP.getText())<=79000))
            {
                if(!(67000<=Integer.parseInt(TGP.getText()) && Integer.parseInt(TGP.getText())<=79000))
                {
                    String s_level = PayBandMapObject.paybandMapWithLevels.get((String) JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                    String[] payBandSplit= ((String) JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex())).split("-");
                    if(payBandSplit[payBandSplit.length-1].equalsIgnoreCase((String) TGP.getText()))
                    {
                        int level = Util.getLevelFor7thPay(Integer.parseInt(TBasic.getText()), Integer.parseInt(TGP.getText()), (String) JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                        TSLEVEL.setText(s_level + " => (" + level + ")");
                        Font font = new Font("SansSerif", Font.BOLD,12);
                        TSLEVEL.setFont(font);
                        TSLEVEL.setBackground(null);
                    }else{
                        TSLEVEL.setText("INVALID GP ENTRY");
                        TSLEVEL.setBackground(Color.pink);
                        Font font = new Font("SansSerif", Font.BOLD,12);
                        TSLEVEL.setFont(font);
                    }

                } else{
                    int level = Util.getLevelFor7thPay(Integer.parseInt(TBasic.getText()), Integer.parseInt(TGP.getText()), (String) JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                    TSLEVEL.setText("S-31" + " => (" + level + ")");
                    TSLEVEL.setBackground(null);
                }
            }else{
                TSLEVEL.setText("INVALID GP ENTRY");
                TSLEVEL.setBackground(Color.pink);
                Font font = new Font("SansSerif", Font.BOLD,12);
                TSLEVEL.setFont(font);
            }
        }catch (Exception ex)
        {
            TSLEVEL.setBackground(Color.red);
            TSLEVEL.setText("Basic Pay or GP is missing");
            TSLEVEL.setBackground(Color.pink);
            Font font = new Font("SansSerif", Font.BOLD,12);
            TSLEVEL.setFont(font);
        }
    }

    private void doIncrement() {

        String selectedIncrement =(String)JINCRE.getItemAt(JINCRE.getSelectedIndex());

        int currentGradePay=Integer.parseInt(TGP.getText());

        int incrementedBasic=0;

        if("Double".equalsIgnoreCase(selectedIncrement))
        {
            int basicAtthisTime=employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
            incrementedBasic= basicAtthisTime+Util.roundOffIncrement((int)(Math.round((basicAtthisTime+lastGradPay)*3/100.0)));
            incrementedBasic = incrementedBasic+Util.roundOffIncrement((int)(Math.round((incrementedBasic+currentGradePay)*3/100.0)));
            doIncrement =true;
            IncrementTime=2;      // double increment
        }else if("Triple".equalsIgnoreCase(selectedIncrement))
        {
            IncrementTime=3;      // triple increment

            int basicAtthisTime=0;
            if(employeeList.size()>0)
            {
                suddenncrement  =true;
                basicAtthisTime=employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
                incrementedBasic =  basicAtthisTime+ Util.roundOffIncrement((int)(Math.round((basicAtthisTime+currentGradePay)*3/100.0)*3));
            } else{ // Integer.parseInt(TBasic.getText())
                basicAtthisTime=Integer.parseInt(TBasic.getText());
                firstTimeAdmissible= Util.getAdmissibleBasicPay(basicAtthisTime,currentGradePay,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                firstTimeIcre  =true;
                incrementedBasic =  basicAtthisTime+ Util.roundOffIncrement((int)(Math.round((basicAtthisTime+currentGradePay)*3/100.0)*3));
            }

        } else if("Six Time".equalsIgnoreCase(selectedIncrement))
        {
            IncrementTime=6;     // sx time increment
            int basicAtthisTime=0;
            if(employeeList.size()>0)
            {

                suddenncrement  =true;
                basicAtthisTime=employeeList.get(employeeList.size()-1).getDrawnSalary().getBasicPay();
                incrementedBasic =  basicAtthisTime+ Util.roundOffIncrement((int)(Math.round((basicAtthisTime+currentGradePay)*3/100.0)*6));
            } else{ // Integer.parseInt(TBasic.getText())
                basicAtthisTime=Integer.parseInt(TBasic.getText());
                firstTimeAdmissible= Util.getAdmissibleBasicPay(basicAtthisTime,currentGradePay,(String)JPAY_BAND.getItemAt(JPAY_BAND.getSelectedIndex()));
                firstTimeIcre  =true;
                incrementedBasic =  basicAtthisTime+ Util.roundOffIncrement((int)(Math.round((basicAtthisTime+currentGradePay)*3/100.0)*6));
            }
        }

        TBasic.setText(incrementedBasic+"");
        setPaybandLevel();
        lastGradPay=0;
    }



	

}
