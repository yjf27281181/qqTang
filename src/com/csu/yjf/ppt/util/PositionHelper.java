package com.csu.yjf.ppt.util;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.bubble.Bubble;
import com.csu.yjf.ppt.character.player.Player;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.goods.Bottle;
import com.csu.yjf.ppt.goods.Goods;
import com.csu.yjf.ppt.goods.Shoe;
import com.csu.yjf.ppt.goods.Suger;

public class PositionHelper {
	
	
	public static Point getPosition(int x,int y) {
		Point position = new Point();
		int x_Left = x/MyJLabel.Grid_WIDTH+1;
		
		int x_Right = x_Left+1;
		if(x-x_Left*MyJLabel.Grid_WIDTH < x_Right*MyJLabel.Grid_WIDTH-x)
			position.x=x_Left;
		else {
			position.x = x_Right;
		}
		
		int y_Up = y/MyJLabel.Grid_HEIGHT +1;
		int y_Down = y_Up+1;
		if(y-y_Up*MyJLabel.Grid_HEIGHT < y_Down*MyJLabel.Grid_HEIGHT-y)
			position.y=y_Up;
		else {
			position.y = y_Down;
		}
		
			
		return position;
	}
	
	public static Point getRightDownPosition(Image image,Point position) {
		int height = image.getHeight(null);
//System.out.println("ImageHeight:" +height);
		if(height<0) height=48;
		Point point = new Point();
		point.x = (position.x-1)*MyJLabel.Grid_WIDTH;
		point.y = position.y*MyJLabel.Grid_HEIGHT-height;
		return point;
	}
	public static Point getRightDownPosition(ImageIcon imageIcon,Point position) {
		int height = imageIcon.getIconHeight();
		int width = imageIcon.getIconWidth();
		Point point = new Point();
		point.x = position.x*MyJLabel.Grid_WIDTH - width;
		point.y = position.y*MyJLabel.Grid_HEIGHT-height;
		return point;
	}
	

	public static Point getLeftUpPosition(Point position) {
		Point p =new Point();
		p.x = (position.x-1)*MyJLabel.Grid_WIDTH;
		p.y = (position.y-1)*MyJLabel.Grid_HEIGHT;
		return p;
	}
	
	public static Point getLeftUpPosition(int Px,int Py) {
		Point p = new Point();
		p.x = Px; p.y = Py;
		return getLeftUpPosition(p);
	}
	
	/**
	 * 人与物体碰撞
	 * @param items
	 * @param p1
	 * @param player
	 * @return
	 */
	public static boolean ifCoverItem(List<Item> items ,Point p1,Player player) {
		for(int i=0 ; i<items.size();i++) {
			Item item = items.get(i);
//System.out.println(p1.x+"  "+p1.y+"  "+item.getPosition().x+"  "+item.getPosition().y);
			Point p2 = PositionHelper.getLeftUpPosition(item.getPosition());
			if(item.getCategory() == Category.BUBBLE) {

				Bubble bubble = (Bubble)item;
				if(!ifTwoRecCrossed(p1, p2)&&bubble.getPlayerId() == player.getId() ) bubble.setHasLeaved(true);  //泡泡的id是player的id，且发生了碰撞
				if(ifTwoRecCrossed(p1, p2)&& bubble.getPlayerId() != player.getId()) {
					return true;	//发生了碰撞，但是id不同
				}
				/*if(ifTwoRecCrossed(p1, p2)&&bubble.getPlayerId() == player.getId()&&!bubble.isHasLeaved()) {
					return false;	//发生了碰撞，id相同，没有离开过
				}*/	
			if(ifTwoRecCrossed(p1, p2)&&bubble.getPlayerId() == player.getId()&& bubble.isHasLeaved()) {
					return true;		//发生了碰撞，id相同，离开过了
				}

			} else if(ifTwoRecCrossed(p1, p2)){
				if(item.getCategory() == Category.GOODS) {
					MusicManager musicManager = new MusicManager();
					
					if(item instanceof Suger) {
						Suger suger = (Suger)item;
						if(suger.getBrick().isDead()) {
							suger.handleCollisiion();
							player.addSugerCount(1);
							musicManager.getSounds_getGoods().play();
						}
						
					} 
					if(item instanceof Bottle){
						Bottle bottle = (Bottle)item;
						if(bottle.getBrick().isDead()) {
							bottle.handleCollisiion();
							player.addPower(1);
							musicManager.getSounds_getGoods().play();
						}
						
					}
					if(item instanceof Shoe){
						Shoe shoe = (Shoe)item;
						if(shoe.getBrick().isDead()) {
							shoe.handleCollisiion();
							player.addSpeed(1);
							musicManager.getSounds_getGoods().play();
						}
					}
				} else {
					return true;
				}
				
			}
			
		}
		return false;
	}
	
	/**
	 * 泡泡和泡泡碰撞
	 * @param items
	 * @param p1
	 * @return
	 */
	public static boolean ifCoverItem(List<Bubble> bubbles ,Point p1) {
		for(int i=0 ; i<bubbles.size();i++) {
			Bubble bubble = bubbles.get(i);
			if(p1.equals(bubble.getPosition()))
				return true;
		}
		return false;
	}
	
	
	
	/**
	 * 判断矩形是否相交
	 * @param p1 第一个顶点
	 * @param p2 第二个顶点
	 * @return
	 */
	public static boolean ifTwoRecCrossed(Point p1,Point p2) {
//System.out.println(p1.x+" "+p1.y+" "+p2.x+"  "+p2.y);
		int up_line = p1.y<p2.y ? p1.y:p2.y;
		int down_line = p1.y > p2.y ? p1.y+40:p2.y+40;
		int left_line = p1.x < p2.x ? p1.x:p2.x;
		int right_line = p1.x > p2.x ? p1.x+40:p2.x+40;
		
		if(down_line-up_line<=74&&right_line-left_line<=74) return true;
		return false;
	}
	
	/**
	 * 判断爆炸是否与items碰撞 
	 */
	public static  boolean hasCollision(Point position ,List<Item> items) {
		for(int i=0;i<items.size();i++) {
			Item item = items.get(i);
			if(position.equals(item.getPosition())) {
				if(item instanceof Goods ) {
					Goods good = (Goods)item;
					if(!good.getBrick().isDead()){
						continue;
					}
					item.handleCollisiion();
				} else {
					item.handleCollisiion();
					return true;
				}
				
			}
		}
		return false;
		
	}
}
