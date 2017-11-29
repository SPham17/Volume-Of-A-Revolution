package com.company;

/**
 * Created by 07517pha on 23/11/2017.
 */
public class Utility {

    private double volume;        //area

    private double dradius;     // delta radius
    private double radius;      // radius
    private double height;

    private double circum;

    private double N;              // number of cylinders

    private double Low;         // lowerbound domain
    private double High;        // higherbound domain

    //functions variables
    private double M;           // slope
    private double B;           // y-intercept

    private String Q1;          // returns everything, ensuring that values meet requirements of quadrant 1
    public boolean negative = true;
   ;

    public void resetData() {              // that will reset all of the private data in the AreaBtwn object to 0, zero

        Low = 0;
        High = 0;
        volume = 0;
        M = 0;
        B = 0;
        negative = true;

    }


    public void setDomain(double low, double high) {                // sets the domain, uses private variables referring to the variables from the main

        this.Low = low;
        this.High = high;

    }

    public void setIterations(int n) {                              // sets number of slices, uses private variables referring to the main

        this.N = n;

    }

    private void displayVolume() {

        System.out.println("Volume is = " + Math.abs(volume) + " units cubed\n "); // prints out the area when called, area is always positive

    }

    private void setData(double m, double b) {              // grabs parameters from main. sets datatype from AreaBtwn to refer to the main

        M = m;
        B = b;

    }


    private double CalcVolumeLinear() {

        // keeps adding one rectangle until it reaches the number of slices
        for (double x = 0; x < this.N; x++) {

            // distance between the shells. divided by number of shells to ensure they are even
            this.dradius = (this.High - this.Low) / this.N;

            this.radius = this.High - this.dradius * x;

            // gets initial height from first shell
            this.height = this.M * this.radius + this.B;

            this.circum = 2 * Math.PI * radius;


            this.volume += Math.abs(dradius * height * circum);                         // adds rectangle to the total area

        }                                                   // repeat until reaches number of slices
        return this.volume;                                   // returns area
    }

    public double CalculateVolume(double m, double b) {
        setData(m, b);
        CalcVolumeLinear();
        displayVolume();
        return this.volume;
    }


    public void setQuadrant1(double low, double high, double n) {

        if (low < 0 || high < low  || n < 0) {

            Q1 = ("\n INVALID\n" +
                    " Please input a positive values\n" +
                    " Also, please ensure your lower domain is less than your higher domain.\n\n ");
        } else {
            negative = false;
            Q1 = ("\n All numbers are positive!\n" +
                    " Proceeding...\n\n");

    }}
    public String getQuadrant1() {
        return this.Q1;
    }
    public boolean getInteger(){
        return this.negative;
    }
}
