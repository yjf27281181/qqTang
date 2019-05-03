package com.csu.yjf.ppt.frame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import com.csu.yjf.ppt.bubble.Bubble;
import com.csu.yjf.ppt.character.player.*;
import com.csu.yjf.ppt.util.MusicManager;
import com.csu.yjf.ppt.util.PositionHelper;

public class MainFrame extends JFrame {
	
	public static final int FRAME_WIDTH=650;
	public static final int FRAME_HEIGHT=850;
	
	
	public static final int MyJLabel_WIDTH = 615;
	public static final int MyJLabel_HEIGHT = 546;
	
	
	MyJLabel myJLabel;
	
	Player player = new Player();
	
	Bubble bubble;
	
	MusicManager musicManager = new MusicManager();
	
	public MainFrame() {
		this.setVisible(true);
		this.setResizable(true);
		this.getContentPane().setBackground(Color.BLACK);

		this.setTitle("qq堂");
		this.setBounds(200, 200, FRAME_HEIGHT, FRAME_WIDTH);
		this.addKeyListener(new keyMonitor());
		
		ImageIcon mapImage = new ImageIcon("src/Images/Map/草地.jpg");
		mapImage.setImage(mapImage.getImage().getScaledInstance(MyJLabel_WIDTH,MyJLabel_HEIGHT,Image.SCALE_DEFAULT));
		this.myJLabel = new MyJLabel(mapImage , player);  //背景和游戏窗体
		myJLabel.setBounds(5, 5, MyJLabel_WIDTH,MyJLabel_HEIGHT);
		this.getLayeredPane().add(myJLabel,2);
		
		
		this.setBackgroundImage();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
	}
	
	
	/**
	 * 设置背景图片
	 */
	public void setBackgroundImage() {
		ImageIcon backgroundImage = new ImageIcon("src/Images/BackgroundImage/游戏窗口.png");
		backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(820,610,Image.SCALE_DEFAULT));
		JLabel lbl_BackgroundImage = new JLabel(backgroundImage);
		lbl_BackgroundImage.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

System.out.println(backgroundImage.getIconWidth()+"  "+backgroundImage.getIconHeight());
		this.getLayeredPane().add(lbl_BackgroundImage,1);
		JPanel jPanel = (JPanel)this.getContentPane();
		jPanel.setOpaque(true);
	}

	/**
	 * 监听键盘按键事件
	 * @author 我也是醉了
	 *
	 */
	private class keyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode()==KeyEvent.VK_LEFT ){
				 player.getDirectionHelper().setPress_KEYLEFT(true);
				 if(player.getDirectionHelper().getLatestDirection()!=Direction.LEFT) {
					 player.setChangeImageImmediately(true);
					 repaint();
				 }
				 player.getDirectionHelper().setLatestDirection(Direction.LEFT);
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_RIGHT ){
				 player.getDirectionHelper().setPress_KEYRIGHT(true);
				 if(player.getDirectionHelper().getLatestDirection()!=Direction.RIGHT){
					 player.setChangeImageImmediately(true);
					 repaint();
				 }
				 player.getDirectionHelper().setLatestDirection(Direction.RIGHT);	 
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_UP ){
				 player.getDirectionHelper().setPress_KEYUP(true);
				 if(player.getDirectionHelper().getLatestDirection()!=Direction.UP){
					 player.setChangeImageImmediately(true);
					 repaint();
				 }
				 player.getDirectionHelper().setLatestDirection(Direction.UP);	 
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_DOWN ){
				 player.getDirectionHelper().setPress_KEYDOWN(true);
				 if(player.getDirectionHelper().getLatestDirection()!=Direction.DOWN){
					 player.setChangeImageImmediately(true);
					 repaint();
				 }
				 player.getDirectionHelper().setLatestDirection(Direction.DOWN);	 
				 return;
			 }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT ){
				 player.getDirectionHelper().setPress_KEYLEFT(false);
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_RIGHT ){
				 player.getDirectionHelper().setPress_KEYRIGHT(false);
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_UP ){
				 player.getDirectionHelper().setPress_KEYUP(false);
				 return;
			 }
			 if(e.getKeyCode()==KeyEvent.VK_DOWN ){
				 player.getDirectionHelper().setPress_KEYDOWN(false);
				 return;
			 }
			 
			 if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				  bubble = new Bubble(player ,myJLabel);
				 if(!PositionHelper.ifCoverItem(myJLabel.getBubbles(), bubble.getPosition())) {
					 if(player.getSugerCount()>0) {
						  player.subSugerCount(1);
						  myJLabel.getitems().add(bubble);
						  myJLabel.getBubbles().add(bubble);
						  musicManager.getSounds_putBubble().play();
					 }
					
				 }
				 
			 }
		}
		
	}

	
}
