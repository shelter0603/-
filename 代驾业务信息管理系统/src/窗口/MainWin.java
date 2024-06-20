package 窗口;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWin extends JFrame{
    Box box1, box2, box3, box4, box5; // 行式盒
    Listener0 listener0;
    Box boxVOne; // 列式盒
    JTextField ID,m;
    JLabel T0,L1,L2,L3;
    JButton button0;
    MainWin(){
        setLayout(new java.awt.FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init(){
        listener0=new Listener0();
        listener0.setview(this);
        Font font=new Font("宋体",Font.PLAIN,20);
        Font font0=new Font("宋体",Font.PLAIN,25);
        box4 = Box.createHorizontalBox();
        box1 = Box.createHorizontalBox();
        box2 = Box.createHorizontalBox();
        box3 = Box.createHorizontalBox();
        box5 = Box.createHorizontalBox();
        boxVOne = Box.createVerticalBox();
        box1.add(T0=new JLabel("管理员登录"));
        T0.setFont(font0);
        box2.add(L1=new JLabel("用户名："));
        L1.setFont(font);
        box2.add(ID=new JTextField(15));
        box3.add(L2=new JLabel("密  码："));
        L2.setFont(font);
        box3.add(m=new JTextField(15));
        box4.add(button0=new JButton("登录"));
        button0.addActionListener(listener0);
        button0.setFont(font);
        box5.add(L3=new JLabel());
        L3.setFont(font);
        boxVOne.add(box1);
        boxVOne.add(box2);
        boxVOne.add(box3);
        boxVOne.add(box4);
        boxVOne.add(box5);
        add(boxVOne);
    }
    public static void main(String args[]) {
        MainWin win = new MainWin();
        win.setBounds(100, 100, 500, 300);
        win.setTitle("代驾业务管理系统登录");
    }
}
class Listener0 implements ActionListener{
    MainWin view;
    public void setview(MainWin view){
        this.view=view;
    }
    public void actionPerformed(ActionEvent e) {
        String y="202331232052";
        String m="lwp0603";
        try{
            if(view.ID.getText().equals(y)&&view.m.getText().equals(m)){
                Winchoice winchoice=new Winchoice();
                winchoice.setBounds(100, 100, 500, 300);
                winchoice.setTitle("代驾业务管理系统登录");
                //view.L3.setText("yer~");
                view.dispose();
            }
            else{
                view.L3.setText("用户名或密码错误");
            }
        }
        catch(Exception exp){
            view.L3.setText("erro");
        }
        
    }
}