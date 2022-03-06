package com.ryan.environment.resources.lights;

import com.ryan.components.Vector3D;
import com.ryan.environment.resources.HitDetection;
import com.ryan.render_engine.RasterOptions;

public class Light
{
    private Vector3D source;

    private int color;

    public Light()
    {
        source = new Vector3D();
        color = RasterOptions.Colors.Vaporwave.PURPLE;
    }

    public Light(Vector3D s)
    {
        this.source = s;
    }

    public Vector3D getSource()
    {
        return this.source;
    }

    public int getColor()
    {
        return color;
    }

    public void setSource(Vector3D s)
    {
        this.source = s;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public int shade(HitDetection s)
    {
        return s.shape.getRgb();
        //return RasterOptions.avgRgb( s.shape.getRgb(), this.color );
    }
}
