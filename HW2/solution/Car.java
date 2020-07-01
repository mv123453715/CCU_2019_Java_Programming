
import java.util.Scanner;
import java.util.Scanner.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;


public class Car implements CarbonFootprint{
    private double Driving_km;
    private double Avg_fuel_degree;
    private int Car_index;
    
    
    public Car(int index,double km,double fuel) { 
        Car_index = index;
        Driving_km = km;
        Avg_fuel_degree = fuel;
    }//Car
    
    @Override
    public double getCarbonFootprint(){
        double result = Driving_km*2.263 / Avg_fuel_degree;
        System.out.print( "car" +Integer.toString(Car_index)  );
        System.out.print( " [Driving_km,Avg_fuel_degree]: " );
        System.out.println( "[" + Double.toString(Driving_km) +"," +Double.toString(Avg_fuel_degree) + "]" );
        System.out.print("car" +Integer.toString(Car_index) + " Carbonfoot : ");
        System.out.print(result);
        System.out.println("kgCO2e");
        return result;
    }//getCarbonfoot
}//Car