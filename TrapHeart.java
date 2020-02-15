import java.util.Scanner;

public class TrapHeart {
    //File: TrapHeart.java
    //Purpose: This is the main method runs the code and prints out the
    //         final area.
    //
    //Input: a: left endpoint of interval
    //       b: right endpoint of interval
    //       n: # of trapezoids
    //
    //Output: estimate of the area between the x-axis, x=a, x=b, and the graph
    //        of top and bottom functions of heart equation using n trapezoids
    //
    //
    //Compile: javac TrapHeart.java
    //Execute: java TrapHeart
    //
    //
    //Notes:    f(x) is hardwired as a private static member.
    //
    //          FOR SIMPLICITY*** I assume endpoints will be half of total
    //          desired rang; in other words, this will only integrate half of
    //          the total heart function and multiply by 2 in order to be
    //          find the total area.

    
    public static void main(String[] args){
	//double area_circ = 
	double area; //store result in area
	double max_area; //of circle
	double a,b; //left and right endpoints
	int n; //# of trapezoids
	double h; //trapezoid base width

	Scanner sc = new Scanner(System.in);

	
        System.out.println("Enter a,b, and n: ");
	a = sc.nextDouble();
	b = sc.nextDouble();
	n = sc.nextInt();

	h = (b-a)/n;

	max_area = circle(Math.sqrt(circle_radius_sq(-1,0,1,0)));
    
	area = 2*trap(a,b,n,h) - max_area;


      System.out.println("With n = " + n + " trapezoids, our estimate");
      System.out.print("of the area for the range of two times " + a + " to " + b);
      System.out.println(" = " + area);
    } // main
    
     /*
       Method: trap
       Purpose: Estimate area using Trapezoidal rule
       
       Input args: a: left endpoint
                   b: right endpoint
		   n: # of trapezoids
		   h: stepsize = length of base of the trapezoids
       Return value: Trapezoidal rule estimate of area between x-axis, 
                    x = a, x = b, and graph of top of heart and bottom of heart
       
       Need *static* so trap can be called from main without instantiating 
       an object
     */
    public static double trap(double a, double b, int n, double h)  {
	double area; //store result in area
	double area_t;
	double area_l;
	double x;
	int i;

	area_t = (top(a) + top(b))/2.0;
	area_l = (bottom(a) + bottom(b))/2.0;

	area = area_t + area_l;

	for (i = 1; i <= n-1; i++) {
	    x = a + i*h;
	    area = area + top(x) + bottom(x);
	}

	area = area*h;

	return area;
    } // trap

    // Method: top
    // Purpose: This is the equation of the top part of the heart shifted
    //          down such that its endpoints line up with the x-axis.
    //
    // Input arg: x
    // Note: Need *static* so top can be called from trap without instantiating
    //       an object
    static double top(double x){
	double return_val;
	
	return_val = (Math.sqrt(2-Math.pow(x, 2))+ Math.sqrt(Math.abs(x))-1.2);
        return return_val;
    } //top

    
    // Method: bottom
    // Purpose: This is the equation of the bottom part of the heart function,
    //          vertically reflected or reflected about the x-axis and shifted
    //          up such that its endpoints line up with the x axis.
    //
    // Input arg: x
    // Note: Need *static* so top can be called from trap without instantiating
    //       an object
     static double bottom(double x){
         double return_val;

	 return_val = (Math.sqrt(2-Math.pow(x, 2))- Math.sqrt(Math.abs(x))+1.19);
         return return_val;
     } //bottom


    // Method: circle radius squared
    // Purpose: This is the calculation of the radius squared value of the circle
    //          of greatest area within
    //          the heart function.
    //
    // Input arg: x1,y1,x2.y2
     public static double circle_radius_sq(double x1, double y1,
					   double x2, double y2){
        double radius_sq;

	double midpoint_x;
	double midpoint_y;

	midpoint_x = (x1 + x2)/2.0;
	midpoint_y = (y1 + y2)/2.0;
	

	radius_sq = Math.sqrt(Math.pow((x1-midpoint_x), 2) +
			      Math.pow((y1-midpoint_y), 2));
        return radius_sq;
    } //circle

     
    // Method: circle
    // Purpose: This is the calculation of the area of the circle within
    //          the heart function.
    //
    // Input arg: x
    public static double circle(double radius){
        double area;

	area = Math.PI * Math.pow(radius, 2);
        return area;
    } //circle
}
