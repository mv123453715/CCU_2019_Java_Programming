import java.util.Scanner;
import java.util.Scanner.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;


public class Bicycle implements CarbonFootprint{
    private double Ride_kilometers;
    private int Bicycle_index;
    
    
    public Bicycle(int index,double km) { 
        Bicycle_index = index;
        Ride_kilometers = km;
    }//Bicycle
    
    @Override
    public double getCarbonFootprint(){
        double result = Ride_kilometers*0;
        System.out.print( "bycicle" +Integer.toString(Bicycle_index)  );
        System.out.print( " [Ride_kilometers]: " );
        System.out.println( "["  +Double.toString(Ride_kilometers) + "]" );
        System.out.print("bycicle" +Integer.toString(Bicycle_index) + " Carbonfoot : ");
        System.out.print(result);
        System.out.println("kgCO2e");
        return result;
    }//getCarbonfoot
}//Bicycle