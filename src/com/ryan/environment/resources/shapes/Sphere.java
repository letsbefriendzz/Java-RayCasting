package com.ryan.environment.resources.shapes;
import com.ryan.environment.resources.HitDetection;
import com.ryan.render_engine.RasterOptions;
import com.ryan.components.Ray;
import com.ryan.components.Vector3D;

/*
A sphere, a really basic 3D object and the easiest to render. So I
made it first. Contains a Vector3D as the centre, and a double to
represent the radius.

Has a few overloaded functions for ray intersection and console display.
 */
public class Sphere extends Shape
{
    // CENTRE POINT OF THE SPHERE
    private Vector3D c;
    // RADIUS OF THE SPHERE
    private double r;

    public Sphere()
    {
        c = new Vector3D();
        r = 5;
        this.type = Shape.SPHERE;
    }

    public Sphere(Vector3D c, double r)
    {
        this();
        this.c = c;
        this.r = r;
        this.rgb = RasterOptions.Colors.WHITE;
    }

    public Sphere(Vector3D c, double r, int rgb)
    {
        this(c,r);
        this.rgb = rgb;
    }

    public Sphere(Vector3D c, double r, String type)
    {
        this(c,r);
        this.type = type;
    }

    public double intersectDiscriminant(Ray ray, double t)
    {
        Vector3D d = ray.eval(t);
        Vector3D e = ray.getOrigin();
        Vector3D c = this.c;
        double R = this.r;

        // render distance issue likely exists within this or rayIntersect
        return (Math.pow( d.dot(e.sub(c)), 2 ) - ( d.dot(d) * ( e.sub(c).dot( e.sub(c) ) ) - Math.pow(R, 2) ) );
    }

    /*
    See Fundamentals of Computer Graphics 5th Edition, p87
     */
    @Override
    public HitDetection rayIntersect(Ray ray, double t)
    {
        double dscrm = intersectDiscriminant(ray, t);

        if(dscrm >= 0)
        {
            Vector3D d = ray.eval(t);
            Vector3D e = ray.getOrigin();
            Vector3D c = this.c;

            double A = (0.0 - d.dot( e.sub(c) ));
            double B = Math.sqrt(dscrm);
            double C = d.dot(d);

            // this math may prove to be wrong later!

            //new Vector3D(0,0,0).sub(d).dot(e.sub(c))
            // i think we take the - first, then the +
            //double t1 = ( ( 0.0 - d.dot(e.sub(c)) ) - Math.sqrt( dscrm ) ) / d.dot(d);
            double t1 = (A-B)/C;

            // runs console output if debug mode is set to on
            if(Shape.DEBUG)
            {
                // <test>
                /*
                This testing section proves that, when reconstructing the viewing ray from its
                origin and the point on the sphere that it intersects, we don't retrieve the *exact*
                same line. It is, however, so small that it is likely trivial. We are dealing with
                precision into the negative exponents here. For example, a difference of:

                (-1.1102230246251565E-16, -4.440892098500626E-16, 1.7763568394002505E-15)
                */
                //*Should* be pretty insubstantial.

                Ray testRay = new Ray( ray.getOrigin(), d );
                Vector3D v1 = testRay.eval(t1);
                Vector3D v2 = ray.eval(t1);

                if(v1.getX() != v2.getX() || v1.getY() != v2.getY() || v1.getZ() != v2.getZ())
                {
                    v1.sub(v2).consoleDisplay();
                    System.out.println();
                    System.out.println();
                }
                // </test>
            }

            double t2 = -1.0;

            if (dscrm > 0)
            {
                t2 = (A+B)/C;

                if(t2 < t1)
                {
                    double temp = t1;
                    t1 = t2;
                    t2 = temp;
                }

                return new HitDetection( this, t1, t2, ray.eval(t1), ray.eval(t2) );
            }
            else
            {
                return new HitDetection( this, t1, t2, ray.eval(t1), null );
            }
        }

        return null;
    }

    @Override
    public void consoleDisplay()
    {
        System.out.println("Sphere");
        System.out.println("Radius:\t" + this.r);
    }

    public Sphere transform(Vector3D t)
    {
        return new Sphere( this.c.add(t), this.r );
    }

    public Vector3D getC()
    {
        return c;
    }

    public double getR()
    {
        return r;
    }

    public void setC(Vector3D c)
    {
        this.c = c;
    }

    public void setR(double r)
    {
        this.r = r;
    }
}
