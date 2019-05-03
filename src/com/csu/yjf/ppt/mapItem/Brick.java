package com.csu.yjf.ppt.mapItem;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.PositionHelper;

public class Brick extends MapItem{
	
	Point real_Position=null;
	ImageIcon imageIcon0 ;
	ImageIcon imageIcon1 ;
	ImageIcon imageIcon2 ;
	ImageIcon imageIcon3 ;
	Image brickImage;
	boolean dead= false;
	
	boolean hasGoods = false;
	
		
	boolean broken = false;
	//BufferedImage brick1;
	
	int timer = 0;
	
	public Brick(Point position ,List<Item> items) {
		super(position);
		imageIcon0 = new ImageIcon("src/Images/Brick/Ô­Ê¼×©¿é.png");
		//brick1 = imageIcon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, imageIcon.getIconHeight(), Image.SCALE_DEFAULT);
		imageIcon1 = new ImageIcon("src/Images/Brick/×©¿éÆÆËé1.png");
		imageIcon2 = new ImageIcon("src/Images/Brick/×©¿éÆÆËé2.png");
		imageIcon3 = new ImageIcon("src/Images/Brick/×©¿éÆÆËé3.png");
		brickImageIcons = new ArrayList<ImageIcon>();
		brickImageIcons.add(imageIcon0);
		brickImageIcons.add(imageIcon1);
		brickImageIcons.add(imageIcon2);
		brickImageIcons.add(imageIcon3);
		brickImage = brickImageIcons.get(0).getImage();
		real_Position = PositionHelper.getRightDownPosition(brickImageIcons.get(0), position);
		category = Category.BRICK;

	}
	
	public void paint(Graphics g) {
		if(!broken) {
			g.drawImage(brickImage,real_Position.x-2, real_Position.y+10, MyJLabel.Grid_WIDTH+5,brickImageIcons.get(0).getIconHeight() ,null);
			return;
		} else {
			timer+=20;
			if(timer<100) {
				brickImage = brickImageIcons.get(1).getImage();
				real_Position = PositionHelper.getLeftUpPosition(position);
				g.drawImage(brickImage,real_Position.x, real_Position.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT+10 ,null);

			}
			if(timer>=100 &&timer<300) {
				brickImage = brickImageIcons.get(2).getImage();
				//real_Position = PositionHelper.getRightDownPosition(brickImageIcons.get(1), position);
				real_Position = PositionHelper.getLeftUpPosition(position);
				g.drawImage(brickImage,real_Position.x, real_Position.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT+13 ,null);

			}
			
			if(timer>=300 &&timer<400) {
				brickImage = brickImageIcons.get(3).getImage();
				//real_Position = PositionHelper.getRightDownPosition(brickImageIcons.get(1), position);
				real_Position = PositionHelper.getLeftUpPosition(position);
				g.drawImage(brickImage,real_Position.x, real_Position.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT+15 ,null);

			}
			if(timer>=700) {	
				dead = true;
			}
		}
		
		
	}

	@Override
	public void handleCollisiion() {
		broken = true;
		
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public Brick changePicture() {
		imageIcon0 = new ImageIcon("src/Images/Brick/Ô­Ê¼×©¿éºì.png");
		brickImage = imageIcon0.getImage();
		return this;
	}

	public boolean isHasGoods() {
		return hasGoods;
	}

	public void setHasGoods(boolean hasGoods) {
		this.hasGoods = hasGoods;
	}

}
