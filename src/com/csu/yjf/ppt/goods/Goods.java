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

public abstract class Goods extends Item {
	
	boolean hasPicked = false;
	GoodsCategory goodsCategory;
	ImageIcon imageIcon ;
	Image image ;
	Point real_position;
	Brick brick;
	
	public Goods(Point position , List<Item> items ,Brick brick) {
		this.position = position;
		this.setCategory(Category.GOODS);
		this.brick = brick;
		real_position = PositionHelper.getLeftUpPosition(position);
	}
	
	

	public boolean isHasPicked() {
		return hasPicked;
	}

	public void setHasPicked(boolean hasPicked) {
		this.hasPicked = hasPicked;
	}

	@Override
	public void handleCollisiion() {
		// TODO Auto-generated method stub
		hasPicked = true;
		setDead(true);
	}



	public Brick getBrick() {
		return brick;
	}
}
