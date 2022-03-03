package com.ryan;
import java.io.*;
/*
NOTES

Camera class is probably redundant, it's literally just an origin point for all of the
rays in a perspective view
 */

import java.util.ArrayList;

public class Main
{
    private static String filePath = "C:\\Users\\ryane\\Desktop\\3dvectors";
    public static void main(String[] args)
    {
        int width = 800;
        int height = 400;

        Scene s = new Scene();
        RasterOptions rp = new RasterOptions(width,height);
        ViewPort vp = new ViewPort();

        ArrayList<ArrayList<Ray>> rays = vp.generateRays(rp);

        s.evaluateRays(rays, rp);
    }
}