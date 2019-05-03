package com.csu.yjf.ppt.mapItem;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.PositionHelper;

public class Vase extends MapItem{

	public Vase(Point position) {
		super(position);
		imageIcon = new ImageIcon("src/Images/Decoration/花瓶.png");
		image = imageIcon.getImage();
	}

	@Override
	public void handleCollisiion() {
		System.out.println("我就是牛逼");
		
	}

	@Override
	public void paint(Graphics g) {
		real_position = PositionHelper.getLeftUpPosition(position);
		g.drawImage(image, real_position.x-2, real_position.y-20,MyJLabel.Grid_WIDTH+4,MyJLabel.Grid_HEIGHT+20 ,null );
		
	}

}
