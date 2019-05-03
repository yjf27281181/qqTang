package com.csu.yjf.ppt.bubble;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.csu.yjf.ppt.frame.MyJLabel;

public class ExplodePiectureManager {
	
	List<Image> explode_Images1 = new ArrayList<Image>();
	List<Image> explode_Images2 = new ArrayList<Image>();
	List<Image> explode_Images3 = new ArrayList<Image>();
	List<Image> explode_vertex = new ArrayList<Image>();
	public ExplodePiectureManager() {
		ImageIcon explode_Icon = new ImageIcon("src/Images/Exploding/1_±¬Õ¨ÉÏ.png");
		Image explode_up1 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images1.add(explode_up1);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/1_±¬Õ¨ÏÂ.png");
		Image explode_down1 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images1.add(explode_down1);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/1_±¬Õ¨×ó.png");
		Image explode_left1 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images1.add(explode_left1);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/1_±¬Õ¨ÓÒ.png");
		Image explode_right1 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images1.add(explode_right1);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/±¬Õ¨ÖÐ.png");
		Image explode_center = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images1.add(explode_center);
		
		
		
		explode_Icon = new ImageIcon("src/Images/Exploding/2_±¬Õ¨ÉÏ.png");
		Image explode_up2 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images2.add(explode_up2);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/2_±¬Õ¨ÏÂ.png");
		Image explode_down2 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images2.add(explode_down2);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/2_±¬Õ¨×ó.png");
		Image explode_left2 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images2.add(explode_left2);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/2_±¬Õ¨ÓÒ.png");
		Image explode_right2 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images2.add(explode_right2);
		
		explode_Images2.add(explode_center);
		
		
		
		
		
		
		
		explode_Icon = new ImageIcon("src/Images/Exploding/3_±¬Õ¨ÉÏ.png");
		Image explode_up3 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images3.add(explode_up3);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/3_±¬Õ¨ÏÂ.png");
		Image explode_down3 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images3.add(explode_down3);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/3_±¬Õ¨×ó.png");
		Image explode_left3 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images3.add(explode_left3);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/3_±¬Õ¨ÓÒ.png");
		Image explode_right3 = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_Images3.add(explode_right3);
		
		explode_Images3.add(explode_center);
		
		
		
		
		
		
		explode_Icon = new ImageIcon("src/Images/Exploding/±¬Õ¨ÉÏ¶¥µã.png");
		Image explode_upVertex = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_vertex.add(explode_upVertex);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/±¬Õ¨ÏÂ¶¥µã.png");
		Image explode_downVertex = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_vertex.add(explode_downVertex);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/±¬Õ¨×ó¶¥µã.png");
		Image explode_leftVertex = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_vertex.add(explode_leftVertex);
		
		explode_Icon = new ImageIcon("src/Images/Exploding/±¬Õ¨ÓÒ¶¥µã.png");
		Image explode_rightVertex = explode_Icon.getImage().getScaledInstance(MyJLabel.Grid_WIDTH, MyJLabel.Grid_HEIGHT, Image.SCALE_DEFAULT);
		explode_vertex.add(explode_rightVertex);
		
		explode_vertex.add(explode_center);
		
		
	}
	public List<Image> getExplode_Images1() {
		return explode_Images1;
	}
	public List<Image> getExplode_Images2() {
		return explode_Images2;
	}
	public List<Image> getExplode_vertex() {
		return explode_vertex;
	}
	public List<Image> getExplode_Images3() {
		return explode_Images3;
	}
}
