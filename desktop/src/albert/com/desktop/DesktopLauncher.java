package albert.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import albert.com.utils.Settings;
import albert.com.utils.SpaceRace;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Race";
		config.width = Settings.GAME_WIDTH*2;
		config.height = Settings.GAME_HEIGHT*2;
		new LwjglApplication(new SpaceRace(), config);
	}
}
