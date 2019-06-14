import java.lang.Math; 

public class Particle {
    private double mass;
    PhysicsVector initialPosition = new PhysicsVector();
    PhysicsVector initialVelocity = new PhysicsVector();
    PhysicsVector centreOfMass = new PhysicsVector(0,0);
    PhysicsVector cOMV=new PhysicsVector(0,0);

    //Default constructor
    public Particle(){
        mass = 1;
        initialPosition.setVector(0,0);
        initialVelocity.setVector(1,1);
    }

    //Constructor 
    public Particle(double mass, PhysicsVector x, PhysicsVector y){

    }


    //Make it static or not? 
    public PhysicsVector updatePosition(PhysicsVector initialPosition, PhysicsVector initialVelocity, double timeStep, PhysicsVector aDueToGravity){

        PhysicsVector x = new PhysicsVector(initialVelocity);
        x.scale(timeStep);

        PhysicsVector z = new PhysicsVector(aDueToGravity);
        z.scale(0.5*timeStep*timeStep);

        initialPosition.increaseBy(x);
        initialPosition.increaseBy(z);
        return initialPosition;

    }
    public PhysicsVector updateVelocity(PhysicsVector initialVelocity, double timeStep, PhysicsVector a, PhysicsVector newA){
        PhysicsVector z = new PhysicsVector(newA);
        PhysicsVector x = new PhysicsVector(a);
        z.increaseBy(x);
        z.scale(0.5*timeStep);
        initialVelocity.increaseBy(z);
        return initialVelocity;
    }


    public PhysicsVector centreOfMass(double[] mass, PhysicsVector[] positions){
        //Set origin at centre of sun, so that sunMass*distance = 0
        double sum = SolarSim.sumArray(mass);
        for(int i=0;i<positions.length;i++){
            centreOfMass.increaseBy(positions[i].scale(mass[i],positions[i]));
        }
        centreOfMass.scale(1/sum);

        return centreOfMass;
    }

    public PhysicsVector cOMVel(double[] mass, PhysicsVector[] velocity){
        double total = SolarSim.sumArray(mass);
        for(int ae=0;ae<velocity.length;ae++){
            cOMV.increaseBy(velocity[ae].scale(mass[ae],velocity[ae]));
        }
        cOMV.scale(1/total);
        return cOMV;
    }
}
