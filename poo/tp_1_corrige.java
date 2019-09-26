// exo 1
/*System.out.println("\n##################\n");

//byte b1=159; // trop grand >127 // forcer le byte : byte b1= (byte)(159)
byte b1= (byte)(159);
//short b1=159;
byte b2=45;
byte b=2;
short s1=3000;
//short s2=35000; // trop grand >32700
long s2=35000;
// short s3=b2+b1; // short + byte => int mais int != short
int s3=b2+s1;
int i=5;
int n=60000;
long q=1500000;
//float f = 25,7f; // virgule et non point
float f = 25.7f;
float x =34.67834E4f;
double y =657.52E3;
double z= 0.1;


System.out.println("\n----------------------------\n");


System.out.println("b2+b1 : " +(b2+b1));

b2+s1;   // int
b2/2.0;  //double
b2/2;    // int
b2%2;    // int
n/0;     // /by zero
y/0;     // infinity
i++ * n+b2;
i++ *(n+b2);
/*long
Long
float

Float


n/0
double
double
int i incrementer apres execution
int i incrementer


int n1=s1;
byte v = (byte)(b*b); // forcer byte
float x1= n;
int n2=(int)x;
int n3 =(int) y;
float x2 = (float) y;


z+z+z==0.3; // /!\ aproximation sur le double

*/

// exo 2
/*
char c=50,d='i',e='k'; // c=50 prend le code UICOD=2
byte b=20;
c+1;
2*c;
e-d;
int v=d;
b*c;
int w=e;
char test=107;
*/


//exo 3
/*
int n =3;
int p=5;
int q=7;
p = q++;
n=--p;


n=((0 == n % 2)? --q : --p) ;
n=((0 == n % 2)? p++ : ++q) ;
*/


public class Main {

    public static void main(String[] args) {
        int n =81;
        int i=2;
        while (n%i!=0) {
            System.out.println("i = "+i + " opp "+(n%i));
            i++;
        }
        System.out.println("i = "+i);

    }
}

public class Main {

    public static void main(String[] args) {
        int a= 3;
        int b= 4;
        int c= 5;

        boolean cHypotenuse = false;
        boolean aHypotenuse = false ;
        boolean bHypotenuse = false ;
        boolean triEquilateral=false;

        triEquilateral=((a==b==c)? true : false);


        //c**2=b**2+a**2;
        cHypotenuse=(((c**2)==((b**2))+(a**2)))? true : false);
        aHypotenuse=((a**2==b**2+c**2)? true : false);
        bHypotenuse=((b**2==c**2+a**2)? true : false);



    }
}



