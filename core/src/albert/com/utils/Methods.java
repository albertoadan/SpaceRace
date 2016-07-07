package albert.com.utils;

import java.util.Random;

/**
 * Created by Albert on 21/11/2015.
 */
public class Methods {

    public static float randomFloat (float min, float max) {
        Random r = new Random();
        return r.nextFloat() * (max-min) + min;
    }
}
