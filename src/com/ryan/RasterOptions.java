package com.ryan;

public class RasterOptions
{
    public int width;
    public int height;

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
