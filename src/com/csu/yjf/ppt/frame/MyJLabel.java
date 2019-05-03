package com.csu.yjf.ppt.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.bubble.Bubble;
import com.csu.yjf.ppt.character.player.Direction;
import com.csu.yjf.ppt.character.player.Player;
import com.csu.yjf.ppt.util.ItemComparator;

public class MyJLabel extends JLabel{
	

	public static int Grid_WIDTH = MainFrame.MyJLabel_WIDTH/15;;
	public static int Grid_HEIGHT = MainFrame.MyJLabel_HEIGHT/13;
	
	
	List<Item> items = new ArrayList<Item>();
	
	List<Bubble> bubbles = new ArrayList<Bubble>();
	
	MapManager mapManager = new MapManager(this);
	
	Player player;
	/**
	 * 游戏的主窗体
	 */
	public MyJLabel(ImageIcon mapImage ,Player player) {
		super(mapImage);
		DrawingThread dThread = new DrawingThread();
		this.player = player;
		player.getItems(items);
		mapManager.createMap();
		dThread.start();
System.out.println("Grid_WIDTH:"+Grid_WIDTH+"   Grid_Height:"+Grid_HEIGHT);
	}
	
	/**
	 * 用来画图
	 * JFrame中双缓冲显现在这里消除
	 * @param g
	 */
	Image offScreenImage;
	public void paint(Graphics g) {
		boolean hasDrawPlayer = false;
		if(offScreenImage==null){
			offScreenImage = this.createImage(800,700);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		super.paint(gOffScreen);
		
		ItemComparator ItemComparator = new ItemComparator();
		items.sort(ItemComparator);
		
		for(int i = 0;i<items.size();i++){
			Item b = items.get(i);
			
			if(player.getPosition().y<b.getPosition().y){
				if(!hasDrawPlayer){
					player.paint(gOffScreen);
					hasDrawPlayer = true;
				}
			}
			b.paint(gOffScreen);
			if(i == items.size()-1){
				if(!hasDrawPlayer){
					player.paint(gOffScreen);
				}
			}
		}
		for(int i = 0;i<items.size();i++) {
			Item item = items.get(i);
			if(item.isDead()) {
				items.remove(item);
				i--;
			}
		}
		for(int i = 0;i<bubbles.size();i++) {
			Bubble bubble = bubbles.get(i);
			if(bubble.isDead()) {
				bubbles.remove(bubble);
				i--;
			}
		}
		if(items.size() == 0) player.paint(gOffScreen);
		gOffScreen.drawString("item数量:"+items.size(), 60, 80);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	
	/**
	 * 内部线程类，重画JLabel
	 * @author 我也是醉了
	 *
	 */
	private class DrawingThread extends Thread{
		@Override
		public void run() {
			while(true){
				repaint();
				//System.out.println(i++);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public List<Item> getitems() {
		return items;
	}

	public List<Bubble> getBubbles() {
		return bubbles;
	}
	
}
