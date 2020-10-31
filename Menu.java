
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Menu extends JFrame implements MouseListener , MouseMotionListener {

	  private Image image;
	  private Select s;
	  private Practice p;
	  private JFrame Selectframe;
	  private JFrame Practiceframe;
	  private JFrame Optionsframe;
	  private Control o;
	  private AudioClip bgm;
	  private File soundFile;
	
	  public Menu(Image i){
		  		super("King of Fighters");
				addMouseListener(this);
				addMouseMotionListener(this);
				image = i;  
				initialBgm("bin/bgm/menubgm.wav");
				
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
		  Graphics2D g2 = (Graphics2D) g;
		  
		  g.drawImage(image,0,0,getWidth(),getHeight(),null);
		  g2.setColor(Color.BLACK);
		  g2.setStroke(new BasicStroke(4));
		  g2.drawRect(550, 200, 150 , 50);
		  g2.drawRect(550, 300, 150 , 50);
		  g2.drawRect(550, 400, 150 , 50);
		  g2.drawRect(550, 500, 150 , 50);
		  g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
		  g.setColor(Color.BLACK);
		  g.drawString("Start Game",560,228);
		  g.drawString("Practice ",580,328);
		  g.drawString("Options",580,428);
		  g.drawString("Exit",580,528);
		  
		  g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 100));
		  g.setColor(Color.RED);
		  g.drawString("King of Figthers",50,120);
		 
	  }
	  
	  
	 public void mousePressed(MouseEvent e){	
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=200 && e.getY()<=250 )  ){
	    	 
	    	 
			 Selectframe = new JFrame("King of Fighters");
	    	 s = new Select(Selectframe);
	    	 Selectframe.add(s);
	    	 Selectframe.setExtendedState(Selectframe.getExtendedState() | Frame.MAXIMIZED_BOTH);
	    	 Selectframe.setVisible(true);
	    	 Selectframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	 bgm.stop();
	         this.dispose();
	    	
	     }
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=300 && e.getY()<=350 )){
	    		
			    Practiceframe = new JFrame("King of Fighters");
				p = new Practice(Practiceframe);
				Practiceframe.add(p);
				Practiceframe.setExtendedState(Practiceframe.getExtendedState() | Frame.MAXIMIZED_BOTH);
				Practiceframe.setVisible(true);
				Practiceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bgm.stop();
				this.dispose();
			 
			 
			 
	     }
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=400 && e.getY()<=450 )){
	    		
			
			    Optionsframe = new JFrame("King of Fighters");
				o = new Control(Optionsframe);
				Optionsframe.add(o);
				Optionsframe.setExtendedState(Optionsframe.getExtendedState() | Frame.MAXIMIZED_BOTH);
				Optionsframe.setVisible(true);
				Optionsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bgm.stop();
				this.dispose();
	     }
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=500 && e.getY()<=550 )){
			 
			 System.exit(0);
		 }
		 
	 }
		
	 public void mouseReleased(MouseEvent event){

	 }
     
	 
	 public void mouseClicked(MouseEvent e){

	 }
	    
	 
	 public void mouseEntered(MouseEvent e){
       
	 }
	    
	 public void mouseExited(MouseEvent e){

	 }
	 
	 
	 public void mouseDragged(MouseEvent e){	 
		 
	 }
	 public void mouseMoved(MouseEvent e){
		 
		 Graphics g = getGraphics();
		 Graphics2D g2 = (Graphics2D) g;

		 
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=200 && e.getY()<=250 )  ){
			  
			  g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			  g.setColor(Color.YELLOW);
			  g.drawString("Start Game",560,228);
			  g2.setStroke(new BasicStroke(4));
			  g2.drawRect(550, 200, 150 , 50);
			 
		 }
		 else{
			  g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			  g.setColor(Color.BLACK);
			  g.drawString("Start Game",560,228);
			  g2.setStroke(new BasicStroke(4));
			  g2.drawRect(550, 200, 150 , 50);
		 }
		 
		 
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=300 && e.getY()<=350 )){
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.YELLOW);	
			 g.drawString("Practice",580,328);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 300, 150 , 50);
			  
	     }
		 else{
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.BLACK);	
			 g.drawString("Practice",580,328);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 300, 150 , 50);
		 }
		 
		 
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=400 && e.getY()<=450 )){
	    		
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.YELLOW);	
			 g.drawString("Options",580,428);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 400, 150 , 50);
			 
	     }
		 else{
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.BLACK);	
			 g.drawString("Options",580,428);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 400, 150 , 50);
		 }
		 
		 
		 
		 if( (e.getX()>=550 && e.getX()<=700 )&&(e.getY()>=500 && e.getY()<=550 )){
	    		
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.YELLOW);	
			 g.drawString("Exit",580,528);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 500, 150 , 50);
			 
	     }
		 else{
			 g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
			 g.setColor(Color.BLACK);	
			 g.drawString("Exit",580,528);
			 g2.setStroke(new BasicStroke(4));
			 g2.drawRect(550, 500, 150 , 50);
		 }
		 
	 }

}
