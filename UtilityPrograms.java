/*
general utility programs :
--------------------------



(1) Number is odd or even
*/



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;




class OddEvenCheck
{
public static void main(String ...args)
	{
		System.out.println("Enter a number");
		
		int number=new java.util.Scanner(System.in).nextInt();
		
		if(number%2==0)
		{
			System.out.println("even");
		}
		else 
		{
			System.out.println("odd");			
		}

	}
}




//(2) Factorial of a number ?


class FactorialOfANumber
{
	public static void main(String ...args)
	{
		System.out.println("Enter a number");
		
		int number=new java.util.Scanner(System.in).nextInt();
		
		for(int factorial=number-1;factorial>=1;factorial--)
		{
			number=number*factorial;
		}
		System.out.println(number);
	}
}


//(3) prime number



class PrimeNumberCheck
{
	public static void main(String ...args)
	{
		System.out.println("Enter a number");
		int number=new java.util.Scanner(System.in).nextInt();
		int count=0;
		
	for(int i=1;i<=number;i++)
		{
			if(number%i==0)
			{
				count++;
			}
		}
		if(count<=2)
			{
				if(number==2)
				{	
					System.out.println("neither prime nor composite");
				}
				else
				{
					System.out.println("prime");
				}
			}
			else
			{
				System.out.println("composite");
			}
	}
}


//(4) Largest element in an array


class LargestElementInTheArray
{
	public static int getLargestAmongTheNumbers(int [] numbers,int total_numbers)
	{
		int largest_number=0;//-----------------
		for(int i=0;i<numbers.length;i++)
		{
			if(numbers[i]>largest_number)
			{
				largest_number=numbers[i];
			}
		}
		return largest_number;
	}
	
	public static void main(String ...args)
	{
		System.out.println("how many numbers do you want to provide ?");
		int total_numbers=new java.util.Scanner(System.in).nextInt();
		
		int [] numbers=new int[total_numbers];
		
		System.out.println("enter numbers");
		for(int i=0;i<total_numbers;i++)
		{
			numbers[i]=new java.util.Scanner(System.in).nextInt();
		}
		int largest_number=LargestElementInTheArray.getLargestAmongTheNumbers(numbers,total_numbers);
		System.out.println("The largest number is : "+largest_number);
	}
}



//(5) Swap two numbers without using third variable ?



class SwappingNumbers
{
	public static void main(String ...args)
	{
		int number1=25;
		int number2=27;
		System.out.println("Before swapping number1 : "+number1+" & number2 : "+number2);
		number1=number1+number2;//25+27=52
		number2=number1-number2;//52-27=25
		number1=number1-number2;//52-25=27
		
		System.out.println("After swapping number1 : "+number1+" & number2 : "+number2);
		
		
		
		//We can also swap two numbers using third variable.
		int z;
		
		z=number1;//27
		number1=number2;//25
		number2=z;//27
	}
	
}

//(6)  fibonaci-series


class FibonacciSeries
{
	public static void main(String ...args)throws InterruptedException
	{
		System.out.println("what length do you want ? put any number");
		
		int length=new java.util.Scanner(System.in).nextInt();
		int n1=1,n2=2;
		System.out.print(1+" ");
		Thread.sleep(600);
		System.out.print(2+" ");
		Thread.sleep(600);
		for(int i=1;i<=length;i++)
		{
			int sum=n1+n2;
			n1=n2;
			n2=sum;
			
			System.out.print(sum+"  ");
			try
			{
				Thread.sleep(700);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
			
	}
}



//(7) reverse the number provided by user input.


class NumberReversing
{
	
	public static int getTheReverseOfTheNumber(int number)
	{
		int remainder_of_the_number;
		int reverse_number=0;
		while(number>0)
		{
			remainder_of_the_number=number%10;
			number=number/10;
			reverse_number=(reverse_number*10)+remainder_of_the_number;
		}
		return reverse_number;
		
	}
	public static void main(String ...args)
	{
		System.out.println("Enter a which you want to reverse...");
		
		int number=new java.util.Scanner(System.in).nextInt();
		
		int reverse_number=NumberReversing.getTheReverseOfTheNumber(number);
		
		try
		{
			Thread.sleep(1700);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println();
		System.out.println("reverse of "+number+" is : "+reverse_number);
	}
}



//(8) Check whether the number provided by the user is armstrong number or not ?




class ArmstrongNumber
{
	
	
	public static boolean checkItArmstrongOrNot(int number)
	{
		
		int l_number=number;
		int remainder;
		int new_number=0;
		while(number>0)
		{
			remainder=number%10;
			number=number/10;
			new_number=new_number+(remainder*remainder*remainder);
		}
		if(new_number==l_number)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String ...args)
	{
		System.out.println("Enter a number");
		int number=new java.util.Scanner(System.in).nextInt();
		
		boolean check_armstrong=ArmstrongNumber.checkItArmstrongOrNot(number);
		
		if(check_armstrong==true)
		{
			System.out.println(number+" is an armstrong number");
		}
		else
		{
			System.out.println(number+" isn't an armstrong number");
		}
		
	}
}



/*
Find out the maximumDifference between two elements in an array ?

*/






class Difference {
  	private int[] elements;
  	public int maximumDifference;

	// Add your code here
    Difference(int elements[])
    {
        this.elements=elements;
    }

    public void computeDifference()
    {

	// at first we are trying to find the largest element of that array
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<=elements.length-1;i++)
        {
            if(elements[i]>largest)
            {
                largest=elements[i];
            }
        }
        

	//then we are storing the differences between the largest element and others
	//in another array.
        int [] total_differences=new int[elements.length];
        int i_diff;
        for(int i=0;i<=elements.length-1;i++)
        {
            i_diff=largest-elements[i];
            //al.Add(i_diff);
            total_differences[i]=i_diff;
        }
	
	//then we are trying to find out the largest element amongst these differences.
	//and assign the value of that largest to the maximumdifference variable.
        for(int i=0;i<=total_differences.length-1;i++)
        {
            if(total_differences[i]>maximumDifference)
            {
                maximumDifference=total_differences[i];
            }

        }
    } 

} // End of Difference class

class Solution 
{

    public static void main(String[] args) {
		
		System.out.println("How many elements do you want to provide ?");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <=n-1; i++) {
			
			System.out.println("enter the value of no:"+i+" element ");
			a[i] = sc.nextInt();
            
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();
		System.out.println("");
        System.out.print("The maximum difference between 2 elements of your provided numbers is "+difference.maximumDifference);
    }
}

class Class1
{	public void m1(){}
	public void m2(){	this.m1();}
}
class Class2 extends Class1
{   public void m1(){System.out.println("child class");}	
}
class Class3
{	public static void main(String [] args){Class2 c=new Class2();  	c.m2();}	
}




class Parent
{
	void m1()
	{
		System.out.println("PARENT");
	}
	void m2()
	{
		//super.m1();
	}
}

class Child extends Parent
{
void m1()
{
  System.out.println("child");
}
}

class Demo
{
public static void main(String ...args)
{
new Child().m2();
}
}

/*
Take 3 inputs from user and check :
all are equal
any of two are equal
( use && || )
*/

class Comparison
{
	public static void compare()
	{
		System.out.println("Enter 3 numbers.");
		int [] numbers=new int[3];
		try(Scanner scan=new Scanner(System.in))
		{
			for(int i=0;i<=2;i++)
			{
				System.out.println("Enter number : "+i);
				numbers[i]=scan.nextInt();
			}
			if(numbers[0]==numbers[1]&&numbers[1]==numbers[2])
			{
				System.out.println("All are equal numbers");
			}
			else if(numbers[0]==numbers[1]||numbers[0]==numbers[2])
			{
				System.out.println("two numbers are equal");
			}
			else if(numbers[1]==numbers[2])
			{
				System.out.println("two numbers are equal");
			}
			else
			{
				System.out.println("All are different numbers");
			}
			}
		catch(Exception e)
		{
			System.out.println("Enter valid numbers");
		}
		
	}
	
	public static void main(String ...args)
	{
		Comparison.compare();
	}
}





/*

java.lang package:
------------------

- course to be covered :
					(1) Object class
					(2) String class
					(3) StrinngBuffer class
					(4) StringBuilder class
					(5) Wrapper class
					(6) Autoboxing & Autounboxing
							


- The default package that is available to all classes is language package.

- This package is by default available to all applications, we don't require to import it 
explicitly.




(1) Object class :
------------------


- This is the by default super class of all java classes. All customized classes are either
directly or indirectly child class of the Object class.

- Some inbuilt methods supports of the Object class are :

						(1) public String toString()
										
						(2) public native int hashCode(										
										
						(3) public boolean equals(Object o)
									
						(4)protected native Object clone()throws cloneNotSupportedException
											
						(5) protected void finalize()throws Throwable
						
						(6) public final class getClass()
						
						(7) public final void wait()throws InterruptedException
						
						(8) public final native void wait(long ms)throws InterruptedException
						
						(9) public final void wait(long ms, int ns)throws InterruptedException
						
						(10) public native void notify()
						
						(11) public native final void notifyAll()
						
						(12) private static native void registerNatives()


*/

/*
(1) public String toString()
----------------------------


- This method is an inbuilt method of Object class.

- If we don't override this method & call it then it will print the string representation of
the object.

predefined syntax inside toString() method : 
							
						public String toStrinng()
						{
							return getClass().getName()+"@"+Integer.toHexString(hashCode())
						}

						
- In Wrapper classes, all collection classes, String class, StringBuffer, StringBuilder classes
this method is overridden for meaningful String representation. Hence it is highly recommended
to override toString() method in our customized class.
*/

class ObjectClass
{
	String clg_name;
	String name;
	String id;
	int age;
	String address;
	
	ObjectClass(String clg_name,String name,String id,int age,String address)
	{
		this.clg_name=clg_name;
		this.name=name;
		this.id=id;
		this.age=age;
		this.address=address;
	}
	public static void main(String ...args)
	{
		ObjectClass o1=new ObjectClass("Ravenshaw univarsity","Satyaprakash Sasmal","14DIS101",23,"Choudwar");
		ObjectClass o2=new ObjectClass("Ravenshaw univarsity","Satyaprakash Sasmal","14DIS101",23,"Choudwar");
		
		o1.toString();
		o2.toString();
		System.out.println(o1);
		System.out.println(o2);
	}
}