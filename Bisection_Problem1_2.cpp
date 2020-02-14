#include<iostream>
#include<cmath>
#include<iomanip>
using namespace std;

double f(double x);  
double f(double x)   
{
    double a = pow(2.020,pow(-x,3)) - pow(x,3)*cos(pow(x,4)) -1.984;    
    //This is the given equation whose roots we are asked to find
    return a;
}

int main()
{    
    cout.precision(4); //Required 4 digits of accuracy
    cout.setf(ios::fixed);
    double x1,delta,a,b,c,e,fa,fb,fc;    
    //Enter the value of x1
    //Set a label('part_a:') for later use
    part_a:cout<<"Enter the root guess 'x1':\n x1= ";    
    cin>>x1;
    cout<<"Enter the intermittent value 'delta;:\n delta= "; //Enter the value of delta
    cin>>delta;
    
    e = 0.0001; // e = measurement of accuracy
    a = x1 - delta;
    b = x1 +delta;

    //Check if a root exists between a and b
    if (f(a)*f(b)>0)        
    {    
        //If f(a)*f(b)>0 (is positive) then the root does not exist between a and b
        cout<<"Please enter a different intial guess"<<endl;            
        //go back to 'part a' and ask for different values of a and b
        goto part_a;
    }
    else                
    //if a root does exists between a and b
    {
    /*if the absolute value of the difference between a and b is greater than the accuracy desired keep bisecting the interval*/
    while (fabs(a-b)>=e)    
    {
        //bisect the interval and find the value of c
        c=(a+b)/2.0;       
        fa=f(a);        
        fb=f(b);
        fc=f(c);
        
        /*prints the values of a,b,c and fc  after each iteration*/ 
        //cout<<"a="<<a<<"     "<<"b="<<b<<"     "<<"c="<<c<<"      fc="<<fc<<endl;

        //if f(c)=0, you found a root of the equation       
        if (fc==0)        
        {
            cout<<"The root of the equation is "<<c;    /*prints root of the equation and break out of the loop*/
            break;
        }

        //if f(a)xf(c)>0, then there is no root that exists between a and c 
        if (fa*fc>0)    
        {
            /*we make a=c, making c the starting point of the next interval and b the end point*/
            a=c;    
        }
        else if (fa*fc<0)
        {    
            b=c;    /*this means there exists a root between a and c so we make c the end point of the next interval*/
        }    
    }
    }            
    
    //The loop ends when the difference between a and b becomes less than the desired accuracy      
    cout<<"The root of the equation is "<<c;    //prints the root    
    return 0;    
}
