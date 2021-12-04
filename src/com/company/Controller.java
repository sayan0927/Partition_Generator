package com.company;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Controller(){}

    void start()
    {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nEnter Target\n");
            int target = scanner.nextInt();

            double start_time = new Date().getTime();

            Generator generator = new Generator();
            generator.compute(target);

            System.out.println("Total partition of the integer " + target + " is " + generator.getPartitionCount());

            System.out.println("Time taken for input " + target + " is " + (new Date().getTime() - start_time) / 1000 + " seconds");

            System.out.println("Press 1 to display the partitions ");

            if (scanner.nextInt() == 1) {

                System.out.println("\nPlease Wait....");

                List<String> list = generator.getPartitions();
                System.out.println("\nThe partitions are");

                for (String s : list)
                    System.out.println(s);

            }


            System.out.println("Press 1 to compute for another Integer");


        } while (scanner.nextInt() == 1);
    }

}


