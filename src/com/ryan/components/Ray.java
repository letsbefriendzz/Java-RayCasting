package com.ryan.components;

/*
CLASS:      Ray
DESC:
    Describes a ray that is cast from our eye in a given direction. A ray has two members:
    The origin (A 3D vector) and a direction (another 3D vector). The direction is always
    normalized. We can traverse this line using the eval function, which takes a scalar t
    and returns a Vector3D using o + t(d).
 */
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

    // constructors
    public Ray()
    {
        origin      = new Vector3D(0,0,0);
        direction   = null;
    }

    public Ray(Vector3D origin, Vector3D direction)
    {
        this.origin = new Vector3D(origin);
        this.direction = new Vector3D(direction).getNormalized(); // might be bad !
    }

    public Ray(double ox, double oy, double oz, double dx, double dy, double dz)
    {
        this.origin = new Vector3D(ox, oy, oz);
        this.direction = new Vector3D(dx, dy, dz).getNormalized();
    }

    // setters
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

    // getters
    public Vector3D getOrigin()
    {
        return this.origin;
    }

    public Vector3D getDirection()
    {
        return this.direction;
    }

    // evaluate function; allows us to traverse the line
    // o + d(t)
    public Vector3D eval(double t)
    {
        return this.origin.add(this.direction.multiplyScalar(t));
    }

    public Ray transform(Vector3D t)
    {
        return new Ray( this.origin.add(t), this.direction.add(t) );
    }

    // console display for debugging
    public void consoleDisplay()
    {
        origin.consoleDisplay();
        direction.consoleDisplay();
        System.out.print("  ");
    }
}
