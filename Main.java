package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initializing variables for all cases
        double b;               // y - intercept
        double m;               // slope value


        double low;             // lowerbound domain (userinput)
        double high;            // higherbound domain (userinput)
        double gx;
        int n;                  // number of shells (userinput)


        int choice;             // choice to continue or leave (userinput)
        boolean cont = true;    // continue or leave, true or false (userinput)

        int ch;                 // choice to start or not (userinput)
        boolean start = true;   // start or leave, true or false (userinput)
        boolean startgo = true; // another factor to start or leave the program
        boolean neg = true;     // to ensure that the variables are not negative (userinput)


        Utility functions = new Utility();  // access to the "Utility" class

        Scanner s = new Scanner(System.in); // scanner allowing userinput

        //----------------------------------------------------------------------------
        // decides whether they would like to start
        System.out.println("Welcome to Calculating the Volume of a Revolution ( Please answer using the numbers)");

        System.out.println("Would you like to start?\n 1. Yes\n 2. No");

        //----------------------------------------------------------------------------
        // if start is true, then begin
        while (start) {

            ch = s.nextInt();                                               // user input of the choice

            // start if false, and if startgo is true
            if (ch == 1) {
                System.out.println("Lets get started!\n");
                start = false;
                startgo = true;

            }

            // stop if true, breaks out of program
            if (ch == 2) {
                System.out.println(" Have a nice day! ");
                startgo = false;
                break;

            }

        } // end while statement
        //-----------------------------------------------------------------------
        // while statement loops while cont and startgo are true
        // resets all data at the start, to ensure previous data will not be used

        while (cont && startgo) {
            functions.resetData();

            System.out.println(" We will be using the default function, Linear: f(x) = mx + b" +
                    "\n We will only be limited to the first quadrant, which means all values given\n ");

            // user inputs slope
            System.out.println(" Please input the slope");
            m = s.nextDouble();

            // user inputs y - intercept
            System.out.println(" Please input your y-intercept");
            b = s.nextDouble();

            //--------------------------------------------------------------------
            // if neg is true, it will keep looping until false
            // will keep looping if a negative was inputted for the domains, or iterations

            while (neg) {

                // user inputs lowerbound domain
                System.out.println(" Set two domains\n " +
                        "lowerbound domain = ");
                low = s.nextDouble();

                // user inputs higherbound domain
                System.out.println(" higherbound domain = ");
                high = s.nextDouble();

                // user inputs a g(x) (range)
                System.out.println(" Please input a g(x)");
                gx = s.nextDouble();

                // inputs the amount of iterations (shells) to use
                System.out.println(" How accurate would you like to be\n" +
                        "acc =");
                n = s.nextInt();

                // sends gx to the method in Utility class
                functions.set_Gx(gx);

                // gives the following parameters to the utility class, and the following method
                functions.setQuadrant1(low, high, n);

                // gets the numbers from setQuadrant1, ensures that they are not negative
                functions.getInteger();

                // negative is set to true, if it is true, loop back to the start of loop
               if (functions.negative) {

                   // returns String: Q1 if negative numbers were inputted
                   System.out.println(functions.getQuadrant1());

                // if numbers are positive, continue the program
                } else {

                   // will change neg to false, therefore, oppose the while conditons and exit the loop
                   neg = false;

                   //returns String: Q1 if positive numbers were inputted
                   System.out.println(functions.getQuadrant1());
               }

                // sends parameters the following parameters to be used within private methods in Utility class
                functions.setDomain(low, high);
                functions.setIterations(n);
            }

            System.out.println(" Your final equation will look like f(x) = " + m + "x + " + b + "\n");

            System.out.println(" Calculating the volume... ");

            // prints a line that with the volume inputted from the Utility class
            functions.CalculateVolume(m, b);

            System.out.println(" Would you like to try again? \n" +
                    " (1) Yes \n" +
                    " (2) No ");

            //----------------------------------------------------------------------
            // user decides whether they would like to try again or not
            // if they do, resets the while loops according to their conditions
            // if false, break out of the program

            choice = s.nextInt();
            if (choice == 1){
                cont = true;
                neg = true;
            }

            if (choice == 2) {
                cont = false;
            }
        }//end of while loop
    } // end of main method
    }// end of class


