package com.ryan;

/*
NOTES

Camera class is probably redundant, it's literally just an origin point for all of the
rays in a perspective view
 */

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        RasterOptions rp = new RasterOptions(7,5);
        ViewPort vp = new ViewPort();

        ArrayList<ArrayList<Ray>> rays = vp.generateRays(rp);

        for(int y = 0; y < 5; y++)
        {
            for(int x = 0; x < 7; x++)
            {
                rays.get(y).get(x).consoleDisplay();
            }
            System.out.println();
        }
    }
}