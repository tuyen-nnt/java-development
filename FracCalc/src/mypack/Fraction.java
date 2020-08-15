package mypack;

import java.util.Scanner;

public class Fraction {
    //PHAN STATE
    private int num;
    private int den;

    //PHAN CONSTRUCTOR
    public Fraction (int nume, int deno) {
        super();
        if (deno == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        if (nume < 0 && deno < 0) {
            this.num = - nume;
            this.den = - deno;
        } else if (deno < 0) {
            this.num = - nume;
            this.den = deno;
        } else {
            this.num = nume;
            this.den = deno;
        }
    }

    public Fraction (int nume) {
        this(nume,1);
    }

    public Fraction () {
        this(0,1);
    }


    //PHAN METHOD
    public int getNum () {
        return num;
    }

    public int getDen () {
        return den;
    }

    public void setNum (int nume) {
        this.num = nume;
    }

    public void setDen (int deno) {
        this.den = deno;
    }

    public String toString () {
        return this.num + "/" + this.den;
    }

    public double toDouble () {
        return (double)this.num/this.den;
    }
    //The Euclidean Algorithm - Tim UCLN de toi gian phan so
    public int findGCD (int a, int b) {
        //Here is pseudocode for its implementation:
        while (a != b) {
            if (a < b) {
                b -= a;
            } else {
                a -= b;
            }
        }
        //This is the GCD
        return a;
    }

    //Toi gian phan so
    public void shortenFrac () {
        int i = findGCD(this.getNum(), this.getDen());
        this.setNum(this.getNum()/i);
        this.setDen(this.getDen()/i);
    }

    //Cong tru nhan chia 2 phan so
    public void add (Fraction other) {
        int ts = this.getNum()*other.getDen() + this.getDen()*other.getNum();
        int ms = this.getDen()*other.getDen();

        Fraction sum = new Fraction(ts, ms);

        sum.shortenFrac();
        System.out.println("Result is " + sum.getNum() + "/" + sum.getDen());

    }
    public void subtract (Fraction other) {
       int ts = this.getNum()*other.getDen() - this.getDen()*other.getNum();
       int ms = this.getDen()*other.getDen();

       Fraction sub = new Fraction(ts, ms);

       sub.shortenFrac();
       System.out.println("Result is " + sub.getNum() + "/" + sub.getDen());
    }

    public void multiply (Fraction other) {
        int ts = this.getNum()*other.getNum();
        int ms = this.getNum()*other.getDen();

        Fraction mul = new Fraction(ts, ms);

        mul.shortenFrac();
        System.out.println("Result is " + mul.getNum() + "/" + mul.getDen());
    }

    public void divide (Fraction other) {
        int ts = this.getNum()*other.getDen();
        int ms = this.getDen()*other.getNum();

        Fraction div = new Fraction(ts, ms);

        div.shortenFrac();
        System.out.println("Result is " + div.getNum() + "/" + div.getDen());
    }

    public boolean equals (Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Fraction)) {
            return false;
        }

        Fraction equal = (Fraction) other;

        return (this.getNum() == equal.getNum() && this.getDen() == equal.getDen());
    }
}