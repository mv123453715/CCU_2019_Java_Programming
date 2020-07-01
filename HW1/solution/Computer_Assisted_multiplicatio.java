//³¢®Ë¸Û ¸ê¤u¤T 406410114

import java.util.Scanner ;  
public class Computer_Assisted_multiplicatio{
  public static long create_random_long(int diffic_level){
    if ( diffic_level == 1 )
      return (long)(Math.random()*10);
    else if ( diffic_level == 2 )
      return (long)(Math.random()*90) + 10;
    else if ( diffic_level == 3 )
      return (long)(Math.random()*900) + 100;
    else if ( diffic_level == 4 )
      return (long)(Math.random()*9000) + 1000;
    else if ( diffic_level == 5 )
      return (long)(Math.random()*90000) + 10000;  
    else if ( diffic_level == 6 )
      return (long)(Math.random()*900000) + 100000;  
    else if ( diffic_level == 7 )
      return (long)(Math.random()*9000000) + 1000000;   
    else if ( diffic_level == 8 )
      return (long)(Math.random()*90000000) + 10000000;   
    else if ( diffic_level == 9 )
      return (long)(Math.random()*900000000) + 100000000;   
    
    return -1 ;
  }//create_random_int
  

  public static void main(String args[]){
    //input difficulty level
    Scanner scanner = new Scanner(System.in);
    
    
    int diffic_level = 0 ,correct_num = 0,random_output_num = 0;
    long multiplier = 0,multiplicand = 0,answer = 0; // long range: 9223372036854775807 ~ -9223372036854775808
    boolean retry = false; 
    System.out.println("Please enter difficulty level.(input interger : 1~9 )");
    diffic_level = scanner.nextInt();
    
    //
    System.out.print("difficulty level :");
    System.out.print(diffic_level);
    System.out.println(" Let's start!");
    
    
    for ( int i = 0 ; i < 10 ; i++ ){
      if ( retry == false ){
        multiplier = create_random_long( diffic_level );
        multiplicand = create_random_long( diffic_level );
      }//if
      
      System.out.print("How much is ");
      System.out.print(multiplier);
      System.out.print(" times ");
      System.out.print(multiplicand);
      System.out.println("?");
      answer = scanner.nextLong();
      
      if ( answer == multiplier*multiplicand ){
        retry = false;
        random_output_num = (int)(Math.random()*4) +1 ;
        switch(random_output_num) { 
            case 1: 
                System.out.println("Very good !"); 
                break; 
            case 2: 
                System.out.println("Excellent !"); 
                break; 
            case 3: 
                System.out.println("Nice work ! "); 
                break; 
            case 4: 
                System.out.println("Keep up the good work !"); 
                break; 
            default: 
                System.out.println("Very good !"); 
        }//switch
        
        correct_num += 1;
      }//if
      
      else {
        retry = true;
        random_output_num = (int)(Math.random()*4) +1 ;
        switch(random_output_num) { 
            case 1: 
                System.out.println("No. Please try again."); 
                break; 
            case 2: 
                System.out.println("Wrong. Try once more."); 
                break; 
            case 3: 
                System.out.println("Don't give up!"); 
                break; 
            case 4: 
                System.out.println("No. Keep trying."); 
                break; 
            default: 
                System.out.println("Don't give up!"); 
        }//switch      
      }//else
    }//for
    
    System.out.print( "correct ratio : " );
    System.out.print(correct_num);
    System.out.println( " / 10" );
    if ( (((double)correct_num)/10) >= 0.75 )
      System.out.println("Congratulations, you are ready to go to the next level!");
    else
      System.out.println("Please ask your teacher for extra help.");
    
	}//main



}//class Computer_Assisted_multiplication
