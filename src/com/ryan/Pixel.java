package com.ryan;

public class Pixel
{
    public double r = 0.0;
    public double g = 0.0;
    public double b = 0.0;

    public Pixel()
    {
        r = 0.0;
        g = 0.0;
        b = 0.0;
    }

    public Pixel(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Pixel(Pixel p)
    {
        this(p.r, p.g, p.b);
    }
}
