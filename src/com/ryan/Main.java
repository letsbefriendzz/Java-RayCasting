package com.ryan;
/*
NOTES

Camera class is probably redundant, it's literally just an origin point for all of the
rays in a perspective view
 */

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
        RasterOptions rp    = new RasterOptions(width,height,10);
        ViewPort vp         = new ViewPort();

        s.addShape(new Sphere(new Vector3D(4,9,8), 4.5));

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