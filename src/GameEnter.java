
import java.awt.Graphics;

import com.csu.yjf.ppt.character.player.Player;
import com.csu.yjf.ppt.frame.MainFrame;
import com.csu.yjf.ppt.util.MusicManager;

public class GameEnter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame mainFrame = new MainFrame();
		MusicManager musicManager = new MusicManager();
		musicManager.getBackgroudMusic().loop();
	}
}
