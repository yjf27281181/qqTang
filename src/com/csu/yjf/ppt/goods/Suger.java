package com.csu.yjf.ppt.goods;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.mapItem.Brick;
import com.csu.yjf.ppt.util.PositionHelper;

public class Suger extends Goods{
	public Suger(Point position, List<Item> items,Brick brick) {
		super(position, items ,brick);
		goodsCategory = GoodsCategory.SUGER;
		imageIcon= new ImageIcon("src/Images/Goods/µÀ¾ß1.png");
		image = imageIcon.getImage();
	}

	int timer = 0;
	
	@Override
	public void paint(Graphics g) {
		if(!hasPicked) {
			timer+=20 ;
			if(timer>600) timer =0 ;
			int i = 0;
			if(timer>=300) i=5;
			g.drawImage(image, real_position.x, real_position.y+5-i,MyJLabel.Grid_WIDTH-3,MyJLabel.Grid_HEIGHT-3, null);
		}
			
	}

}
