import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Control extends JPanel implements MouseListener , MouseMotionListener{

	private JFrame frame;
	private Image image;
	private Menu m;
	private Image i=new ImageIcon("bin/image/menu.jpg").getImage();
	private JFrame Optionsframe;
	private AudioClip bgm;
	private File soundFile;
	
	public Control(JFrame f){
	
		Optionsframe = f;
		image = new ImageIcon("bin/image/options.jpg").getImage();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		initialBgm("bin/bgm/optionsbgm.wav");
	}
	
	public void initialBgm(String filename){
		try
		{
			soundFile = new File(filename);
			URL currentDirURL = soundFile.toURL();
			bgm = Applet.newAudioClip(currentDirURL);
			bgm.loop();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
		g.setColor(Color.RED);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 100));
		g.drawString("Button Control",200,120);
		g.drawRect(1100, 600, 200 , 50);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
		g.drawString("Back to Menu",1120,630);
		g.setColor(Color.WHITE);
		g.drawRect(200, 180, 800,500);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 40));
		g.drawString("right : Move to right",220,220);
		g.drawString("left : Move to left",220,260);
		g.drawString("down : Defense",220,300);
		g.drawString("N : Light Attack",220,340);
		g.drawString("M : Light Attack2",220,380);
		g.drawString("H : Critical Attack",220,420);
		g.drawString("J : Dash Attack",220,460);
		g.drawString("K : Critical Attack2",220,500);
	}
	
	public void mousePressed(MouseEvent e){
	
		if( (e.getX()>=1100 && e.getX()<=1300 )&&(e.getY()>=600 && e.getY()<=650 )  ){
			  bgm.stop();
			  Optionsframe.dispose();
			  m  = new Menu(i);
			  m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      m.setExtendedState(m.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      m.setVisible(true);
		}
	}
		
	public void mouseReleased(MouseEvent event){
	}
	public void mouseClicked(MouseEvent e){
	}
	public void mouseEntered(MouseEvent event){
	}
	public void mouseExited(MouseEvent event){            
	}
	public void mouseDragged(MouseEvent e){	 		 
	}
	 
		public void mouseMoved(MouseEvent e){
		
			Graphics g = getGraphics();
			
			if( (e.getX()>=1100 && e.getX()<=1300 )&&(e.getY()>=600 && e.getY()<=650 )  ){
			
			    g.setColor(Color.YELLOW); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Menu",1120,630);	
				g.drawRect(1100, 600, 200 , 50);	
		    }
		    else{
		   
			    g.setColor(Color.RED); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Menu",1120,630);	
				g.drawRect(1100, 600, 200 , 50);
		    }
		}
}		