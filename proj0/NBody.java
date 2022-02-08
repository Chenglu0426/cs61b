public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
		int firstitem = in.readInt();
		double res = in.readDouble();
		return res;
	}
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int num = in.readInt();
		Planet[] res = new Planet[num];
		double r = in.readDouble();
		for (int i = 0; i < num; i = i + 1){
			double xpos = in.readDouble();
			double ypos = in.readDouble();
			double xvel = in.readDouble();
			double yvel = in.readDouble();
			double pmass = in.readDouble();
			String pname = in.readString();
			res[i] = new Planet(xpos, ypos, xvel, yvel, pmass, pname);
		}
		return res;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		StdDraw.enableDoubleBuffering();
		

		double t = 0;
		int num = planets.length;
		while (t < T){
			double xForces[] = new double[num];
			double yForces[] = new double[num];
			for (int i = 0; i < num; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForces[i], yForces[i]);
				
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i = 0; i < num; i++){
				planets[i].draw();
			}
			
			StdDraw.show();
			StdDraw.pause(10);

			t += dt;

		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        		          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            		      planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

	}






}

