package albert.com.helpers;

import com.badlogic.gdx.InputProcessor;

import albert.com.objects.SpaceCraft;
import albert.com.screens.GameScreen;

/**
 * Created by Albert on 23/11/2015.
 */
public class InputHandler implements InputProcessor {

    private SpaceCraft spacecraft;
    private GameScreen screen;

    int previousY =0;

    public InputHandler (GameScreen screen) {
        this.screen = screen;
        spacecraft = screen.getSpacecraft();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        previousY = screenY;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        spacecraft.goStraight();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (Math.abs(previousY - screenY) > 2 )
            if (previousY < screenY) {
                spacecraft.goDown();
            }
        else {
                spacecraft.goUp();

            }
        previousY = screenY;
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
