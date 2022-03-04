package com.ryan;

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
        int width = 1200;
        int height = 400;

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height,1);
        ViewPort vp         = new ViewPort();

        // ad shapes
        s.addShape(new Sphere(new Vector3D(-18, -3, 12), 2.75, RasterOptions.YELLOW ) );
        s.addShape(new Sphere(new Vector3D(4,2,14), 4.5, RasterOptions.ORANGE ) );
        s.addShape(new Sphere(new Vector3D(32, 0, 48), 4.15, RasterOptions.GREEN ) );

        System.out.println("Eye:");
        vp.getEye().consoleDisplay();

        File out = new File("C:\\_retemp\\test.bmp");
        BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp) , rp);
        try
        {
            ImageIO.write(img, "BMP", out);
        } catch (IOException ioe) {}
    }
}