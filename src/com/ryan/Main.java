package com.ryan;
/*
NOTES

Camera class is probably redundant, it's literally just an origin point for all of the
rays in a perspective view
 */

import com.ryan.components.RasterOptions;
import com.ryan.components.Vector3D;
import com.ryan.shapes.Shape;
import com.ryan.shapes.Sphere;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        int width = 1920;
        int height = 1080;

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height,1);
        ViewPort vp         = new ViewPort();

        // ad shapes
        s.addShape(new Sphere(new Vector3D(-18, -3, 12), 2.75, Shape.YELLOW ) );
        s.addShape(new Sphere(new Vector3D(4,2,14), 4.5, Shape.ORANGE ) );
        s.addShape(new Sphere(new Vector3D(48, 0, 48), 4.15, Shape.GREEN ) );

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