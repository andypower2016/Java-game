

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyEvent;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Map extends JPanel implements MouseListener , MouseMotionListener{
	
	private Select s;
	private Game g;
	private JFrame Mapframe;
	private JFrame Selectframe;
	private JFrame gf;
	private Image image[];
	private int x;
	private Random rand;
	private int mplayer2;
	
	private AudioClip bgm;
	private File soundFile;
	
	public Map(int mplayer, JFrame f){
	
		Mapframe = f;
		mplayer2 = mplayer;
		image = new Image[4];
		image[0] = new ImageIcon("bin/image/bgjpg.jpg").getImage();
		image[1] = new ImageIcon("bin/image/bg2jpg.jpg").getImage();
		image[2] = new ImageIcon("bin/image/bg3jpg.jpg").getImage();
		image[3] = new ImageIcon("bin/image/map.png").getImage();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		initialBgm("bin/bgm/selectbgm.wav");
	}
	
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.drawImage(image[3],0,0,getWidth(),getHeight(),null);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 100));
		g.setColor(Color.RED);
		g.drawString("Map Select",350,120);
		g.drawImage(image[0],100,300,300,300,null);
		g.drawImage(image[1],500,300,300,300,null);
		g.drawImage(image[2],900,300,300,300,null);
		g.drawRect(1000, 200, 200 , 50);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
		g.drawString("Back to Select",1020,230);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
	    g2.setColor(Color.RED); 
		g2.drawRect(100,300,300,300);
		g2.drawRect(500,300,300,300);
		g2.drawRect(900,300,300,300);
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
	
	public void mousePressed(MouseEvent e){	
		 
		 if( (e.getX()>=1000 && e.getX()<=1200 )&&(e.getY()>=200 && e.getY()<=250 )  ){     // Back to Select
			 
			  Mapframe.dispose();
			  bgm.stop();
			  Selectframe = new JFrame("King of Fighters");
			  s = new Select(Selectframe);
	    	  Selectframe.add(s);
			  Selectframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      Selectframe.setExtendedState(Selectframe.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      Selectframe.setVisible(true);

			 
		 }
		 
		 // Map Select
		 
		 if( (e.getX()>=100 && e.getX()<=400 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  gf = new JFrame("King of Fighters"); 
			  g = new Game(mplayer2,x,1,gf);
			
			  gf.add(g);
			  gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
			  gf.setVisible(true);
		      bgm.stop();
		      Mapframe.dispose();
		      
			 
		 }
		  
		   
		 if( (e.getX()>=500 && e.getX()<=800 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			  
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  gf = new JFrame("King of Fighters");
			  g=new Game(mplayer2,x,2,gf);  
			   
			  gf.add(g);
			  gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
			  gf.setVisible(true);
		      bgm.stop();
		      Mapframe.dispose();
		      
			 
		 }
		  
		
		 if( (e.getX()>=900 && e.getX()<=1200 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			  
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  gf = new JFrame("King of Fighters");			 
		      g=new Game(mplayer2,x,3,gf);  
			   
		      gf.add(g);
		      gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      gf.setVisible(true);
		      bgm.stop();
		      Mapframe.dispose();
		      

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
		   Graphics2D g2 = (Graphics2D) g;
		   
		   
		   if( (e.getX()>=1000 && e.getX()<=1200 )&&(e.getY()>=200 && e.getY()<=250 )  ){
			    g.setColor(Color.YELLOW); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Select",1020,230);	
				g.drawRect(1000, 200, 200 , 50);
	
		   }
		   else{
			    g.setColor(Color.RED); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Select",1020,230);	
				g.drawRect(1000, 200, 200 , 50);

		   }
		   
		
		   // Map
		   //01
		   if( (e.getX()>=100 && e.getX()<=400 )&&(e.getY()>=300 && e.getY()<=600 ) ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(100,300,300,300);
				
				
		   
			}
		   else {
			    
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(100,300,300,300);
				
		   }
		   
	
		   
		   //02
		   if( (e.getX()>=500 && e.getX()<=800 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(500,300,300,300);
				
				
		   }
		   else {
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(500,300,300,300);
				
		   }
		   
		   
		   //03
		   if( (e.getX()>=900 && e.getX()<=1200 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(900,300,300,300);
				
				
				
		   }
		   else {
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(900,300,300,300);
				
		   }
		   
		 
		 
	 }
}