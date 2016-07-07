package albert.com.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.Random;

import albert.com.helpers.AssetManager;
import albert.com.utils.Methods;
import albert.com.utils.Settings;

/**
 * Created by Albert on 20/11/2015.
 */
public class Asteroid extends Scrollable {

    private float runTime;
    private Circle collisionCircle;

    @Override
    public void act(float delta) {
        super.act(delta);
        runTime += delta;
        collisionCircle.set(position.x + width / 2.0f, position.y + width / 2.0f, width / 2.0f);
    }

    public boolean collides(SpaceCraft nau) {

        if (position.x <= nau.getX() + nau.getWidth()) {
            // Comprovem si han col·lisionat sempre i quan l'asteroid estigui a la mateixa alçada que la spacecraft
            return (Intersector.overlaps(collisionCircle, nau.getCollisionRect()));
        }
        return false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetManager.asteroidAnim.getKeyFrame(runTime), position.x, position.y, width, height);
    }

    public float getRunTime() {
        return runTime;
    }

    public Asteroid (float x, float y, float width, float heigth, float velocity) {
        super(x,y,width,heigth,velocity);
        runTime = Methods.randomFloat(0,1);

    }

    public void reset (float newx) {
        super.reset (newx) ;
        float newSize = Methods.randomFloat(Settings.MIN_ASTEROID, Settings.MAX_ASTEROID);

        width = height = 34*newSize;

        position.y = new Random().nextInt(Settings.GAME_HEIGHT - (int) height);


    }

}
