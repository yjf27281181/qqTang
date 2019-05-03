package com.csu.yjf.ppt.bubble;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.PositionHelper;

public class Exploding {
	List<Image> explode_Images ;
	List<Image> explode_imagesVertex;
	
	ExplodePiectureManager explodePictureManager;
	Bubble bubble;
	Point real_position;
	Point position;
	Point temp_realPosition;
	
	int explodeTimer = 0;
	
	List<Item> items ;
	
	
	
	public Exploding (Bubble bubble) {
		this.bubble = bubble;
		explodePictureManager = new ExplodePiectureManager();
		explode_Images = explodePictureManager.getExplode_Images1();
		explode_imagesVertex = explodePictureManager.getExplode_vertex();
		position = bubble.getPosition();
		items = bubble.jLabel.getitems();
		
		real_position = new Point();
		real_position.x = PositionHelper.getLeftUpPosition(bubble.position).x;
		real_position.y = PositionHelper.getLeftUpPosition(bubble.position).y;
		
		//temp_realPosition = new Point();
	}

	public void paint(Graphics g) {
	
		explodeTimer+=20;
		if((explodeTimer>500&&explodeTimer<600)||explodeTimer<100){
			if(explodeTimer<=40) explode_Images=explodePictureManager.getExplode_Images1();
			if(explodeTimer>60) explode_Images=explodePictureManager.getExplode_Images2();
			//return csu_yjf;
			
			g.drawImage(explode_Images.get(4),real_position.x, real_position.y, null);
			if(bubble.power != 1) paintPicture(1 ,g);
			//paintPicture(1 ,g);
		}
		
		if(explodeTimer>100 && explodeTimer<500){
			if(explodeTimer<200) explode_Images=explodePictureManager.getExplode_Images1();
			if(explodeTimer>200&&explodeTimer<400) explode_Images=explodePictureManager.getExplode_Images2();
			if(explodeTimer>200&&explodeTimer>400) explode_Images=explodePictureManager.getExplode_Images3();
			g.drawImage(explode_Images.get(4),real_position.x, real_position.y, null);
			paintPicture(bubble.power ,g);
		}
		
		if(explodeTimer>600){ 
			bubble.setDead(true);
		}
			
			
	}
		
		//g.drawImage(explode_Images.get(4),real_position.x, real_position.y, null);

		public void paintPicture(int power ,Graphics g) {
			
			boolean left_stop = false;
			boolean right_stop = false;
			boolean up_stop = false;
			boolean down_stop = false;
			for(int i=1;i<=bubble.power;i++){
				if(i==bubble.power) explode_Images = explodePictureManager.getExplode_vertex();
				g.drawImage(explode_Images.get(4),real_position.x, real_position.y, null);
				
				
				Point temp_Position =null;
				if(!up_stop){
					temp_Position = new Point(position.x,position.y-i);
					if(PositionHelper.hasCollision(temp_Position, items)){
						up_stop = true;
					} else {
						temp_realPosition = PositionHelper.getLeftUpPosition(position.x, position.y-i);
						g.drawImage(explode_Images.get(0), temp_realPosition.x, temp_realPosition.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, null);
					}
				}
				
				if(!down_stop) {
					temp_Position = new Point(position.x,position.y+i);
					if(PositionHelper.hasCollision(temp_Position, items) ) {
						down_stop = true;
					} else  {
						temp_realPosition = PositionHelper.getLeftUpPosition(position.x, position.y+i);
						g.drawImage(explode_Images.get(1), temp_realPosition.x, temp_realPosition.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, null);
					}
				}
				
				if(!left_stop) {
					temp_Position = new Point(position.x-i,position.y);
					if(PositionHelper.hasCollision(temp_Position, items)) {
						left_stop = true;
					} else {
						temp_realPosition = PositionHelper.getLeftUpPosition(position.x-i, position.y);
						g.drawImage(explode_Images.get(2), temp_realPosition.x, temp_realPosition.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, null);
					}
				}
				
				if(!right_stop) {
					temp_Position = new Point(position.x+i,position.y);
					if(PositionHelper.hasCollision(temp_Position, items) ) {
						right_stop = true;
					} else  {
						temp_realPosition = PositionHelper.getLeftUpPosition(position.x+i, position.y);
						g.drawImage(explode_Images.get(3), temp_realPosition.x, temp_realPosition.y, MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, null);
					
					}
				}
			
			}
		}
	
}
