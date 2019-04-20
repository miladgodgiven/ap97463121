package assignment5;
import static java.lang.Math.*;
public class assignment5 {
	
	public static void main(String[] args) {
		double y ;;double max=0;double neu;
		
		for( y=10; y>0;y=y-0.01) {
			for(double x=10; x>0;x=x-0.001) {
				neu=f(x-0.001, y);
				max=f(x, y);
				if(neu>max) {
					max=neu;
				}
			}
		}
	
		System.out.println(max);
	}
	public static double f ( double x,double y) {
		
		double f ;
		f=(sqrt(pow(x, 2)+pow(y, 2)))/((x*sin(x+y))+(y*cos(x+y)));
		return f;	
	}
	
}
