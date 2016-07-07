package albert.com.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import albert.com.helpers.AssetManager;
import albert.com.utils.Settings;

/**
 * Created by Albert on 20/11/2015.
 */
public class SpaceCraft extends Actor {

    public static final int SPACECRAFT_STRAIGHT = 0;
    public static final int SPACECRAFT_UP = 1;
    public static final int SPACECRAFT_DOWN = 2;

    private Vector2 position;
    private int height, width;
    private int direction;
    private Rectangle collisionRect;


    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public SpaceCraft (float x, float y, int width, int heigth) {

        this.width = width;
        this.height = heigth;
        position = new Vector2(x,y);

        direction = SPACECRAFT_STRAIGHT;

        collisionRect = new Rectangle();

    }


    public void goUp () {
        direction = SPACECRAFT_UP;
    }
    public void goDown () {
        direction = SPACECRAFT_DOWN;
    }
    public void goStraight () {
        direction = SPACECRAFT_STRAIGHT;
    }
    public Vector2 getPosition() {
        return position;
    }
    public float getHeight() {
        return height;
    }
    public float getWidth() {
        return width;
    }
    public int getDirection() {
        return direction;
    }
    public float getX() {
        return position.x;
    }
    public float getY() {
        return position.y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(getSpaceCraftTexture(), position.x, position.y, width, height);
    }

    @Override
    public void act (float delta) {
        switch (direction) {

            case SPACECRAFT_STRAIGHT:
                break;
            case SPACECRAFT_UP:
                if (this.position.y - Settings.SPACECRAFT_VELOCITY *delta >= 0) {
                    this.position.y -= Settings.SPACECRAFT_VELOCITY * delta ;
                }
                break;
            case SPACECRAFT_DOWN:
                if (this.position.y + height + Settings.SPACECRAFT_VELOCITY * delta <= Settings.GAME_HEIGHT) {
                    this.position.y += Settings.SPACECRAFT_VELOCITY * delta;
                }
                break;
        }
        collisionRect.set(position.x, position.y + 3, width, 10);

    }

    public TextureRegion getSpaceCraftTexture () {
        switch (direction) {
            case SPACECRAFT_STRAIGHT:
                return AssetManager.spacecraft;
            case SPACECRAFT_UP:
                return AssetManager.spacecraftUp;
            case SPACECRAFT_DOWN:
                return AssetManager.spacecraftDown;
            default:
                return AssetManager.spacecraft;
        }
    }


}
