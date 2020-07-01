
import java.util.Scanner;
import java.util.Scanner.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;


public class Building implements CarbonFootprint{
    private double Power_degree;
    private double Water_degree;
    private double Gas_degree;
    private int Building_index;
    
    public Building(int index,double Power,double Water,double Gas) { 
        Building_index =index;
        Power_degree = Power;
        Water_degree = Water;
        Gas_degree = Gas;
    }//Building
    
    @Override
    public double getCarbonFootprint(){
        double result = Power_degree*0.554 + Water_degree*0.162 + Gas_degree*1.879;
        System.out.print( "building" +Integer.toString(Building_index)  );
        System.out.print( " [power_degree,water_degree,gas_degree]: " );
        System.out.println( "[" + Double.toString(Power_degree) +"," +Double.toString(Water_degree) +"," + Double.toString(Gas_degree) + "]" );
        System.out.print("buliding" +Integer.toString(Building_index) + " Carbonfoot : ");
        System.out.print(result);
        System.out.println("kgCO2e");
        return result;
        
    }//getCarbonfoot
}//Building
