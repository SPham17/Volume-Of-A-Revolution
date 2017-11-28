package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initializing variables for all cases
        double b;               // y - intercept
        double m;               // slope value


        double low;
        double high;
        int n;                  // number of slices


        int choice;             // choice to continue or leave (userinput)
        boolean cont = true;    // continue or leave, true or false

        int ch;                 // choice to start or not (userinput)
        boolean start = true;   // start or leave, true or false
        boolean startgo = true;
        boolean neg = true;


        Utility functions = new Utility();

        Scanner s = new Scanner(System.in); // scanner allowing userinput

        //----------------------------------------------------------------------------

        System.out.println("Welcome to Calculating the volume of a revolution");

        System.out.println("Would you like to start?\n 1. Yes\n 2. No");    // decides whether they would like to start

        while (start) {                                                      // if start is true, then begin

            ch = s.nextInt();                                               // user input of the choice

            if (ch == 1) {
                System.out.println("Lets get started!\n");                   // start if false
                start = false;
                startgo = true;
            }

            if (ch == 2) {
                System.out.println(" Have a nice day! ");                   // stop if true
                startgo = false;
                break;
            }

        }

        while (cont && startgo) {
            functions.resetData();

            System.out.println(" We will be using the default function, Linear: f(x) = mx + b" +
                    "\n We will only be limited to the first quadrant, which means all values given\n ");

            System.out.println(" Please input the slope");          // user inputs slope
            m = s.nextDouble();

            System.out.println(" Please input your y-intercept");   // user inputs y - intercept
            b = s.nextDouble();

            while (neg) {

                System.out.println(" Set two domains\n " +              // user inputs lowerbound and higherbound domain
                        "lowerbound domain = ");
                low = s.nextDouble();

                System.out.println(" higherbound domain = ");
                high = s.nextDouble();

                System.out.println(" How accurate would you like to be\n" + // inputs the amount of cylinders to use
                        "acc =");
                n = s.nextInt();

                functions.setQuadrant1(low, high, n);
                functions.getInteger();

               if (functions.negative) {
                   System.out.println(functions.getQuadrant1());

                } else {
                   neg = false;
                   System.out.println(functions.getQuadrant1());
               }


                functions.setDomain(low, high);
                functions.setIterations(n);
            }

            System.out.println(" Your final equation will look like f(x) = " + m + "x +" + b + "\n");

            System.out.println(" Calculating the volume... ");
            System.out.println(functions.CalculateVolume(m, b));


            System.out.println("\n\n Would you like to try again? \n" +
                    " (1) Yes \n" +
                    " (2) No ");

            choice = s.nextInt();
            if (choice == 1){
                cont = true;
                neg = true;
            }
            if (choice == 2) {
                cont = false;
            }
        }
    }
    }


