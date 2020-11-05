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
public class SalaryEmployee extends Employee implements java.io.Serializable
{
    @Override
    public void calcGrosspay()
    {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.print("Are you Staff (S) or Executive (E)? ");
        input = sc.next().charAt(0);
        if(input == 'S' || input == 's')
        {
            //staff employee
            gross = 50000;

        }
        else if(input == 'E' || input == 'e')
        {
            //executive employee
            gross = 100000;
        }

    }
    @Override
    public void calcTax()
    {
        tax = taxrate * gross;
    }
    @Override
    public void calcNetpay()
    {
        net = gross - tax;
    }
    @Override
    public void calcNetpercent()
    {
        net_percent = net / gross;
    }
    @Override 
    public void displayEmployee()
    {
        calcTax();
        calcNetpay();
        calcNetpercent();
        System.out.println("Names:" + ID);
        System.out.println("Gross: " + gross);
        System.out.println("Tax: " + tax);
        System.out.println("Net: " + net);
        System.out.println("Net%: " + net_percent + "%"); 
    
    }
}
