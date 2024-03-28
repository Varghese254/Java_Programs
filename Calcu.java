import java.awt.*;
import java.applet.*;
import java.awt.event.*;
class CalcuDemo extends Applet
implements ActionListener
{
     Button b1,b2,b3,b4;
     Label l1,l2,l3;
     TextField tf1,tf2,tf3;
     int x,y,z;
     public void init()
     {
        l1=new Label("!st no:");
        tf1=new TextField(20);
        l2=new Label("2nd number:");
        tf2=new TextField(20);
        l3=new Label("result");
        tf3=new TextField(20);
        b1=new Button("add");
        b2=new Button("minus");
        b3=new Button("mul");
        b4=new Button("div");
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(l3);
        add(tf3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
     }
     public void ActionPerformed(ActionEvent ae)
     {
        String str=ae.getActionCommand();
        x=Integer.parseInt(tf1.getText());
        y=Integer.parseInt(tf2.getText());
        if(str.equals("add"))
        z=x+y;
        if(str.equals("minus"))
        z=x-y;
        if(str.equals("mul"))
        z=x*y;
        if(str.equals("div"))
        z=x/y;
        tf3.setText(String.valueOf(z));
        repaint();

     } 
}