
package cpu_scheduling;

import java.util.Scanner;

public class SJN
{
    public static void main(String[] args)
    {
         Scanner input = new Scanner(System.in);
        int process;
        System.out.print("Please Enter How Many Process :\t");
        process = input.nextInt();
        
//      Taking Burst Time value 
        int burtsTime[] = new int[process];
        System.out.println("Please Enter Your Burts Time:");
        for(int i=0; i<burtsTime.length; i++)
        {
            System.out.printf("Burts Time_%d:\t",(i+1));
            burtsTime[i] = input.nextInt();
        }
//      Sorting Burst Time 
        for(int i=0; i<burtsTime.length; i++)
        {
            for(int j=0; j<burtsTime.length-1; j++)
            {
                if(burtsTime[j]>burtsTime[j+1])
                {
                    int swap = burtsTime[j];
                    burtsTime[j] = burtsTime[j+1];
                    burtsTime[j+1] = swap;
                }
            }
        }
        
 //     Taking Burst Time value 
        int arrivalTime[] = new int[process];
        System.out.println("\nPlease Enter Your Arrival Time:");
        for(int i=0; i<arrivalTime.length; i++)
        {
            System.out.printf("Arrival Time_%d:\t",(i+1));
            arrivalTime[i] = input.nextInt();
        }
//        Gantt Chart 
        int ganttChart[] = new int[process];
        ganttChart[0] = 0;
        System.out.print("\nGantt Chart:\t"+ganttChart[0]);
        
        for(int i=1; i<ganttChart.length; i++)
        {
             ganttChart[i] = ganttChart[i-1] + burtsTime[i-1];         
             System.out.print("  "+ganttChart[i]);
        }
//Calculat Equatin (Service Time - Arrival Time)
        int temp[] = new int[process];
        int totalWaitingTime = 0;
        System.out.print("\nWaiting Time:\t");
        for(int i=0; i<temp.length; i++)
        {
            temp[i] = ganttChart[i] - arrivalTime[i];
            totalWaitingTime = totalWaitingTime + temp[i];
            System.out.print("  "+temp[i]);
        }
        
        System.out.println("\nTotal Waiting Time:\t"+totalWaitingTime);
       System.out.println("Average Waiting Time:\t"+(double)totalWaitingTime/process);
    }
}
