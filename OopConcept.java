/*

OBJECT ORIENTED PROGRAMING METHODOLOGY:
---------------------------------------


- Oops have 6 main pillars :

1: class
2: objects
3: inheritance
4: polymerphism
5: abstraction
6: Encapsulation


Class and Object:
-----------------

definition:
-----------
- Class is the collection of objects and the objects are the instance of a class.
- Class is not a real world entity rather it is just a template or a blueprint whereas objects 
are real world entities.
- Class doesn't occupy memory but the object does.

ex : If animal is taken as class then different animals like Tiger, lion, dog etc can be
considered as objects.
 

 
 - an object has following properties :
 
 1: Identity(ie name)
 2: state/attributes( if animal is taken as class and Tiger as object then its state are-color,
 legs,breed,age,size etc)
 3: behavior(run(),eat(),sleep() etc)

 
 -syntax for class :
			access modifier class class_name
			{
				//body of the class
				1:variables
				2:methods
				3:constructors
				4:instance blocks
				5:static blocks
			}

			
- How to create objects :
-------------------------
by using :
1: 	new keyword
2:  newInstance method(it is a predefined method)
3:  clone() method
4:  deserialization
5:  factory methods		
	

	
*/



import java.io.*;
import java.util.*;
// 1: by using new keyword :
/*
	2 steps :
	
	1: declaration
	2: initialization
*/

class Animal
{
	String food="meat";
	
	public void eat()//behavior
	{
		System.out.println("Tiger eats "+food);
	}
	
	public void run()//behavior
	{
		System.out.println("Tiger runs faster than dog.");
	}
	
	
	public static void main(String [] args)
	{
		Animal tiger;// declaration
		
		tiger=new Animal();//initialization
		
		//lets call eat() and run() method
		tiger.eat();
		tiger.run();
		
	}
}
/*
O|P:
Tiger eats meat
Tiger runs faster than dog.
*/

//EX2

class Birds
{
	public void fly()
	{
		System.out.println("I am flying.");
	}
	public static void main(String [] args)
	{
		Birds cuckoo=new Birds();
		cuckoo.fly();
	}
}

/*
-We can't access the properties of one class from another class directly.
- To achieve this, we have to do through objects and inheritance concept.
*/

class Goat
{
	String food="vegitables and leafs";
	public void eat()
	{
		System.out.println("Goat eats : "+food);
	}
}
class Lion
{
	String food="meats";
	public void eat()
	{
		System.out.println("Lion eats : "+food);		
	}
}
class Human
{
	String food="meat and vegetables";
	public void eat()
	{
		System.out.println("Human eats : "+food);				
	}
}
class Beings
{
	public static void main(String [] args)
	{
		new Human().eat();
		new Goat().eat();
		new Lion().eat();
	}
}





// 01 : Encapsulation //

/*
- The process of binding the data so that those data can't be accessed directly is called
 encapsulation.
 - To achieve encapsulation the keyword "private" is used.
 
 -Tightly encapsulated class :
 -----------------------------
 - Inside a class if we declare the fields as private and use public getter() and setter()
methods to set and get the the values of those variables then that class will become tightly
encapsulated class.

- In project level "bean class" is best to achieve encapsulation.  

-What is bean class ?

- Bean class is basically a user defined class with some extra properties from java API. This class is basically used 
to achieve encapsulation.
*/

class StudentInformation
{
	//The following fields can easily be accessed from another class.
	String student_name;
	String student_id;
}
class StudentDemo
{
	public static void main(String [] args)
	{
		// here we can access the StudentInformation class fields directly.
		
		StudentInformation si=new StudentInformation();
		si.student_name="Deepak";
		si.student_id="1910A25";
		
	}
}
// So to achieve encapsulation we should do the following things.

class StudentInformation1
{
	private String student_name;
	private String student_id;
	
	public String getStudentName()
	{
		return student_name;
	}
	public String getStudentId()
	{
		return student_id;
	}
	
	public void setStudentInformation(String student_name,String student_id)
	{
		this.student_name=student_name;
		this.student_id=student_id;
	}
}
class StudentDemo1
{
	public static void main(String [] args)
	{
		StudentInformation1 si1=new StudentInformation1();
		
		//si1.student_name="Deepak";// error : student_name has private access in StudentInformation1
		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("Enter name and id");
		String student_name=sc.next();
		String student_id=sc.next();
		si1.setStudentInformation(student_name,student_id);
		
		System.out.println("Student name is : "+student_name+" & his/her id is : "+student_id);
	}
}



// 2 : Inheritance //

/*
- The process of acquiring the properties of one class/interface to other class/interface
is called inheritance.
-The class which provides the properties is called super class and the class which
acquires the properties is called child class.

-  To achieve inheritance, the keywords "extends" and "implements" are used.


- Why do we need inheritance ?

ans: To interpret why we need inheritance lets see the 2 basic examples.

*/

//without inheritance//

/*

class A
{
	public void display1()
	{
	}
	public void display2()
	{
	}
}
class B
{
	public void display1()
	{
	}
	public void display2()
	{
	}
	public void display3()
	{
	}
	public void display4()
	{
	}
}
class C
{
	public void display1()
	{
	}
	public void display2()
	{
	}
	public void display3()
	{
	}
	public void display4()
	{
	}
	public void display5()
	{
	}
	public void display6()
	{
	}
}
- In the above example, we are facing code redundancy/ duplicacy and to access the methods
of all class we have to create the objects of all classes. And also we have to call those
methods multiple number of times.

-Hence to avoid code redundancy  and to reduce the length of the application we should go 
for inheritance concept.

*/

//with inheritance//


class A
{
	public void display1()
	{
		System.out.println("display1");
	}
	public void display2()
	{
		System.out.println("display2");
	}
}
class B extends A
{
	public void display3()
	{
		System.out.println("display3");
	}
	public void display4()
	{
		System.out.println("display4");		
	}
}
class C extends B
{
	public void display5()
	{
		System.out.println("display5");			
	}
	public void display6()
	{
		System.out.println("display6");			
	}
	public static void main(String [] args)
	{
		C c=new C();
		// using the object c we can access all the methods.
		c.display1();//valid
	}
}


// Types of inheritance //
/*

1: single inheritance
2: multilevel Inheritance
3: hierarchical inheritance
4: Multiple inheritance
5: Hybrid inheritance

- In class level, Java doesn't support multiple inheritance and hybrid inheritance 
-But using interface, we can achieve multiple inheritance.
*/

/*
single inheritance:
-------------------

- One super class and one child class. 

*/

class SingleInheritance
{
	public void display1()
	{
		System.out.println("display1");
	}
}
class SIChild extends SingleInheritance
{
	public void display2()
	{
		System.out.println("display2");
	}
}
class SIDemo1
{
	public static void main(String ...args)
	{
		SIChild sc=new SIChild();
		sc.display1();
		sc.display2();
	}
}

/*
multilevel inheritance:
-----------------------
*/

class MultilevelInheritance
{
	public void display1()
	{
		System.out.println("display1");
	}
}
class MIA extends MultilevelInheritance
{
	public void display2()
	{
		System.out.println("display2");
	}
}
class MIB extends MIA
{
	public void display3()
	{
		System.out.println("display3");
	}
}
class MIC extends MIB
{
	public void display4()
	{
		System.out.println("display4");
	}
}
class MIDemo
{
	public static void main(String ...args)
	{
		MIC m=new MIC();
		m.display1();
		m.display2();
		m.display3();
		m.display4();
	}
}
/*
Hierarchical inheritance:
-------------------------

-Inheritance in tree structure.
*/

class HierarchicalInheritance
{
	public void display1()
	{
		System.out.println("display1");
	}
}
class HIA extends HierarchicalInheritance
{
	public void display2()
	{
		System.out.println("display2");
	}
}
class HIB extends HierarchicalInheritance
{
	public void display3()
	{
		System.out.println("display3");
	}
}
class HIDemo
{
	public static void main(String ...args)
	{
		HIA a=new HIA();
		HIB b=new HIB();
		a.display1();
		b.display1();
	}
}


/*
- How to avoid inheritance ?

ans: By using the keyword "final" we can avoid inheritance. In this case, the class is 
declared final, for that we can't inherit that class.
*/

final class AvoidInheritance
{
}
class AIB /*extends AvoidInheritance*/
{
	
}
/*
o|P:
error: cannot inherit from final AvoidInheritance
class AIB extends AvoidInheritance
*/



//"this" and "super" keyword:
//---------------------------
/*
-when the local variables, parent class variables and the child class variables have different
identity then we can access them easily without any compilation error.


-But when the current class variables and the local variables are identical then we can use
"this" keyword to represent current class variables.

-If parent class variables and the child class variables are identical then to represent the
parent class variables we can use "super" keyword.
*/

//different identity
class DifferentIdentity
{
	String name1;
}
class DIA extends DifferentIdentity
{
	String name2;
	public void display1(String name3)
	{
		System.out.println(name1+name2+name3);
	}
}
class DIDemo
{
	public static void main(String ...args)
	{
		DIA a=new DIA();
		a.name1="Saty";
		a.name2="aprakash Sa";
		a.display1("smal");
	}
}
/*
o|p:
Satyaprakash Sasmal
*/

//same identity

class SameIdentity
{
	String name;
}
class SIA extends SameIdentity
{
	String name;
	SIA(String name)
	{
		super.name=name;
	}
	public void display(String name)
	{
		System.out.println(super.name+this.name+name);
	}
}
class SIDemo10
{
	public static void main(String ...args)
	{
		SIA a=new SIA("Saty");
		a.name="aprakas";
		a.display("h Sasmal");
	}
}


/*
How to access the private constructor ?


ans: By using static factory method.


*/
//ex
class AccessPrivateConstructor
{
	private AccessPrivateConstructor()
	{
		
	}
	static AccessPrivateConstructor getThePrivateConstructor()
	{
		return new AccessPrivateConstructor();
	}
}
class APCDemo
{
	public static void main(String ...args)
	{
		//The following statement will generate compilation error.
		/*AccessPrivateConstructor apc=new AccessPrivateConstructor();*/
		
		//So to get the private object/private constructor we use static factory method
		
		AccessPrivateConstructor apc=AccessPrivateConstructor.getThePrivateConstructor();
		System.out.println(apc.hashCode());//o|P: 366712642
	}
}







// "this" , "super" , "final" keywords :
//----------------------------------------
/*

"this"
------

- "this" keyword refers to reference variable that points towards object of a class.

- TO analyze the use of "this" keyword lets see the following examples.

*/

//without "this" keyword

class ThisKeywordEx1
{
	//if the local and the instance variables have same identities then there will be
	//some problems in assigning the values inside those blocks.
	
	int counter;
	
	public void setCounterValue(int counter)
	{
		counter=counter;
	}
	public int getCountervalue()
	{
		return counter;
	}
}
class ThisKeywordDemo1
{
	public static void main(String [] args)
	{
		ThisKeywordEx1 tke=new ThisKeywordEx1();
		tke.setCounterValue(275);
		//the above statement will assign 175 to the local variable of setCounterValue method
		//but that value will not be assigned to the instance variable.
		
		
		int counter=tke.getCountervalue();
		System.out.println("counter value is : "+counter);// o|p : 0
	}
}

//with "this" keyword

class ThisKeywordEx2
{
	//if the local and the instance variables have same identities then there will be
	//some problems in assigning the values inside those blocks.
	
	int counter;
	
	public void setCounterValue(int counter)
	{
		this.counter=counter;
		// in the above statement we are assigning the value of local variable to the instance
		//variable.
		
	}
	public int getCountervalue()
	{
		return counter;
	}
}
class ThisKeywordDemo2
{
	public static void main(String [] args)
	{
		ThisKeywordEx2 tke=new ThisKeywordEx2();
		tke.setCounterValue(275);
		//the above statement will assign 175 to the local variable of setCounterValue method
		//and that value will be assigned to the instance variable.
		
		
		int counter=tke.getCountervalue();
		System.out.println("counter value is : "+counter);// o|p : 275
	}
}


//uses of "this" keyword :
//------------------------

/*
(1) "this" keyword is used to invoke current class instance variable
*/

class ThisUsage1
{
	int i;
	public void set(int i)
	{
		this.i=i;
	}
	public int get()
	{
		return i;
	}
}
class ThisDemo1
{
	public static void main(String ...args)
	{
		ThisUsage1 tu=new ThisUsage1();
		tu.set(35);
		int i=tu.get();
		System.out.println("Value of i is : "+i);
	}
}
/*
(2) "this" keyword can be used to invoke current class method(implicitly)
*/
class ThisUsage2
{
	public void show1()
	{
		System.out.println("hello");
	}
	public void show2()
	{
		show1();
		this.show1();
		//if we don't call the method with "this" keyword then the compiler will automatica-
		//lly place the "this" keyword before the method.
		
		
		
	}
	public static void main(String ...args)
	{
		ThisUsage2 tu=new ThisUsage2();
		tu.show2();
		
		/*o|p : 
				hello
				hello
		*/
	}
}
/*
(3) "this" keyword can be used to invoke current class constructor.
*/
class ThisUsage3
{
	ThisUsage3()
	{
		System.out.println("0 arg cons");
	}
	ThisUsage3(int i)
	{
		this();
		System.out.println("1 arg cons");
	}
	ThisUsage3(int i,int j)
	{
		this(15);
		System.out.println("2 arg cons");
	}
	public static void main(String ...args)
	{
		new ThisUsage3(15,40);
		
		/*
		o|P:
			0 arg cons
			1 arg cons
			2 arg cons
		*/
	}
}
/*(4) "this" keyword can be used to pass as an argument in the method call.
*/
class ThisUsage4
{
	public void show1(ThisUsage4 tu4)
	{
		System.out.println("show1 method");
	}
	public void show2()
	{
		show1(this);
		//same as the following
		show1(new ThisUsage4());
		this.show1(this);
		this.show1(new ThisUsage4());
	}
	public static void main(String ...args)
	{
		ThisUsage4 tu=new ThisUsage4();
		tu.show2();
		/*
		o|p:
			show1 method
			show1 method
			show1 method
			show1 method
		*/
	}
}
/*
(5) "this" keyword can be used to pass as an argument in the constructor call.
*/
class ThisUsage5
{
	ThisUsage5(){}
	ThisUsage5(ThisUsage5 tu)
	{
		System.out.println("1 arg cons");
	}
	public void show()
	{
		new ThisUsage5(this);
	}
	public static void main(String ...args)
	{
		new ThisUsage5().show();
		/*
		o|p:
		1 arg cons
		*/
	}
}
/*
(6) "this" keyword can be used to return class instance from methods.
*/

class ThisUsage6
{
	public ThisUsage6 get()
	{
		return this;
	}
	public static void main(String ...args)
	{
		ThisUsage6 tu=new ThisUsage6().get();
		System.out.println(tu);
		/*
		o|p:
				ThisUsage6@15db9742
		*/	
	}	
}
//"super" keyword:
/*
- "super" keyword refers to parent class reference variable
-Only in case of inheritance relationship "super" keyword can be used.
*/
class SuperKeywordEx1
{
	int counter;
}
class ChildOfSkE1 extends SuperKeywordEx1
{
	int counter=75;
	ChildOfSkE1(int counter)
	{
		super.counter=counter;
	}
	public void addAll(int counter)
	{
		System.out.println("Addition of all numbers is "+(super.counter+this.counter+counter));
	}
	public static void main(String ...args)
	{
		new ChildOfSkE1(45).addAll(50);
	}
}


// Uses of "super" keyword//
/*
(1) "Super" keyword can be used to refer the immediate parent class instance variable.
*/
class SuperKeywordEx2
{
	static int i;
}
class ChildOfSkE2 extends SuperKeywordEx2
{
	static int i;
	void set()
	{
		super.i=20;
		this.i=20;
	}
	void add()
	{
		System.out.println(super.i+this.i);
	}
	public static void main(String ...args)
	{
		new ChildOfSkE2().set();
		new ChildOfSkE2().add();
	}
}
/*
"super" keyword can be used to invoke immediate parent class method.
*/
class SuperKeywordEx3
{
	public void show()
	{
		System.out.println("this is parent class method");
	}
}
class ChildOfSkE3 extends SuperKeywordEx3
{
	public void show()
	{
		System.out.println("this is child class method");
	}
	public void display()
	{
		super.show();
		this.show();
	}
	public static void main(String ...args)
	{
		new ChildOfSkE3().display();
	}
}
/*
(3) "super" keyword can be used to invoke the immediate parent class constructor.
*/
class SuperKeywordEx4
{
	SuperKeywordEx4()
	{
		System.out.println("parent class cons...");
	}
}
class ChildOfSkE4 extends SuperKeywordEx4
{
	ChildOfSkE4()
	{
		super();
		System.out.println("child class cons...");
	}
	void show()
	{
		//super();
		//this();
		
		//the above terms are only applicable inside constructors.
	}
	public static void main(String...args)
	{
		new ChildOfSkE4();
	}
}
class SuperKeywordEx5
{
	public void show()
	{
		System.out.println("parent class method");
	}
}
class ChildOfSkE5 extends SuperKeywordEx5
{
	public void show()
	{
		System.out.println("child class method");
	}
	public void showAll()
	{
		super.show();
		this.show();
	}
	public static void main(String ...args)
	{
		new ChildOfSkE5().showAll();
	}
}

//"final" keyword
/*
-This keyword can only be used with variables, methods and classes.

(1) variable : If a variable is declared final then we can't change its value.

(2) method : When a method is declared final then we can't override it.

(3) class : When a class is declared final then we can't create its child class.

*/
class FinalVariable
{
	public static void check(final int y)
	{
		//y=50;// here we can't reassign the final variable y
		System.out.println("y : "+y);
	}
	public static void main(String ...args)
	{
		FinalVariable.check(10);
	}
}
class FinalMethod
{
	private final void show()
	{
		System.out.println("parent class method");
	}
	void display()
	{
		show();
	}
}
class ChildOfFM extends FinalMethod
{
	//public void show()
	{
		//System.out.println("child class method...");
		//super.display();
	}
	public static void show1()
	{
		//super.display();
		
		
		//inside static area, "this" & "super" are not allowed.
		
		
		
	}
	public static void main(String ...args)
	{
		new ChildOfFM().display();
	}
}
final class FinalClass
{
}
class ChildOfFC //extends FinalClass
{
	//we can't make child class of a class declared final.
}



/*

IMPORTANT FACTS REGARDING "this" and "super" KEYWORDS
-----------------------------------------------------

(1)

(a)- Inside a constructor, we can invoke other constructors by using     "this(args)"  &
"super(args)" and these keywords must be first statement inside the constructors. we can't
use both of them at a time inside the constructors.
 
(b)- Inside a method we can't use "this(args)" & "super(args).
	
(c)- But the keywords "this" & "super" both can be used at a time an ay where inside any
blocks( e.g. cons,instance methods etc ) except static area. 
 
 
*/
class RulesOfThisAndSuperKeywords
{
	int i;
	RulesOfThisAndSuperKeywords()
	{
		System.out.println("parent class zero arg constructor.");
	}
}
class ChildOFROTASK extends RulesOfThisAndSuperKeywords
{
	int i;
	
	ChildOFROTASK()
	{
		//this(10);
		//super();
		//at a time both not allowed 
		
		
		System.out.println("child class zero arg constructor");
	}
	ChildOFROTASK(int i)
	{
		this();//allowed
		System.out.println("child class one arg constructor");

		super.i=60;//allowed
	}
	ChildOFROTASK(float i)
	{
		System.out.println("child class one arg with float type local variable cons.");
		//super();//not allowed because the statement must be first statement
		this.i=80;//allowed.
	}
	
	public void display1()
	{
		//this();//this statement is not allowed inside method
		
		System.out.println("child class display3 method");
		
		this.i=45;//allowed
		super.i=333;//allowed
	}
	
	public void display2()
	{
		//super();//this statement is not allowed inside method
	}
	
	public void display3()
	{
		System.out.println("child class display3 method");
	}

	public static void main(String ...args)
	{
		new ChildOFROTASK();
	}
}

/*

Assumptions regarding "super" and "this" keywords in inheritance :
------------------------------------------------------------------


Assumption-1:
-------------
- If the parent class doesn't have any constructors and at such situation, we call the
0-arg constructor of the parent class from the constructors inside the child class then
the compiler won't generate any error.
										Because, we know that if we don't provide any type 
of constructor inside a class then at compile time the compiler will automatically generate
0-arg default constructor.										
*/

class Parent1
{
	// here we aren't providing any kind of constructor.
	
}
class Child1 extends Parent1
{
	Child1()
	{
		super();
		System.out.println("Child class 0 arg cons");
	}
	Child1(int i)
	{
		this(new Parent1());
		//System.out.println("Child class 1 arg int type cons");		
	}
	Child1(Parent1 p)
	{
		System.out.println(p);
		System.out.println("Child class 1 arg class type cons");		
	}
	public static void main(String ...args)
	{
		new Child1();
		new Child1(1);
	}
}


/*

Assumption-2
------------


In case of parent class having parameterized constructors and the child class has user 
defined constructors(either parameterized or non parameterized cons) then we must have 
to provide "super()" or "this()"statement inside all constructors of the child class 
otherwise we will get compile time error.
									

*/
class Parent2
{
	Parent2(int x)
	{
		System.out.println("parent class 1 arg int type cons");
	}
	Parent2()
	{
		System.out.println("parent class 1 arg int type cons");		
	}
}
class Child2 extends Parent2
{
	//in the following constructors we must have to provide "this()" or "super()" statement
	//inside all constructors and inside any one constructor "super()" statement is
	//mandatory either provided by us or by compiler automatically.
	Child2()
	{
		//this(10);
		System.out.println("child class 0 arg cons");
	}
	Child2(int x)
	{
		this("zzzz","wwww","tttt","uuuu");
		System.out.println("child class 1 arg int type constructor");
	}
	Child2(String ...x)
	{
		super(10);
		System.out.println(" child class var arg cons");
	}
	public static void main(String ...args)
	{
		new Child2();
	}
}












//POLYMERPHISM//


/*

- The ability to appear more than one form is called polymerphism.

- In java, polymerphism is of two types.


(1) overloading(compile time polymerphism/static binding/early binding)

(2) overriding(runtime polymerphism/dynamic binding/late binding/)




(1) Overloading:
----------------

-To achieve overloading one java class is required.

- There are 3 types of overloading 

  (i) method overloading
 (ii) constructor overloading
(iii) operator overloading





(i) method overloading:
-----------------------

- When we declare more than one methods having different signature inside a class that is 
called method overloading and those methods are called overloaded methods.



- rules to achieve method overloading :
---------------------------------------

- method names must be same.
- return_type must be same.
- If there are same type and same number of parameters then the order must be different.

*/

class MethodOverloading
{
	public void display()
	{
		System.out.println("0 arg method");
		
	}
	public void display(int x)
	{
		System.out.println("1 arg int type method");
	}
	
	public void show(int x,double y)
	{
		System.out.println("int-double");
	}
	public void show(double y,int x)
	{
		System.out.println("double-int");
	}
	public static void main(String [] args)
	{
		MethodOverloading mo=new MethodOverloading();
		
		mo.display();
		mo.display(10);
		mo.show(10,23.45);
		mo.show(245.54,345);
	}
}
/*

Var-args method
---------------



*/

/*
(ii) constructor overloading:
----------------------------

When a class have more than one constructor having different number of parameters then that
is called constructor overloading.

*/


class ConstructorOverloading
{
	private int length;
	private int bredth;
	
	ConstructorOverloading(int length,int bredth)
	{
		this.length=length;
		this.bredth=bredth;
	}
	ConstructorOverloading(int length)
	{
		this.length=length;
	}
	
	public void setLength(int length)
	{
		this.length=length;
	}
	public void setBredth(int bredth)
	{
		this.bredth=bredth;
	}
	
	public int getArea()
	{
		return length*bredth;
	}
	
	public static void main(String ...args)
	{
		ConstructorOverloading co=new ConstructorOverloading(50,30);
		
		System.out.println("The area of the structure is : "+co.getArea());
		
		co.setLength(70);
		System.out.println("The area of the structure is : "+co.getArea());
		
	}
}
/*
o|p: 
The area of the structure is : 1500
The area of the structure is : 2100
*/


/*
(iii) operator overloading:
---------------------------

- The ability to behave differently at different situations is called operator overloading.

- In java, there is only one overloaded operator that is "+". This operator supports over
loading implicitly.
*/

class OperatorOverloading
{
	public static void main(String ...args)
	{
		System.out.println(20+30);            //50
		System.out.println("satya"+"prakash");//satyaprakash
		System.out.println("satya"+20);       //satya20
		System.out.println(56+"satya"+30+40); //56satya3040
	}
}



/*
(2) overriding:
---------------


- Method overriding.


- To achieve method overriding we require 2 java classes with inheritance relationship.

-While overriding we must follow the following 7 rules.
*/



/*

rule-1:
------

-Both overridden method and the overriding method must have same signature.
*/

class MethodOverriding1
{
	public void display1()
	{
		System.out.println("overridden method");
	}
}
class ChildOfMethodOverriding1
{
	public void display1()
	{
		System.out.println("overriding method");
	}
	public static void main(String ...args)
	{
		new ChildOfMethodOverriding1().display1();
	}
}

/*

rule-2:
-------

-At primitive level, the return_type of both overridden method and the overriding method
must be same. 

- But at class level, the overridden method and overriding method can have different
return_type. In such a case, if the overridden method has parent class return_type then
the overriding method must have child class return_type. 

*/



class AA{}
class BB extends A{}

class MethodOverriding2
{
	public AA display1(){System.out.println("overridden");return new AA();}
}
class ChildOfMethodOverriding2
{
	public BB display1(){System.out.println("overriding");return new BB();}
	
	public static void main(String ...args)
	{
		new ChildOfMethodOverriding2().display1();
	}
}



/*

rule-3:
-------

-  "final" keyword- applicable for class, method, variable.


- If the parent class is declared final then we can't inherit it i.e. we can't make its
child class. 
 
- final class methods are by default final.

- If a method is declared final then we can't override it in the child class.


- If a variable is declared final then we can't reassign its value.

- The only modifier applicable for local variables is "final".


- final class variables aren't final.
*/

final class FinalClass1
{
}
class ChildOffinalClass //extends FinalClass1//
{
}


class FinalMethods
{
	final void display()
	{
		System.out.println("final method");
	}
}
class childOfFinlaMethod extends FinalMethods
{
	//final void display()
	{
		
	}
}

class FinalVariables
{
	final int x;
	FinalVariables(int x)
	{
		this.x=x;
	}
	public int get()
	{
		
		//x=10;
		final int a=10;
		//a=a+10;//error**********************
		
		
		return x;
	}
	public static void main(String ...args)
	{
		System.out.println(new FinalVariables(1000).get());
	}
}


/*

rule-4:
-------

- Static methods can't be overridden. To interpret this, lets understand the following 
concept.

* The parent class reference variable can hold child class object. In such case, we can
access the overriding methods of the child class and non overridden methods of the parent 
class but we can't access the non overriding methods inside the child class.


why ?


ans : When Parent class reference variable holds the child class object,then at compile
time the compiler will check whether the methods that we want to execute are present inside
the parent class or not. At run time the overriding methods are executed.


*/

class Parent3
{
	public void display1()
	{
		System.out.println("parent class display1 method");
	}
	public void display2()
	{
		System.out.println("parent class display2 method");
	}
	
}
class ChildOfParent3 extends Parent3
{
	public void display1()
	{
		System.out.println("child class display1 method");
	}
	public void show()
	{
		System.out.println("child class show method");
	}
	
	public static void main(String ...args)
	{
		Parent3 p=new ChildOfParent3();
		
		p.display1();
		p.display2();
		//p.show();// can't access this method
		
		
		
	}
}

/*
- How to access the non overriding methods of the child class the parent class reference
variable that is holding the child class object ?


ans: In such case we have 2 options 
i- we can create the child class object holded by child class reference variable and 
by using that object we can access those non  overriding methods inside the child class.

ii- We can also typecast the parent class variable which is holding the child class object.
 How ?
 
 lets see the following example.

*/

class TypeCaseTheParentClassReference
{
	public static void main(String ...args)
	{
		Parent3 p=new ChildOfParent3();
		
		p.display1();
		p.display2();
		
		
		//lets typecast
		
		ChildOfParent3 c=(ChildOfParent3)p;
		c.show();
		c.display2();
		
	}
}


/*
But in case of static methods :---


- The static methods deal with class loading but not with the objects.
So we can't override the static methods.

-when we are trying to overriding the static methods and want to access through the parent
class reference variable which is holding the child class object the we always get the
out put of the parent class static method. 
*/
class Parent4
{
	public static void display()
	{
		System.out.println("parent class static method");
	}
}
class ChildOfParent4 extends Parent4
{
	public static void display()
	{
		System.out.println("child class static method");
	}
	public static void main(String ...args)
	{
		Parent4 p=new ChildOfParent4();
		
		p.display();// here we never get the child class method.
	}
}


















// Abstraction //




/*

- The process of highlighting the set of services but hiding the internal implementations
is called abstraction.

- In java we can achieve abstraction using : i- abstract class
											 ii- interface
											 
											 
											 
- Abstract class :
------------------


-A class is said to be abstract if it is declared with a keyword "abstract" and inside that
class we may or may not declare abstract methods.

what is abstract method ?

-A Method is said to be abstract if it is declared abstract and that method can only be 
declared with semicolon. It has no definition( method body).


-Normal class VS abstract class :
-----------------------------

- Inside an abstract class we may or mayn't declare abstract methods but inside a normal
class can't have abstract methods and all the methods must be normal i.e those methods 
must have their definition.

- In case of normal class, we can create an object but we can't create object of an abstract
class.

-When a normal class inherits another normal class then we may or mayn't override the parent
class methods but in case of inheriting an abstract class, inside that child class we have
to override all the abstract methods of the parent class.

note: in case of not overriding all the abstract methods of the parent class, the child class
must have to be declared abstract and if a new child class inherits that previous child class
we have to override the remaining abstract methods otherwise we have to declare that child
class abstract. This process will go on till all the abstract methods are overridden.


-Inside an abstract class, we can declare normal as well as abstract methods. But if a method
is declared abstract then the associated class must be abstract class.  


*/

abstract class AbstractClass1
{
	abstract void display1();
	
	public void display2()
	{
		System.out.println("parent class display2 method");
	}
}
class ChildOfAbstractClass1 extends AbstractClass1
{
	public void display1()
	{
		System.out.println("we are overriding the abstract method of the parent class");
		
	}
	public static void main(String ...args)
	{
		AbstractClass1 ac=new ChildOfAbstractClass1();
		ac.display1();
		ac.display2();
	}
}


abstract class AbstractClass2
{
	abstract void display1();
	abstract void display2();
	abstract void display3();
	abstract void display4();
}
abstract class Child1OfAbstractClass2 extends AbstractClass2
{
	public void display1()
	{
		System.out.println("display1 method");
	}
}
abstract class  Child2OfAbstractClass2 extends Child1OfAbstractClass2
{
	public void display2()
		{
			System.out.println("display2 method");
		}	
}

abstract class  Child3OfAbstractClass2 extends Child2OfAbstractClass2
{
	public void display3()
		{
			System.out.println("display3 method");
		}	
	}


class  Child4OfAbstractClass2 extends Child3OfAbstractClass2
{
	public void display4()
		{
			System.out.println("display4 method");
		}	
		public static void main(String ...args)
		{
			Child4OfAbstractClass2 ca=new Child4OfAbstractClass2();
			ca.display1();
			ca.display2();
			ca.display3();
			ca.display4();
		}
}

/*
- Inside abstract class we can declare the main method.
- Inside abstract class we can declare a constructor.
-Inside abstract class, we can declare the initializer blocks.
-Inside abstract class , we can declare the variables but those variables can't be abstract.

- Except all the constraints of a class , only method can be declared abstract.  
*/


abstract class AbstractClass3
{
	AbstractClass3()
	{
		System.out.println("This is abstract class constructor");
	}
	
	{
		System.out.println("This is abstract class instance block");
	}
	static
	{
		System.out.println("This is abstract class static block");
	}
	
	abstract void display();
	
	public static void main(String ...args)
	{
		AbstractClass3 ac= new ChildOfAbstractClass3();
		ac.display();
	}
}
class ChildOfAbstractClass3 extends AbstractClass3
{
	public void display()
	{
		System.out.println("we are overriding the abstract class display method.");
	}
}



/*

o|p:
This is abstract class static block
This is abstract class instance block
This is abstract class constructor
we are overriding the abstract class display method.
*/





// Interface //


/*

- It is otherwise called 100% abstract class.

- The methods inside an interface are by default public and abstract.

- The variables inside an interface are by default public, static and final. So we can't 
reassign the value of a variables of an interface.

- If a class implements an interface then inside that class we must have to override
all the abstract methods otherwise we have to declare that class abstract and so on.

- Interface reference variable can hold the child class object.

- We can't create the object of an interface.

- Inside an interface we can......................................... 
*/


interface Interface1
{
	void display1();
	void display2();
	void display3();
}
class ChildOfInterface1 implements Interface1
{
	public void display1()
	{
		System.out.println("We are overriding the display1 method");
	}
	public void display2()
	{
		System.out.println("We are overriding the display2 method");
	}
	public void display3()
	{
		System.out.println("We are overriding the display3 method");
	}
	public static void main(String ...args)
	{
		Interface1 i=new ChildOfInterface1();
		i.display1();
		i.display2();
		i.display3();
	}
}




/*

- One class can extends only one class at a time.
- But one class/ interface can implements multiple interfaces at a time.

- One class can extend another class and at the same time it can implements multiple
interfaces. But in such case, "extends" keyword must be written followed by "implements"
keyword.
*/ 


class AAA{}
class BBB{}
interface CCC{}
interface DDD{}

class EEE extends AAA implements CCC,DDD
{
	public static void main(String ...args)
	{
		new EEE();
	}
}


/*

case study:

1: when multiple interfaces contains same abstract methods, then inside the child class we are 
required to override only one method( of the same methods). 


2: When multiple interfaces contain same variables then we have to access those variables
through their interface names otherwise we will get ambiguous error.

*/


interface Interface2
{
	int x1=100;
	void display1();
}
interface Interface3
{
	int x1=300;
	void display1();	
}
class ChildOfI1AndI2 implements Interface2,Interface3
{
	public void display1()
	{
		System.out.println("we are overriding the display1 method");
		System.out.println(Interface2.x1+" & "+Interface3.x1);
	}
	public static void main(String [] args)
	{
		new ChildOfI1AndI2().display1();
	}
}




/*

Adopter class :
---------------

- An adopter class is a class which implements one or multiple interfaces and inside that
class all the abstract methods are overridden but with empty implementation inside those
methods.

- Why we need an adopter class ?

ans: If a class directly implements any interface then we have to override the abstract
methods otherwise we have to declare that child class abstract. But when we use an adopter
class as a child class of that interface/abstract class then we don't have to declare the
child class of the adopter class abstract, i.e. when we inherit that adopter class we can 
override our required number of methods.  


-we can easily interpret the above statement with the following examples. 

*/


// without adopter class

interface Interface4
{
	public void display1();
	public void display2();
	public void display3();
	public void display4();
	public void display5();
}
abstract class Child1OfInterface4 implements Interface4
{
	// here we have to override all the abstract methods otherwise we have to declare this
	//class abstract.
	
	public void display1()
	{
		System.out.println("d1");
	}
	public void display2()
	{
		System.out.println("d2");
	}
}
class Child2OfCH1 extends Child1OfInterface4
{
	public void display3()
	{
		System.out.println("d3");
	}
	public void display4()
	{
		System.out.println("d4");
	}
	public void display5()
	{
		System.out.println("d5");
	}
	public static void main(String ...args)
	{
		new Child2OfCH1().display1();
		new Child2OfCH1().display2();
		new Child2OfCH1().display3();
		new Child2OfCH1().display4();
		new Child2OfCH1().display5();
	}
	
}




// with adopter class


class AdopterClass1 implements Interface4
{
	public void display1(){}
	public void display2(){}
	public void display3(){}
	public void display4(){}
	public void display5(){}
}
class ChildOfAdopterClass1 extends AdopterClass1
{
	// here we can override our required methods and we don't have to declare this class
	//abstract
	
	
	// suppose our requirement is only to override the display4() methods
	public void display4()
	{
		System.out.println("d4");
	}
	public static void main(String ...args)
	{
		new ChildOfAdopterClass1().display4();
		new ChildOfAdopterClass1().display3();
	}
}


// nested interfaces //



/*

- Interface declared inside another interfaces/normal classes/abstract class is called 
nested interface.

- i.e interface can be declared inside 
										
										i: inside another interface
										ii: inside a class
										iii: inside an abstract class
										



*/


//Interface inside another interface






interface Interface5
{
	void m1();
	interface Interface6
	{
		void m2();
	}
}
class NestedIDemo1 implements Interface5,Interface5.Interface6
{
	public void m1(){System.out.println("m1");}
	public void m2(){System.out.println("m2");}
	
	public static void main(String ...args)
	{
		Interface5.Interface6 i1=new NestedIDemo1();

		Interface5 i2=new NestedIDemo1();
		//i1.m1();
		i1.m2();
		i2.m1();

	}
}




// interface inside abstract class


abstract class AbstractClass4
{
	abstract void m1();
	interface Interface1
	{
		void m2();
	}
}

class NestedIDemo2 extends AbstractClass4 implements AbstractClass4.Interface1
{
	public void m1(){System.out.println("m1");}
	public void m2(){System.out.println("m2");}
	
	public static void main(String ...args)
	{
		AbstractClass4 o1= new NestedIDemo2();
		AbstractClass4.Interface1 o2=new NestedIDemo2();
		o1.m1();
		o2.m2();
	}
}



// Interface inside a class

class Class2
{
	interface Interface1
	{
		void m1();
	}
	
}
class Class3 implements Class2.Interface1
{
	public void m1(){System.out.println("m1");}
	public static void main(String ...args)
	{
		Class2 obj1=new Class2();
		Class2.Interface1 obj2=new Class3();
		obj2.m1();
		
	}
}







// Var-args methods //


/*

- What will happen if you don't know how many arguments you need to pass ?
- What will happen if you want to pass unlimited variables to the parameter_list of a 
method ?


ans:  Using varargs concept we can pass unlimited variables to the parameter_list of a
method.

- Using var_arg concept we can pass as many as parameters( same type) without any restriction.


syntax : modifier return_type method_name(type ...variable_name) 


- We can easily interpret the var_args concept in the following examples
*/


// without var_args

class Class6
{
	public void show(int x)
	{
		System.out.println(x);
	}
	public void show(int x,int y)
	{
		System.out.println(x+" "+y);
	}
	public void show(int x,int y,int z)
	{
		System.out.println(x+" "+y+" "+z);
	}
	public void show(int x,int y,int z,int p)
	{
		System.out.print(x+" "+y+" "+z+" "+p);
	}
	public static void main(String ...args)
	{
		Class6 c=new Class6();
		
		c.show(10);
		c.show(10,20);
		c.show(10,20,30);
		c.show(10,20,30,40);
	}
}


//with var_args concept

class Class7
{
	public void show(int ...x)
	{
		for(int i:x)
		{
			System.out.print(i+" ");
		}
	}
	public static void main(String ...args)
	{
		Class7 c=new Class7();
		c.show(10);
		c.show(10,20);
		c.show(10,20,30);
		c.show(10,20,30,40);
	}
}


/*
- Var_args works as 1-d array, so we can pass 1-d array as argument during method calling.

*/
class Class8
{
	public void display(int ...x)
	{
		System.out.println(x[4]);
	}
	public static void main(String ...args)
	{
		Class8 c=new Class8();
		c.display(20,33,3554,2342,243);
		
		
		int [] x={12,13,535,77,343,8978};
		c.display(x);
	}
}

/* 
-If we create var_arg method and call it with no argument then we will not get any error.
*/
class Class9
{
	public void display(int ...x)
	{
		System.out.println("var_args method");
	}
	public static void main(String ...args)
	{
		new Class9().display();// valid.
	}
	
}

/*
- If we want to provide simple parameter_type with a var_arg type then the simple type must
be first parameter inside the parameter_list.
*/

class Class10
{
	public void display(int ...x/*,double y*/)// var_arg at first isn't allowed. 
	{
		// invalid
	}
	public void display(double y,int ...x)// valid 
	{
		System.out.println("valid");
	}
	public static void main(String ...args)
	{
		Class10 c=new Class10();
		c.display(12.33,42,243,243);
	}
}

/*
- inside a single method , more than 1 var_args is not allowed.  

- But while overloading, the all overloaded methods can have var_args(but different type)
  
*/
class Class11
{
	public void display(int ...x)
	{
		System.out.println("int type var_arg");
	}
	public void display(double ...x)
	{
		System.out.println("double type var_arg");
	}
	public void display(String ...x)
	{
		System.out.println("String type var_arg");	
	}
	
	public static void main(String ...args)
	{
		Class11 c=new Class11();
		
		c.display(100,232,33);
		c.display(13.132,1231.213);
		c.display("sda","tensorflow");
	}
}

/*
-The following example will arise compile time error.

*/

class Class12
{
	public void show(int ...x)
	{
	}
	public void show(boolean ...z)
	{
	}
	public static void main(String ...args)
	{
		Class12 c=new Class12();
		//c.show();  //ambiguous error
	}
}
/*
- In the above example we will get ambiguous error because when we call the show method
with no arguments then the compiler will unable to decide which method it should call. In
such case , the compiler will generate error message saying ambiguous error. 

*/

/*

- Var_args method can receive only 1-d array. And passing array other than 1-d array 
directly is not allowed.


note: combination of multiple 1-d array = 2-d array.
	  combination of multiple 2-d array = 3-d array.

*/

class Class13
{
	public void m1(String ...str)
	{
		System.out.println(str.length);
		
		for(String i:str)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void main(String ...args)
	{
		String [] str1={"tensorflow","machine learning","deep leraning"};
		
		String [] str2={"javafx","zzz","block chain"};

		String str3="This is ";
		String str4="valid ";
		Class13 c=new Class13();
		
		//c.m1(str1,str2);//error: method m1 in class Class13 cannot be applied to given types;
		
		c.m1(str1);// valid
		c.m1(str2);// valid
		c.m1(str3,str4);// valid
	}
}


/*

-How to pass 2-d array ?

ans : 

syntax :: variable_type []...variable_name

ex : pubic void m(int []... a)






-How to receive 3-d array ?

ans:

syntax :: variable_type [][]...variable_name

ex : pubic void m(int [][]... a)


*/
class Class14
{
	//here we are creating 2-d type var_arg to receive 2-d array while calling
	public void show(int []...counter)
	{
		for(int[] i:counter)
		{
			for(int j:i)
			{
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String ...args)
	{
		
		int [][] x={{12,23,566,77},{2,62,29,4,42},{73,41,35,82,25,755}};
		new Class14().show(x);
	}
}

// to receive 3-d array

class Class15
{
	public void display(int [][]... x)
	{
		for(int i[][]:x)
		{
			for(int j[]:i)
			{
				for(int k:j)
				{
					System.out.print(k+" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String [] args)
	{
		int [][][] x={
					{{1,2,3},{4,5,321},{3,5,6}},
					{{0,243,243},{4,5,321},{23,734,2}},
					{{234,53,1233},{7,34,23},{27,8,36}}
					 };
		
		new Class15().display(x);
	}
}

















//   MULTITHREADING PROGREMMING  //




/*


THREAD :
--------


- Threads are light weight processes of the same application in which these are executed 
in parallel.



- What is multi_threading ?


ans- executing more than one thread simultaneously where each thread is separate individual 
process of the same application is called multi_threadig. 



- To achieve multi_threading we have two ways, those are :
											
												i : by extending Thread class
												ii : by implementing Runnable interface.
												
												* Both the above class and the interface
												are present inside the lang_package.
												


*/


//ex:1 (By extending Threrad class)

class MyThread1 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread 1");
		}
	}
}
class ThreadDemo1
{
	public static void main(String ...args)
	{
		MyThread1 t1=new MyThread1();
		
		t1.start();
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
		}
	}
}


//ex:2 (by implementing Runnable interface)

class MyThread2 implements Runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			try
			{
				Thread.sleep(750);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println("user thread");
		}
	}
}
class ThreadDemo2
{
	public static void main(String ...args)
	{
		Runnable r=new MyThread2();
		Thread th=new Thread(r);
		//MyThread2 th=new MyThread2();
		th.start();
		
		// main thread functionality
		for(int i=1;i<=5;i++)
		{
			try
			{
				Thread.sleep(750);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println("main thread");
		}
	}
}


/*

Single_Threaded application :
------------------------------


- If the application contains only one thread then that application is called single threaded
application.


- What is main thread ?

- When an application start its execution from main method , then one thread starts auto-
_metically that thread is called main thread.
*/




/*

- If the application contains multiple threads then we can't conform the exact execution
order. The execution order is only decided by the Thread_scheduler which is an integral
part of JVM.

- The Thread_scheduler follows different algorithms to execute those threads. Some of the
algorithms are :  preemptive algorithm, time slice algorithm etc.
 
 
 
 What happens when we call start() method ?
 ------------------------------------------
 
 
 - When we call start() method there are 2 actions performed :
					
															i: our user threads are 
															registered into the T.S.
															
															ii: internally start() method
															calls run() method of Thread
															class.

note:
-----
- The Thread class run() method has empty implementation. The run() method get the 
functionality when we override it inside user thread class.															
															
*/



/*
case-1: (if we call call run() method instead of start() method)
----------------------------------------------------------------

- When we do so, our class run() method will execute just like a normal method call and
in such case, our thread will not be created.

*/

class MyThread4 extends Thread
{
	public void run()
	{
		// functionality
	}
}
class ThreadDemo3
{
	public static void main(String [] args)
	{
		MyThread4 t=new MyThread4();
		
		//here instead of calling start() method, we are calling run() method
		// so it will work just like a normal method call.
		
		t.run();
	}
}
/*

case-2:( if we don't override the Thread class run() method)
------------------------------------------------------------

- In such case, The Thread class run() method will be executed. As Thread class run() 
method has empty implementation, we don't get any output of that user thread. But in such
case, our thread will be created because we will have called the start() method.

*/

class MyThread5 extends Thread
{
	//this class can have functionalities but ,here we are not overriding the Thread class
	//run() method.
	
}
class ThreadDemo4
{
	public static void main(String ...args)
	{
		MyThread5 mt=new MyThread5();
		mt.start();
	}
}
/*
case:3 (If we override the start() method)
------------------------------------------

in such case, the application will be executed just like a normal method call because if
we override the start() method and call it then Thread class start() method will not be 
executed.

*/
class MyThread6 extends Thread
{
	public void start()
	{
	}
	public void run()
	{
	}
}

class ThreadDemo5
{
	public static void main(String ...args)
	{
		MyThread6 mt=new MyThread6();
		mt.start();
	}
}
/*

case:4 (If we overload the run() method inside our thread class)
----------------------------------------------------------------

-When we call start() method, it only internally calls the 0-arg run() method. So in this
case, if we have 0-arg run() method in our thread class then that method only be executed
otherwise no output will be shown for our thread class and if we want to execute the over_
loaded run() method then we have to explicitly call them.
*/

class MyThread7 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread");
		}
	}
	public void run(int x)
	{
		System.out.println("over loaded run() method");
	}
}
class ThreadDemo6
{
	public static void main(String ...args)
	{
		MyThread7 mt=new MyThread7();
		mt.start();
		mt.run(10);
	}
}

/*
-Multiple threads can execute single task as well as multiple task at a time.

*/

class MyThread8 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread1");
		}
	}
}
class MyThread9 extends MyThread8
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread2");
		}
	}
}
class MyThread10 extends MyThread9
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread3");
		}
	}
}
class MyThread11 extends MyThread10
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread4");
		}
	}
}
class ThreadDemo7
{
	public static void main(String ...args)
	{
		// the followings are multiple threads performing single task.
		MyThread8 mt1=new MyThread8();
		MyThread8 mt2=new MyThread8();
		MyThread8 mt3=new MyThread8();
		MyThread8 mt4=new MyThread8();
		MyThread8 mt5=new MyThread8();
		
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		mt5.start();
		
		
		
		//the followings are multiple thread performing multiple tasks.
		
		MyThread8 mt10=new MyThread8();
		MyThread9 mt20=new MyThread9();
		MyThread10 mt30=new MyThread10();
		MyThread11 mt40=new MyThread11();
		
		mt10.start();
		mt20.start();
		mt30.start();
		mt40.start();

	}
}


/*
Names of threads:
-----------------

- default names : The default name of the main thread is : main & other child threads have
names starting from : thread0
					  thread1
					  thread2
					  thread3.... & so on.

setNAme() and getName() method :
--------------------------------			
- We can also change the default name of any thread by using setName() method and get the
name of the thread by using getName() method. Both methods return string value.


- isAlive() method :
--------------------

- Using this method, we can know whether the target thread is alive or not.  This method
returns boolean value.


activeCount() method :
----------------------

- This method returns the total active threads.




getId() method :
----------------

return an integer value that indicates the id of the target thread.
*/

class MyThread12 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread");
		}
	}
}
class ThreadDemo8 
{
	public static void main(String ...args)
	{
		//default names
		System.out.println("default names");
		System.out.println();
		MyThread12 mt=new MyThread12();
		System.out.println(mt.getName());
		System.out.println(Thread.currentThread().getName().toString());
		
		//customized names
		System.out.println();
		mt.setName("user_Thread");
		Thread.currentThread().setName("super_thread");
		
		System.out.println("get the customized names");
		System.out.println();
		System.out.println(mt.getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println();
		//checking the threads are alive or not
		System.out.println("alive threads");
		System.out.println();
		System.out.println(mt.isAlive());
		System.out.println(Thread.currentThread().isAlive());
		System.out.println();
		
		//checking the total active threads
		System.out.println("active threads");
		System.out.println();
		System.out.println(Thread.activeCount());
		System.out.println();
		
		//checking the ids of the threads
		System.out.println("ids");
		System.out.println();
		System.out.println(mt.getId());
		System.out.println(Thread.currentThread().getId());
	}
}




/*

Thread priority:
----------------


- The execution order of multiple threads is decided in terms of priority number of the 
threads.

- The default priority of the main thread is 5.

- The thread priority ranges from :1 to 10

- There are also some constant priorities.
						
									MIN_PRIORITY (VAL:1)
									NORM_PRIORITY (VAL:5)
									MAX_PRIORITY (VAL:10)


- Threads having more priority have more chance to be executed first.

- If the multiple thread have same priorities then we can't expect the exact execution
order of the application. Thread_scheduler will decide the execution order of those threads
using its algorithm.



setPriority() & getPriority() method:
-------------------------------------

- These methods are used to set and get the priorities of the threads.


note: If we set the priority of a thread other than between 0 & 10 then the compiler will
throw error saying : illegalArgumentException

*/

class ThreadDemo9
{
	public static void main(String ...args)
	{
		MyThread12 mt=new MyThread12();
		
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(mt.getPriority());
		
		mt.setPriority(Thread.MAX_PRIORITY);
		mt.start();
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
		}
	}
}

/*
Hook Thread:
------------


- If we want to perform any task before the termination of JVM( either normally or 
abnormally), then we should use hook thread concept.

- We can interpret and get more clarity by the following example :

- Suppose, a thread is in running state. After completion of execution of that thread &
before termination(eihter normal or abnormal) of JVM we want to perform a task. In such 
case, that task(thread) has to be converted into hook thread.


- How to make a simple thread into hook thread ?

step1: create the thread class and add the functionalities that we require to perform 
before the termination of JVM.

step2: create that thread class object.

UserThread t=new UserThread();

step3: convert that thread into hook thread by using addShutdownHook() method which is
present inside the Runtime class

Runtime r=new Runtime();
r.addshutdownHook(t);



*/

class ThreadDemo10
{
	public static void main(String ...args)
	{
		MyThread12 mt=new MyThread12();
		
		
		Runtime r=Runtime.getRuntime();
		r.addShutdownHook(mt);
		for(int i=0;i<=25;i++)
		{
			System.out.println("main thread :"+i);
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			if(i==15)
			{
				System.exit(0);
			}
		}
	}
}


/*to understand it please check the output from cmd and while te application is running,
enter ctrl+c for abnormal termination & before termination you can check the hook thread
execution.
*/ 
 
 
/*
Daemon thread :
---------------


- The threads that are executed at background to support the foreground threads are called
daemon threads.

-In java there are some in_built daemon threads : garbage collector

												  Thread_scheduler
												  
												  default exception handler
												  etc.

												  
- We can also make the user defined thread into daemon thread by using setDaemon(boolean)
method.

-behavior of daemon thread : Once the foreground threads complete their execution, the
daemon threads also stop execution automatically whether those daemon threads complete
their execution or not.  

*/


class ThreadDemo11
{
	public static void main(String ...args)
	{
		MyThread12 mt=new MyThread12();
		
		mt.setDaemon(true);
		mt.start();
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
		}
	}
}

class MyThread13 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			try
			{
				Thread.sleep(700);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println("user thread");
		}
	}
}
class ThreadDemo12
{
	public static void main(String ...args)
	{
		MyThread13 t=new MyThread13();
		t.start();
		try
		{
			t.join();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		for(int i=0;i<=4;i++)
		{
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.println("main thread");
		}
	}
}



/*
join() method :
---------------


- If we want to stop the execution of the current thread until completion of the target
thread then we should use join() method.

ex: Suppose there are 2 threads namely main thread and user thread. Our requirement is to
stop the execution of main thread until completion of user thread.

*/

class MyThread14 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread");
			
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
class ThreadDemo13
{
	public static void main(String ...args)throws InterruptedException
	{
		MyThread14 t=new MyThread14();
		
		t.start();
		t.join();
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
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

/*

- We can also provide time duration to join() method.
- In such case, if the target thread doesn't complete its execution within the time limit
then other threads will be executed in parallel.
*/

class MyThread15 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread");
			
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
class ThreadDemo14
{
	public static void main(String ...args)
	{
		MyThread15 t=new MyThread15();
		
		t.start();
		
		try
		{
			t.join(1800);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
			
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		
	}
}


/*

interrupt() method :
--------------------


- If a thread is in sleeping state or waiting state then other thread can interrupt that
target thread by using interrupt() method.

- In case of the target thread not in sleeping state or waiting state then interrupt()
method doesn't affect that target thread but the interrupt call will save a flag to true
for that thread.

*/



class MyThread16 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("user thread");
		}
	}
}
class ThreadDemo15
{
	public static void main(String ...args)
	{
		MyThread16 t=new MyThread16();
		
		t.start();
		
		t.interrupt();
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("main thread");
			
			try
			{
				Thread.sleep(400);
				
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		
		boolean b=t.isInterrupted();
		System.out.println(b);
		
	}
}

/*


creating threads by using inner class concept:
----------------------------------------------



*/

class ThreadDemo16
{
	public static void main(String ...args)
	{
		Thread t=new Thread()
		{
			public void run()
			{
				for(int i=0;i<=4;i++)
				{
					System.out.println("user thread");
					
					try
					{
						Thread.sleep(500);
					}
					catch(InterruptedException ie)
					{
						ie.printStackTrace();
					}
				}
			}
		};
		t.start();
		
		System.out.println(t.getName());
		
		
		//by implementing Runnable interface
		
		Runnable r=new Runnable()
		{
			public void run()
			{
				for(int i=0;i<=4;i++)
				{
					System.out.println("user inner_thread using Runnable.");
					try
					{
						Thread.sleep(600);
					}
					catch(InterruptedException ie)
					{
						ie.printStackTrace();
					}
				}
			}
		};
		
		Thread th=new Thread(r);
		th.start();
		
		
		
		
		// creating and executing thread inside argument of Thread object


			new Thread(new Runnable()
			{
				public void run()
				{
					for(int i=0;i<=4;i++)
					{
						System.out.println("user thread inside argument list of thread obj");
						try
						{
							Thread.sleep(600);
						}
						catch(InterruptedException ie)
						{
							ie.printStackTrace();
						}
					}
				}
			}).start();
	}
}


/*

Thread synchronization :
------------------------

- Using this concept, multiple threads access the synchronized method and while executing 
one thread that is accessing that sync_method , other thread can't access that method i.e.
if multiple threads are accessing synchronized method then the execution order will be 
performed one after one.


- But if that method is non_synchronezed then the threads will be executed in parallel.

*/

// without synchronization

// in such application the thread will be executed in parallel.

class NonSyncMethodClass
{
	public static void display(String s)
	{
		System.out.println("non sync_method calling from "+s+" class");
	}
}

class MyThread17 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			NonSyncMethodClass.display("MyThread17");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class MyThread18 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			NonSyncMethodClass.display("MyThread18");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class MyThread19 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			NonSyncMethodClass.display("MyThread19");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class ThreadDemo17
{
	public static void main(String ...args)
	{
		new MyThread17().start();
		new MyThread18().start();
		new MyThread19().start();
	}
}




// with synchronization 

class SyncMethodClass
{
	synchronized static void display(String s)
	{
		System.out.println("non sync_method calling from "+s+" class");
	}
}

class MyThread20 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			SyncMethodClass.display("MyThread20");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class MyThread21 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			SyncMethodClass.display("MyThread21");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class MyThread22 extends Thread
{
	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			SyncMethodClass.display("MyThread22");
			try
			{
				Thread.sleep(600);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
class ThreadDemo18
{
	public static void main(String ...args)
	{
		new MyThread20().start();
		new MyThread21().start();
		new MyThread22().start();
	}
}










/*


// exception handling //



- What is exception ?

ans: it is an unexpected event that occurs during execution of an application due to
some risky codes inside that application. When an exception occurs the application 
terminates abnormally and the rest of the code from where the exception occurs will not be
executed.

- So, to overcome such situation we have to handle that exception by using 
												
												i : try_catch block
												ii : throws keyword
												iii : throw keyword
												

*/


class ExceptionClass1 
{
	public static void main(String ...args)
	{
		System.out.println("quickly learn the exception handling...");
		
		//System.out.println(10/0);// here an exception will rised.
		
		// the following codes will not be executed.
		System.out.println("rest of the code");
		
	}
}

/*

- Exception is of 3 types :
							i:   checked exception
							ii:  unchecked exception
						    iii: Error


*/


/*
unchecked exception:
--------------------


- The exception which is not checked by compiler at compile time and it occurs at runtime
is called unchecked exception.

- Otherwise, the exceptions which are child classes of Runtime class are called unchecked
exception.


- To handle this kind of exception, we have to use try_catch block.
*/

class ExceptionClass2
{
	public static void main(String ...args)
	{
		System.out.println("quickly complete the exception handling topic.");
		try
		{
			System.out.println(123/0);
		}
		catch(ArithmeticException a)
		{
			System.out.println(10/5);
		}
		System.out.println("Rest of the application");
		
	}
}

/*
- The followings are some of the unchecked exceptions in java.

ArrayIndexoutOfBoundsException

StringIndexOutOfBoundsException

NullPointerException

NumberFormatException

etc........


*/

class ExceptionClass3
{
	public static void main(String ...args)
	{
		//System.out.println(10/0);
		
		int numbers[]=new int[]{1,45,344,53};
		//System.out.println(numbers[7]);
		//System.out.println("tensorflow".charAt(15));
	}
}
/*
- It is recommended to provide only the risky codes inside the try block. Why ?
- Because when ever exception is rose inside the try block then the codes written after
the risky code will not be executed.



*/
class ExceptionClass4
{
	public static void main(String ...args)
	{
		try
		{
			String s=null;
			
			System.out.println(s.length());
			
			//the following lines of code will not be executed.
			
			System.out.println("these codes will not be executed.");
			System.out.println("these following code will not be executed.");
		}
		catch(NullPointerException n)
		{
			System.out.println(n);
		}
	}
}

/*

- If there is no exception occurs inside try block then the catch block will not be executed.


*/

class ExceptionClass5
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println("no exception here");
		}
		catch(ArithmeticException ie)
		{
			ie.printStackTrace();
		}
		
		System.out.println("rest of the code after try_ catch block");
	}
}
/*
imp:
----


if no exception rises inside the try block then catch block code will not be executed.
In such cases even though the catch block contains risky code exception will not be rose. 
*/
class ExceptionClass6 
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println("no exception here");
		}
		catch(NullPointerException a)
		{
			System.out.println(35/0);// 
		}
	}
}

/*

- In between try_catch block no statement is allowed.
*/
class ExceptionClass7
{
	public static void main(String ...args)
	{
		try
		{
			Thread.sleep(100);
		}
		//System.out.println("here no statement is allowed");
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


/*
- try_block with multiple catch_block:
--------------------------------------

- If there is a possibility that multiple types of exceptions will occur then in such case
we have to provide try_block with multiple catch_blocks, but the order of the parameters
inside the param_list of the catch_blocks must be child to parent.

*/
class ExceptionClass8
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println("enter a number");
			int x=new java.util.Scanner(System.in).nextInt();
			//System.out.println(x/0);
			
			String s="satya";
			//System.out.println(s.charAt(9));
			
			int [] arr=new int[x];
			
			for(int i=0;i<=x-1;i++)
			{
				arr[i]=new java.util.Scanner(System.in).nextInt();
			}
			System.out.println(arr[20]);
		}
		catch(StringIndexOutOfBoundsException o)
		{
			o.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException o)
		{
			o.printStackTrace();
		}
		catch(ArithmeticException o)
		{
			System.out.println(33/5);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
}

/*
The order of parameters inside multiple catch blocks must be from child to parent 
otherwise we will get error message.
*/
class ExceptionClass9
{
	public static void main(String ...args)
	{
		try
		{
			String s[]=new String[]{"learn","as","soon","possible"};		
			System.out.println(s[6]);
		}
		catch(Exception e)
		{
		}
		/*catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println(a);
		}*/
	}
}

/*
For the above application from the output console we will get :

opConcept.java:3949: error: exception ArrayIndexOutOfBoundsException has already been caught
                catch(ArrayIndexOutOfBoundsException a)

*/

/*
Exception propagation:
----------------------

*/

class ExceptionClass10
{
	public static void main(String ...args)
	{
		ExceptionClass10.m1();
	}
	
	static void m1()
	{
		ExceptionClass10.m2();
	}
	static void m2()
	{
		ExceptionClass10.m3();
	}
	static void m3()
	{
		System.out.println(33/0);
	}
}
/*
observation:
------------

For the above application, the exception will rise inside the m3() method but it will
propagate to m2() method then m2() method will propagate it to m1() method and finally
the main() method is responsible to handle that exception. This concept is called exception
propagation.



note: Only the unchecked exceptions are propagated but not checked exceptions.
*/



/*
pipe symbol :
-------------



- Using this symbol we can handle multiple types of exceptions inside one catch block.

- But there are certain rules regarding pipe symbol.


*/
// ex : 1


class ExceptionClass11
{
	public static void main(String ...args)
	{
		try
		{
			int i=10/0;
			String x=null;
			System.out.println(x.length());
		}
		catch(ArithmeticException|NullPointerException n)
		{
			n.printStackTrace();
		}
	}
}
/*
rule : 1
--------

- If we want to provide unchecked type inside the parameter_list of the catch block then
there is no mandatory to provide the corresponding risky code.

*/


class ExceptionClass12
{
	public static void main(String ...args)
	{
		try
		{
			// not mandatory to provide the risky code here
		}
		catch(ArithmeticException|NullPointerException n)
		{
			System.out.println(n);
		}
		
	}
}
/*
rule : 2
--------


- But in case of checked exception the try block must contain the corresponding risky code.
*/
class ExceptionClass13
{
	public static void main(String ...args)
	{
		try
		{
			Thread.sleep(100);
			FileInputStream fis=new FileInputStream("abc.txt");
		}
		catch(InterruptedException|IOException o)
		{
			System.out.println(o);
		}
	}
}
/*
o|p:
oopConcept.java:4081: error: exception IOException is never thrown in body of corresponding try statement
                catch(InterruptedException|IOException o)
*/

/*
- rule :3
---------

- We can provide both checked & unchecked type simultaneously inside the parameter_list of
the catch block but in such case the the corresponding risky code of the checked type must
be present inside the try block.

*/

class ExceptionClass14
{
	public static void main(String ...args)
	{
		try
		{
			FileInputStream fis=new FileInputStream("abc.txt");
			Thread.sleep(100);
		}
		catch(InterruptedException|NullPointerException|IOException i)
		{
			System.out.println("exception handled");
		}
	}
}

/*

rule :4
-------

- We must not provide both parent and child type exception inside the parameter_list of
the catch block otherwise we will get error message.
*/

class ExceptionClass15
{
	public static void main(String ...args)
	{
		try
		{
			FileInputStream f=new FileInputStream("abc.txt");
		}
		catch(FileNotFoundException/*|IOException*/ O)
		{
			System.out.println("exception handled");
		}
	}
}
/*
o|P:
oopConcept.java:4136: error: Alternatives in a multi-catch statement cannot be related by subclassing
                catch(FileNotFoundException|IOException O)                                            ^
*/







/*

try with resources :
--------------------


- In java, when we open/use any resources like Scanner, File, database etc then it is our 
responsibility to close those resources using close() method before termination of the 
application.
*/

class ExceptionClass16
{
	public static void main(String ...args)
	{
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		System.out.println(x);
		sc.close();
	}
}

/*
- But using try block we can open those resources & those resources will be automatically
closed i.e. we are not responsible to close those resources.

*/

class ExceptionClass17
{
	public static void main(String ...args)
	{
		try(Scanner s=new Scanner(System.in))
		{
			String str=s.nextLine();
			
			System.out.println(str);
		}
		// here catch block is not mandatory.
	}
}
// For the above application the close() method will automatically called.


/*
rule :1
-------

If the resources throw unchecked exception then it is not mandatory to provide catch block.


rule "2
-------
If the resources throw checked exception then we must have to provide the catch block.

*/

class ExceptionClass18
{
	public static void main(String ...args)
	{
		try(FileInputStream f=new FileInputStream("abc.txt"))
		{
			//
		}
		catch(IOException f)
		{
			System.out.println(f);
		}
		/*catch(IOException o)
		{
			System.out.println(o);
		}*/
	}
}

/*
- finally block :
-----------------

- finally block code is always executed irrespective of try or catch block.

- Before normal/abnormal termination of the application, finally block is executed.


- Why do we need a finally block in exception handling ?


ans : If in our application, any resources/ connections are open then to close those resources
or connections we can use a finally block i.e finally block is needed for clean up activity.



- But there are 2 specific cases where the finally block code will not be executed.

- Before going to know those 2 cases lets observe the some case_studies where the finally
block code will be executed. 
*/


/*
case: 1(- If exception isn't occurred inside the try block)
*/

class FinallyBlock
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println("No exception in try block");
		}
		catch(Exception e)
		{
			System.out.println("catch block");
		}
		finally
		{
			System.out.println("finally block");
		}
	}
	/*
	No exception in try block
	finally block
	*/
}
/*
case:2(If exception occurs inside try block and the corresponding catch block is matched)
*/

class FinallyBlock2
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println(38/0);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("catch block");
		}
		finally
		{
			System.out.println("finally block");
		}
	}
}
/*
No exception in try block
finally block
*/

/*
case :3(if exception occurs inside the try block but catch block is not matched)
*/
class FinallyBlock3
{
	public static void main(String ...args)
	{
		try
		{
			String s=null;
			System.out.println(s.length());
		}
		catch(StringIndexOutOfBoundsException siob)
		{
			System.out.println("catch block");
		}
		finally
		{
			System.out.println("finally block");
		}
	}
}
/*
finally block
Exception in thread "main" java.lang.NullPointerException
        at FinallyBlock3.main(OOpConcept.java:4317)
*/

/*
case:4(exception occurs in try, catch block is matched but further exception occurs
inside finally block)
*/
class FinallyBlock4
{
	public static void main(String ...args)
	{
		try
		{
			int [] a={3,4,2,3,434,333};
			System.out.println(a[6]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println(45/0);
		}
	}
}
/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at FinallyBlock4.main(OOpConcept.java:4354)
*/
/*
case:5(exception in try block catch block is matched but further exception occurs inside
catch block)
*/

class FinallyBlock5
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println(35/0);
		}
		catch(ArithmeticException a)
		{
			System.out.println("satya".charAt(5));
		}
		finally
		{
			System.out.println("finally block");
		}
	}
}
/*
finally block
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 5
        at java.lang.String.charAt(String.java:658)
        at FinallyBlock5.main(OOpConcept.java:4377)
*/


/*
case:6
------
- If all three blocks raise exceptions then onlt the finally block exception will be shown
*/
class FinallyBlock6
{
	public static void main(String ...args)
	{
		try
		{
			String s=null;
			System.out.println(s.length());
		}
		catch(NullPointerException n)
		{
			System.out.println(45/0);
		}
		finally
		{
			System.out.println("java".charAt(4));
		}
	}
}
/*
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 4
        at java.lang.String.charAt(String.java:658)
        at FinallyBlock6.main(OOpConcept.java:4413)
*/

/*
The following 2 examples in which the finally block code will not be executed.
*/
class FinallyBlock7
{
	public static void main(String ...arg)
	{
		System.out.println(12/0);
		try
		{
		}
		catch(Exception ie)
		{
		}
		finally
		{
			System.out.println("finally block");
		}
	}
}
/*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 4
        at java.lang.String.charAt(String.java:658)
        at FinallyBlock6.main(OOpConcept.java:4413)
*/
class FinallyBlock8
{
	public static void main(String ...args)
	{
		try
		{
			System.out.println("try block");
			//System.out.println(344/0);
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("catch block");
			//System.exit(0);
		}
		finally
		{
			System.out.println("finally block");
			//System.exit(0);
		}
	}
}
/*
o|p: try block
*/



/*
quiz : what will be the return value form the following block ?
*/
class FinallyBlock9
{
	static int getValue()
	{
		try
		{
			return 10;
		}
		catch(Exception e)
		{
			return 20;
		}
		finally
		{
			return 30;
		}
	}
	public static void main(String ...args)
	{
		int value=FinallyBlock9.getValue();
		System.out.println("value is :"+value);
	}
}



/*
Nested try- catch block :
-------------------------


- We can declare try- catch block further inside try block , catch block and also inside
finally block as per application requirement.



*/

class NestedException
{
	public static void main(String ...args)
	{
		java.util.Scanner scan=new java.util.Scanner(System.in);
		try
		{
			int num=scan.nextInt();
			System.out.println(35/num);
			
			try
			{
				System.out.println("core".charAt(4));
			}
			catch(StringIndexOutOfBoundsException ss)
			{
				System.out.println("core".charAt(3));
			}
		}
		catch(ArithmeticException a)
		{
			System.out.println(35/5);
		}
		finally
		{
			System.out.println("finally block");
		}
		scan.close();
	}
}

/*

"throws" keyword :
------------------


- In java, unchecked exceptions are propagated automatically but in case of checked exception
the exceptions must have to be propagated explicitly.

- "throws" keyword is used to handle checked exceptions.


Q : What is the difference between checked and unchecked exceptions ?

ans : In case of unchecked exception our java application is not connected to any outside
resources. So the compiler will not check at compile time. It is our responsibility to handle
it. If we handle it then the application will terminate normally otherwise abnormally.

But in case of checked exception, as our application is connected to outside resources the
compiler has the responsibility to take care to those resources , so at compile time the
compiler will check and warn and doesn't generate the .class file if we don't handle to
those exceptions. If we handle then the compiler will generate .class file and the applica-
-tion will run normally/abnormally according to our handling code.
*/

/*
q:
--
- How to handle checked exception and what is the main purpose of "throws" keyword ?


ans :
-----
- Whether it is checked or unchecked , all kinds of exceptions are handled by using try -
catch block.

- In case of unchecked exception the exceptions are delegated from one method to its caller
method automatically but in case of checked exceptions we have to delegate those exception
explicitly by using "throws" keyword.
*/


class CheckedException
{
	public void m1()throws InterruptedException
	{
		Thread.sleep(100);
	}
	public void m2()throws InterruptedException
	{
		m1();
	}
	public void m3()
	{
		try
		{
			m2();
		}
		catch(InterruptedException i)
		{
			System.out.println("m3");
		}
	}
	public void m4()
	{
		m3();
	}
	
	public static void main(String ...args)
	{
		new CheckedException().m4();
	}
}
class CheckedException2
{
	public void m1()throws InterruptedException
	{
	}
}
/*
- Using "throws" keyword we can delegate multiple number of checked exceptions
*/

class CheckedException3
{
	public void m1()throws InterruptedException,FileNotFoundException
	{
		Thread.sleep(100);
		
		FileInputStream f=new FileInputStream("abc.txt");
	}
	
	public void m2()throws Exception
	{
		m1();
	}
	
	public static void main(String ...args)
	{
		try
		{
			new CheckedException3().m2();
		}
		catch(Exception a)
		{
			System.out.println("catch block");
		}
	}
}

/*
- If there are multiple number of checked exceptions then we can delegate our required 
number of exception to the caller method but inside that application all exceptions must
have to be delegated.
*/

class CheckedException4
{
	public void m1()throws FileNotFoundException
	{
		try
		{
			Thread.sleep(100);
			
			FileInputStream f=new FileInputStream("abc.txt");
		}
		catch(InterruptedException i)
		{
		}
	
	}
	public void m2()throws FileNotFoundException
	{
		m1();		
	}
	public static void main(String ...args)
	{
		try
		{
			new CheckedException4().m1();
		}
		catch(FileNotFoundException i)
		{
		}
	}
}
/*
Exception handling in method overriding :
-----------------------------------------


rule :1
-------

- The overriding method inside the child class can only throw unchecked exception otherwise
we will get error.

*/
class ExceptionHandlingInOverriding
{
	public void m1()throws InterruptedException
	{
		Thread.sleep(100);
	}
}
class ChildOfEHIO extends ExceptionHandlingInOverriding
{
	public void m1()throws StringIndexOutOfBoundsException
	{
	}
}

/*
rule :2
-------

- If the overridden method inside the parent class throws parent type exception then 
the overriding method inside the child class must throw either same type od child type.
But the exceptions must be unchecked type.
*/
class ExceptionHandlingInOverriding2
{
	public void m1()throws RuntimeException
	{
	}
}
class ChildOfEHIO2 extends ExceptionHandlingInOverriding2
{
	public void m1()throws ArrayIndexOutOfBoundsException
	{
	}
}


/*

"throw" keyword:
----------------

- Predefined exceptions are thrown by JVM. But we can create our own user defined exceptions
and handover them by using "throw" keyword.

- Using "throw" keyword we can create user defined checked exception as well as unchecked
exception.

- syntax : throw new InvalidAgeException

- When we declare the above statement it will be hand_overed to the JVM and print the 
exception message.

note :
------
- Our user defined exception class will become checked type by extending "Exception" class.
Similarly by extending "RuntimeException" class we can create user defined unchecked
exception.  
*/


/*
How to create and use user defined checked exception ?


step-1 : Create a class by extending Exception class.


step-2 : use that in our application using "throw" keyword.
*/
class InvalidAgeException extends Exception
{
}

class UserDefinedException1
{
	public static void status(int age)throws InvalidAgeException
	{
		if(age>20)
		{
			System.out.println("You are eligible for this interview.");
		}
		else
		{
			throw new InvalidAgeException();
		}
	}
	
	public static void main(String ...args)
	{
		System.out.println("Enter age");
		
		java.util.Scanner scan=new java.util.Scanner(System.in);
		
		int age=scan.nextInt();
		try
		{
			UserDefinedException1.status(age);
		}
		catch(InvalidAgeException e)
		{
			e.printStackTrace();
		}
	}
}

// type :2(using parameterized constructor to display exception with some message)


class InvalidNumberInputException extends Exception
{
	InvalidNumberInputException(String s)
	{
		super(s);
	}
}
class ReverseANumber
{
	public static int reverseTheNumber(int number)throws InvalidNumberInputException
	{
		int reverse=0;
		int remainder;
		if(number>=10000&&number<100000)
		{
			while(number>0)
			{
				remainder=number%10;
				number=number/10;
				reverse=reverse*10 + remainder;
			}
		}
		else
		{
			throw new InvalidNumberInputException("You have entered a wrong number");
		}
		return reverse;
	}
	public static void main(String ...args)
	{
		System.out.println("Enter a 5 digit number");
		int number;
		try(java.util.Scanner s=new java.util.Scanner(System.in))
		{
			number=s.nextInt();
			
			int reverse_number=ReverseANumber.reverseTheNumber(number);
			try
			{
				Thread.sleep(1400);
				System.out.println("The reverse of "+number+" is : "+reverse_number);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(InvalidNumberInputException e)
		{
			e.printStackTrace();
		}
		
		
		
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
// case:1( if we don't override toString() method)
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
		
		String s1=o1.toString();
		String s2=o2.toString();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(o1);
		System.out.println(o2);
	}
}

// case:2( if we override toString() method)

class ObjectClass2
{
	public String toString()
	{
		return getClass().getName();
	}
	public String toString(String s1,String s2)
	{
		String s=s1.concat(s2);
		return s;
	}
	public static void main(String ...args)
	{
		String s=new ObjectClass2().toString();
		System.out.println(s);
		System.out.println(s.toString("language"," package"));
		
	}
}