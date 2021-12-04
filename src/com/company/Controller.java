package com.company;

import java.util.List;
import java.util.Scanner;

public class Controller {

    Controller(){}

    void start()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nEnter Target\n");
            int target = scanner.nextInt();

            //  double start_time = new Date().getTime();

            Generator generator = new Generator();
            generator.compute(target);

            System.out.println("Total partition of the integer " + target + " is " + generator.getPartitionCount());
            System.out.println("Press 1 to display the partitions ");

            if (scanner.nextInt() == 1)
            {
                System.out.println("\nThe partitions are");
                List<String> list=generator.getPartitions();
                for (String s:list)
                    System.out.println(s);

            }


            System.out.println("Press 1 to compute for another Integer");
            if(scanner.nextInt()!=1)
                break;


        }
    }

}


