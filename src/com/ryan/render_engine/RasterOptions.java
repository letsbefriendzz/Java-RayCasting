package com.ryan.render_engine;

import java.util.Random;

import static com.ryan.render_engine.RasterOptions.Colors.*;

public class RasterOptions
{
    public class Colors
    {
        public final static int RED       = (255<<16)|(0<<8)|(0);
        public final static int YELLOW    = (250<<16)|(253<<8)|(15);
        public final static int GREEN     = (0<<16)|(255<<8)|(0);
        public final static int BLUE      = (0<<16)|(0<<8)|(255);
        public final static int ORANGE    = (255<<16)|(140<<8)|(0);
        public final static int WHITE     = (255<<16)|(255<<8)|(255);
        public final static int BLACK     = (0<<16)|(0<<8)|(0);
        public final static int GRAY      = (30<<16)|(30<<8)|(30);
        public final static int NULL      = 0;

        public class Vaporwave
        {
            public final static int PINK    = (255<<16)|(113<<8)|(206);
            public final static int BLUE    = (1<<16)|(205<<8)|(254);
            public final static int GREEN   = (5<<16)|(255<<8)|(161);
            public final static int PURPLE  = (185<<16)|(103<<8)|(255);
            public final static int YELLOW  = (255<<16)|(251<<8)|(150);
        }
    }

    public int width;
    public int height;

    // do not modify this
    public final int renderScale = 1;
    // you can and will kill the rendering process !

    public static int getRandomColour()
    {
        // lol this design is awful
        // don't keep this
        int[] colors = { RED, YELLOW, GREEN, BLUE, ORANGE, WHITE, Colors.Vaporwave.BLUE, Colors.Vaporwave.PINK,
                        Colors.Vaporwave.GREEN, Colors.Vaporwave.PURPLE, Colors.Vaporwave.YELLOW };

        return colors[ new Random().nextInt(colors.length) ];
    }

    // avgs rgb values
    // bitwise rgb integers is pretty nifty
    public static int avgRgb(int rgb_a, int rgb_b, double ratio)
    {
        double iRatio = 1.0f - ratio;

        int b1 = (rgb_a)&0xFF;
        int g1 = (rgb_a>>8)&0xFF;
        int r1 = (rgb_a>>16)&0xFF;

        int b2 = (rgb_b)&0xFF;
        int g2 = (rgb_b>>8)&0xFF;
        int r2 = (rgb_b>>16)&0xFF;

        int R = ((int)(r2 * iRatio) + (int)(r1 * ratio));
        int G = ((int)(g2 * iRatio) + (int)(g1 * ratio));
        int B = ((int)(b2 * iRatio) + (int)(b1 * ratio));

        return (R<<16)|(G<<8)|(B);
    }

    // init to default 400x800
    public RasterOptions()
    {
        this.width = 400;
        this.height = 800;
    }

    // init with dimensions
    public RasterOptions(int width, int height)
    {
        this();

        //as it should be! width > height!
        if (width >= height)
        {
            this.width = width;
            this.height = height;
        }
    }
}
