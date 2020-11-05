/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */

public class HourlyEmployee extends Employee implements java.io.Serializable
{  
    @Override
    public void calcGrosspay()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many hours did you work? ");
        Workhours = sc.nextInt();

        System.out.print("What is your wage per hour?: $");
        rate = sc.nextInt();
         if(Workhours > 40)
        {
        Overtimehours = hours - 40;
        Overtimehours = (float)((40 * rate) + (hours - 40)*(rate * 1.5));
        gross = Overtimehours * rate * 1.5f;
        }
        else
        {
        Overtimehours = 0;
        gross = rate * hours;
        }
         
        
    }

}

    
    


    
    
  
    

