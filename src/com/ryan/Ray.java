package com.ryan;

public class Ray
{
    private Vector3D origin;
    private Vector3D direction;

    public static void testRay(Ray r)
    {
        System.out.println("Origin:");
        r.getOrigin().consoleDisplay();
        System.out.println("Direction:");
        r.getDirection().consoleDisplay();

        System.out.println();

        System.out.println("Evaluating R where t=0.5");
        r.eval(0.5).consoleDisplay();
        System.out.println("Evaluating R where t=0.75");
        r.eval(0.75).consoleDisplay();
        System.out.println("Evaluating R where t=1.5");
        r.eval(1.5).consoleDisplay();
    }

    public Ray()
    {
        origin      = new Vector3D(0,0,0);
        direction   = null;
    }

    public Ray(Vector3D origin, Vector3D direction)
    {
        this.origin = new Vector3D(origin);
        this.direction = new Vector3D(direction);
    }

    public Ray(double ox, double oy, double oz, double dx, double dy, double dz)
    {
        this.origin = new Vector3D(ox, oy, oz);
        this.direction = new Vector3D(dx, dy, dz);
    }

    public void setOrigin(Vector3D origin)
    {
        this.origin = origin;
    }

    public void setOrigin(double x, double y, double z)
    {
        this.origin = new Vector3D(x,y,z);
    }

    public void setDirection(Vector3D direction)
    {
        this.direction = direction;
    }

    public void setDirection(double x, double y, double z)
    {
        this.direction = new Vector3D(x,y,z);
    }

    public Vector3D getOrigin()
    {
        return this.origin;
    }

    public Vector3D getDirection()
    {
        return this.direction;
    }

    public Vector3D eval(double t)
    {
        return new Vector3D( this.origin.add( this.direction.multiplyScalar( t ) ) );
    }

    public void consoleDisplay()
    {
        origin.consoleDisplay();
        direction.consoleDisplay();
        System.out.print("--");
    }
}
