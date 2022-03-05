package com.ryan.environment.resources.lights;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;
import com.ryan.environment.resources.HitDetection;
import com.ryan.render_engine.RasterOptions;

import java.awt.*;

public class PointLight extends Light
{
    private double strength;

    public PointLight(Vector3D s, double str)
    {
        this.setSource(s);
        this.strength = str;
    }

    @Override
    public int shade(HitDetection hd)
    {
        Ray ray = new Ray( this.getSource(), hd.hit );
        HitDetection light_ray = hd.shape.rayIntersect(ray, 1);
        if (light_ray != null)
        {
            if( light_ray.t2 == -1 )
            {
                System.out.println("succ");
            }
        }
        double distance = this.getSource().getDistance( hd.hit );
        double val = distance / strength;
        if (distance < strength)
        {
            return hd.shape.getRgb();
        }
        return RasterOptions.Colors.GRAY;
    }
}
