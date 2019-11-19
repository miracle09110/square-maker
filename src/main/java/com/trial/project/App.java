package com.trial.project;

import com.trial.project.objects.SquareMaker;

public class App
{
    public static void main(String[] args) {

        if (args == null || args.length <= 0){
            System.out.println("Please provide size of square");
            return;
        }

        SquareMaker.print(args);
    }


}
