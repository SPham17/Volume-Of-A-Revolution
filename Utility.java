package com.company;

/**
 * Created by 07517pha on 23/11/2017.
 */
public class Utility {

    private double volume;        //area

    private double length;      // height
    private double width;       // length

    private int N;              // number of rectangles
    private double cylinder;    //volume  of cylinder

    private double Low;         // lowerbound domain
    private double High;        // higherbound domain

    private double gx;          // gx

    //functions variables
    private double M;           // slope
    private double B;           // y-intercept

    private double Q1;          // returns everything, ensuring that values meet requirements of quadrant 1

    public void resetData() {                                        // that will reset all of the private data in the AreaBtwn object to 0, zero


    }

    public void set_Gx(double b) {

        this.gx = b;

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

    private void setLineData(double m, double b) {              // grabs parameters from main. sets datatype from AreaBtwn to refer to the main

        M = m;
        B = b;

    }

    private void Quadrant1 ( double m, double b, double gx, double n){


    }
}
