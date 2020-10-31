
import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Hero2 {
	
	private Image l_d[];
	private Image l_h[];
	private Image l_k[];        // kick
	private Image l_m[];		// move	
	private Image l_p[];		// punch
	private Image l_s[];   //stand
	private Image l_s1[];
	private Image l_s2[];
	private Image l_s3[];
	private Image l_j[];
	
	private Image r_d[];
	private Image r_h[];
	private Image r_k[];        // kick
	private Image r_m[];		// move	
	private Image r_p[];		// punch
	private Image r_s[];        //stand
	private Image r_s1[];
	private Image r_s2[];
	private Image r_s3[];
	private Image r_j[];
	
	private int posx,posy;      // location
	private int def;
	private int speed;
	private int hp;
    private int p_damage;       
    private int sk_1_damage;
    private int sk_2_damage;
    private int sk_3_damage;
    private int rangex,rangey;
    private int hrange;
    private int jrange;
    
    private double size;
	
	public Hero2(double size){
		
		this.size = size;
		//Left
		
		l_d = new Image[1];
		l_d[0] = new ImageIcon("bin/image/hero2/ld/ld.gif").getImage();
	
		l_h= new Image[3];
		for(int i=0;i<3;i++){
			l_h[i]=new ImageIcon("bin/image/hero2/lh/lh0"+(i+1)+".gif").getImage();
		}
		
		l_k = new Image[4];
		for(int i=0;i<4;i++){
			l_k[i]=new ImageIcon("bin/image/hero2/lk/lk0"+(i+1)+".gif").getImage();
		}
		
		l_m = new Image[4];	
		for(int i=0;i<4;i++){
			l_m[i]=new ImageIcon("bin/image/hero2/lm/lm0"+(i+1)+".gif").getImage();
		}
		
		l_p = new Image[3];
		for(int i=0;i<3;i++){
			l_p[i]=new ImageIcon("bin/image/hero2/lp/lp0"+(i+1)+".gif").getImage();
		}
		
		l_s = new Image[1];
		l_s[0] = new ImageIcon("bin/image/hero2/ls/ls.gif").getImage();
		
		l_s1 = new Image[4];
		for(int i=0;i<4;i++){
			l_s1[i]=new ImageIcon("bin/image/hero2/ls1/ls10"+(i)+".gif").getImage();
		}
		
		l_s2 = new Image[4];
		for(int i=0;i<4;i++){
			l_s2[i]=new ImageIcon("bin/image/hero2/ls2/ls20"+(i+1)+".gif").getImage();
		}
		
		l_s3 = new Image[7];
		for(int i=0;i<7;i++){
			l_s3[i]=new ImageIcon("bin/image/hero2/ls3/ls30"+(i+1)+".gif").getImage();
		}
		
		l_j = new Image[7];
		for(int i=0;i<7;i++){
			l_j[i]=new ImageIcon("bin/image/hero2/lj/lj0"+(i+1)+".gif").getImage();
		}
		
		//Right
		
		r_d = new Image[1];
		r_d[0] = new ImageIcon("bin/image/hero2/rd/rd.gif").getImage();
	
		r_h= new Image[3];
		for(int i=0;i<3;i++){
			r_h[i]=new ImageIcon("bin/image/hero2/rh/rh0"+(i+1)+".gif").getImage();
		}
		
		r_k = new Image[4];
		for(int i=0;i<4;i++){
			r_k[i]=new ImageIcon("bin/image/hero2/rk/rk0"+(i+1)+".gif").getImage();
		}
		
		r_m = new Image[4];	
		for(int i=0;i<4;i++){
			r_m[i]=new ImageIcon("bin/image/hero2/rm/rm0"+(i+1)+".gif").getImage();
		}
		
		r_p = new Image[3];
		for(int i=0;i<3;i++){
			r_p[i]=new ImageIcon("bin/image/hero2/rp/rp0"+(i+1)+".gif").getImage();
		}
		
		r_s = new Image[1];
		r_s[0] = new ImageIcon("bin/image/hero2/rs/rs.gif").getImage();
		
		r_s1 = new Image[4];
		for(int i=0;i<4;i++){
			r_s1[i]=new ImageIcon("bin/image/hero2/rs1/rs10"+(i)+".gif").getImage();
		}
		
		r_s2 = new Image[4];
		for(int i=0;i<4;i++){
			r_s2[i]=new ImageIcon("bin/image/hero2/rs2/rs20"+(i+1)+".gif").getImage();
		}
		
		r_s3 = new Image[7];
		for(int i=0;i<7;i++){
			r_s3[i]=new ImageIcon("bin/image/hero2/rs3/rs30"+(i+1)+".gif").getImage();
		}
		
		r_j = new Image[7];
		for(int i=0;i<7;i++){
			r_j[i]=new ImageIcon("bin/image/hero2/rj/rj0"+(i+1)+".gif").getImage();
		}
		
		// initialize
		
		speed = 20;
		def   = 60;
		hp    = 8000;
		p_damage = 50;
		sk_1_damage = 200;
		sk_2_damage = 250;
		sk_3_damage = 150;
		rangex = 100;
		rangey = 20;
		hrange = 10;
		jrange = 80;
	}

	public void setpos(int x1,int y1){
		 
		 posx=x1; posy=y1;
		
	}

    public int getx(){
    	return posx;
    }
    public int gety(){
    	return posy;
    }
    
    public void rincx(int x){
     if(posx<(size-100))	
    	posx+=x;
    }
    public void lincx(int x){
        if(posx>0)	
       	posx-=x;
    }
    public void incy(int y){
    	posy+=y;
    }
    
    public void dechp(int x){
    	hp-=x;
    }
    
    public void sethp(int x){
    	hp=x;
    }
    
    public void decy(int y){
    	posy-=y;
    }
    
    public void sety(int y){
    	posy=y;
    }
    
    public int getspeed(){
    	return speed;
    }
    public int getdef(){
    	return def;
    }
    public int gethp(){
    	if(hp>0)
        	return hp;
    	else
    		return 0;
        }
    public int getp_damage(){
    	return p_damage;
    }
    public int getsk_1_damage(){
    	return sk_1_damage;
    }
    public int getsk_2_damage(){
    	return sk_2_damage;
    }
    public int getsk_3_damage(){
    	return sk_3_damage;
    }
    public int getrangex(){
    	return rangex;
    }
    public int getrangey(){
    	return rangey;
    }
    
    public int gethrange(){
    	return hrange;
    }
    
    public int getjrange(){    // hurt range
    	return jrange;
    }
    // get image
    
    public Image getld(){
    	return l_d[0];
    }
    
    public Image getlh(int i){
    	return l_h[i];
    }
    
    public Image getlk(int i){
    	return l_k[i];
    }
    
    public Image getlm(int i){
    	return l_m[i];
    }
    
    public Image getlp(int i){
    	return l_p[i];
    }
    
    public Image getls(){
    	return l_s[0];
    }
	
    public Image getls1(int i){
    	return l_s1[i];
    }
    public Image getls2(int i){
    	return l_s2[i];
    }
    public Image getls3(int i){
    	return l_s3[i];
    }
    
    // right
    
    public Image getrd(){
    	return r_d[0];
    }
    
    public Image getrh(int i){
    	return r_h[i];
    }
    
    public Image getrk(int i){
    	return r_k[i];
    }
    
    public Image getrm(int i){
    	return r_m[i];
    }
    
    public Image getrp(int i){
    	return r_p[i];
    }
    
    public Image getrs(){
    	return r_s[0];
    }
	
    public Image getrs1(int i){
    	return r_s1[i];
    }
    public Image getrs2(int i){
    	return r_s2[i];
    }
    public Image getrs3(int i){
    	return r_s3[i];
    }
    
// jump
    
    public Image getrj(int i){
    	return r_j[i];
    }
    
    public Image getlj(int i){
    	return l_j[i];
    }

}
