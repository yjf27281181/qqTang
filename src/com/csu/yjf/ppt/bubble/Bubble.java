package com.csu.yjf.ppt.bubble;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.character.player.Player;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.MusicManager;
import com.csu.yjf.ppt.util.PositionHelper;

public class Bubble extends Item{
	ImageIcon bubble ;
	Image bubble1 ;
	Image bubble2 ;
	Image bubble3 ;
	Image bubble4 ;
	
	Category category = Category.BUBBLE;
	List<Image> bubbleImages = new ArrayList<Image>();
	
	int timeCounter = 0;
	
	Image currentImage;
	//bubble.setImage(bubble.getImage().getScaledInstance(820,610,Image.SCALE_DEFAULT));
	Player player;
	Point position;
	Point rightDownPoint;
	
	MusicManager musicManager;
	
	boolean bomb = false;
	Exploding explode;
	int explodeTimer = 0;
	
	int power = 1;
	
	MyJLabel jLabel;
	
	boolean addSugerCount = false;
	
	boolean hasLeaved=false;
	
	int playerId;
	public Bubble(Player player ,MyJLabel jLabel) {
		bubble = new ImageIcon("src/Images/Bubble/西瓜1.png");
		bubble1 = bubble.getImage();
		bubble2 = bubble.getImage().getScaledInstance(42, 44,Image.SCALE_DEFAULT);
		bubble3 = bubble.getImage();
		bubble4 = bubble.getImage().getScaledInstance(38, 52,Image.SCALE_DEFAULT);
		
		this.player = player;
		position = player.getPosition();
		playerId=player.getId();
		power = player.getPower();
		
		super.setPosition(position); //设置item的position
		super.setCategory(category);
		bubbleImages.add(bubble1);bubbleImages.add(bubble2);bubbleImages.add(bubble3);bubbleImages.add(bubble4);
		//currentImage=bubble4;
		rightDownPoint = PositionHelper.getRightDownPosition(bubble4, position);
		this.jLabel = jLabel;
		musicManager = new MusicManager();
		explode = new Exploding(this);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		if(!bomb) {
			timeCounter+=20;
			explodeTimer += 20;
			if(timeCounter>=400) timeCounter = 0;
			if(timeCounter%100==0) {
				int index =  timeCounter/100;
				currentImage = bubbleImages.get(index);
				rightDownPoint = PositionHelper.getRightDownPosition(currentImage,position);
			}	
		//System.out.println(position.x+"  "+position.y);
		g.drawImage(currentImage, rightDownPoint.x, rightDownPoint.y, null);
			if(explodeTimer>=3000) {  //三秒后爆炸
				musicManager.getSounds_bubbleBomb().play();
				bomb = true;  
			}
		}
		
		if(bomb) {
			if(!addSugerCount) {
				player.addSugerCount(1);
				addSugerCount = true;
			}
			
			explode.paint(g);
		}
		
	}

	public Point getPosition() {
		return position;
	}

	public boolean isHasLeaved() {
		return hasLeaved;
	}

	public void setHasLeaved(boolean hasLeaved) {
		this.hasLeaved = hasLeaved;
	}

	public int getPlayerId() {
		return playerId;
	}

	@Override
	public void handleCollisiion() {
		bomb = true;
	}
}
