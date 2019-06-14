import java.lang.Math;
import java.io.*;

public class GravField {
    public static final double G = 6.67408e-11;            

    private double planetMass;                      
    private double planetRadius;                        
    PhysicsVector gravityAcceleration = new PhysicsVector();


    /**
    *Default constructor that creates a GravField object with the mass and radius of the earth,
    *acting on a projectile starting at x=0, y=0, where the x and y axes are on the surface of the planet
    */
    public GravField(){

    }

    /** 
    *Constructor that creates a GravField object
    *@param planetMass Mass of the planet whose field is to be calculated
    *@param planetRadius Radius of the planet
    */ 
    public GravField(double mass, double radius, PhysicsVector initialPos){
    //can't think of anything to do here
    }

    //Calculates the acceleration due to the gravitational field of the object
    public PhysicsVector aDueToGravity(double planetMass, PhysicsVector sourcePos, PhysicsVector initialPosition){

        PhysicsVector a = new PhysicsVector(sourcePos);
        PhysicsVector b = new PhysicsVector(initialPosition);

        b.decreaseBy(sourcePos);

        double distance = b.magnitude();
        b.scale(-1*G*planetMass/(distance*distance*distance));
        return b;
    }
}
