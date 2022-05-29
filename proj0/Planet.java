import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Planet {
// Its current x position
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public  Planet(double xP, double yP, double xV,
                   double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    // Calcalutes the distance between two Planets
    public double calcDistance(Planet p) {
        double dist = sqrt(pow(this.xxPos - p.xxPos, 2) +
                            pow(this.yyPos - p.yyPos,2));
        return dist;
    }

//  Calculating the force exerted on this planet by the given planet
    public double calcForceExertedBy(Planet p){
        if(calcDistance(p) == 0)
        return 0;
        double G = 6.67e-11;
        double force = G* this.mass
                        * p.mass
                        / pow(calcDistance(p),2);
        return force;
    }

//  Calculating forcer exerted on this planet by the give planet in X/Y dir;
    public double calcForceExertedByX(Planet p){
        if(calcDistance(p) == 0)
            return 0;
        double cosx = (p.xxPos - this.xxPos)/calcDistance(p);
        double fX = calcForceExertedBy(p) * cosx;
        return fX;
    }

    public double calcForceExertedByY(Planet p){
        if(calcDistance(p) == 0)
            return 0;
        double sinx = (p.yyPos - this.yyPos)/calcDistance(p);
        double fY = calcForceExertedBy(p)*sinx;

        return fY;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        int n = planets.length;
        double netFX = 0;
        for (int i = 0; i < n; i++)
            netFX += calcForceExertedByX(planets[i]);

        return netFX;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        int n = planets.length;
        double netFY = 0;
        for (int i = 0; i < n; i++)
            netFY += calcForceExertedByY(planets[i]);

        return netFY;
    }
    /*a method that determines how much the forces exerted
    on the planet will
    cause that planet to accelerate*/
    public void update(double dt, double xF, double yF) {
        // Calculate the acceleration using the provided x- and y-forces.
        double Ax = xF / mass;
        double Ay = yF / mass;

    /*Calculate the new velocity by using
        the acceleration and current velocity.
        Recall that acceleration describes the
        change in velocity per unit time*/
        xxVel += Ax * dt;
        yyVel += Ay * dt;

    /*Calculate the new position by using the
    velocity computed in step 2 and the current position*/
        xxPos += dt * this.xxVel;
        yyPos += dt * this.yyVel;
    }
    public void draw(){
        /*uses the StdDraw API mentioned above to
        draw the Planet’s image at the Planet’s position*/
         StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
    }
}
