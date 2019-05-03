package com.csu.yjf.ppt.character.player;

public class DirectionHelper {
	Direction direction  = Direction.STOP;
	Direction preDirection = Direction.STOP; //用来判断停住时用哪张图片
	
	boolean press_KEYUP = false;
	boolean press_KEYDOWN = false;
	boolean press_KEYLEFT = false;
	boolean press_KEYRIGHT = false;
	
	
	Direction latestDirection = Direction.STOP;
	
	/**
	 * 得到当前的方向
	 * @return
	 */
	public Direction getDirection() {
		if(press_KEYUP&&!press_KEYDOWN&&!press_KEYLEFT&&!press_KEYRIGHT) {
			direction = Direction.UP;
			return Direction.UP;
		}
		if(!press_KEYUP&&press_KEYDOWN&&!press_KEYLEFT&&!press_KEYRIGHT) {
			direction = Direction.DOWN;
			return Direction.DOWN;
		}
		if(!press_KEYUP&&!press_KEYDOWN&&press_KEYLEFT&&!press_KEYRIGHT) {
			direction = Direction.LEFT;
			return Direction.LEFT;
		}
		if(!press_KEYUP&&!press_KEYDOWN&&!press_KEYLEFT&&press_KEYRIGHT) {
			direction = Direction.RIGHT;
			return Direction.RIGHT;
		}
		if(!press_KEYUP&&!press_KEYDOWN&&!press_KEYLEFT&&!press_KEYRIGHT) {
			direction = Direction.STOP;
			return Direction.STOP;
		}
		
		direction = latestDirection;
		
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public void setPreDirection(Direction preDirection) {
		this.preDirection = preDirection;
	}
	public boolean isPress_KEYUP() {
		return press_KEYUP;
	}
	public void setPress_KEYUP(boolean press_KEYUP) {
		this.press_KEYUP = press_KEYUP;
	}
	public boolean isPress_KEYDOWN() {
		return press_KEYDOWN;
	}
	public void setPress_KEYDOWN(boolean press_KEYDOWN) {
		this.press_KEYDOWN = press_KEYDOWN;
	}
	public boolean isPress_KEYLEFT() {
		return press_KEYLEFT;
	}
	public void setPress_KEYLEFT(boolean press_KEYLEFT) {
		this.press_KEYLEFT = press_KEYLEFT;
	}
	public boolean isPress_KEYRIGHT() {
		return press_KEYRIGHT;
	}
	public void setPress_KEYRIGHT(boolean press_KEYRIGHT) {
		this.press_KEYRIGHT = press_KEYRIGHT;
	}

	public Direction getLatestDirection() {
		return latestDirection;
	}

	public void setLatestDirection(Direction latestDirection) {
		this.latestDirection = latestDirection;
	}
}
