package com.company;

/**
 * Created by 07517pha on 23/11/2017.
 */
public class Utility {

    private String invalid;
    private double volume;      // total volume

    private double length;      // height
    private double height;
    private double radius;

    private int N;              // number of cylinders
    private double cylinder;    // volume  of cylinder

    private double Y1;         // lowerbound domain
    private double X1;
    private double Y2;        // higherbound domain
    private double X2;


    //functions variables
    private double M;           // slope
    private double B;           // y-intercept

    private double Q1;          // returns everything, ensuring that values meet requirements of quadrant 1

    public void resetData() {                                        // that will reset all of the private data in the AreaBtwn object to 0, zero

        M = 0;
        N = 0;

    }

    public void Invalid(){

        this.invalid = (" an error has occurred! Perhaps use positive values only?"); // will use this message if the user implements a negative value

    }


    public void setDomain(double x2, double x1){


        this.X1 = x1;
        this.X2 = x2;

    }

    public void setRange(double y1, double y2) {                // sets the domain, uses private variables referring to the variables from the main

        this.Y1 = y1;
        this.Y2 = y2;

    }

    public void Quadrant1(double y1, double y2, double x1, double x2){

        if (X1 < 0 || X2 < 0 || Y1 < 0 || Y2 < 0) {             // if X1, X2, Y1, Y2 are

            System.out.println(this.invalid);
        }

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

        private double CalcVolume() {


            this.height = (this.Y2 - this.Y1) / this.N;       // gets the width of the small rectangles, divides by number of slices to create even slices
            this.length = M * this.Y1 + this.B - this.X2;      // gets height (length) of the initial small rectangle
            this.radius = X2;

            for (double y = 0; y < this.N; y++) {               // keeps adding one cylinders until it reaches the number of slices

                cylinder = Math.abs(Math.PI * (this.radius)*(this.radius) * this.height); // calculates area of the rectangle, absolute value for positive area

                this.Y1 += this.height;                         // moves rectangle over to the right one point
                this.length = this.M * this.Y1 + this.B - this.X2; // finds new height for new rectangle

                this.volume += cylinder;                         // adds rectangle to the total area
            }                                                   // repeat until reaches number of slices
            return this.volume;                                   // returns area
        }

        public double CalcVolumeLinear(double m, double b) {           // calls the setLineData, and calcAreaLinear

            setData(m, b);                                        // sends these parameters to setLineData
            CalcVolume();                                         // calculates area using parameters that were set
            displayVolume();                                            //  displays area with units
            return this.volume;                                         // returns to main class
        }
    }


