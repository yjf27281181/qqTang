package com.csu.yjf.ppt.character.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.character.picture.PictureManager;
import com.csu.yjf.ppt.frame.MainFrame;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.PositionHelper;

public class Player {
	private int id=1;
	private String name;
	private int x=300,y=400;
	int oldX = x ; int oldY = y;
	
	private int position_x=0,position_y=0;
	
	
	Image portray;
	
	Point position;
	Point real_position ;
	
	private int speed = 2;
	int sugerCount =1;
	int power=1;
	
	ImageIcon imageIcon_portray = null;
	
	int count_changePicture=0;
	PictureManager pictureManager = new PictureManager();
	ArrayList<ImageIcon> SunWuKong_Front;
	ArrayList<ImageIcon> SunWuKong_Back;
	ArrayList<ImageIcon> SunWuKong_Left;
	ArrayList<ImageIcon> SunWuKong_Right;
	ArrayList<ImageIcon> SunWuKong_Stop;

	DirectionHelper directionHelper = new DirectionHelper();
	//Direction direction;
	
	boolean changeImageImmediately = false;
	private List<Item> items;
	
	public Player() {
		imageIcon_portray = new ImageIcon("src/Images/孙悟空/悟空正面1.png");  
		SunWuKong_Front = pictureManager.getSunWuKong_Front();
		SunWuKong_Back = pictureManager.getSunWuKong_Back();
		SunWuKong_Left = pictureManager.getSunWuKong_Left();
		SunWuKong_Right = pictureManager.getSunWuKong_Right();
		SunWuKong_Stop = pictureManager.getSunWuKong_Stop();
		
		position_x = imageIcon_portray.getIconWidth()/2 + x;
		position_y = imageIcon_portray.getIconHeight()/2 + y;
		position = PositionHelper.getPosition(position_x, position_y);
		real_position = PositionHelper.getLeftUpPosition(position);
System.out.println(imageIcon_portray.getIconWidth()+"  "+imageIcon_portray.getIconHeight());
		 
	}
	
	public void paint(Graphics g) {
		changePicture();
		portray = imageIcon_portray.getImage();
		run();
		g.drawImage(portray, x, y, null);
		changeImageImmediately = false;
		g.drawString("("+position.x+" , "+position.y+")", 50, 50);
	}
	private void changePicture() {
		count_changePicture+=10;
		
		if(count_changePicture/100>3) count_changePicture=0;
		if(count_changePicture%100==0 || changeImageImmediately){					//200ms换一次图
			int index = (int)count_changePicture/100;
			switch(directionHelper.getDirection()) {
				case UP:
					imageIcon_portray = SunWuKong_Back.get(index);
					break;
				case DOWN:
					imageIcon_portray = SunWuKong_Front.get(index);
					break;
				case LEFT:
					imageIcon_portray = SunWuKong_Left.get(index);
					break;
				case RIGHT:
					imageIcon_portray = SunWuKong_Right.get(index);
					break;
				case STOP:
					if(directionHelper.latestDirection==Direction.UP) imageIcon_portray = SunWuKong_Stop.get(0);
					if(directionHelper.latestDirection==Direction.DOWN) imageIcon_portray = SunWuKong_Stop.get(1);
					if(directionHelper.latestDirection==Direction.LEFT) imageIcon_portray = SunWuKong_Stop.get(2);
					if(directionHelper.latestDirection==Direction.RIGHT) imageIcon_portray = SunWuKong_Stop.get(3);
					break;
			}
		}
	}
	
	
	private void run() {
		
		
		position_x = imageIcon_portray.getIconWidth()/2 + x;
		position_y = imageIcon_portray.getIconHeight()-20 + y;
		
		
		position = PositionHelper.getPosition(position_x, position_y);
		
		oldX = x;
		oldY = y;
		switch(directionHelper.getDirection()) {
			case UP:
				this.y-=speed;
				break;
			case DOWN:
				this.y+=speed;
				break;
			case LEFT:
				this.x-=speed;
				break;
			case RIGHT:
				this.x+=speed;
				break;
			case STOP:
				break;
			
		}
		Point p = new Point();
		p.x = x;p.y = y+16;
		if(PositionHelper.ifCoverItem(items,p,this ) ||
				x + 44 > MainFrame.MyJLabel_WIDTH ||
				x < 0 ||
				y + 60 > MainFrame.MyJLabel_HEIGHT ||
				y < -16 ) {
			x = oldX;
			y = oldY;
			return;
		}
//System.out.println(PositionHelper.ifCoverItem(items,p ));
		

	}
	

	public DirectionHelper getDirectionHelper() {
		return directionHelper;
	}

	public void setChangeImageImmediately(boolean changeImageImmediately) {
		this.changeImageImmediately = changeImageImmediately;
	}

	public Point getPosition() {
		return position;
	}

	public void getItems(List<Item> items) {
		 this.items = items;
		
	}

	public int getId() {
		return id;
	}

	public void addSugerCount(int i) {
		// TODO Auto-generated method stub
		if(sugerCount<7) {
			sugerCount+=i;
		}
			
System.out.println("有"+sugerCount+"个炮弹");
	}
	public void subSugerCount(int i) {
		// TODO Auto-generated method stub
		if(sugerCount>0) {
			sugerCount-=i;
		}
			
System.out.println("有"+sugerCount+"个炮弹");
	}
	
	public void addSpeed(int i) {
		// TODO Auto-generated method stub
		if(speed < 5)
		speed+=i;
System.out.println("速度为"+speed);
	}

	public void addPower(int i) {
		// TODO Auto-generated method stub
		if(power<6)
			power+=1;
System.out.println("威力为"+power);
		
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSugerCount() {
		return sugerCount;
	}

}
