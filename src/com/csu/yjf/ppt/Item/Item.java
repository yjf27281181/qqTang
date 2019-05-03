package com.csu.yjf.ppt.Item;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Item {
	protected Point position;
	protected Category category;
	protected boolean dead = false;
	
	public abstract void paint(Graphics g);
	public abstract void handleCollisiion();
	
	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setCategory(Category category) {
		// TODO Auto-generated method stub
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
}
