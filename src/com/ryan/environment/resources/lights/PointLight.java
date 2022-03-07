package com.ryan.environment.resources.lights;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;
import com.ryan.environment.resources.HitDetection;
import com.ryan.environment.resources.shapes.Shape;
import com.ryan.render_engine.RasterOptions;

public class PointLight extends Light
{
    private double strength;

    public PointLight(Vector3D s, double str)
    {
        this.setSource(s);
        this.strength = str;
    }

    @Override
    public int absoluteShade(HitDetection hd)
    {
        Ray lightRay = new Ray( this.getSource(), hd.hit1 );
        HitDetection lightRayHit = hd.shape.rayIntersect( lightRay, 1.0 );

        if(lightRayHit != null)
        {
            lightRayHit.consoleDisplay();
            System.out.println();
        }

        return hd.shape.getRgb();
    }

    @Override
    public int shade(HitDetection hd)
    {
        double distance = this.getSource().getDistance( hd.hit1 );
        double maxLighting = this.strength * 2.5;

/*        hd.hit1.consoleDisplay();
        System.out.println();*/
        //System.out.println( distance );

        if(distance > maxLighting)
            return RasterOptions.Colors.GRAY;
        else if (distance <= strength)
            return hd.shape.getRgb();
        else
        {
            if(Light.DEBUG)
            {
                System.out.println( distance );
                System.out.println( ( 1 - ( distance - this.strength ) / ( maxLighting - this.strength ) ) );
            }
            return RasterOptions.avgRgb( hd.shape.getRgb(), RasterOptions.Colors.GRAY,  1 - ( distance - this.strength ) / ( maxLighting - this.strength ) );
        }

        /*
        // construct a new ray with the light source as the origin and the coordinates
        // that we found an object
        Ray ray = new Ray( this.getSource(), hd.hit1 );

        if(Light.DEBUG)
        {
            // <test>
            // we are creating a new ray that uses the light source a the origin point,
            // and points in the direction of the location on an object that is visible
            // to the screen. If we use the light origin and the hit vector as our origin
            // and destination, we should be able to traverse this light ray and reach
            // the exact coordinates of the point of hit1 or hit2. this debugging code
            // dumps the information about the light ray to the console, as well as the
            // first and second hit location information.
            System.out.println("LIGHT RAY:");
            ray.eval(distance).consoleDisplay();
            System.out.println();
            System.out.println("HIT DETECTION T1 & T2:");
            hd.hit1.consoleDisplay();
            System.out.println();
            hd.hit2.consoleDisplay();
            System.out.println("\n");
            // </test>
        }

        // find all points where the line passes through this object
        HitDetection light_ray = hd.shape.rayIntersect(ray, 1);

        // if it is not null, it means that the light ray stretches out to touch our object
        if (light_ray != null && hd.shape.getType() != Shape.NULL)
        {
            // our point light collides with the object
            // we now need to figure out if the point that we are rendering is the first or
            // second intersection of the object.
            if(Light.DEBUG)
            {
                light_ray.consoleDisplay();
                System.out.println();
                hd.consoleDisplay();
                System.out.println();
                System.out.println("\n===============================================\n");
            }
        }

        return hd.shape.getRgb();
        */
    }
}
