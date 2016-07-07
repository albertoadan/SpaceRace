package albert.com.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import albert.com.helpers.AssetManager;
import albert.com.screens.GameScreen;

public class SpaceRace extends Game {
	SpriteBatch batch;
	Texture img;




	
	@Override
	public void create () {
		AssetManager.load();
		setScreen(new GameScreen()) ;
	}

	@Override
	public void render () {
		super.render();
		//
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		 Gdx.app.log("LifeCycle", "resize(" + Integer.toString(width) + ", " +
				Integer.toString(height) + ")");
	}

	@Override
	public void pause () {
			super.pause();
		Gdx.app.log("LifeCycle", "pause()");
	}

	@Override
	public void resume () {
			super.resume();
		Gdx.app.log("LifeCycle", "resume()");
	}

	@Override
	public void dispose () {
			super.dispose();
		AssetManager.dispose();
		Gdx.app.log("LifeCycle", "dispose()");
	}





}
