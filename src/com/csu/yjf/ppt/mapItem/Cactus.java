package com.csu.yjf.ppt.mapItem;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.frame.MyJLabel;
import com.csu.yjf.ppt.util.PositionHelper;

public class Cactus extends MapItem{

	public Cactus(Point position) {
		super(position);
		imageIcon = new ImageIcon("src/Images/Decoration/œ…»À’∆.png");
		image = imageIcon.getImage();
	}

	@Override
	public void paint(Graphics g) {
		real_position = PositionHelper.getLeftUpPosition(position);
		g.drawImage(image, real_position.x-2, real_position.y-30,MyJLabel.Grid_WIDTH+4,MyJLabel.Grid_HEIGHT+30 ,null );
		
		
	}

	@Override
	public void handleCollisiion() {
		
	}

}
