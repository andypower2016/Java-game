
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.util.concurrent.*;

import javax.swing.ImageIcon;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;

public class Base {
	
    public static void main(String []args){
    	 Image i = new ImageIcon("bin/image/menu.jpg").getImage();
    	 Menu m = new Menu(i);
    	 m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 m.setExtendedState(m.getExtendedState() | Frame.MAXIMIZED_BOTH);
         m.setVisible(true);

     }
	

}