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
        // construct a new ray with the light source as the origin and the coordinates
        // that we found an object
        Ray ray = new Ray( this.getSource(), hd.hit1 );

        // find all points where the line passes through this object
        HitDetection light_ray = hd.shape.rayIntersect(ray, 1);

        // if it is not null, it means that the light ray stretches out to touch our object
        if (light_ray != null)
        {
            // our point light collides with the object
            // we now need to figure out if the point that we are rendering is the first or
            // second intersection of the object.
            light_ray.consoleDisplay();
            System.out.println();
            hd.consoleDisplay();
            System.out.println();

            System.out.println("\n===============================================\n");
        }

        double distance = this.getSource().getDistance( hd.hit1 );
        double val = distance / strength;
        if (distance < strength)
        {
            return hd.shape.getRgb();
        }
        return RasterOptions.Colors.GRAY;
    }
}
