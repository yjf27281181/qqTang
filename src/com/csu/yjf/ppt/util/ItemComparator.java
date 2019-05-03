package com.csu.yjf.ppt.util;

import java.util.Comparator;

import com.csu.yjf.ppt.Item.Category;
import com.csu.yjf.ppt.Item.Item;
import com.csu.yjf.ppt.bubble.Bubble;

public class ItemComparator implements Comparator<Item>{

	@Override
	public int compare(Item b1, Item b2) {
		if(b1.getPosition().y<b2.getPosition().y) return -1;
		if(b1.getPosition().y>b2.getPosition().y) return 1;
		if(b1.getPosition().x>b2.getPosition().x) return -1;
		if(b1.getPosition().x<b2.getPosition().x) return 1;
		if(b1.getCategory() == Category.GOODS && b2.getCategory() !=Category.GOODS) return -1;
		if(b1.getCategory() != Category.GOODS && b2.getCategory() ==Category.GOODS) return 1;
		return 0;
	}

}
