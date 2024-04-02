import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AppletStarDisplay extends Applet
{

public AppletStarDisplay()
{
}
public void paint(Graphics g)
{
g.drawLine(200,100,150,180);
g.drawLine(150,180,80,150);
g.drawLine(200,100,250,180);
g.drawLine(80,150,140,230);

g.drawLine(250,180,320,150);
g.drawLine(320,150,260,230);
g.drawLine(140,230,100,300);
g.drawLine(260,230,330,290);

g.drawLine(100,300,180,270);
g.drawLine(330,290,240,270);
g.drawLine(240,270,210,340);
g.drawLine(210,340,180,270);

 }
}