package com.ryan.render_engine;

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

    // really uncertain as to what renderScale does!!!!
    public int renderScale;

    // init to default 400x800
    public RasterOptions()
    {
        this.width = 400;
        this.height = 800;
        this.renderScale = 1;
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
            this.renderScale = 1;
        }
    }
}
