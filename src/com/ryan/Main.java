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
        int width = 600;
        int height = 400;

        Vector3D camera     = new Vector3D();

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height,1);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // add shapes
        s.addShape(new Sphere( new Vector3D( 8, 0, 12 ), 4, RasterOptions.Colors.Vaporwave.GREEN ));
        s.addShape(new Sphere( new Vector3D( 6, -4, 20 ), 3, RasterOptions.Colors.Vaporwave.PURPLE ));

        s.addShape(new Sphere( new Vector3D( -16, 4, 18 ), 5, RasterOptions.Colors.Vaporwave.BLUE ));
        s.addShape(new Sphere( new Vector3D(-20, -4, 44 ), 5, RasterOptions.Colors.Vaporwave.YELLOW));

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