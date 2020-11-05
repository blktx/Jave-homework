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
public class Employee implements java.io.Serializable
{
    protected String ID;
    protected float paycheck;
    protected float Workhours;
    protected float Overtimehours;
    protected float rate = 30.0f;
    protected float taxrate = 0.2f;
    protected int hours = 40;
    protected float gross = 0.0f;
    float tax = 0.0f;
    float net = 0.0f;
    protected float net_percent = 0.0f;
    protected float overtimepay;

   

    

//Gross Pay = hourly pay rate * numbers of hours worked in a week.
//Federal Tax withholding = Federal Tax withholding rate * gross pay
//State Tax withholding = State Tax withholding rate * gross pay
//Total Deductions = Federal Tax withholding + State Tax withholding
//Net Pay = Gross Pay + Total Deductions
//Overtime pay is calculated: Hourly pay rate x 1.5 x overtime hours worked. 
//Here is an example of total pay for an employee who worked 42 hours in a workweek:
//Regular pay rate x 40 hours = Regular pay, plus. Regular pay rate x 1.5 x 2 hours = Overtime pay, equals.
    public String getID()
    {
        return ID;
    }
    public void setID(String s)
    {
        ID = s;
    }
//    public float getWorkhours()
//    {
//        return Workhours;
//    }
    
    public void calcGrosspay()
    {
        calcOvertimepay();
        gross = (float) ((rate * hours) +  overtimepay);
    }
 
    protected void calcOvertimepay()
    {
        overtimepay = (float) (rate * 1.5 * getOvertimehours());
    }
    protected void calcTax()
    {       
        tax = taxrate * gross;
    }
    protected void calcNetpay()
    {       
        net = gross - tax;
    }
    protected void calcNetpercent()
    {       
       net_percent = net / gross;
    }
    public float getNetpayment()
    {
        calcOvertimepay();
        calcTax();
        calcNetpay();
        paycheck = net;
        return paycheck;
    }
    public float setNetpayment(float paycheck)
    {
        calcOvertimepay();
        calcTax();
        calcNetpay();
        this.paycheck = paycheck;
        return paycheck;
        
    }
 
    protected void displayEmployee()
    {
             
        calcTax();
        calcNetpay();
        calcNetpercent();
        System.out.println("Names:" + ID);
        System.out.println("Hours: " + Workhours);
        System.out.println("Rate: " + rate);
        System.out.println("Gross: " + gross);
        System.out.println("Tax: " + tax);
        System.out.println("Net: " + net);
        System.out.println("Net%: " + net_percent + "%");

        
    }
   
//    public Employee(String ID, float Workhours)
//    {
////        this.Fname = Fname;
////        this.Lname = Lname;
//        this.Workhours = Workhours;
//    }
//    Employee(String tempFname, String tempLname, float tempWorkhours) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public String getNull()
    {
        return null;
    }
 
    public float getOvertimehours()
    {
        Overtimehours = Workhours - hours;
        return Overtimehours;
    }
 
    public void lookup() 
    {
        calcTax();
        calcNetpay();
        calcNetpercent();
        Scanner sc = new Scanner(System.in);
        int selection;
        boolean exit = false;
        while(!exit)
        {
//          System.out.println("1) Calculate Gross Pay");
            System.out.println("1) Calculate Tax");
            System.out.println("2) Calculate Net Pay");
            System.out.println("3) Calculate Net Percent");
            System.out.println("4) Display All");
            System.out.println("5) Exit");
            System.out.print("Please select an option:");
            selection = sc.nextInt();
            if (selection < 1 || selection > 5)
            {
                System.out.println("Invalid choice. Try again: ");
            }
            switch(selection)
            {
//                case 1:
//                    computeGross();
//                    break;
                case 1:
                    calcTax();
                    System.out.println("Tax: " + tax);
                    break;
                case 2:
                    calcNetpay();
                    System.out.println("net: " + net);                   
                    break;
                case 3:
                    calcNetpercent();
                    System.out.println("netpercent: " + net_percent);
                    break;
                case 4:
                    displayEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }
        
   

//       calcGrosspay();
//       calcTax();
//       calcNetpay();
//       calcNetpercent();
//       calcAll();
//          
//    }



    

    

}
    

