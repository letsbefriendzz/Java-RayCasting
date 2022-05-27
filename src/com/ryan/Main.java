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
    private static void writeFile(BufferedImage img, int i)
    {
        try
        {
            File f = new File("C:\\_retemp\\hd" + i + ".bmp");
            ImageIO.write( img, "bmp", f );
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void sceneTestHarness(boolean lightDebug, boolean shapeDebug)
    {
        int width   = 1000;
        int height  = 750;
        Light.DEBUG = lightDebug;
        Shape.DEBUG = shapeDebug;

        Vector3D camera     = new Vector3D(0,0,0);

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // add shapes
        // DEBUG SPHERE:
        s.addShape( new Sphere( new Vector3D( 0, 0, 14 ), 5, RasterOptions.Colors.Vaporwave.GREEN ) );

        // add a light
        double l_str = 4.6;
        Vector3D l = new Vector3D(4,-7,8);
        s.addLight( new PointLight( l, l_str ) );
        //s.addLight( new Light() );

        int i = 0;
        while(i<1)
        {
            BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp, camera) , rp);
            // camera = camera.add(new Vector3D(0,0,0.0025));

            // writeFile(img, 0);
            d.setFrame(img);
            i++;
        }

        //d.close();
    }

    public static void main(String[] args)
    {
        sceneTestHarness(false, false);
    }
}