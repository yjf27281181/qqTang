package com.csu.yjf.ppt.frame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.goods.Bottle;
import com.csu.yjf.ppt.goods.Shoe;
import com.csu.yjf.ppt.goods.Suger;
import com.csu.yjf.ppt.mapItem.Brick;
import com.csu.yjf.ppt.mapItem.Cactus;
import com.csu.yjf.ppt.mapItem.SolidBrick;
import com.csu.yjf.ppt.mapItem.Vase;

public class MapManager {
	
	MyJLabel myJLabel;
	
	List<Point> brickHasGoods = new ArrayList<Point>();
	
	Random random = new Random();
	
	Point[][] points = new Point[16][14];
	
	public MapManager(MyJLabel myJLabel) {
		this.myJLabel = myJLabel;
		for(int i=1;i<16;i++) {
			for(int j=1;j<14 ;j++) {
				points[i][j] = new Point(i,j);
			}
		}
	}
	public void createMap() {
		
		/*Point p = new Point(3,3);
		Brick b = new Brick(p ,myJLabel.items);
		myJLabel.getitems().add(b);
		
		Suger suger = new Suger(p,myJLabel.items,b);
		myJLabel.items.add(suger);*/
		Brick brick = new Brick(points[1][1],myJLabel.items);
		myJLabel.items.add(brick);
		
		/**
		 * 普通砖块
		 */
		brick = new Brick(points[3][1],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[13][1],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][1],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[1][3],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][3],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[6][4],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[8][4],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[10][4],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[1][5],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[5][5],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[7][5],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[9][5],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[11][5],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][5],myJLabel.items);
		myJLabel.items.add(brick);
		
		brick = new Brick(points[6][6],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[10][6],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[1][7],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[5][7],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[11][7],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][7],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[2][8],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[6][8],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[8][8],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[10][8],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[14][8],myJLabel.items);
		myJLabel.items.add(brick);
		
		brick = new Brick(points[1][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[3][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[7][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[9][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[13][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][9],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[2][10],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[4][10],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[12][10],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[14][10],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[1][11],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[5][11],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[11][11],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][11],myJLabel.items);
		myJLabel.items.add(brick);
		
		brick = new Brick(points[4][12],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[6][12],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[10][12],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[12][12],myJLabel.items);
		myJLabel.items.add(brick);
		
		brick = new Brick(points[1][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[5][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[7][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[9][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[11][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[13][13],myJLabel.items);
		myJLabel.items.add(brick);
		brick = new Brick(points[15][13],myJLabel.items);
		myJLabel.items.add(brick);
		
		
		
		
		
		
		
		/**
		 * 普通砖块红
		 */
		Brick brickRed = new Brick(points[2][1],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[4][1],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[8][1],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[12][1],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[14][1],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][2],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[3][2],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[13][2],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][2],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[2][3],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[6][3],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[10][3],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[14][3],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[5][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[7][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[9][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[11][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][4],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		
		brickRed = new Brick(points[4][5],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[6][5],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[8][5],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[10][5],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[12][5],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][6],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[5][6],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[11][6],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][6],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[4][7],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[6][7],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[10][7],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[12][7],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][8],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[7][8],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[9][8],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][8],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[2][9],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[6][9],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[8][9],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[10][9],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[14][9],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][10],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[3][10],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[13][10],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][10],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[2][11],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[4][11],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[12][11],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[14][11],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[1][12],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[5][12],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[11][12],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[15][12],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[4][13],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[6][13],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[8][13],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[10][13],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		brickRed = new Brick(points[12][13],myJLabel.items).changePicture();
		myJLabel.items.add(brickRed);
		
		/**
		 * 加入物品
		 */
		addGoods();
		
		/**
		 * 仙人掌
		 */
		Cactus cactus = new Cactus(points[7][7]);
		myJLabel.items.add(cactus);
		cactus = new Cactus(points[8][7]);
		myJLabel.items.add(cactus);
		cactus = new Cactus(points[9][7]);
		myJLabel.items.add(cactus);
		
		/**
		 * 花坛
		 */
		Vase vase = new Vase(points[2][2]);
		myJLabel.items.add(vase);
		vase = new Vase(points[14][2]);
		myJLabel.items.add(vase);
		vase = new Vase(points[2][12]);
		myJLabel.items.add(vase);
		vase = new Vase(points[14][12]);
		myJLabel.items.add(vase);
		vase = new Vase(points[7][6]);
		myJLabel.items.add(vase);
		vase = new Vase(points[8][6]);
		myJLabel.items.add(vase);
		vase = new Vase(points[9][6]);
		myJLabel.items.add(vase);
	}
	
	private void addGoods() {
		int number = 0;
		for(int i=0;i<15 ; ) {
			Point p = new Point(random.nextInt(14) ,random.nextInt(16));
			for(int j=0; j< myJLabel.items.size();j++) {
				Item item = myJLabel.items.get(j);
				if(item.getCategory() == Category.BRICK && item.getPosition().equals(p)) {
					Brick brick = (Brick)myJLabel.getitems().get(j);
					if(!brick.isHasGoods()) {
						Suger suger = new Suger(p,myJLabel.items,brick);
						myJLabel.items.add(suger);
						brick.setHasGoods(true);
						i++ ;
					}
				}
			}
		}
		
		for(int i=0;i<15 ; ) {
			Point p = new Point(random.nextInt(14) ,random.nextInt(16));
			for(int j=0; j< myJLabel.items.size();j++) {
				Item item = myJLabel.items.get(j);
				if(item.getCategory() == Category.BRICK && item.getPosition().equals(p)) {
					Brick brick = (Brick)myJLabel.getitems().get(j);
					if(!brick.isHasGoods()) {
						Bottle bottle = new Bottle(p,myJLabel.items,brick);
						myJLabel.items.add(bottle);
						brick.setHasGoods(true);
						i++ ;
					}
				}
			}
		}
		
		for(int i=0;i<15 ; ) {
			Point p = new Point(random.nextInt(14) ,random.nextInt(16));
			for(int j=0; j< myJLabel.items.size();j++) {
				Item item = myJLabel.items.get(j);
				if(item.getCategory() == Category.BRICK && item.getPosition().equals(p)) {
					Brick brick = (Brick)myJLabel.getitems().get(j);
					if(!brick.isHasGoods()) {
						Shoe shoe = new Shoe(p,myJLabel.items,brick);
						myJLabel.items.add(shoe);
						brick.setHasGoods(true);
						i++ ;
					}
				}
			}
		}
		
	}
}
