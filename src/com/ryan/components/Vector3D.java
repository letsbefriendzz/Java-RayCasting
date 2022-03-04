package com.ryan.components;
import java.lang.Math;

/*
NAME    : Vector3D
DESC    :
    Represents a 3D vector, with X, Y and Z values.
    Has methods to return the magnitude, add and
    multiply, and so forth. Contains a static testing
    function if you'd like to conduct tests to ensure
    the provided code works properly.
 */
public class Vector3D
{
    private double x;
    private double y;
    private double z;

    // default constructor; all values set to 0.
    public Vector3D()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // constructor that takes an x, y, z value
    public Vector3D(double x, double y, double z)
    {
        // if gnarly values are passed, reset to 0.0
        // don't think it makes a diff
        if(x == -0.0)
            x = 0.0;
        if (y == -0.0)
            y = 0.0;
        if (z == -0.0)
            z = 0.0;

        this.x = x;
        this.y = y;
        this.z = z;
    }

    //copy constructor
    public Vector3D(Vector3D v)
    {
        this(v.getX(), v.getY(), v.getZ());
    }

    // calculates magnitude of the current vector
    // |u| = sqrt(x^2 + y^2 + z^2)
    public double getMagnitude()
    {
        return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + ( this.z * this.z ) );
    }

    // Normalizes and creates a new Vector3D instance
    // length of one; all vector components divided by the magnitude.
    // norm(u) = (x/|u|, y/|u|, z/|z|)
    public Vector3D getNormalized()
    {
        return new Vector3D( this.x / this.getMagnitude(), this.y / this.getMagnitude(), this.z / this.getMagnitude() );
    }

    // multiplies the current vector by a scalar and returns a new Vector3D instance with those values.
    public Vector3D multiplyScalar(double scalar)
    {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Gets the distance between the current instance of a Vector3D instance and another Vector3D instance,
    // passed as a parameter.
    public double getDistance(Vector3D v)
    {
        return Math.sqrt( Math.pow( v.x - this.x, 2 ) + Math.pow( v.y - this.y, 2 ) + Math.pow( v.z - this.z, 2) );
    }

    // Adds current vector and parameter vector; returns new vector.
    public Vector3D add(Vector3D add)
    {
        return new Vector3D( this.x + add.getX(), this.y + add.getY(), this.z + add.getZ() );
    }

    // Subtracts parameter vector from current vector; returns new vector.
    public Vector3D sub(Vector3D sub)
    {
        return new Vector3D(this.x - sub.getX(), this.y - sub.getY(), this.z - sub.getZ());
    }

    // Returns the dot product of the current vector and the parameter vector.
    // u.v = x1 * x2 + y1 * y2 + z1 * z2
    public double dot(Vector3D dot)
    {
        return ( ( this.x * dot.getX() ) + (this.y * dot.getY() ) + (this.z * dot.getZ() ) );
    }

    public Vector3D getDifference(Vector3D diff)
    {
        return new Vector3D( -(this.getX() - diff.getX()), -(this.getY() - diff.getY()), -(this.getZ() - diff.getZ()) );
    }

    // Calculates the cross product of two vectors, returns a new vector.
    public Vector3D cross(Vector3D cross)
    {
        return new Vector3D( (this.y*cross.getZ()) - (this.z*cross.getY()), (this.x*cross.getZ()) - (this.z*cross.getX()), (this.x*cross.getY()) - (this.y*cross.getX()) );
    }

    public Vector3D avg(Vector3D avg)
    {
        return  new Vector3D( ( this.getX() + avg.getX() ) / 2, ( this.getY() + avg.getY() ) / 2, ( this.getZ() + avg.getZ() ) / 2 );
    }

    public void consoleDisplay()
    {
        System.out.print("(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")");
    }

    public String textOut()
    {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }


    // generic getters
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getZ()
    {
        return z;
    }

    // generic setters
    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void setZ(double z)
    {
        this.z = z;
    }

    // testing function; takes two vectors and performs all available
    // vector arithmetic supported by this class and dumps values to
    // the console.
    public static void testVectors(Vector3D v1, Vector3D v2)
    {
        System.out.println("Testing Vectors");
        v1.consoleDisplay();
        v2.consoleDisplay();

        System.out.println();

        System.out.println("Magnitude:");
        System.out.println("V1:\t" + v1.getMagnitude());
        System.out.println("V2:\t" + v2.getMagnitude());

        System.out.println("Adding V1 + V2");
        System.out.println("(" + v1.add(v2).getX() + ", " + v1.add(v2).getY() + ", " + v1.add(v2).getZ() + ")");

        System.out.println("Multiplying V1 * 5");
        v1.consoleDisplay();
        System.out.println();
        v1.multiplyScalar(5).consoleDisplay();
        System.out.println();

        System.out.println("Normalized Magnitude (Expects 1.0):");
        System.out.println("V1:\t" + v1.getNormalized().getMagnitude());
        System.out.println("V2:\t" + v1.getNormalized().getMagnitude());

        System.out.println("Dot Product:");
        System.out.println("V1 . V2 = " + v1.dot(v2));

        System.out.println("Cross Product:");
        Vector3D cross = v1.cross(v2);
        cross.consoleDisplay();
        System.out.println();
    }
}
