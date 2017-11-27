package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initializing variables for all cases
        double b;               // y - intercept
        double m;               // slope value

        double y1;             // lowerbound domain
        double y2;            // higherbound domain
        double x1;
        double x2;
        int n;                  // number of slices

        double gx;

        int choice;             // choice to continue or leave (userinput)
        boolean cont = true;    // continue or leave, true or false

        int ch;                 // choice to start or not (userinput)
        boolean start = true;   // start or leave, true or false

        int z = 0;

        Utility functions = new Utility();

        Scanner s = new Scanner(System.in); // scanner allowing userinput

        //----------------------------------------------------------------------------

        System.out.println("Welcome to Calculating the volume of a revolution");

        System.out.println("Would you like to start?\n 1. Yes\n 2. No");    // decides whether they would like to start

        while (start) {                                                      // if start is true, then begin

            ch = s.nextInt();                                               // user input of the choice

            if (ch == 2) {
                System.out.println(" Have a nice day! ");                   // stop if true
                break;
            }

            if (ch == 1) {
                System.out.println("Lets get started!\n");                   // start if false
                start = false;
            }

        }

            System.out.println(" We will be using the default function, Linear: f(x) = mx + b" +
                    "\n We will only be limited to the first quadrant, which means all values given ");

            System.out.println(" Please input the slope");          // user inputs slope
            m = s.nextDouble();

            System.out.println(" Please input your y-intercept");   // user inputs y - intercept
            b = s.nextDouble();

            System.out.println(" Set two domains\n " +              // user inputs lowerbound and higherbound domain
                "lowerbound domain = ");
            x1 = s.nextDouble();

             System.out.println(" higherbound domain = ");
            x2 = s.nextDouble();

            System.out.println(" value of g(x) = ");
            gx = s.nextDouble();

            System.out.println(" How accurate would you like to be\n" + // inputs the amount of cylinders to use
                    "acc =");
            n = s.nextInt();

            System.out.println(" Your final equation will look like f(x) = " + m + "x " + b +
                    "\n g(x = " + gx);


            functions.setDomain(x1, x2);
           // functions.Quadrant1(x1 ,x2 ,y1 ,y2);

            functions.setIterations(n);

            System.out.println(" Calculating the volume... ");
            //System.out.println(functions.CalcVolumeLinear(m, b));



        }
    }

