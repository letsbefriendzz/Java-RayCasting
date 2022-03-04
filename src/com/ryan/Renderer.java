package com.ryan;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer
{
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
                //for each ray that we have, we're iterating through each object to check if the ray intersects
                //this is super inefficient but I don't care
                int i_rgb = (255<<16)|(255<<8)|(255);
                int r_rgb = (0<<16)|(0<<8)|(0);
                for (int i = 0; i < scene.getShapes().size(); i++)
                {
                    if ( scene.getShapes().get(i).rayIntersect( rays.get(y).get(x), raster.renderDistance ) )
                        img.setRGB(x, y, i_rgb);
                    else
                        img.setRGB(x, y, r_rgb);
                }
            }
        }

        return img;
    }
}
