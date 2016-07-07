package albert.com.objects;

import com.badlogic.gdx.graphics.g2d.Batch;

import albert.com.helpers.AssetManager;

/**
 * Created by Albert on 20/11/2015.
 */
public class Background extends Scrollable {

    public Background (float x, float y, float width, float heigth, float velocity ) {
        super (x,y,width, heigth, velocity) ;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.disableBlending();
        batch.draw(AssetManager.background, position.x, position.y, width, height);
        batch.enableBlending();
    }
}
