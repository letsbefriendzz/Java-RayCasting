package com.ryan;

import com.ryan.display.Display;
import com.ryan.render_engine.RasterOptions;
import com.ryan.components.Vector3D;
import com.ryan.environment.Scene;
import com.ryan.environment.shapes.Sphere;
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
        int width = 800;
        int height = 400;

        Vector3D camera     = new Vector3D();

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height,1);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // ad shapes
        s.addShape(new Sphere(new Vector3D(-18, -3, 64), 2.75, RasterOptions.YELLOW ) );
        s.addShape(new Sphere(new Vector3D(14,7,14), 4.5, RasterOptions.ORANGE ) );
        s.addShape(new Sphere(new Vector3D(32, 0, 48), 4.15, RasterOptions.GREEN ) );
        s.addShape(new Sphere(new Vector3D(-36, 19, 64), 6));

        System.out.println("Eye:");
        vp.getEye().consoleDisplay();

        while(true)
        {
            BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp, camera) , rp);
            camera = camera.add( new Vector3D( 0.00, 0, 0.005 ) );
            d.setFrame(img);
        }

        /*
        File out = new File("C:\\_retemp\\test.bmp");
        try
        {
            ImageIO.write(img, "BMP", out);
        } catch (IOException ioe) {}
         */
    }
}