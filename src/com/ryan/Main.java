package com.ryan;

import com.ryan.display.Display;
import com.ryan.environment.resources.lights.Light;
import com.ryan.render_engine.RasterOptions;
import com.ryan.components.Vector3D;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.shapes.Sphere;
import com.ryan.render_engine.Renderer;
import com.ryan.render_engine.ViewPort;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        int width   = 800;
        int height  = 400;

        Vector3D camera     = new Vector3D(0,0,0);

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // add shapes
        s.addShape( new Sphere( new Vector3D( 0, -2, 4 ),0.2 ) );
        s.addShape( new Sphere( new Vector3D( 2, 0, 6 ), 1, RasterOptions.Colors.Vaporwave.YELLOW ) );
        s.addShape( new Sphere( new Vector3D( 4, 0, 18 ), 1, RasterOptions.Colors.Vaporwave.PINK ) );
        s.addShape( new Sphere( new Vector3D( -8, 4, 18 ), 2, RasterOptions.Colors.Vaporwave.PURPLE ) );
        s.addShape( new Sphere( new Vector3D( -16, -6, 14 ), 0.4, RasterOptions.Colors.Vaporwave.BLUE ) );

        // add a light
        s.addLight( new Light());

        int i = 0;
        while(i < 500)
        {
            File f = new File("C:\\_test_files\\test" + i + ".bmp");
            BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp, camera) , rp);
            try
            {
                ImageIO.write(img,"BMP", f);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            camera = camera.add(new Vector3D(0,0,0.005));
            d.setFrame(img);
            i++;
        }
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

