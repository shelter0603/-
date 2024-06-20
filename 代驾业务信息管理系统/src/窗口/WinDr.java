package 窗口;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import 信息类.*;
public class WinDr extends JFrame{
    Box box1,box2,box3,box4,box5,box0;
    Box boxO;
    Listener2 listener2;
    JLabel l1,l2,l3,l4;
    JButton button1,button2,button3,button4,button5,button;
    JTextField ph,na,wo;
    WinDr(){
        setLayout(new FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init(){
        listener2=new Listener2();
        listener2.setview(this);
        Font font=new Font("宋体",Font.PLAIN,20);
        box0 = Box.createHorizontalBox(); 
        box1 = Box.createHorizontalBox();
        box2 = Box.createHorizontalBox();
        box3 = Box.createHorizontalBox();
        box4 = Box.createHorizontalBox();
        box5 = Box.createHorizontalBox();
        boxO = Box.createVerticalBox();
        box0.add(button=new JButton("返回"));
        button.setFont(font);
        button.addActionListener(listener2);
        box1.add(l1=new JLabel("工    号："));
        l1.setFont(font);
        box1.add(ph=new JTextField(15));
        box2.add(l2=new JLabel("姓    名："));
        l2.setFont(font);
        box2.add(na=new JTextField(15));
        box3.add(l3=new JLabel("业务状况："));
        l3.setFont(font);
        box3.add(wo=new JTextField(10));
        box3.add(button5=new JButton("派单"));
        box4.add(button1=new JButton("录入"));
        box4.add(button2=new JButton("修改"));
        box4.add(button3=new JButton("查询"));
        box4.add(button4=new JButton("删除"));
        button1.setFont(font);
        button1.addActionListener(listener2);
        button2.setFont(font);
        button2.addActionListener(listener2);
        button3.setFont(font);
        button3.addActionListener(listener2);
        button4.setFont(font);
        button4.addActionListener(listener2);
        button5.setFont(font);
        button5.addActionListener(listener2);
        box5.add(l4=new JLabel());
        boxO.add(box1);
        boxO.add(box2);
        boxO.add(box3);
        boxO.add(box4);
        boxO.add(box5);
        boxO.add(box0);
        add(boxO);
    }
    public static void main(String args[]) {
        WinDr winDr=new WinDr();
        winDr.setBounds(200, 100, 500, 300);
        winDr.setTitle("代驾业务管理系统登录");
    }
}
class Listener2 implements ActionListener{
    WinDr view;
    File driver=new File("D:\\desktop\\代驾业务信息管理系统\\代驾业务信息管理系统\\src","driver.txt");
    File users=new File("D:\\desktop\\代驾业务信息管理系统\\代驾业务信息管理系统\\src","users.txt");
    void setview(WinDr view){
        this.view=view;
    }
    public void actionPerformed(ActionEvent e) {
       try{
            if(e.getActionCommand().equals("返回")){
                Winchoice winchoice=new Winchoice();
                winchoice.setBounds(100, 100, 500, 300);
                winchoice.setTitle("代驾业务管理系统登录");
                //view.L3.setText("yer~");
                view.dispose();
            }
            if(e.getActionCommand().equals("录入")){
                BufferedWriter writer = new BufferedWriter(new FileWriter(driver,true));
                Driver der=new Driver();
                der.setphone(view.ph.getText()+"\t");
                der.setname(view.na.getText()+"\t");
                der.seton(view.wo.getText()+"\t");
                writer.append(der.getphone());
                writer.append(der.getName());
                writer.append(der.geton());
                writer.newLine();
                writer.close();
                view.l4.setText("录入成功");
            }
            if(e.getActionCommand().equals("修改")){
                BufferedReader reader = new BufferedReader(new FileReader(driver));
                String str=null;
                int i=0,k=0;
                Driver der[]=new Driver[100];
                for(int x=0;x<100;x++){
                    der[x]=new Driver();
                }
                while((str=reader.readLine())!=null){
                    String Der[]=str.split("\t");
                    der[i].setphone(Der[0]);
                    der[i].setname(Der[1]);
                    der[i].seton(Der[2]);
                    if(view.ph.getText().equals(Der[0])){
                        der[i].setphone(Der[0]);
                        der[i].setname(view.na.getText());
                        der[i].seton(view.wo.getText());
                        view.l4.setText("查询找到该司机，修改完成");
                        k=1;
                    }
                    i++;
                }
                if(k==0)view.l4.setText("未找到该司机");
                reader.close();
                //System.out.println(der[0].getName());
                BufferedWriter w = new BufferedWriter(new FileWriter(driver));
                w.write("");
                w.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter(driver,true));
                for(int j=0;j<i;j++){  
                    writer.append(der[j].getphone()+"\t");
                    writer.append(der[j].getName()+"\t");
                    writer.append(der[j].geton()+"\t");
                    writer.newLine();
                }
                writer.close();
            }
            if(e.getActionCommand().equals("查询")){
                BufferedReader reader = new BufferedReader(new FileReader(driver));
                String str=null;
                while((str=reader.readLine())!=null){
                    String[] Der=str.split("\t");
                    if(view.ph.getText().equals(Der[0])){
                        view.na.setText(Der[1]);
                        view.wo.setText(Der[2]);
                        view.l4.setText("查询成功");
                        break;
                    }
                }
                if((str=reader.readLine())==null)view.l4.setText("未找到该司机");
                reader.close();
            }
            if(e.getActionCommand().equals("删除")){
                BufferedReader reader = new BufferedReader(new FileReader(driver));
                String str=null;
                int i=0,k=0;
                Driver der[]=new Driver[100];
                for(int x=0;x<100;x++){
                    der[x]=new Driver();
                }
                while((str=reader.readLine())!=null){
                    String Der[]=str.split("\t");
                    if(view.ph.getText().equals(Der[0])){
                        der[i].setphone(null);
                        der[i].setname(null);
                        der[i].seton(null);
                        view.l4.setText("查询找到该司机，删除完成");
                        k=1;
                    }
                    else{
                        der[i].setphone(Der[0]);
                        der[i].setname(Der[1]);
                        der[i].seton(Der[2]);
                    }
                    i++;
                }
                if(k==0)view.l4.setText("未找到该司机");
                reader.close();
                BufferedWriter w = new BufferedWriter(new FileWriter(driver));
                w.write("");
                w.close();
                BufferedWriter writer = new BufferedWriter(new FileWriter(driver,true));
                for(int j=0;j<i;j++){
                    if(der[j].getphone()==null){
                        j++;
                    }
                    if(der[j]!=null){
                        writer.append(der[j].getphone()+"\t");
                        writer.append(der[j].getName()+"\t");
                        writer.append(der[j].geton()+"\t");
                        writer.newLine();
                    }
                    //System.out.println(der[j].getName());
                }
                writer.close();
            }
            if(e.getActionCommand().equals("派单")){
                BufferedReader reader = new BufferedReader(new FileReader(driver));
                String str=null;
                while((str=reader.readLine())!=null){
                    String[] Der=str.split("\t");
                    if(view.ph.getText().equals(Der[0])){
                        view.na.setText(Der[1]);
                        view.wo.setText(Der[2]);
                        view.l4.setText("查询成功");
                        break;
                    }
                }
                if((str=reader.readLine())==null)view.l4.setText("未找到该司机");
                reader.close();
                if(view.wo.getText().equals("no")){
                    try (//System.out.println("cao");
                    BufferedReader r = new BufferedReader(new FileReader(users))) {
                        String str0=null;
                        int i=0,k=0,a=0;
                        Users der[]=new Users[100];
                        for(int x=0;x<100;x++){
                            der[x]=new Users();
                        }
                        while((str0=r.readLine())!=null){
                            String Der0[]=str0.split("\t");
                            der[i].setphone(Der0[0]);
                            der[i].setname(Der0[1]);
                            der[i].seton(Der0[2]);
                            der[i].setdz(Der0[3]);
                            //System.out.println(der[i].getName());
                            if(der[i].geton().equals("no")){
                                for(;a<1;a++){
                                    view.wo.setText("尾号"+der[i].getphone());
                                    view.l4.setText("尾号"+der[i].getphone()+der[i].getName()+"正在"+der[i].getdz()+"等待，请尽快完成订单");
                                    der[i].seton("工号"+view.ph.getText());
                                    k=1;
                                }
                            }
                            i++;
                        }
                        if(k==0)view.l4.setText("未找到该客户");
                        reader.close();
                        //System.out.println(der[0].getName());
                        BufferedWriter w = new BufferedWriter(new FileWriter(users));
                        w.write("");
                        w.close();
                        BufferedWriter writer = new BufferedWriter(new FileWriter(users,true));
                        for(int j=0;j<i;j++){  
                            writer.append(der[j].getphone()+"\t");
                            writer.append(der[j].getName()+"\t");
                            writer.append(der[j].geton()+"\t");
                            writer.append(der[j].getdz()+"\t");
                            writer.newLine();
                            //System.out.println(der[j].getName());
                        }
                        writer.close();
                    }
                }
                else{
                    view.l4.setText("尾号"+view.wo.getText()+"先生/女士正在等待，请尽快完成订单");
                }
                try (BufferedReader reade = new BufferedReader(new FileReader(driver))) {
                    String str1=null;
                    int i=0,k=0;
                    Driver der[]=new Driver[100];
                    for(int x=0;x<100;x++){
                        der[x]=new Driver();
                    }
                    while((str1=reade.readLine())!=null){
                        String Der1[]=str1.split("\t");
                        der[i].setphone(Der1[0]);
                        der[i].setname(Der1[1]);
                        der[i].seton(Der1[2]);
                        if(view.ph.getText().equals(Der1[0])){
                            der[i].setphone(Der1[0]);
                            der[i].setname(view.na.getText());
                            der[i].seton(view.wo.getText());
                            k=1;
                        }
                        i++;
                    }
                    if(k==0)view.l4.setText("未找到该司机");
                    reader.close();
                    //System.out.println(der[0].getName());
                    BufferedWriter w = new BufferedWriter(new FileWriter(driver));
                    w.write("");
                    w.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(driver,true));
                    for(int j=0;j<i;j++){  
                        writer.append(der[j].getphone()+"\t");
                        writer.append(der[j].getName()+"\t");
                        writer.append(der[j].geton()+"\t");
                        writer.newLine();
                    }
                    writer.close();
                }
            }
        }
        catch(Exception exp){
            view.l4.setText("erro");
        }
    }
    
}