package com.company;

/**
 * Created by 07517pha on 23/11/2017.
 */
public class Utility {
    private double volume;      // volume

    private double dradius;     // delta radius, units between each shell
    private double radius;      // radius
    private double height;      // height

    private double circum;      // circumference

    private double Gx;          // gx
    private double N;           // number of shells

    private double Low;         // lowerbound domain
    private double High;        // higherbound domain

    //functions variables
    private double M;           // slope
    private double B;           // y-intercept

    private String Q1;          // returns everything, ensuring that values meet requirements of quadrant 1
    public boolean negative = true; // used to loop negative numbers

    //-------------------------------------------------------------------------------------------------------
    //resets all of the user inputted data to the default data from the start

    public void resetData() {

        Low = 0;
        High = 0;
        volume = 0;
        M = 0;
        B = 0;
        Gx = 0
        negative = true;

    }

    //-------------------------------------------------------------------------------------------------------
    // sets the domain, uses private variables referring to the variables from the main

    public void setDomain(double low, double high) {

        this.Low = low;
        this.High = high;

    }

    public void set_Gx (double gx) {

        this.Gx = gx;

    }
    //-------------------------------------------------------------------------------------------------------
    // sets number of shells, uses private variables referring to the main

    public void setIterations(int n) {

        this.N = n;

    }

    //-------------------------------------------------------------------------------------------------------
    // prints out the volume when called, area is always positive

    private void displayVolume() {

        System.out.println(" Volume is = " + Math.abs(volume) + " units cubed\n ");

    }

    //-------------------------------------------------------------------------------------------------------
    // grabs parameters from main.

    private void setData(double m, double b) {

        M = m;
        B = b;

    }

    //-------------------------------------------------------------------------------------------------------
    // calculates volume of the revolution

    private double CalcVolumeLinear() {

        // keeps adding one shell until it reaches the number of iterations the user inputs
        for (double x = 0; x < this.N; x++) {

            // distance between the shells. divided by number of shells to ensure they are even
            this.dradius = (this.High - this.Low) / this.N;

            // finds radius of the shell, finds new radius depending on which shell iteration it is.
            this.radius = this.High - this.dradius * x;

            // finds height, height differs in each shell, uses a different radius in different iterations
            this.height = this.M * this.radius + (this.B - this.Gx);

            // finds circumference, circuference differs in each shell, uses a different radius in different iterations
            this.circum = 2 * Math.PI * radius;

            // finds volume of the shell with previously calculated data, adds to total volume
            this.volume += Math.abs(dradius * height * circum);

        // repeat until reaches number of shells / iterations
        } // end of for loop

        // returns volume
        return this.volume;

    }

    //-------------------------------------------------------------------------------------------------------
    // used from the Main, links main to this public method, which branches off to private methods in Utility
    // grabs parameters from main to private method setData
    // calculates volume, and loops until number of iterations is reached using the CalcVolumeLinear method
    // displays message made in the method "displayVolume()"

    public void CalculateVolume(double m, double b) {
        setData(m, b);
        CalcVolumeLinear();
        displayVolume();

    }

    //-------------------------------------------------------------------------------------------------------
    // method ensures that positive units are inputted from the user

    public void setQuadrant1(double low, double high, double n) {

        /* if lower domain is less than 0, higher domain is more than lower domain, or number of iterations is less than
           0 than sets the String Q1 to the message displayed */
        if (low < 0 || high <= low  || n < 0) {

            Q1 = ("\n INVALID\n\n" +
                    " Please input a positive values\n" +
                    " Also, please ensure the following:\n" +
                    "  - Your lower domain is less than your higher domain\n" +
                    "  - Your two domains do not equal eachother \n\n");

            // if all the numbers are positive, set negative to false to exit loop inside main, sets the String Q1
        } else {
            negative = false;
            Q1 = ("\n All numbers are positive!\n" +
                    " Proceeding...\n\n");

            }
    }

    //-------------------------------------------------------------------------------------------------------
    // returns the string Q1 to the main
    // Q1 differs from the conditions in method "setQuadrant1"

    public String getQuadrant1() {
        return this.Q1;
    }
    //-------------------------------------------------------------------------------------------------------
    // returns the negative condition to the main
    // condition of negative differs from the conditions in method "setQuadrant1"

    public boolean getInteger(){
        return this.negative;
    }
}
