
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Practice extends JPanel implements MouseListener , MouseMotionListener {
	private Menu m;
	private GamePractice g;
	private JFrame Selectframe;
	private Image image[];
	private Image i;
	private int x;
	private int y;
	private Inf01 inf01,inf02,inf03;
	private int op1=0,op2=0,op3=0;
	private JFrame f1,f2,f3,gf;
	private Random rand;
	
	private AudioClip bgm;
	private File soundFile;
	
	public Practice(JFrame f){
       
		Selectframe = f;
		i=new ImageIcon("bin/image/menu.jpg").getImage();
		image = new Image[4];
		image[0] = new ImageIcon("bin/image/3.jpg").getImage();
		image[1] = new ImageIcon("bin/image/1.jpg").getImage();
		image[2] = new ImageIcon("bin/image/2.jpg").getImage();
		image[3] = new ImageIcon("bin/image/select.jpg").getImage();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		initialBgm("bin/bgm/selectbgm.wav");
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
	
	public void paintComponent(Graphics g){
		
        super.paintComponent(g);
		g.drawImage(image[3],0,0,getWidth(),getHeight(),null);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 100));
		g.setColor(Color.RED);
		g.drawString("Character Select",350,120);
		g.drawImage(image[0],100,300,300,300,null);
		g.drawImage(image[1],500,300,300,300,null);
		g.drawImage(image[2],900,300,300,300,null);
		g.drawRect(1000, 200, 200 , 50);
		g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
		g.drawString("Back to Menu",1020,230);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
	    g2.setColor(Color.RED); 
		g2.drawRect(100,300,300,300);
		g2.drawRect(500,300,300,300);
		g2.drawRect(900,300,300,300);
		
	}

	 public void mousePressed(MouseEvent e){	
		 
		 if( (e.getX()>=1000 && e.getX()<=1200 )&&(e.getY()>=200 && e.getY()<=250 )  ){     // Back to Menu
			 
			  Selectframe.dispose();
			  bgm.stop();
			  m  = new Menu(i);
			  m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      m.setExtendedState(m.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      m.setVisible(true);

			 
		 }
		 
		 // Character Select
		 
		 if( (e.getX()>=100 && e.getX()<=400 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  gf = new JFrame("King of Fighters"); 
			  g = new GamePractice(1,x,gf);
			
			  
		      gf.add(g);
		      gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      gf.setVisible(true);
		      bgm.stop();
		      Selectframe.dispose();
		      f1.dispose();
			 
		 }
		  
		   
		 if( (e.getX()>=500 && e.getX()<=800 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			  
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  
			  gf = new JFrame("King of Fighters");
			  g=new GamePractice(2,x,gf);  
			   
		      gf.add(g);
		      gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      gf.setVisible(true);
		      bgm.stop();
		      Selectframe.dispose();
		      f2.dispose();
			 
		 }
		  
		
		 if( (e.getX()>=900 && e.getX()<=1200 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			  
			  rand = new Random();
			  int x = rand.nextInt(3)+1;
			  gf = new JFrame("King of Fighters");			 
		      g=new GamePractice(3,x,gf);  
			   
		      gf.add(g);
		      gf.setExtendedState(gf.getExtendedState() | Frame.MAXIMIZED_BOTH);
		      gf.setVisible(true);
		      bgm.stop();
		      Selectframe.dispose();
		      f3.dispose();

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
		   inf01 = new Inf01(1);  
		   inf02 = new Inf01(2);
		   inf03 = new Inf01(3);
		   
		   if( (e.getX()>=1000 && e.getX()<=1200 )&&(e.getY()>=200 && e.getY()<=250 )  ){
			    g.setColor(Color.YELLOW); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Menu",1020,230);	
				g.drawRect(1000, 200, 200 , 50);
	
		   }
		   else{
			    g.setColor(Color.RED); 
				g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
				g.drawString("Back to Menu",1020,230);	
				g.drawRect(1000, 200, 200 , 50);

		   }
		   
		
		   // hero
		   //01
		   if( (e.getX()>=100 && e.getX()<=400 )&&(e.getY()>=300 && e.getY()<=600 ) ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(100,300,300,300);
				if(op1==0){
				  f1 = new JFrame();
			      f1.add(inf01);
			      f1.setSize(800,400);
			      f1.setVisible(true);
			      op1=1;
				}
		   
			}
		   else if(op1==1){
			    
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(100,300,300,300);
				f1.dispose();
				op1=0;
		   }
		   
	
		   
		   //02
		   if( (e.getX()>=500 && e.getX()<=800 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(500,300,300,300);
				if(op2==0){
					  f2 = new JFrame(); 
				      f2.add(inf02);
				      f2.setSize(800,400);
				      f2.setVisible(true);
				      op2=1;
					}
		   }
		   else if(op2==1){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(500,300,300,300);
				f2.dispose();
				op2=0;
		   }
		   
		   
		   //03
		   if( (e.getX()>=900 && e.getX()<=1200 )&&(e.getY()>=300 && e.getY()<=600 )  ){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.YELLOW); 
				g2.drawRect(900,300,300,300);
				if(op3==0){
					  f3 = new JFrame();
				      f3.add(inf03);
				      f3.setSize(800,400);
				      f3.setVisible(true);
				      op3=1;
				}
		   }
		   else if(op3==1){
			    g2.setStroke(new BasicStroke(4));
			    g2.setColor(Color.RED); 
				g2.drawRect(900,300,300,300);
				f3.dispose();
				op3=0;
		   }
		   
		 
		 
	 }
}


