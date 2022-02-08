public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;
	public Planet (double xP, double yP, double xV,
				   double yV, double m, String img) {
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
	public double calcDistance(Planet p){
		return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
	}
	public double calcForceExertedBy(Planet p){
		double d = calcDistance(p);
		return G * p.mass * mass / (d * d);
	}
	public double calcForceExertedByX(Planet p){
		double f = calcForceExertedBy(p);
		double d = calcDistance(p);
		return f * (p.xxPos - xxPos) / d;
	}
	public double calcForceExertedByY(Planet p){
		double f = calcForceExertedBy(p);
		double d = calcDistance(p);
		return f * (p.yyPos - yyPos) / d;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double d = 0;
		for (int i = 0; i < allPlanets.length; i = i + 1){
			if (this.equals(allPlanets[i])){
				continue;
			}
			d = d + calcForceExertedByX(allPlanets[i]);
		}
		return d;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double d = 0;
		for (int i = 0; i < allPlanets.length; i = i + 1){
			if (this.equals(allPlanets[i])){
				continue;
			}
			d = d + calcForceExertedByY(allPlanets[i]);
		}
		return d;
	}
	public void update(double dt, double fX, double fY){
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}
	public void draw(){
		StdDraw.clear();
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}













