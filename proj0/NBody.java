public class NBody {
    public static double  readRadius(String path){
        In in = new In(path);
        int n = in.readInt();
        double r = in.readDouble();
        return r;

    }
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int n = in.readInt();
        double r = in.readDouble();
        Planet[] planets = new Planet[n];
        for (int i = 0; i < n; i++){
            //the x- and y-coordinates of the initial position
            double xP = in.readDouble();
            double yP = in.readDouble();
            double Vx = in.readDouble();
            double Vy = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP,yP,Vx,Vy,m,img);

        }
        return planets;
    }

    public static void main(String[] args) {
        // Collecting All Needed Input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        // set the universe scale
        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while (t <= T) {
            // Create an xForces array and yForces array.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

           /* Calculate the net x and y forces for each planet,
            storing these in the xForces and yForces arrays respectively.*/
            for (int i = 0 ; i < planets.length;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);

            }
            // call update on each of the planets
            for (int i = 0; i < planets.length;i++){
            planets[i].update(dt,xForces[i],yForces[i]);
            }
            // drawing the background
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // drawing all the planets
            for (Planet planet : planets) {
                planet.draw();
            }

            // show the offscreen buff
            StdDraw.show();

           /* Pause the animation for 10
            milliseconds(see the pause method of StdDraw).
            You may need to tweak this on your computer.*/
            StdDraw.pause(10);

            t += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }



    }


