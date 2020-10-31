
import java.awt.*;
import javax.swing.*;

public class Inf01 extends JPanel{

	Image image;
	
	public Inf01(int x){
		
		image = new ImageIcon("bin/image/inf0"+x+".jpg").getImage();
	}
	
	
	public void paintComponent(Graphics g){
		
		g.drawImage(image,0,0,getWidth(),getHeight(),null);

	}

}
