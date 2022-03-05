package com.ryan.components;

public class Matrix33
{
    public double[] r1;
    public double[] r2;
    public double[] r3;

    public Matrix33()
    {
        this.r1 = new double[3];
        this.r2 = new double[3];
        this.r3 = new double[3];
    }

    public boolean setValues( double[] a, double[] b, double[] c )
    {
        if ( a.length != 3 || b.length != 3 || c.length != 3)
            return false;
        else
        {
            this.r1 = a;
            this.r2 = b;
            this.r3 = c;
            return true;
        }
    }

    public static Matrix33 xRotationMatrix(double theta)
    {
        Matrix33 xRotation = new Matrix33();
        double[] r1 = { 1, 0, 0 } ;
        double[] r2 = { 0, Math.cos(theta), 0 - Math.sin(theta) } ;
        double[] r3 = { 0, Math.sin(theta), Math.cos(theta) };
        xRotation.setValues( r1,r2,r3 );
        return xRotation;
    }

    public static Matrix33 yRotationMatrix(double theta)
    {
        Matrix33 yRotation = new Matrix33();
        double[] r1 = { Math.cos(theta), 0, Math.sin(theta) } ;
        double[] r2 = { 0, 1, 0 } ;
        double[] r3 = { 0 - Math.sin(theta), 0, Math.cos(theta) };
        yRotation.setValues(r1,r2,r3);
        return yRotation;
    }

    public static Matrix33 zRotationMatrix(double theta)
    {
        Matrix33 yRotation = new Matrix33();
        double[] r1 = { Math.cos(theta), 0 - Math.sin(theta),   0 } ;
        double[] r2 = { Math.sin(theta), Math.cos(theta),       0 } ;
        double[] r3 = { 0, 0, 1 };
        yRotation.setValues(r1,r2,r3);
        return yRotation;
    }

    public void consoleDisplay()
    {
        System.out.println("[" + r1[0] + ", " + r1[1] + ", " + r1[1] + "]");
        System.out.println("[" + r2[0] + ", " + r2[1] + ", " + r2[1] + "]");
        System.out.println("[" + r3[0] + ", " + r3[1] + ", " + r3[1] + "]");
    }

    public Vector3D multiply(Vector3D v)
    {
        double x = ( v.getX() * this.r1[0] ) + ( v.getY() * this.r1[1] ) + ( v.getZ() * this.r1[2] );
        double y = ( v.getX() * this.r2[0] ) + ( v.getY() * this.r2[1] ) + ( v.getZ() * this.r2[2] );
        double z = ( v.getX() * this.r3[0] ) + ( v.getY() * this.r3[1] ) + ( v.getZ() * this.r3[2] );

        return new Vector3D( x,y,z ) ;
    }
}
