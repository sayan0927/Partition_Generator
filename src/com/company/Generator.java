package com.company;

import java.util.*;



public class Generator {


    private final List<Integer> sequence;   // this hold current sequnce for example [1,1,2] means currently 1+1+2 has been added
    private  final HashSet<List<Integer>> sequences_present;   // holds all the unique sequences that add upto the number
    private final List<String> partitions;                     // if user wants to print the partitions , sequences from previous variable appended to
                                                               //this and returned
    private  int calls;

    Generator()
    {

        calls=0;
        sequence=new LinkedList<>();
        sequences_present=new HashSet<>();
        partitions=new LinkedList<>();
    }

    void compute(int target)
    {
        compute(target,0,1);   //initially adding will start from 1
        stringifyPartitions();
    }

    private void compute(int target, int curr_sum,int level)
    {
        calls++;
        if(curr_sum>target)
            return;
        if(curr_sum==target)
        {
            List<Integer> temp=new LinkedList<>(sequence);
            Collections.sort(temp);
          
            sequences_present.add(temp);
        }

        // if 1+1+1+1 already calculated then 1+1+2+1 will not be calculated instead it starts from 1+1+2+2, recursive call in line 50 sets the level
        //from which looping start
        for(int i=level;i<=target;i++)
        {
            if(curr_sum+i>target)
                break;
            sequence.add(i);
            compute(target,curr_sum+i,i);
            sequence.remove(sequence.size()-1);
        }

    }

    private void stringifyPartitions()
    {

        for(List<Integer> list:sequences_present)
        {
            StringBuilder stringBuilder=new StringBuilder();
            for(Integer i:list)
            {
                stringBuilder.append(i);
                stringBuilder.append('+');
            }
            if(stringBuilder.length()>0&&stringBuilder.charAt(stringBuilder.length()-1)=='+')
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            this.partitions.add(stringBuilder.toString());
        }

        partitions.sort(new StringSorter()); //sorting the list according to sequence length
    }



    List<String> getPartitions()
    {
        return partitions;
    }

    long getPartitionCount()
    {
        return sequences_present.size();
    }

    long getNumberOfCalls()
    {
        return calls;
    }

   
}

