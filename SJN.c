#include<stdio.h>
int main(void)
{
    int process ,i,j,swap;

    //Taking number of process
    printf("\n Please Enter How Many Process :\t");
    scanf("%d",&process);

    //Taking value of Burst Time
     int burstTime[process];
     printf("\n Please Enter Your Burst Time: \n\n");
     for(i=0; i<process; i++)
     {
         printf(" Burst Time_%d:\t",i+1);
         scanf("%d",&burstTime[i]);
     }
     //Sort Burst Time
     for(i=0; i<process; i++)
     {
         for(j=0; j<process-1; j++)
         {
                    if(burstTime[j]>burstTime[j+1])
                    {
                        swap = burstTime[j];
                        burstTime[j] = burstTime[j+1];
                        burstTime[j+1] = swap;
                    }
         }
     }

     //Taking value of  Arrival Time
   int arrivalTime[process];
     printf("\n Please Enter Your Arrival Time: \n\n");
     for(i=0; i<process; i++)
     {
         printf(" Arrival Time_%d:\t",i+1);
         scanf("%d",&arrivalTime[i]);
     }

    // Calculating and Printing Gantt Chart
    int ganttChart[process];
    ganttChart[0] = 0;
    printf("\n Gantt Chart : \t%d\t",ganttChart[0]);
    for(i=1; i<process; i++)
    {

            ganttChart[i] = ganttChart[i-1] + burstTime[i-1];
            printf("%d\t",ganttChart[i]);

    }

//Calculating Equation (Service Time - Arrival Time )
    printf("\n Waiting Time :\t");
    int temp[process];
    int totalWaitingTime = 0;
    for(i=0; i<process; i++)
    {

            temp[i] = ganttChart[i] - arrivalTime[i];
            totalWaitingTime = totalWaitingTime + temp[i];
            printf("%d\t",temp[i]);
    }

        printf("\n Total Waiting Time:\t%d",totalWaitingTime);
        printf("\n Average Waiting Time:\t%.2f",(float)totalWaitingTime/process);

    getch();
    return 0;
}
