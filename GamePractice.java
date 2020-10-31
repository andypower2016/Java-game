
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.util.concurrent.*;

import javax.swing.ImageIcon;



import javax.swing.JFrame;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GamePractice extends JPanel {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	
	 private int player,com;
	 private Hero1 h1,h11;
	 private Hero2 h2,h22;
	 private Hero3 h3,h33;
	 private Image bg=new ImageIcon("bin/image/bg1.gif").getImage();
	 private int sleeptime=75;
	 private AudioClip bgm;
	 private File soundFile;
	 
	 private Image hp2b = new ImageIcon("bin/image/hp2b.png").getImage();
	 private Image hp2m = new ImageIcon("bin/image/hp2m.png").getImage();
	 
	 private Menu m;
	 private Image i=new ImageIcon("bin/image/menu.jpg").getImage();
	
	 private JFrame gameframe;
	
	 // Animation Counter 
	 private int counter1[],counter11[];
	 private int counter2[],counter22[];
	 private int counter3[],counter33[];
	 private Timer time;
     //*************************************************************
	 // State
	 enum directionstate{RIGHT,LEFT};
	 enum herostate{PUNCH,KICK,DEFEND,MOVE,STABLE,HURT,SK1,SK2,SK3,J};
	//*************************************************************
	 //player state    
	 directionstate p1_d,p2_d,p3_d;
	 herostate p1_h,p2_h,p3_h;
	//com state 
	 directionstate p11_d,p22_d,p33_d;
	 herostate p11_h,p22_h,p33_h;
	//*************************************************************
	 
	 GamePractice(int player,int com,JFrame f){
		 
		 gameframe = f;
		
		
		initialBgm("bin/bgm/battlebgm.wav");
//*******************************************************************************************************************		
// KEY State Initialization		 
//*******************************************************************************************************************
//     player 1 -> 1
//*******************************************************************************************************************		 
		if(player==1){
			
			
			  addKeyListener(new KeyAdapter(){
				
				
				 
				 public void keyPressed(KeyEvent e){
				    	
					    int c = e.getKeyCode();
					    // Hero1

				    	if(c==e.VK_UP){
				    		if(p1_h != herostate.HURT)
				    		p1_h = herostate.J;
				    	}
				    	
				    	if(c==e.VK_DOWN){
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
					    		countinit1();
					    		p1_h = herostate.DEFEND;
					    	}
				    	}
				    	
				    	if(c==e.VK_LEFT){
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_d = directionstate.LEFT;
				    		p1_h = herostate.MOVE;
				    		}
				    	}
				    	
				    	if(c==e.VK_RIGHT){
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_d = directionstate.RIGHT;
				    		p1_h = herostate.MOVE;
				    		}
				    	}
				    	
				    	if(c==e.VK_N){                       // punch
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		countinit1();
				    		p1_h = herostate.PUNCH;
				    		}
				    	}
				    	
				    	if(c==e.VK_M){		 			     // kick
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_h = herostate.KICK;
				    		}
				    	}
				    	
				    	if(c==e.VK_H){		 			    
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_h = herostate.SK1;	   
				    		}
				    	}
				    	
				    	if(c==e.VK_J){		 			    
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_h = herostate.SK2;
				    		}
				    	}
				    	
				    	if(c==e.VK_K){		 			    
				    		if(p1_h != herostate.HURT && p1_h != herostate.J){
				    		p1_h = herostate.SK3;
				    		}
				    	}
				    	
				   
				   	
				 }
				    
				 public void keyReleased(KeyEvent e){
					if(p1_h != herostate.J){
					if(p1_h==herostate.DEFEND)  
					  p1_h=herostate.STABLE;
					}
				 }

			 });
			  
			}
	//************************************************************************************			 
//		    player 1 -> 2 
	//************************************************************************************		 
			if(player==2){ 
			
			this.addKeyListener(new KeyAdapter(){
				 		    
				 public void keyPressed(KeyEvent e){
				    	
					   
					    int t = e.getKeyCode();
				    	
				    	//Hero2
				    
				    	if(t==e.VK_UP){
				    		if(p2_h != herostate.HURT)
				    		p2_h = herostate.J;
				    	}
				    	
				    	if(t==e.VK_DOWN){
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		countinit2();
				    		p2_h = herostate.DEFEND;
				    		}
				    	}
				    	
				    	if(t==e.VK_LEFT){
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_d = directionstate.LEFT;
				    		p2_h = herostate.MOVE;
				    		}
				    	}
				    	
				    	if(t==e.VK_RIGHT){
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_d = directionstate.RIGHT;
				    		p2_h = herostate.MOVE;
				    		}
				    	}
				    	
				    	if(t==e.VK_N){                       // punch
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_h = herostate.PUNCH;
				    		}
				    	}
				    	
				    	if(t==e.VK_M){		 			     // kick
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_h = herostate.KICK;
				    		}
				    	}
				    	
				    	if(t==e.VK_H){		 			    
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_h = herostate.SK1;
				    		}
				    	}
				    	
				    	if(t==e.VK_J){		 			    
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_h = herostate.SK2;
				    		}
				    	}
				    	
				    	if(t==e.VK_K){		 			    
				    		if(p2_h != herostate.HURT && p2_h != herostate.J){
				    		p2_h = herostate.SK3;
				    		}
				    	}
				    	
				   
				 }
				    
				 public void keyReleased(KeyEvent e){
				    	
					
					 if(p2_h != herostate.J){
					  if(p2_h==herostate.DEFEND)  
					  p2_h=herostate.STABLE;
					 }
					}
				 
				 
			 });
			 
			}
			

	//************************************************************************************		     			 
//			    player 1 -> 3 
	//************************************************************************************		 
				 if(player==3){
					 
				 
				     this.addKeyListener(new KeyAdapter(){
					
					    
					 public void keyPressed(KeyEvent e){
					    	
						   
						    int t = e.getKeyCode();
					    	
					    	//Hero3
					    	
					    	if(t==e.VK_UP){
					    		if(p3_h != herostate.HURT)
					    		p3_h = herostate.J ;
					    	}
					    	
					    	if(t==e.VK_DOWN){
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		countinit3();
					    		p3_h = herostate.DEFEND;
					    		}
					    	}
					    	
					    	if(t==e.VK_LEFT){
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_d = directionstate.LEFT;
					    		p3_h = herostate.MOVE;
					    		}
					    	}
					    	
					    	if(t==e.VK_RIGHT){
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_d = directionstate.RIGHT;
					    		p3_h = herostate.MOVE;
					    		}
					    	}
					    	
					    	if(t==e.VK_N){                       // punch
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_h = herostate.PUNCH;
					    		}
					    	}
					    	
					    	if(t==e.VK_M){		 			     // kick
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_h = herostate.KICK;
					    		}
					    	}
					    	
					    	if(t==e.VK_H){		 			    
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_h = herostate.SK1;
					    		}
					    	}
					    	
					    	if(t==e.VK_J){		 			    
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_h = herostate.SK2;
					    		}
					    	}
					    	
					    	if(t==e.VK_K){		 			    
					    		if(p3_h != herostate.HURT && p3_h != herostate.J){
					    		p3_h = herostate.SK3;
					    		}
					    	}
					    	
					   	
					 }
					    
					 public void keyReleased(KeyEvent e){
					    	
						if(p3_h != herostate.J){
						if(p3_h==herostate.DEFEND)  
						  p3_h=herostate.STABLE;
						 }
					 }
					 
				 });
				     
				 }
				 
				 
			 
			 this.setFocusable(true);
		     this.requestFocusInWindow();
		    
		     
		     
		     this.addKeyListener(new KeyAdapter(){
					
				    
				 public void keyPressed(KeyEvent e){
				    	
					   
					    int t = e.getKeyCode();
				    	
					    if(t==27){
					    	
					    	int choice = JOptionPane.showOptionDialog(null,"Back to Menu?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null, null);  
					    		    
					    	if (choice == JOptionPane.YES_OPTION)
					    	{
					    		bgm.stop();
								gameframe.dispose();
								m  = new Menu(i);
							    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						        m.setExtendedState(m.getExtendedState() | Frame.MAXIMIZED_BOTH);
						        m.setVisible(true);
					    	}	      
					    		      
					    
					    }
				    
				   	
				 }
				    
			
			 });
//**********************************************************************************************************		     
	     
	     
//***********************************************************************************************************	
//  Fighting pair initialization
	     this.player=player;
	     this.com=com;
	     // initialize player
	     switch(player){
	     //Hero 1
	     case 1 :
		 h1 = new Hero1(width);
		 h1.setpos(200,600);
		 p1_h = herostate.STABLE;
		 p1_d = directionstate.RIGHT;
		 counter1 = new int[20];
		 for(int i : counter1){
			 i=0;
		 }
		 break;
		 
	     case 2 :
		 //Hero2
		 h2 = new Hero2(width);
		 h2.setpos(200,600);
		 p2_h = herostate.STABLE;
		 p2_d = directionstate.RIGHT;
		 counter2 = new int[20];
		 for(int i : counter2){
			 i=0;
		 }
		 break;
		 //Hero3
	     case 3 :
	     h3 = new Hero3(width);
		 h3.setpos(200,600);
		 p3_h = herostate.STABLE;
		 p3_d = directionstate.RIGHT;
		 counter3 = new int[20];
		 for(int i : counter3){
				 i=0;
		 }
	     }
	     
	     // initialize com
	     
	     switch(com){
	     //Hero 1
	     case 1 :
		 h11 = new Hero1(getWidth());
		 h11.setpos((int)width-266,600);
		 p11_h = herostate.STABLE;
		 p11_d = directionstate.LEFT;
		 counter11 = new int[18];
		 for(int i : counter11){
			 i=0;
		 }
		 break;
		 
	     case 2 :
		 //Hero2
		 h22 = new Hero2(getWidth());
		 h22.setpos((int)width-266,600);
		 p22_h = herostate.STABLE;
		 p22_d = directionstate.LEFT;
		 counter22 = new int[20];
		 for(int i : counter22){
			 i=0;
		 }
		 break;
		 //Hero3
	     case 3 :
	     h33 = new Hero3(getWidth());
		 h33.setpos((int)width-266,600);
		 p33_h = herostate.STABLE;
		 p33_d = directionstate.LEFT;
		 counter33 = new int[20];
		 for(int i : counter33){
					 i=0;
		}
	     
	     
	    }

//******************************************************************************************************************************

	     playerstate();
		 detect();
		 new COM_ATTACK();
		 
//******************************************************************************************************************************		 
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
	
//******************************************************************************************************************************							    
//		PLAYER STATE
//******************************************************************************************************************************
	 
	 public void playerstate()
	 {
		  	 
			   time = new Timer();
		       time.schedule( new TimerTask() 
		       {
		    	     
							public void run()
							{

								if(player==1){
								// Hero1
								
								if(p1_h==herostate.PUNCH && p1_d==directionstate.RIGHT){
						        	counter1[0]++;
						        	if(counter1[0]==11){
										counter1[0]=0;
										p1_h=herostate.STABLE;
									}
									
						        }
						        
						        if(p1_h==herostate.PUNCH && p1_d==directionstate.LEFT){
						        	counter1[1]++;
						        	if(counter1[1]==11){
										counter1[1]=0;
										p1_h=herostate.STABLE;
									}
						        }
						        
						        if(p1_h==herostate.KICK && p1_d==directionstate.RIGHT){
						        	counter1[2]++;
						        	if(counter1[2]==6){
										counter1[2]=0;
										p1_h=herostate.STABLE;
									}
						        }
						        
						        if(p1_h==herostate.KICK && p1_d==directionstate.LEFT){
						        	counter1[3]++;
						        	if(counter1[3]==6){
										counter1[3]=0;
										p1_h=herostate.STABLE;
									}
						        }
								
						        //DEFEND RIGHT 4
								//DEFEND LEFT 5
						
								if(p1_h==herostate.MOVE && p1_d==directionstate.RIGHT){
									
									counter1[6]++;
									h1.rincx(h1.getspeed());
									if(counter1[6]==5){
										counter1[6]=0;
										p1_h=herostate.STABLE;
									}
								   
								}
								
								if(p1_h==herostate.MOVE && p1_d==directionstate.LEFT){
									counter1[7]++;
									h1.lincx(h1.getspeed());
									if(counter1[7]==5){
								     counter1[7]=0;
									 p1_h=herostate.STABLE;
								    }
								}
								
								//STABLE 8
								//STABLE 9
						    	
								if( (p1_h==herostate.HURT && p1_d==directionstate.RIGHT ) )              
								{
									counter1[10]++;
									h1.lincx(h1.gethrange());
									if(counter1[10]==7){
								        counter1[10]=0;
								        p1_h=herostate.STABLE;
									}
								}
								
								if(p1_h==herostate.HURT && p1_d==directionstate.LEFT){
									counter1[11]++;
									h1.rincx(h1.gethrange());
									if(counter1[11]==7){
									     counter1[11]=0;
									     p1_h=herostate.STABLE;
									}
								}
								
								if( (p1_h==herostate.SK1 && p1_d==directionstate.RIGHT ) )              
								{
									counter1[12]++;
									if(counter1[12]==7){
								        counter1[12]=0;
								        p1_h=herostate.STABLE;
									}
								}
								
								if(p1_h==herostate.SK1 && p1_d==directionstate.LEFT){
									counter1[13]++;
									if(counter1[13]==7){
									     counter1[13]=0;
									     p1_h=herostate.STABLE;
									}
								}
								
								if( (p1_h==herostate.SK2 && p1_d==directionstate.RIGHT ) )              
								{
									counter1[14]++;
									h1.rincx(h1.getrangex());
									if(counter1[14]==9){
								        counter1[14]=0;
								        p1_h=herostate.STABLE;
									}
								}
								
								if(p1_h==herostate.SK2 && p1_d==directionstate.LEFT){
									counter1[15]++;
									h1.lincx(h1.getrangex());
									if(counter1[15]==9){
									     counter1[15]=0;
									     p1_h=herostate.STABLE;
									}
								}
								
								if( (p1_h==herostate.SK3 && p1_d==directionstate.RIGHT ) )              
								{
									counter1[16]++;
									h1.rincx(h1.getrangex());
									if(counter1[16]==8){
								        counter1[16]=0;
								        p1_h=herostate.STABLE;
									}
								}
								
								if(p1_h==herostate.SK3 && p1_d==directionstate.LEFT){
									counter1[17]++;
									h1.lincx(h1.getrangex());
									if(counter1[17]==8){
									     counter1[17]=0;
									     p1_h=herostate.STABLE;
									}
								}
								
								
								if( (p1_h==herostate.J && p1_d==directionstate.RIGHT ) )              
								{
									counter1[18]++;
									
									if(counter1[18]<4)
									h1.decy(h1.getjrange());
									else
									h1.incy(h1.getjrange());	
									
									if(counter1[18]==7){
								        counter1[18]=0;
								        p1_h=herostate.STABLE;
								        h1.sety(600);
									}
								}
								
								if(p1_h==herostate.J && p1_d==directionstate.LEFT){
									
									counter1[19]++;
									
									if(counter1[19]<4)
									 h1.decy(h1.getjrange());
									else
									 h1.incy(h1.getjrange());	
									
									if(counter1[19]==7){
									     counter1[19]=0;
									     p1_h=herostate.STABLE;
									     h1.sety(600);
									}
								}
								
								
								}
								
//**************************************************************************************************************
								if(player==2){
								// Hero2
								
								if(p2_h==herostate.PUNCH && p2_d==directionstate.RIGHT){
						        	counter2[0]++;
						        	if(counter2[0]==3){
										counter2[0]=0;
										p2_h=herostate.STABLE;
									}
									
						        }
						        
						        if(p2_h==herostate.PUNCH && p2_d==directionstate.LEFT){
						        	counter2[1]++;
						        	if(counter2[1]==3){
										counter2[1]=0;
										p2_h=herostate.STABLE;
									}
						        }
						        
						        if(p2_h==herostate.KICK && p2_d==directionstate.RIGHT){
						        	counter2[2]++;
						        	if(counter2[2]==4){
										counter2[2]=0;
										p2_h=herostate.STABLE;
									}
						        }
						        
						        if(p2_h==herostate.KICK && p2_d==directionstate.LEFT){
						        	counter2[3]++;
						        	if(counter2[3]==4){
										counter2[3]=0;
										p2_h=herostate.STABLE;
									}
						        }
								
								//DEFEND RIGHT 4
								//DEFEND LEFT 5
								

								if(p2_h==herostate.MOVE && p2_d==directionstate.RIGHT){
									
									counter2[6]++;
									h2.rincx(h2.getspeed());
									if(counter2[6]==4){
										counter2[6]=0;
										p2_h=herostate.STABLE;
									}
								   
								}
								
								
								if(p2_h==herostate.MOVE && p2_d==directionstate.LEFT){
									counter2[7]++;
									h2.lincx(h2.getspeed());
									if(counter2[7]==4){
								     counter2[7]=0;
									 p2_h=herostate.STABLE;
								    }
								}
								
								// STABLE 8
								// STABLE 9
								
							    
								if( (p2_h==herostate.HURT && p2_d==directionstate.RIGHT ) )              
								{
									counter2[10]++;
									h2.lincx(h2.gethrange());
									if(counter2[10]==3){
								        counter2[10]=0;
								        p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.HURT && p2_d==directionstate.LEFT){
									counter2[11]++;
									h2.rincx(h2.gethrange());
									if(counter2[11]==3){
									     counter2[11]=0;
									     p2_h=herostate.STABLE;
									}
								}
								
								
								if( (p2_h==herostate.SK1 && p2_d==directionstate.RIGHT ) )              
								{
									counter2[12]++;
									
									if(counter2[12]==4){
								        counter2[12]=0;
								        p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.SK1 && p2_d==directionstate.LEFT){
									counter2[13]++;
									
									if(counter2[13]==4){
									     counter2[13]=0;
									     p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.SK2 && p2_d==directionstate.RIGHT)              
								{
									counter2[14]++;
									h2.rincx(h2.getrangex());
									if(counter2[14]==4){
								        counter2[14]=0;
								        p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.SK2 && p2_d==directionstate.LEFT){
									counter2[15]++;
									h2.lincx(h2.getrangex());
									if(counter2[15]==4){
									     counter2[15]=0;
									     p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.SK3 && p2_d==directionstate.RIGHT)              
								{
									counter2[16]++;
									
									if(counter2[16]==7){
								        counter2[16]=0;
								        p2_h=herostate.STABLE;
									}
								}
								
								if(p2_h==herostate.SK3 && p2_d==directionstate.LEFT){
									counter2[17]++;
									
									if(counter2[17]==7){
									     counter2[17]=0;
									     p2_h=herostate.STABLE;
									}
								}
								
								
								if( (p2_h==herostate.J && p2_d==directionstate.RIGHT ) )              
								{
									counter2[18]++;
									
									if(counter2[18]<4)
									h2.decy(h2.getjrange());
									else
									h2.incy(h2.getjrange());	
									
									if(counter2[18]==7){
								        counter2[18]=0;
								        p2_h=herostate.STABLE;
								        h2.sety(600);
									}
								}
								
								if(p2_h==herostate.J && p2_d==directionstate.LEFT){
									
									counter2[19]++;
									
									if(counter2[19]<4)
									 h2.decy(h2.getjrange());
									else
									 h2.incy(h2.getjrange());	
									
									if(counter2[19]==7){
									     counter2[19]=0;
									     p2_h=herostate.STABLE;
									     h2.sety(600);
									}
								}
								
								
								}
								
//**************************************************************************************************************								
								if(player==3){
									// Hero3
									
									if(p3_h==herostate.PUNCH && p3_d==directionstate.RIGHT){
							        	counter3[0]++;
							        	if(counter3[0]==3){
											counter3[0]=0;
											p3_h=herostate.STABLE;
										}
										
							        }
							        
							        if(p3_h==herostate.PUNCH && p3_d==directionstate.LEFT){
							        	counter3[1]++;
							        	if(counter3[1]==3){
											counter3[1]=0;
											p3_h=herostate.STABLE;
										}
							        }
							        
							        if(p3_h==herostate.KICK && p3_d==directionstate.RIGHT){
							        	counter3[2]++;
							        	if(counter3[2]==2){
											counter3[2]=0;
											p3_h=herostate.STABLE;
										}
							        }
							        
							        if(p3_h==herostate.KICK && p3_d==directionstate.LEFT){
							        	counter3[3]++;
							        	if(counter3[3]==2){
											counter3[3]=0;
											p3_h=herostate.STABLE;
										}
							        }
									
									//DEFEND RIGHT 4
									//DEFEND LEFT 5
									

									if(p3_h==herostate.MOVE && p3_d==directionstate.RIGHT){
										
										counter3[6]++;
										h3.rincx(h3.getspeed());
										if(counter3[6]==3){
											counter3[6]=0;
											p3_h=herostate.STABLE;
										}
									   
									}
									
									
									if(p3_h==herostate.MOVE && p3_d==directionstate.LEFT){
										counter3[7]++;
										h3.lincx(h3.getspeed());
										if(counter3[7]==3){
									     counter3[7]=0;
										 p3_h=herostate.STABLE;
									    }
									}
									
									// STABLE 8
									// STABLE 9
									
								    
									if( (p3_h==herostate.HURT && p3_d==directionstate.RIGHT ) )              
									{
										counter3[10]++;
										h3.lincx(h3.gethrange());
										if(counter3[10]==3){
									        counter3[10]=0;
									        p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.HURT && p3_d==directionstate.LEFT){
										counter3[11]++;
										h3.rincx(h3.gethrange());
										if(counter3[11]==3){
										     counter3[11]=0;
										     p3_h=herostate.STABLE;
										}
									}
									
									
									if( (p3_h==herostate.SK1 && p3_d==directionstate.RIGHT ) )              
									{
										counter3[12]++;
										
										if(counter3[12]==4){
									        counter3[12]=0;
									        p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.SK1 && p3_d==directionstate.LEFT){
										counter3[13]++;
										
										if(counter3[13]==4){
										     counter3[13]=0;
										     p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.SK2 && p3_d==directionstate.RIGHT)              
									{
										counter3[14]++;
										h3.rincx(h3.getsk2range());
										if(counter3[14]==5){
									        counter3[14]=0;
									        p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.SK2 && p3_d==directionstate.LEFT){
										counter3[15]++;
										h3.lincx(h3.getsk2range());
										if(counter3[15]==5){
										     counter3[15]=0;
										     p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.SK3 && p3_d==directionstate.RIGHT)              
									{
										counter3[16]++;
										h3.rincx(h3.getsk3range());
										if(counter3[16]==4){
									        counter3[16]=0;
									        p3_h=herostate.STABLE;
										}
									}
									
									if(p3_h==herostate.SK3 && p3_d==directionstate.LEFT){
				            
											counter3[17]++;
											h3.lincx(h3.getsk3range());
											
											if(counter3[17]==4){
											     counter3[17]=0;
											     p3_h=herostate.STABLE;
											}

									}
									
									
									if( (p3_h==herostate.J && p3_d==directionstate.RIGHT ) )              
									{
										counter3[18]++;
										
										if(counter3[18]<4)
										h3.decy(h3.getjrange());
										else
										h3.incy(h3.getjrange());	
										
										if(counter3[18]==7){
									        counter3[18]=0;
									        p3_h=herostate.STABLE;
									        h3.sety(600);
										}
									}
									
									if(p3_h==herostate.J && p3_d==directionstate.LEFT){
										
										counter3[19]++;
										
										if(counter3[19]<4)
										 h3.decy(h3.getjrange());
										else
										 h3.incy(h3.getjrange());	
										
										if(counter3[19]==7){
										     counter3[19]=0;
										     p3_h=herostate.STABLE;
										     h3.sety(600);
										}
									}
									
									
									}

												
								repaint();

							}
							
				},0,sleeptime); 
		 
	}
	 
	


//*************************************************************************************************************
//								Fighting Pair State
//*************************************************************************************************************	 
	 public void detect(){
		 
		   time = new Timer();
	       time.schedule( new TimerTask() 
	       {
	    	     
						public void run()
						{
						   
							
//**************************************************************************************************************
							//player 1 vs com 1
//***************************************************************************************************************							
							// h1 player
							
							if(player==1 && com==1){
								
							
							if(( (h1.getx()<=(h11.getx()+70) )&&( h1.getx()>=(h11.getx()-70)) ) && p1_h==herostate.PUNCH && p11_h!=herostate.DEFEND){
								
								p11_h=herostate.HURT;
								h11.dechp(h1.getp_damage());

						    }

							if(( (h1.getx()<=(h11.getx()+70) )&&( h1.getx()>=(h11.getx()-70)) ) && p1_h==herostate.KICK && p11_h!=herostate.DEFEND){
						    	p11_h=herostate.HURT;
						    	h11.dechp(h1.getp_damage());
						    
						    }
							
							if(( (h1.getx()<=(h11.getx()+70) )&&( h1.getx()>=(h11.getx()-70)) ) && p1_h==herostate.SK1 && p11_h!=herostate.DEFEND){
						    	p11_h=herostate.HURT;
						    	h11.dechp(h1.getsk_1_damage());
						    
						    }
							
							if(( (h1.getx()<=(h11.getx()+70) )&&( h1.getx()>=(h11.getx()-70)) ) && p1_h==herostate.SK2 && p11_h!=herostate.DEFEND){
						    	p11_h=herostate.HURT;
						    	h11.dechp(h1.getsk_2_damage());
						    }
							
							if(( (h1.getx()<=(h11.getx()+70) )&&( h1.getx()>=(h11.getx()-70)) ) && p1_h==herostate.SK3 && p11_h!=herostate.DEFEND){
						    	p11_h=herostate.HURT;
						    	h11.dechp(h1.getsk_3_damage());
						    }
							
							
							//h11 com
													
							if(( (h11.getx()<=(h1.getx()+70) )&&( h11.getx()>=(h1.getx()-70)) ) && p11_h==herostate.PUNCH && p1_h!=herostate.DEFEND){
								
								p1_h=herostate.HURT;
								h1.dechp(h11.getp_damage());

						    }
							
							if(( (h11.getx()<=(h1.getx()+70) )&&( h11.getx()>=(h1.getx()-70)) ) && p11_h==herostate.KICK && p1_h!=herostate.DEFEND){
								
								p1_h=herostate.HURT;
								h1.dechp(h11.getp_damage());
						    }
							
							if(( (h11.getx()<=(h1.getx()+70) )&&( h11.getx()>=(h1.getx()-70)) ) && p11_h==herostate.SK1 && p1_h!=herostate.DEFEND){
								
								p1_h=herostate.HURT;
								h1.dechp(h11.getsk_1_damage());
						    }

							if(( (h11.getx()<=(h1.getx()+70) )&&( h11.getx()>=(h1.getx()-70)) ) && p11_h==herostate.SK2 && p1_h!=herostate.DEFEND){
								
								p1_h=herostate.HURT;
								h1.dechp(h11.getsk_1_damage());
						    }
							
							if(( (h11.getx()<=(h1.getx()+70) )&&( h11.getx()>=(h1.getx()-70)) ) && p11_h==herostate.SK3 && p1_h!=herostate.DEFEND){
								
								p1_h=herostate.HURT;
								h1.dechp(h11.getsk_1_damage());
						    } 
							
							
							if(h11.gethp()<=0){
								h11.sethp(8000);
							}
							
							
							}
//*****************************************************************************************************************************************************************
//**************************************************************************************************************
							//player 1 vs com 2
//***************************************************************************************************************									
							if(player==1 && com==2){
								
								//player h1
								
								if(( (h1.getx()<=(h22.getx()+70) )&&( h1.getx()>=(h22.getx()-70)) ) && p1_h==herostate.PUNCH && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h1.getp_damage());

							    }

								if(( (h1.getx()<=(h22.getx()+70) )&&( h1.getx()>=(h22.getx()-70)) ) && p1_h==herostate.KICK && p22_h!=herostate.DEFEND){
							    	p22_h=herostate.HURT;
							    	h22.dechp(h1.getp_damage());
							    }
								
								if(( (h1.getx()<=(h22.getx()+70) )&&( h1.getx()>=(h22.getx()-70)) ) && p1_h==herostate.SK1 && p22_h!=herostate.DEFEND){
							    	p22_h=herostate.HURT;
							    	h22.dechp(h1.getsk_1_damage());
							    }
								
								if(( (h1.getx()<=(h22.getx()+70) )&&( h1.getx()>=(h22.getx()-70)) ) && p1_h==herostate.SK2 && p22_h!=herostate.DEFEND){
							    	p22_h=herostate.HURT;
							    	h22.dechp(h1.getsk_2_damage());
							    }
								
								if(( (h1.getx()<=(h22.getx()+70) )&&( h1.getx()>=(h22.getx()-70)) ) && p1_h==herostate.SK3 && p22_h!=herostate.DEFEND){
							    	p22_h=herostate.HURT;
							    	h22.dechp(h1.getsk_3_damage());
							    }
								
								
								//com h22
														
								if(( (h22.getx()<=(h1.getx()+70) )&&( h22.getx()>=(h1.getx()-70)) ) && p22_h==herostate.PUNCH && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h22.getp_damage());
							    }
								
								if(( (h22.getx()<=(h1.getx()+70) )&&( h22.getx()>=(h1.getx()-70)) ) && p22_h==herostate.KICK && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h22.getp_damage());
							    }
								
								if(( (h22.getx()<=(h1.getx()+70) )&&( h22.getx()>=(h1.getx()-70)) ) && p22_h==herostate.SK1 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h22.getsk_1_damage());
							    }

								if(( (h22.getx()<=(h1.getx()+100) )&&( h22.getx()>=(h1.getx()-100)) ) && p22_h==herostate.SK2 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h22.getsk_2_damage());
							    }
								
								if(( (h22.getx()<=(h1.getx()+70) )&&( h22.getx()>=(h1.getx()-70)) ) && p22_h==herostate.SK3 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h22.getsk_3_damage());
							    } 
								
								if(h22.gethp()<=0){
									h22.sethp(8000);
								}
								
								
								}
//************************************************************************************************************************************************							
//						    player1 vs com3
//************************************************************************************************************************************************							
							if(player==1 && com==3){
								
								if(( (h1.getx()<=(h33.getx()+70) )&&( h1.getx()>=(h33.getx()-70)) ) && p1_h==herostate.PUNCH && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h1.getp_damage());
							    }
								
								if(( (h1.getx()<=(h33.getx()+70) )&&( h1.getx()>=(h33.getx()-70)) ) && p1_h==herostate.KICK && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h1.getp_damage());
							    }  
								
								if(( (h1.getx()<=(h33.getx()+70) )&&( h1.getx()>=(h33.getx()-70)) ) && p1_h==herostate.SK1 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h1.getsk_1_damage());
							    }  
								
								if(( (h1.getx()<=(h33.getx()+70) )&&( h1.getx()>=(h33.getx()-70)) ) && p1_h==herostate.SK2 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h1.getsk_2_damage());
							    } 
								
								if(( (h1.getx()<=(h33.getx()+70) )&&( h1.getx()>=(h33.getx()-70)) ) && p1_h==herostate.SK3 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h1.getsk_3_damage());
							    }    
								
								
								// com h33
								if(( (h33.getx()<=(h1.getx()+70) )&&( h33.getx()>=(h1.getx()-70)) ) && p33_h==herostate.PUNCH && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h33.getp_damage());
							    }
								
								if(( (h33.getx()<=(h1.getx()+70) )&&( h33.getx()>=(h1.getx()-70)) ) && p33_h==herostate.KICK && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h33.getp_damage());
							    } 
								
								if(( (h33.getx()<=(h1.getx()+70) )&&( h33.getx()>=(h1.getx()-70)) ) && p33_h==herostate.SK1 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h33.getsk_1_damage());
							    } 
								
								if(( (h33.getx()<=(h1.getx()+70) )&&( h33.getx()>=(h1.getx()-70)) ) && p33_h==herostate.SK2 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h33.getsk_2_damage());
							    } 
								
								if(( (h33.getx()<=(h1.getx()+70) )&&( h33.getx()>=(h1.getx()-70)) ) && p33_h==herostate.SK3 && p1_h!=herostate.DEFEND){
									
									p1_h=herostate.HURT;
									h1.dechp(h33.getsk_3_damage());
							    }  
								
								if(h33.gethp()<=0){
									h33.sethp(8000);
								}
								
							}
							
//*******************************************************************************************************************************************************************							
//************************************************************************************************************************************************							
//						    player2 vs com1
//************************************************************************************************************************************************		
							if(player==2 && com==1){
								
								//p2
								
								if(( (h2.getx()<=(h11.getx()+70) )&&( h2.getx()>=(h11.getx()-70)) ) && p2_h==herostate.PUNCH && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h11.getx()+70) )&&( h2.getx()>=(h11.getx()-70)) ) && p2_h==herostate.KICK && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h11.getx()+70) )&&( h2.getx()>=(h11.getx()-70)) ) && p2_h==herostate.SK1 && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h2.getsk_1_damage());
							    }
								
								if(( (h2.getx()<=(h11.getx()+70) )&&( h2.getx()>=(h11.getx()-70)) ) && p2_h==herostate.SK2 && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h2.getsk_2_damage());
							    }
								
								if(( (h2.getx()<=(h11.getx()+70) )&&( h2.getx()>=(h11.getx()-70)) ) && p2_h==herostate.SK3 && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h2.getsk_3_damage());
							    }	
								
								
								// com1
								
								if(( (h11.getx()<=(h2.getx()+70) )&&( h11.getx()>=(h2.getx()-70)) ) && p11_h==herostate.PUNCH && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h11.getp_damage());
							    }
								
								if(( (h11.getx()<=(h2.getx()+70) )&&( h11.getx()>=(h2.getx()-70)) ) && p11_h==herostate.KICK && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h11.getp_damage());
							    }
								
								if(( (h11.getx()<=(h2.getx()+70) )&&( h11.getx()>=(h2.getx()-70)) ) && p11_h==herostate.SK1 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h11.getsk_1_damage());
							    } 
								
								if(( (h11.getx()<=(h2.getx()+100) )&&( h11.getx()>=(h2.getx()-100)) ) && p11_h==herostate.SK2 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h11.getsk_2_damage());
							    } 
								
								if(( (h11.getx()<=(h2.getx()+70) )&&( h11.getx()>=(h2.getx()-70)) ) && p11_h==herostate.SK3 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h11.getsk_3_damage());
							    }  
								
								if(h11.gethp()<=0){
									h11.sethp(8000);
								}
								
							}
//************************************************************************************************************************************************							
//						    player2 vs com2
//************************************************************************************************************************************************								
							
							if(player==2 && com==2){
								
								if(( (h2.getx()<=(h22.getx()+70) )&&( h2.getx()>=(h22.getx()-70)) ) && p2_h==herostate.PUNCH && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h22.getx()+70) )&&( h2.getx()>=(h22.getx()-70)) ) && p2_h==herostate.KICK && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h22.getx()+70) )&&( h2.getx()>=(h22.getx()-70)) ) && p2_h==herostate.SK1 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h2.getsk_1_damage());
							    }
								
								if(( (h2.getx()<=(h22.getx()+100) )&&( h2.getx()>=(h22.getx()-100)) ) && p2_h==herostate.SK2 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h2.getsk_2_damage());
							    }
								
								if(( (h2.getx()<=(h22.getx()+70) )&&( h2.getx()>=(h22.getx()-70)) ) && p2_h==herostate.SK3 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h2.getsk_3_damage());
							    }
								
								
								//com2
								
								if(( (h22.getx()<=(h2.getx()+70) )&&( h22.getx()>=(h2.getx()-70)) ) && p22_h==herostate.PUNCH && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h22.getp_damage());
							    }
								
								if(( (h22.getx()<=(h2.getx()+70) )&&( h22.getx()>=(h2.getx()-70)) ) && p22_h==herostate.KICK && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h22.getp_damage());
							    }  
								
								if(( (h22.getx()<=(h2.getx()+70) )&&( h22.getx()>=(h2.getx()-70)) ) && p22_h==herostate.SK1 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h22.getsk_1_damage());
							    }  
								
								if(( (h22.getx()<=(h2.getx()+100) )&&( h22.getx()>=(h2.getx()-100)) ) && p22_h==herostate.SK2 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h22.getsk_2_damage());
							    }  
								
								if(( (h22.getx()<=(h2.getx()+70) )&&( h22.getx()>=(h2.getx()-70)) ) && p22_h==herostate.SK3 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h22.getsk_3_damage());
							    }    
								
								if(h22.gethp()<=0){
									h22.sethp(8000);
								}
								
							}
							
//************************************************************************************************************************************************							
//						    player2 vs com3
//************************************************************************************************************************************************								
							
							if(player==2 && com==3){
								
								//p2
								
								if(( (h2.getx()<=(h33.getx()+70) )&&( h2.getx()>=(h33.getx()-70)) ) && p2_h==herostate.PUNCH && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h33.getx()+70) )&&( h2.getx()>=(h33.getx()-70)) ) && p2_h==herostate.KICK && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h2.getp_damage());
							    }
								
								if(( (h2.getx()<=(h33.getx()+70) )&&( h2.getx()>=(h33.getx()-70)) ) && p2_h==herostate.SK1 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h2.getsk_1_damage());
							    }
								
								if(( (h2.getx()<=(h33.getx()+100) )&&( h2.getx()>=(h33.getx()-100)) ) && p2_h==herostate.SK2 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h2.getsk_2_damage());
							    }
								
								if(( (h2.getx()<=(h33.getx()+70) )&&( h2.getx()>=(h33.getx()-70)) ) && p2_h==herostate.SK3 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h2.getsk_3_damage());
							    }
								
								
								//com3
								if(( (h33.getx()<=(h2.getx()+70) )&&( h33.getx()>=(h2.getx()-70)) ) && p33_h==herostate.PUNCH && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h33.getp_damage());
							    }
								
								if(( (h33.getx()<=(h2.getx()+70) )&&( h33.getx()>=(h2.getx()-70)) ) && p33_h==herostate.KICK && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h33.getp_damage());
							    }    
								
								if(( (h33.getx()<=(h2.getx()+70) )&&( h33.getx()>=(h2.getx()-70)) ) && p33_h==herostate.SK1 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h33.getsk_1_damage());
							    }    
								
								if(( (h33.getx()<=(h2.getx()+70) )&&( h33.getx()>=(h2.getx()-70)) ) && p33_h==herostate.SK2 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h33.getsk_2_damage());
							    }    
								
								if(( (h33.getx()<=(h2.getx()+70) )&&( h33.getx()>=(h2.getx()-70)) ) && p33_h==herostate.SK3 && p2_h!=herostate.DEFEND){
									
									p2_h=herostate.HURT;
									h2.dechp(h33.getsk_3_damage());
							    }        
								
								if(h33.gethp()<=0){
									h33.sethp(8000);
								}
							}
							
//************************************************************************************************************************************************							
//						    player3 vs com1
//************************************************************************************************************************************************														
									
							if(player==3 && com==1){
								
								//p3
								
								if(( (h3.getx()<=(h11.getx()+70) )&&( h3.getx()>=(h11.getx()-70)) ) && p3_h==herostate.PUNCH && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h11.getx()+70) )&&( h3.getx()>=(h11.getx()-70)) ) && p3_h==herostate.KICK && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h11.getx()+70) )&&( h3.getx()>=(h11.getx()-70)) ) && p3_h==herostate.SK1 && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h3.getsk_1_damage());
							    }
								
								if(( (h3.getx()<=(h11.getx()+70) )&&( h3.getx()>=(h11.getx()-70)) ) && p3_h==herostate.SK2 && p11_h!=herostate.DEFEND){
														  
									p11_h=herostate.HURT;
									h11.dechp(h3.getsk_2_damage());
							    }
								
								if(( (h3.getx()<=(h11.getx()+70) )&&( h3.getx()>=(h11.getx()-70)) ) && p3_h==herostate.SK3 && p11_h!=herostate.DEFEND){
									
									p11_h=herostate.HURT;
									h11.dechp(h3.getsk_3_damage());
							    }
								
								
								
							// com1
								
								if(( (h11.getx()<=(h3.getx()+70) )&&( h11.getx()>=(h3.getx()-70)) ) && p11_h==herostate.PUNCH && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h11.getp_damage());
							    }
								
								if(( (h11.getx()<=(h3.getx()+70) )&&( h11.getx()>=(h3.getx()-70)) ) && p11_h==herostate.KICK && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h11.getp_damage());
							    }
								
								if(( (h11.getx()<=(h3.getx()+70) )&&( h11.getx()>=(h3.getx()-70)) ) && p11_h==herostate.SK1 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h11.getsk_1_damage());
							    }
								
								if(( (h11.getx()<=(h3.getx()+70) )&&( h11.getx()>=(h3.getx()-70)) ) && p11_h==herostate.SK2 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h11.getsk_2_damage());
							    }
								
								if(( (h11.getx()<=(h3.getx()+70) )&&( h11.getx()>=(h3.getx()-70)) ) && p11_h==herostate.SK3 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h11.getsk_3_damage());
							    }
								
								
								if(h11.gethp()<=0){
									h11.sethp(8000);
								}
								
								
							}
							
							
							
							
							if(player==3 && com==2){
								
								//p3
								
								if(( (h3.getx()<=(h22.getx()+70) )&&( h3.getx()>=(h22.getx()-70)) ) && p3_h==herostate.PUNCH && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h22.getx()+70) )&&( h3.getx()>=(h22.getx()-70)) ) && p3_h==herostate.KICK && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h22.getx()+70) )&&( h3.getx()>=(h22.getx()-70)) ) && p3_h==herostate.SK1 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h3.getsk_1_damage());
							    }
								
								if(( (h3.getx()<=(h22.getx()+70) )&&( h3.getx()>=(h22.getx()-70)) ) && p3_h==herostate.SK2 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h3.getsk_2_damage());
							    }
								
								if(( (h3.getx()<=(h22.getx()+70) )&&( h3.getx()>=(h22.getx()-70)) ) && p3_h==herostate.SK3 && p22_h!=herostate.DEFEND){
									
									p22_h=herostate.HURT;
									h22.dechp(h3.getsk_3_damage());
							    }
								
								
								// com2
								
								if(( (h22.getx()<=(h3.getx()+70) )&&( h22.getx()>=(h3.getx()-70)) ) && p22_h==herostate.PUNCH && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h22.getp_damage());
							    }
								
								if(( (h22.getx()<=(h3.getx()+70) )&&( h22.getx()>=(h3.getx()-70)) ) && p22_h==herostate.KICK && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h22.getp_damage());
							    }
								
								if(( (h22.getx()<=(h3.getx()+70) )&&( h22.getx()>=(h3.getx()-70)) ) && p22_h==herostate.SK1 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h22.getsk_1_damage());
							    }
								
								if(( (h22.getx()<=(h3.getx()+100) )&&( h22.getx()>=(h3.getx()-100)) ) && p22_h==herostate.SK2 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h22.getsk_2_damage());
							    }
								
								if(( (h22.getx()<=(h3.getx()+70) )&&( h22.getx()>=(h3.getx()-70)) ) && p22_h==herostate.SK3 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h22.getsk_3_damage());
							    }
								
								if(h22.gethp()<=0){
									h22.sethp(8000);
								}
								
							
							}
							
							
							if(player==3 && com==3){
								
								//p3
								
								if(( (h3.getx()<=(h33.getx()+70) )&&( h3.getx()>=(h33.getx()-70)) ) && p3_h==herostate.PUNCH && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h33.getx()+70) )&&( h3.getx()>=(h33.getx()-70)) ) && p3_h==herostate.KICK && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h3.getp_damage());
							    }
								
								if(( (h3.getx()<=(h33.getx()+70) )&&( h3.getx()>=(h33.getx()-70)) ) && p3_h==herostate.SK1 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h3.getsk_1_damage());
							    }
								
								if(( (h3.getx()<=(h33.getx()+70) )&&( h3.getx()>=(h33.getx()-70)) ) && p3_h==herostate.SK2 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h3.getsk_2_damage());
							    }
								
								if(( (h3.getx()<=(h33.getx()+70) )&&( h3.getx()>=(h33.getx()-70)) ) && p3_h==herostate.SK3 && p33_h!=herostate.DEFEND){
									
									p33_h=herostate.HURT;
									h33.dechp(h3.getsk_3_damage());
							    }
								
								
								// com3
								
								if(( (h33.getx()<=(h3.getx()+70) )&&( h33.getx()>=(h3.getx()-70)) ) && p33_h==herostate.PUNCH && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h33.getp_damage());
							    }
								
								if(( (h33.getx()<=(h3.getx()+70) )&&( h33.getx()>=(h3.getx()-70)) ) && p33_h==herostate.KICK && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h33.getp_damage());
							    }
								
								if(( (h33.getx()<=(h3.getx()+70) )&&( h33.getx()>=(h3.getx()-70)) ) && p33_h==herostate.SK1 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h33.getsk_1_damage());
							    }
								
								if(( (h33.getx()<=(h3.getx()+70) )&&( h33.getx()>=(h3.getx()-70)) ) && p33_h==herostate.SK2 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h33.getsk_2_damage());
							    }
								
								if(( (h33.getx()<=(h3.getx()+70) )&&( h33.getx()>=(h3.getx()-70)) ) && p33_h==herostate.SK3 && p3_h!=herostate.DEFEND){
									
									p3_h=herostate.HURT;
									h3.dechp(h33.getsk_3_damage());
							    }
								
								
								if(h33.gethp()<=0){
									h33.sethp(8000);
								}
								
							}
							
			
						  
						}
						
			},0,sleeptime); 
	 
		 
		 
	 }
	 
//*************************************************************************************************************	 
// 										Counter Initialization 
//*************************************************************************************************************	 
public void countinit1(){
		 
		 for(int i=0;i<20;i++){
			 counter1[i]=0;
		 }
	 }
	 
	 public void countinit2(){
		 for(int i=0;i<20;i++){
			 counter2[i]=0;
		 }
		
	 }
	 
	 public void countinit3(){
		 for(int i=0;i<20;i++){
			 counter3[i]=0;
		 }
		
	 }
	 
	 public void countinit11(){
		 for(int i=0;i<18;i++){
			 counter11[i]=0;
		 }
	 }
	 
	 public void countinit22(){
		 for(int i=0;i<18;i++){
			 counter22[i]=0;
		 }
		
	 }
	 
	 public void countinit33(){
		 for(int i=0;i<18;i++){
			 counter33[i]=0;
		 }
		
	 }
	 
	 // AI state detect
	 	 
	
	 
	 public boolean countdetect11(){
		 for(int i : counter11){
			 if(i!=0){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public boolean countdetect22(){
		 for(int i=0;i<4;i++){
			 if(counter22[i]!=0)
				 return false;
		 }
		 for(int i=12;i<18;i++){
			 if(counter22[i]!=0)
				 return false;
		 }
		 return true;
	 }
	 
	 public boolean countdetect33(){
		 for(int i=0;i<4;i++){
			 if(counter33[i]!=0)
				 return false;
		 }
		 for(int i=12;i<18;i++){
			 if(counter33[i]!=0)
				 return false;
		 }
		 return true;
	 }

    
	 
//****************************************************************************************************************	 	 
//						Animation	 
//****************************************************************************************************************	 	 	 
	 public void paintComponent(Graphics g){
			
	        super.paintComponent(g);
	        g.drawImage(bg,0,0,getWidth(),getHeight(),null);
	        
	        g.drawImage(hp2b,770,25,549,150,null);	
//**************************************************************************************************************************	       
	        //Hero1
//**************************************************************************************************************************
	        if(player==1){
	        
	        
	        	
	        if(p1_h==herostate.PUNCH && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrp(counter1[0]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.PUNCH && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getlp(counter1[1]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.KICK && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrk(counter1[2]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.KICK && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getlk(counter1[3]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.DEFEND && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrd(),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.DEFEND && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getld(),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.MOVE && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrm(counter1[6]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.MOVE && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getlm(counter1[7]),h1.getx(),h1.gety(),100,100,null);
	        }
        
	        if(p1_h==herostate.STABLE && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrs(),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.STABLE && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getls(),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.HURT && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrh(counter1[10]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.HURT && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getlh(counter1[11]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK1 && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrs1(counter1[12]),h1.getx(),h1.gety()-h1.getrangey(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK1 && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getls1(counter1[13]),h1.getx(),h1.gety()-h1.getrangey(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK2 && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrs2(counter1[14]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK2 && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getls2(counter1[15]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK3 && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrs3(counter1[16]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.SK3 && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getls3(counter1[17]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.J && p1_d==directionstate.RIGHT){
	        	g.drawImage(h1.getrj(counter1[18]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        if(p1_h==herostate.J && p1_d==directionstate.LEFT){
	        	g.drawImage(h1.getlj(counter1[19]),h1.getx(),h1.gety(),100,100,null);
	        }
	        
	        
	        }
	        
//******************************************************************************************************************************************
	        
	        if(com==1){
		        
	        	g.drawImage(hp2m,795,83,h11.gethp()/20,20,null);
	        	
	        	g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
	  		    g.setColor(Color.RED);
	        	g.drawString("COM",h11.getx()+20,h11.gety()+115);
	        	
		        if(p11_h==herostate.PUNCH && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrp(counter11[0]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.PUNCH && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getlp(counter11[1]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.KICK && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrk(counter11[2]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.KICK && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getlk(counter11[3]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.DEFEND && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrd(),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.DEFEND && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getld(),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.MOVE && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrm(counter11[6]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.MOVE && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getlm(counter11[7]),h11.getx(),h11.gety(),100,100,null);
		        }
	        
		        if(p11_h==herostate.STABLE && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrs(),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.STABLE && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getls(),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.HURT && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrh(counter11[10]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.HURT && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getlh(counter11[11]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK1 && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrs1(counter11[12]),h11.getx(),h11.gety()-h11.getrangey(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK1 && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getls1(counter11[13]),h11.getx(),h11.gety()-h11.getrangey(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK2 && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrs2(counter11[14]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK2 && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getls2(counter11[15]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK3 && p11_d==directionstate.RIGHT){
		        	g.drawImage(h11.getrs3(counter11[16]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        if(p11_h==herostate.SK3 && p11_d==directionstate.LEFT){
		        	g.drawImage(h11.getls3(counter11[17]),h11.getx(),h11.gety(),100,100,null);
		        }
		        
		        
		        }
	        
//****************************************************************************************************************************************
	        //Hero2
//****************************************************************************************************************************************	       
	        if(player==2){
	        
	        
	        	
	        if(p2_h==herostate.PUNCH && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrp(counter2[0]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.PUNCH && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getlp(counter2[1]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.KICK && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrk(counter2[2]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.KICK && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getlk(counter2[3]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.DEFEND && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrd(),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.DEFEND && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getld(),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.MOVE && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrm(counter2[6]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.MOVE && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getlm(counter2[7]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.STABLE && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrs(),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.STABLE && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getls(),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.HURT && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrh(counter2[10]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.HURT && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getlh(counter2[11]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK1 && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrs1(counter2[12]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK1 && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getls1(counter2[13]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK2 && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrs2(counter2[14]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK2 && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getls2(counter2[15]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK3 && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrs3(counter2[16]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.SK3 && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getls3(counter2[17]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.J && p2_d==directionstate.RIGHT){
	        	g.drawImage(h2.getrj(counter2[18]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        if(p2_h==herostate.J && p2_d==directionstate.LEFT){
	        	g.drawImage(h2.getlj(counter2[19]),h2.getx(),h2.gety(),100,100,null);
	        }
	        
	        }
//****************************************************************************************************************************************	
	        
	        if(com==2){
		        
	        	g.drawImage(hp2m,795,83,h22.gethp()/20,20,null);
	        	
	        	g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
	  		    g.setColor(Color.RED);
	        	g.drawString("COM",h22.getx()+20,h22.gety()+115);
	        	
		        if(p22_h==herostate.PUNCH && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrp(counter22[0]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.PUNCH && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getlp(counter22[1]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.KICK && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrk(counter22[2]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.KICK && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getlk(counter22[3]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.DEFEND && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrd(),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.DEFEND && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getld(),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.MOVE && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrm(counter22[6]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.MOVE && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getlm(counter22[7]),h22.getx(),h22.gety(),100,100,null);
		        }
	        
		        if(p22_h==herostate.STABLE && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrs(),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.STABLE && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getls(),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.HURT && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrh(counter22[10]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.HURT && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getlh(counter22[11]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK1 && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrs1(counter22[12]),h22.getx(),h22.gety()-h22.getrangey(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK1 && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getls1(counter22[13]),h22.getx(),h22.gety()-h22.getrangey(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK2 && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrs2(counter22[14]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK2 && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getls2(counter22[15]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK3 && p22_d==directionstate.RIGHT){
		        	g.drawImage(h22.getrs3(counter22[16]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        if(p22_h==herostate.SK3 && p22_d==directionstate.LEFT){
		        	g.drawImage(h22.getls3(counter22[17]),h22.getx(),h22.gety(),100,100,null);
		        }
		        
		        
		        }
//********************************************************************************************************************************************
//	        Hero3
	        if(player==3){
		        
	        	
	        	
	        	        	
		        if(p3_h==herostate.PUNCH && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrp(counter3[0]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.PUNCH && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getlp(counter3[1]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.KICK && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrk(counter3[2]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.KICK && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getlk(counter3[3]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.DEFEND && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrd(),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.DEFEND && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getld(),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.MOVE && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrm(counter3[6]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.MOVE && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getlm(counter3[7]),h3.getx(),h3.gety(),100,100,null);
		        }
	        
		        if(p3_h==herostate.STABLE && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrs(),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.STABLE && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getls(),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.HURT && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrh(counter3[10]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.HURT && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getlh(counter3[11]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK1 && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrs1(counter3[12]),h3.getx(),h3.gety()-h3.getrangey(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK1 && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getls1(counter3[13]),h3.getx(),h3.gety()-h3.getrangey(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK2 && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrs2(counter3[14]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK2 && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getls2(counter3[15]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK3 && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrs3(counter3[16]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.SK3 && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getls3(counter3[17]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.J && p3_d==directionstate.RIGHT){
		        	g.drawImage(h3.getrj(counter3[18]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        if(p3_h==herostate.J && p3_d==directionstate.LEFT){
		        	g.drawImage(h3.getlj(counter3[19]),h3.getx(),h3.gety(),100,100,null);
		        }
		        
		        
		        }
		        
	        
	        if(com==3){
		        
	        	g.drawImage(hp2m,795,83,h33.gethp()/20,20,null);
	        	
	        	g.setFont(new Font("monospaced", Font.BOLD|Font.ITALIC , 25));
	  		    g.setColor(Color.RED);
	        	g.drawString("COM",h33.getx()+20,h33.gety()+115);
	        	
		        if(p33_h==herostate.PUNCH && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrp(counter33[0]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.PUNCH && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getlp(counter33[1]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.KICK && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrk(counter33[2]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.KICK && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getlk(counter33[3]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.DEFEND && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrd(),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.DEFEND && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getld(),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.MOVE && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrm(counter33[6]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.MOVE && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getlm(counter33[7]),h33.getx(),h33.gety(),100,100,null);
		        }
	        
		        if(p33_h==herostate.STABLE && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrs(),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.STABLE && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getls(),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.HURT && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrh(counter33[10]),h33.getx(),h33.gety(),100,100,null);     
		        }
		        
		        if(p33_h==herostate.HURT && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getlh(counter33[11]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK1 && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrs1(counter33[12]),h33.getx(),h33.gety()-h33.getrangey(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK1 && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getls1(counter33[13]),h33.getx(),h33.gety()-h33.getrangey(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK2 && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrs2(counter33[14]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK2 && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getls2(counter33[15]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK3 && p33_d==directionstate.RIGHT){
		        	g.drawImage(h33.getrs3(counter33[16]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        if(p33_h==herostate.SK3 && p33_d==directionstate.LEFT){
		        	g.drawImage(h33.getls3(counter33[17]),h33.getx(),h33.gety(),100,100,null);
		        }
		        
		        
		        }
	        
	        
	     
	     
	        
	 }

	
private class COM_ATTACK implements Runnable{

		 
		 public COM_ATTACK(){
			 new Thread(this).start();
		 }
		 
		 public void attack(){
			    
			 
			//**************************************************************************************************************
			//**************************************************************************************************************							    
//												COM   STATE
			//**************************************************************************************************************
											    
												if(com==1){
													// Hero1
												
													
													if(p11_h==herostate.PUNCH && p11_d==directionstate.RIGHT){
											        	counter11[0]++;
											        	if(counter11[0]==11){
															counter11[0]=0;
															p11_h=herostate.STABLE;
														
														}
														
											        }
											        
													
													
											        if(p11_h==herostate.PUNCH && p11_d==directionstate.LEFT ){
											      
											        	counter11[1]++;
											          
											            if(counter11[1]==11){
															counter11[1]=0;
															p11_h=herostate.STABLE;
														
														}
											        }
											        
											        if(p11_h==herostate.KICK && p11_d==directionstate.RIGHT){
											        	counter11[2]++;
											        	if(counter11[2]==6){
															counter11[2]=0;
															p11_h=herostate.STABLE;
															
														}
											        }
											        
											        if(p11_h==herostate.KICK && p11_d==directionstate.LEFT){
											        	counter11[3]++;
											        	if(counter11[3]==6){
															counter11[3]=0;
															p11_h=herostate.STABLE;
														
														}
											        }
											        
											        //DEFEND
												
											
													if(p11_h==herostate.MOVE && p11_d==directionstate.RIGHT){
														
														counter11[6]++;
														h11.rincx(h11.getspeed());
														if(counter11[6]==5){
															counter11[6]=0;
															p11_h=herostate.STABLE;
														}
													   
													}
													
													if(p11_h==herostate.MOVE && p11_d==directionstate.LEFT){
														counter11[7]++;
														h11.lincx(h11.getspeed());
														if(counter11[7]==5){
													     counter11[7]=0;
														 p11_h=herostate.STABLE;
													    }
													}
													
													//STABLE 8
													//STABLE 9
											    	
													if( (p11_h==herostate.HURT && p11_d==directionstate.RIGHT ) )              
													{
														counter11[10]++;
														h11.lincx(h11.gethrange());
														if(counter11[10]==7){
															countinit11();
													        counter11[10]=0;
													        p11_h=herostate.STABLE;
														}
													}
													
													if(p11_h==herostate.HURT && p11_d==directionstate.LEFT){
														counter11[11]++;
														h11.rincx(h11.gethrange());
														if(counter11[11]==7){
															 countinit11();
														     counter11[11]=0;
														     p11_h=herostate.STABLE;
														}
													}
													
													if( (p11_h==herostate.SK1 && p11_d==directionstate.RIGHT ) )              
													{
														counter11[12]++;
														if(counter11[12]==7){
													        counter11[12]=0;
													        p11_h=herostate.STABLE;
													     
														}
													}
													
													if(p11_h==herostate.SK1 && p11_d==directionstate.LEFT){
														counter11[13]++;
														if(counter11[13]==7){
														     counter11[13]=0;
														     p11_h=herostate.STABLE;
														   
														}
													}
													
													if( (p11_h==herostate.SK2 && p11_d==directionstate.RIGHT ) )              
													{
														counter11[14]++;
														h11.rincx(h11.getrangex());
														if(counter11[14]==9){
													        counter11[14]=0;
													        p11_h=herostate.STABLE;
													       
														}
													}
													
													if(p11_h==herostate.SK2 && p11_d==directionstate.LEFT){
														counter11[15]++;
														h11.lincx(h11.getrangex());
														if(counter11[15]==9){
														     counter11[15]=0;
														     p11_h=herostate.STABLE;
														   
														}
													}
													
													if( (p11_h==herostate.SK3 && p11_d==directionstate.RIGHT ) )              
													{
														counter11[16]++;
														h11.rincx(h11.getrangex());
														if(counter11[16]==8){
													        counter11[16]=0;
													        p11_h=herostate.STABLE;
													       
														}
													}
													
													if(p11_h==herostate.SK3 && p11_d==directionstate.LEFT){
														counter11[17]++;
														h11.lincx(h11.getrangex());
														if(counter11[17]==8){
														     counter11[17]=0;
														     p11_h=herostate.STABLE;
														     
														     
														}
													}
													
													
													
													}

				//********************************************************************************************************************************************	
												
												
												if(com==2){
													// Hero2
													
													if(p22_h==herostate.PUNCH && p22_d==directionstate.RIGHT){
											        	counter22[0]++;
											        	if(counter22[0]==3){
															counter22[0]=0;
															p22_h=herostate.STABLE;
															
														}
														
											        }
											        
											        if(p22_h==herostate.PUNCH && p22_d==directionstate.LEFT){
											        	counter22[1]++;
											        	if(counter22[1]==3){
															counter22[1]=0;
															p22_h=herostate.STABLE;
															
														}
											        }
											        
											        if(p22_h==herostate.KICK && p22_d==directionstate.RIGHT){
											        	counter22[2]++;
											        	if(counter22[2]==4){
															counter22[2]=0;
															p22_h=herostate.STABLE;
															
														}
											        }
											        
											        if(p22_h==herostate.KICK && p22_d==directionstate.LEFT){
											        	counter22[3]++;
											        	if(counter22[3]==4){
															counter22[3]=0;
															p22_h=herostate.STABLE;
															
														}
											        }
													
											        //DEFEND RIGHT 4
													//DEFEND LEFT 5
											
													if(p22_h==herostate.MOVE && p22_d==directionstate.RIGHT){
														
														counter22[6]++;
														h22.rincx(h22.getspeed());
														if(counter22[6]==4){
															counter22[6]=0;
															p22_h=herostate.STABLE;
														}
													   
													}
													
													if(p22_h==herostate.MOVE && p22_d==directionstate.LEFT){
														counter22[7]++;
														h22.lincx(h22.getspeed());
														if(counter22[7]==4){
													     counter22[7]=0;
														 p22_h=herostate.STABLE;
													    }
													}
													
													//STABLE 8
													//STABLE 9
											    	
													if( (p22_h==herostate.HURT && p22_d==directionstate.RIGHT ) )              
													{
														counter22[10]++;
														h22.lincx(h22.gethrange());
														if(counter22[10]==3){
															countinit22();
													        counter22[10]=0;
													        p22_h=herostate.STABLE;
														}
													}
													
													if(p22_h==herostate.HURT && p22_d==directionstate.LEFT){
														counter22[11]++;
														h22.rincx(h22.gethrange());
														if(counter22[11]==3){
															 countinit22();
														     counter22[11]=0;
														     p22_h=herostate.STABLE;
														}
													}
													
													if( (p22_h==herostate.SK1 && p22_d==directionstate.RIGHT ) )              
													{
														counter22[12]++;
														if(counter22[12]==4){
													        counter22[12]=0;
													        p22_h=herostate.STABLE;
													        
													        
													        
														}
													}
													
													if(p22_h==herostate.SK1 && p22_d==directionstate.LEFT){
														counter22[13]++;
														if(counter22[13]==4){
														     counter22[13]=0;
														     p22_h=herostate.STABLE;
														     														}
													}
													
													if( (p22_h==herostate.SK2 && p22_d==directionstate.RIGHT ) )              
													{
														counter22[14]++;
														h22.rincx(h22.getrangex());
														if(counter22[14]==4){
													        counter22[14]=0;
													        p22_h=herostate.STABLE;
													       
														}
													}
													
													if(p22_h==herostate.SK2 && p22_d==directionstate.LEFT){
														counter22[15]++;
														h22.lincx(h22.getrangex());
														if(counter22[15]==4){
														     counter22[15]=0;
														     p22_h=herostate.STABLE;
														     
														}
													}
													
													if( (p22_h==herostate.SK3 && p22_d==directionstate.RIGHT ) )              
													{
														counter22[16]++;
														h22.rincx(h22.getrangex());
														if(counter22[16]==7){
													        counter22[16]=0;
													        p22_h=herostate.STABLE;
													       
														}
													}
													
													if(p22_h==herostate.SK3 && p22_d==directionstate.LEFT){
														counter22[17]++;
														h22.lincx(h22.getrangex());
														if(counter22[17]==7){
														     counter22[17]=0;
														     p22_h=herostate.STABLE;
														     
														}
													}
													
													}
												
				//******************************************************************************************************************************************								
												if(com==3){
													// Hero3
													
													if(p33_h==herostate.PUNCH && p33_d==directionstate.RIGHT){
											        	counter33[0]++;
											        	if(counter33[0]==3){
															counter33[0]=0;
															p33_h=herostate.STABLE;
															
														}
														
											        }
											        
											        if(p33_h==herostate.PUNCH && p33_d==directionstate.LEFT){
											        	counter33[1]++;
											        	if(counter33[1]==3){
															counter33[1]=0;
															p33_h=herostate.STABLE;
															
														}
											        }
											        
											        if(p33_h==herostate.KICK && p33_d==directionstate.RIGHT){
											        	counter33[2]++;
											        	if(counter33[2]==2){
															counter33[2]=0;
															p33_h=herostate.STABLE;
															
														}
											        }
											        
											        if(p33_h==herostate.KICK && p33_d==directionstate.LEFT){
											        	counter33[3]++;
											        	if(counter33[3]==2){
															counter33[3]=0;
															p33_h=herostate.STABLE;
															
														}
											        }
													
													//DEFEND RIGHT 4
													//DEFEND LEFT 5
													

													if(p33_h==herostate.MOVE && p33_d==directionstate.RIGHT){
														
														counter33[6]++;
														h33.rincx(h33.getspeed());
														if(counter33[6]==3){
															counter33[6]=0;
															p33_h=herostate.STABLE;
														}
													   
													}
													
													
													if(p33_h==herostate.MOVE && p33_d==directionstate.LEFT){
														counter33[7]++;
														h33.lincx(h33.getspeed());
														if(counter33[7]==3){
													     counter33[7]=0;
														 p33_h=herostate.STABLE;
													    }
													}
													
													// STABLE 8
													// STABLE 9
													
												    
													if( (p33_h==herostate.HURT && p33_d==directionstate.RIGHT ) )              
													{
														counter33[10]++;
														h33.lincx(h33.gethrange());
														if(counter33[10]==3){										
													        counter33[10]=0;
													        p33_h=herostate.STABLE;
														}
													}
													
													if(p33_h==herostate.HURT && p33_d==directionstate.LEFT){
														counter33[11]++;
														h33.rincx(h33.gethrange());
														if(counter33[11]==3){																	
														     counter33[11]=0;
														     p33_h=herostate.STABLE;
														}
													}
													
													
													if( (p33_h==herostate.SK1 && p33_d==directionstate.RIGHT ) )              
													{
														counter33[12]++;
														
														if(counter33[12]==4){
													        counter33[12]=0;
													        p33_h=herostate.STABLE;
														}
													}
													
													if(p33_h==herostate.SK1 && p33_d==directionstate.LEFT){
														counter33[13]++;
														
														if(counter33[13]==4){
														     counter33[13]=0;
														     p33_h=herostate.STABLE;
														   
														}
													}
													
													if(p33_h==herostate.SK2 && p33_d==directionstate.RIGHT)              
													{
														counter33[14]++;
														h33.rincx(h33.getsk2range());
														if(counter33[14]==5){
													        counter33[14]=0;
													        p33_h=herostate.STABLE;
													      
														}
													}
													
													if(p33_h==herostate.SK2 && p33_d==directionstate.LEFT){
														counter33[15]++;
														h33.lincx(h33.getsk2range());
														if(counter33[15]==5){
														     counter33[15]=0;
														     p33_h=herostate.STABLE;
														    
														}
													}
													
													if(p33_h==herostate.SK3 && p33_d==directionstate.RIGHT)              
													{
														counter33[16]++;
														h33.rincx(h33.getsk3range());
														if(counter33[16]==4){
													        counter33[16]=0;
													        p33_h=herostate.STABLE;
													       
														}
													}
													
													if(p33_h==herostate.SK3 && p33_d==directionstate.LEFT){
														counter33[17]++;
														h33.lincx(h33.getsk3range());
														if(counter33[17]==4){
														     counter33[17]=0;
														     p33_h=herostate.STABLE;
														     
														    
														}
													}
													
													
													}
												
		 }
	 
		 
		 public void run(){
				
			 while(true){
			 
				 
				 try{
				       
					   attack();
				       Thread.sleep(85);
	       
			     }catch(InterruptedException e){
			    	 
			     }
			 
			
			 }
		 
		 
		 
		 
         }
		 
      }


	



	 


}

