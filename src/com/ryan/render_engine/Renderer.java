package com.ryan.render_engine;

import com.ryan.components.Ray;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.HitDetection;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer
{
    public static void setPixel(BufferedImage img, int rgb, int x, int y)
    {
        img.setRGB(x, y, rgb);
    }

    public static BufferedImage renderScene(Scene scene, ArrayList<ArrayList<Ray>> rays, RasterOptions raster)
    {
        /*input validation*/
        if(rays.size() != raster.height || rays.get(0).size() != raster.width)
        {
            System.out.println("Invalid Ray list : RasterOptions combo");
            return null;
        }

        int height = rays.size();
        int width = rays.get(0).size();

        BufferedImage img = new BufferedImage(raster.width, raster.height, BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                HitDetection closestObject = null;
                for (int i = 0; i < scene.shapes.size(); i++)
                {
                    HitDetection hd = scene.shapes.get(i).rayIntersect( rays.get(y).get(x), raster.renderScale);
                    if ( hd != null )
                    {
                        if(closestObject == null)
                            closestObject = hd;
                        else if (closestObject.t1 > hd.t1)
                            closestObject = hd;
                    }
                }

                int colour = RasterOptions.Colors.BLACK;
                if(closestObject != null)
                {
                    for (int l = 0; l < scene.lights.size(); l++)
                    {
                        //closestObject.consoleDisplay();
                        colour = scene.lights.get(l).shade( closestObject );
                    }
                }
                setPixel(img, colour, x, y);
            }
        }

        return img;
    }
}
