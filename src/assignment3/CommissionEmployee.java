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
public class CommissionEmployee extends Employee implements java.io.Serializable 
{
    @Override
    public void calcGrosspay()
    {
        int items;
        float unitprice;
        Scanner sc = new Scanner(System.in);
        System.out.print("How items were sold? ");
        items = sc.nextInt();
        System.out.print("What was the unit price? $");
        unitprice = sc.nextInt();
        gross = (float)((items * unitprice)*.5);


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

