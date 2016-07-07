package albert.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

import albert.com.helpers.AssetManager;
import albert.com.helpers.InputHandler;
import albert.com.objects.Asteroid;
import albert.com.objects.ScrollHandler;
import albert.com.objects.SpaceCraft;
import albert.com.utils.Settings;

/**
 * Created by Albert on 20/11/2015.
 */



public class GameScreen implements Screen {

    private Stage stage;
    private SpaceCraft spacecraft;
    private ScrollHandler scrollhandler;

    private ShapeRenderer shapeRenderer;
    private Batch batch;
    private boolean gameOver= false;
    private float explosionTime =0;

    public GameScreen (){


        shapeRenderer = new ShapeRenderer();
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        camera.setToOrtho(true);

        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT, camera);

        stage = new Stage (viewport);
        batch = stage.getBatch();


        spacecraft = new SpaceCraft(Settings.SPACECRAFT_STARTX, Settings.SPACECRAFT_STARTY, Settings.SPACECRAFT_WIDTH, Settings.SPACECRAFT_HEIGHT);
        scrollhandler = new ScrollHandler();

        stage.addActor(spacecraft);
        spacecraft.setName("spacecraft");
        stage.addActor(scrollhandler);

        AssetManager.music.play();

        Gdx.input.setInputProcessor(new InputHandler(this));

    }


    private void drawElements ()  {

//        Gdx.gl20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
//        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(new Color(0, 1, 0, 1));

        shapeRenderer.rect(spacecraft.getX(), spacecraft.getY(), spacecraft.getWidth(), spacecraft.getHeight());

        ArrayList<Asteroid> asteroids = scrollhandler.getAsteroids();
        Asteroid asteroid;

        for (int i=0; i<asteroids.size(); i++) {
            asteroid = asteroids.get(i);
            switch (i) {
                case 0:
                    shapeRenderer.setColor(1,0,0,1);
                    break;
                case 1:
                    shapeRenderer.setColor(0,0,1,1);
                    break;
                case 2:
                    shapeRenderer.setColor(1,1,0,1);
                    break;
                default:
                    shapeRenderer.setColor(1,1,1,1);
                    break;
            }
            shapeRenderer.circle(asteroid.getX() + asteroid.getWidth()/2, asteroid.getY() + asteroid.getWidth()/2, asteroid.getWidth()/2);
        }
        shapeRenderer.end();
    }

    @Override
    public void show() {

    }

    public Stage getStage() {
        return stage;
    }

    public SpaceCraft getSpacecraft() {
        return spacecraft;
    }

    public ScrollHandler getScrollhandler() {
        return scrollhandler;
    }

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act(delta);

       if (!gameOver) {
           if (scrollhandler.collides(spacecraft)) {
               AssetManager.explosionSound.play();
               stage.getRoot().findActor("spacecraft").remove();
               gameOver=true;
           }
           else {
               batch.begin();
               batch.draw(AssetManager.explosionAnim.getKeyFrame(explosionTime, false), (spacecraft.getX() + spacecraft.getWidth() / 2) - 32,
                       spacecraft.getY() + spacecraft.getHeight() / 2 - 32, 64, 64);
               batch.end();
               explosionTime += delta;
           }
       }
       // drawElements();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
