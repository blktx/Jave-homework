/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class RunEmployee 
{
      Employee[] myaccts = new Employee[3];
      static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException
    {
       RunEmployee rs = new RunEmployee();
       rs.menu();  
             
               
    }

//    public RunEmployees2() 
//    {
//    }
    public void menu() throws ClassNotFoundException, IOException
    {
        Scanner scan = new Scanner(System.in);
        int selection;
        boolean done = false;
        while (!done)
        {
            System.out.println("1) Populate Employees");
            System.out.println("2) Select Employees");
            System.out.println("3) Save Employees");
            System.out.println("4) Load Employees");
            System.out.println("5) Print Payroll");
            System.out.println("6) Exit");
            System.out.println("Please select an option: ");

        selection = scan.nextInt();
           
            switch (selection)
            {
                case 1:
                    populateEmployees();
                    break;
                case 2:
                    selectEmployees();
                    break;
                case 3:
                    saveEmployees();
                    break;
                case 4:
                    loadEmployees();
                    break;
                case 5:
                    printPayroll();
                case 6:
                    done = true;
            }
        }
        
       
    }
    private void populateEmployees()
    {
       int selectedindex =0;
       Scanner scan = new Scanner(System.in);
       for(int i = 0; i < myaccts.length; i++)
       {
            if(myaccts[i] == null)
            {
                selectedindex = i;
                break;
            }
       }
        char input;
        String local_id;
        System.out.println("Are you an Hourly (H), Salary (S), or Commission (C) employee? [ type H, S, OR C ]");
        input = sc.next().charAt(0);
            
       switch (input) {
           case 'H':
           case 'h':
               myaccts[selectedindex] = new HourlyEmployee();
               System.out.println("Please enter your id number[first name and last initial]: ");
               local_id = sc.next();
               myaccts[selectedindex].setID(local_id);
               myaccts[selectedindex].calcGrosspay();
               break;
           case 'S':
           case 's':
               myaccts[selectedindex] = new SalaryEmployee();
               System.out.println("Please enter your id number[first name and last initial]: ");
               local_id = sc.next();
               myaccts[selectedindex].setID(local_id);
               myaccts[selectedindex].calcGrosspay();
               break;
           case 'C':
           case 'c':
               myaccts[selectedindex] = new CommissionEmployee();
               System.out.println("Please enter your id number[first name and last initial]: ");
               local_id = sc.next();
               myaccts[selectedindex].setID(local_id);
               myaccts[selectedindex].calcGrosspay();
               break;
           default:
               break;
       }
                       

//            System.out.println("Please enter your first name: ");
//            tempFname = sc.next();
//            System.out.println("Please enter your last name:  ");
//            tempLname = sc.next();
//            System.out.println("Please enter your total work hours this week: ");
//            tempWorkhours = Float.parseFloat(sc.next());

//            myEmployee[i] = new Employee(tempFname, tempLname, tempWorkhours);
       
    }


    private void selectEmployees() throws ClassNotFoundException, IOException 
    {
       
        String tempID ;
//        String tempLname = null;
        int index = -99;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        for(int i = 0; i < myaccts.length; i++)
        {        
            //Scanner sc = new Scanner(System.in);
            System.out.println("Enter your first name and last initial: [eg. BeckyL]");
            try
            {   
              tempID = br.readLine();
              if(myaccts[i].getID().equalsIgnoreCase(tempID))
              {
               index = i;
               myaccts[i].lookup();
               break;

              }
              else if(myaccts[i+1].getID().equalsIgnoreCase(tempID))
              {
                  index = i;
                   myaccts[i+1].lookup();
                   break;
              }
              else if(myaccts[i+2].getID().equalsIgnoreCase(tempID))
              {
                 index = i;
                   myaccts[i+2].lookup();
                   break; 
              }
              else
              {
                  System.out.println("Student cannot be found, try again.");
              }
              
            
//                tempLname = br.readLine();
            }
            catch(IOException ioe)
            {
                System.out.println("Something went wrong with your input name try again");
                i=-1;
            }
            
        }
        menu();
    }
     
    
       
    
    
       
    
    

    private void saveEmployees() throws IOException 
    {
        writeSerializedArray();
    }
    public void writeSerializedArray() throws IOException 
    {
        

    try 
    {
       FileOutputStream fs = new FileOutputStream("SerMyEmployee.txt"); 
        try (ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(myaccts);
            os.flush();
        }
       

    }
    catch (IOException e)
    {
       System.err.println(e);
    }
        
    }
    

    private void loadEmployees() throws ClassNotFoundException 
    {
        
        Employee[] Null = null;
        if (myaccts == Null)
        {
            System.out.println("File is empty so you cannot load it");
           

        }
        else 
        {
            System.out.println("File is not empty, and loading now.");
            readSerializedArray();
           

        }
        
    }
    public void readSerializedArray() throws ClassNotFoundException
    {
    

       try 
       {
           try (FileInputStream fis = new FileInputStream("SerMyEmployee.txt")) 
           {
               ObjectInputStream ois = new ObjectInputStream(fis);
               myaccts = (Employee[])ois.readObject();
           }
          System.out.println("Ready for printing out the payroll check.");


       }
       catch (IOException e)
       {
//        System.err.println(e);
          System.out.println("The file is empty, populate the employees now.");

       }
        

    }

    private void printPayroll() throws ClassNotFoundException, IOException 
    {
        
        writeAcct();
        showAcct();
        menu();
        
       
    }
    public void showAcct() throws ClassNotFoundException, IOException
    {
 
    
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Paycheck.txt"));
            int counter = 0;

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                    System.out.println(sCurrentLine);
                    StringTokenizer st = new StringTokenizer(sCurrentLine, "|");

                    while(st.hasMoreTokens())
                    {
                        for(int i = 0; i < 2; i++)
                        {

                            if(i == 0)
                            {
                                String tempAcct = st.nextToken();
                                myaccts[counter].setID(tempAcct);
                            }
                            else
                            {
                                myaccts[counter].setNetpayment(Float.parseFloat(st.nextToken()));
                            }

                        }
                    }
                    counter++;
            }

        } 
        catch (IOException e)
        {
        }
    }
    

    public void writeAcct()
    {
         
    
        try{
                File file = new File("Paycheck.txt");

//                 if file doesnt exists, then create it
                if (!file.exists())
                {
                        file.createNewFile();
                }


                FileWriter fw = new FileWriter(file, false); //change to true to append to the file
                try (BufferedWriter bw = new BufferedWriter(fw)) 
                {
                    for (Employee myEmployee1 : myaccts) 
                    {
                        Employee Null = null;
                        if (myEmployee1 == Null) 
                        {
                            String tempString = "No data";
                            bw.write(tempString);
                            bw.newLine();


                        }
                        else
                        {
                            String tempString = myEmployee1.getID();
                            double tempNumber = myEmployee1.getNetpayment();
                            String tempStringNum = Float.toString((float) tempNumber);
                            bw.write(tempString);
                            bw.write("|");
                            bw.write(tempStringNum);
                            bw.newLine();
                        }
                    }
                    
                System.out.println("Done");
            }
          } 
          catch (IOException e)
          {
          }
    
    }
}
   
    

    
    