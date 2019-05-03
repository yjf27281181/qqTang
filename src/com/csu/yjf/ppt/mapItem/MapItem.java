package com.csu.yjf.ppt.mapItem;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;

public abstract class MapItem extends Item{
	ImageIcon imageIcon ;
	Image image;
	Point real_position;
	List<ImageIcon> brickImageIcons;
	
	public MapItem(Point position) {
		super.setPosition(position);
		super.setCategory(Category.ITEM);
	}

}
