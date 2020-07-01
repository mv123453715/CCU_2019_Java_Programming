//³¢®Ë¸Û ¸ê¤u¤T 406410114
import java.util.Scanner;
import java.util.Scanner.*;
import java.io.FileReader;
import java.io.FileReader.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList; 


public class Java_HW2{
  /*public static print_item_Carbonfoot( ArrayList<CarbonFootprint> footprintItems,String mode ){
      
      if ( mode.equals( "building" ) ){
          System.out.println("building : " + Integer.toString(i) + "/"  + Integer.toString(footprintItems.size()));
          for ( i = 0; i <footprintItems.size();i++ ){
              System.out.print( now )    
          }//for
      }//if
  
  
  }//print_item
  */
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);
    
    //ArrayList
    ArrayList<CarbonFootprint> footprintItems = new ArrayList<CarbonFootprint>();
    
    
    //car_num,bicycle_num;
    
    //bulidning
    System.out.println("building_num");
    int building_num = scanner.nextInt();
    
    for ( int i = 0 ;i < building_num;i++ ){
        System.out.println("Please enter building" + Integer.toString(i+1) + " power degree.(double type)");
        double building_power = scanner.nextDouble();
        System.out.println("Please enter building" + Integer.toString(i+1) + " water degree.(double type)");
        double building_water = scanner.nextDouble();
        System.out.println("Please enter building" + Integer.toString(i+1) + " gas degree.(double type)");
        double building_gas = scanner.nextDouble();
        
        footprintItems.add(new Building(i+1,building_power,building_water,building_gas));
    }//for
    
    
    System.out.println("car_num");
    int car_num = scanner.nextInt();
    
    for ( int i = 0 ;i < car_num;i++ ){
        System.out.println("Please enter car" + Integer.toString(i+1) + " driving km.(double type)");
        double car_km = scanner.nextDouble();
        System.out.println("Please enter car" + Integer.toString(i+1) + " average fuel degree.(double type)");
        double car_avg_fuel = scanner.nextDouble();
        
        footprintItems.add(new Car(i+1,car_km,car_avg_fuel));
    }//for
    
    
    System.out.println("bicycle_num");
    int bicycle_num = scanner.nextInt();
    
    for ( int i = 0 ;i < bicycle_num;i++ ){
        System.out.println("Please enter bicycle" + Integer.toString(i+1) + " bicycle_km.(double type)");
        double bicycle_km = scanner.nextDouble();
        
        footprintItems.add(new Bicycle(i+1,bicycle_km));
    }//for
    
    
    
    double totalCarbon= 0.0;
    for (CarbonFootprint item : footprintItems) {
        totalCarbon += item.getCarbonFootprint();
    }//for
    
    System.out.print("total Carbonfoot : ");
    System.out.print(totalCarbon);
    System.out.println(" kg CO2e");
    
      
    
	}//main



}//class Computer_Assisted_multiplication
