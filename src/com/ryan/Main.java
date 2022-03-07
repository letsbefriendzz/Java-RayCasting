package com.ryan;

import com.ryan.components.Ray;
import com.ryan.display.Display;
import com.ryan.environment.resources.lights.Light;
import com.ryan.environment.resources.lights.PointLight;
import com.ryan.environment.resources.shapes.Shape;
import com.ryan.render_engine.RasterOptions;
import com.ryan.components.Vector3D;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.shapes.Sphere;
import com.ryan.render_engine.Renderer;
import com.ryan.render_engine.ViewPort;
import com.sun.jdi.connect.TransportTimeoutException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    private static void sceneTestHarness(boolean lightDebug, boolean shapeDebug)
    {
        int width   = 1000;
        int height  = 1000;

        Light.DEBUG = lightDebug;
        Shape.DEBUG = shapeDebug;

        Vector3D camera     = new Vector3D(0,0,0);

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // add shapes
        // DEBUG SPHERE:
        s.addShape( new Sphere( new Vector3D( 0, 0, 26 ), 5, RasterOptions.Colors.Vaporwave.GREEN ) );

        //s.addShape( new Sphere( new Vector3D( 2, 0, 26 ), 5, RasterOptions.Colors.Vaporwave.GREEN ) );

        // add a light
        double l_str = 5.5;
        Vector3D l = new Vector3D(4,-10,18);
        s.addLight( new PointLight( l, l_str ) );
        //s.addLight( new Light() );

        int i = 0;
        while(i < 1)
        {
            // uncomment for file writing if needed /shrug
            BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp, camera) , rp);
            camera = camera.add(new Vector3D(0,0,0.0025));

            try
            {
                File f = new File("C:\\_test_files\\light_fail" + i + ".bmp");
                ImageIO.write( img, "bmp", f );
            } catch (IOException e) { e.printStackTrace(); }

            d.setFrame(img);
            i++;
        }

        //d.close();
    }

    public static void main(String[] args)
    {
        sceneTestHarness(false, false);

        // sceneTestHarness( true, false );
    }
}

/*
rng
            if(i % 1 == 0)
            {
                Random r = new Random();
                double x = -8 + (8 - (-8)) * r.nextDouble();
                double y = -8 + (8 - (-8)) * r.nextDouble();
                double z = 8 + (64 - (0 - ( 8 ))) * r.nextDouble();
                double rad = 0.1 + (3 - (-0.1)) * r.nextDouble();
                s.addShape( new Sphere( new Vector3D(x,y,z), rad, RasterOptions.getRandomColour() ) );
                s.shapes.remove(0);
                //System.out.println(i);
            }
 */

