package 窗口;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Winchoice extends JFrame {
    JButton button1,button2;
    Box box1,box2;
    Box box0;
    JLabel l0;
    Listener1 listener1;
    Winchoice(){
        setLayout(new java.awt.FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init(){
        listener1=new Listener1();
        listener1.setview(this);
        box1 = Box.createHorizontalBox();
        box2 = Box.createHorizontalBox();
        box0 = Box.createVerticalBox();
        Font font=new Font("宋体",Font.PLAIN,20);
        box1.add(l0=new JLabel("请选择用户端"));
        l0.setFont(font);
        box2.add(button1=new JButton("司机端"));
        button1.addActionListener(listener1);
        box2.add(button2=new JButton("客户端"));
        button2.addActionListener(listener1);
        button1.setFont(font);
        button2.setFont(font);
        box0.add(box1);
        box0.add(box2);
        add(box0);
       
    }
    public static void main(String args[]) {
        Winchoice winchoice=new Winchoice();
        winchoice.setBounds(200, 100, 500, 300);
        winchoice.setTitle("代驾业务管理系统登录");
    }
}
class Listener1 implements ActionListener{
    Winchoice view;
    void setview(Winchoice view){
        this.view=view;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("司机端")){
            //view.l0.setText("司机端");
            WinDr winDr=new WinDr();
            winDr.setBounds(200, 100, 500, 300);
            winDr.setTitle("代驾业务管理系统登录");
            view.dispose();
        }
        if(e.getActionCommand().equals("客户端")){
            //view.l0.setText("客户端");
            WinUs winUs=new WinUs();
            winUs.setBounds(200, 100, 500, 300);
            winUs.setTitle("代驾业务管理系统登录");
            view.dispose();
        }
    }
}
