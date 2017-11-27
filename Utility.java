package com.company;

import javafx.scene.shape.Cylinder;

/**
 * Created by 07517pha on 23/11/2017.
 */
public class Utility {

    private double volume;        //area

    private double length;      // height
    private double width;       // length
    private double diameter;
    private double radius;      // radius
    private double height;
    private double Area;
    private double circum;

    private double N;              // number of cylinders
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



    private double CalcAreaLinear() {

        volume = 0;
                                                   // sets area to 0, previous area will not interrupt this method
        this.width = (High - Low) / N;
        this.radius = (High - Low);
        this.height = M * Low + B - gx;
        this.circum = 2 * Math.PI * radius;

        this.volume = circum * height *N;

        for (double x = 0; x < this.N; x++) {               // keeps adding one rectangle until it reaches the number of slices

            this.cylinder = this.Area* this.height;
            this.volume += cylinder;                         // adds rectangle to the total area
            this.height = this.M * this.Low + this.B - this.gx; // finds new height for new rectangle
        }                                                   // repeat until reaches number of slices
        return this.volume;                                   // returns area
    }

    private void Quadrant1 ( double m, double b, double gx, double n){


    }
}


/*cylinder = Math.abs(this.width * this.length); // calculates area of the rectangle, absolute value for positive area

            this.Low += this.width;                         // moves rectangle over to the right one point
            this.length = this.M * this.Low + this.B - this.gx; // finds new height for new rectangle

            this.volume += cylinder;                         // adds rectangle to the total area
        }                                                   // repeat until reaches number of slices
        return this.volume;                                   // returns area
        */