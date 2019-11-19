package com.trial.project.objects;

import java.util.ArrayList;
import java.util.Collections;

public class SquareMaker {

    public static String[][] createBiggestSquare(ArrayList<Integer> inputs){
        int biggest = getBiggestSquare(inputs);
        String[][] box = new String [biggest][biggest];
        return box;
    }

    public static String[][] markSquares(ArrayList<Integer> boxSizes, String[][] box){
        for (int i =0; i < boxSizes.size(); i++){
            box = mark(box, boxSizes.get(i));
        }
        return box;
    }

    public static String[][] mark(String[][] box,int size){
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++) {
                if (isEnds(i,size)) {
                    box = markAllRows(box,i,size);
                } else {
                    box = markStartandEnd(box,i,size);
                }
            }
        }
        return box;
    }

    public static void print(String[] values){

        ArrayList<Integer> integers = findValidInputs(values);

        if(integers.size()<=0){
            System.out.print("Please add valid inputs");
            return;
        }

        String[][] toPrint = markSquares(integers,createBiggestSquare(integers));;
        for (int i=0; i< toPrint.length; i++){
            for (int j = 0; j < toPrint.length; j++){
                System.out.print(toPrint[j][i]);
            }
            System.out.print("\n");
        }
    }

    public static ArrayList findValidInputs(String[] input){
        ArrayList<Integer> validInput = new ArrayList<>();
        for (int i=0; i < input.length; i++){
            if(isInt(input[i])){
                validInput.add(Integer.parseInt(input[i]));
            }
        }
        return validInput;
    }

    public static Integer getBiggestSquare(ArrayList<Integer> validInputs){
        Collections.sort(validInputs,Collections.reverseOrder());
        return validInputs.get(0);
    }

    public static boolean isInt(String value){
        try {
            Integer.parseInt(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isEnds(int index, int size){
        return (index == (size - 1) || index == 0);
    }

    public static String[][] markAllRows(String[][] box,int column, int size){
        for (int i=0; i < size; i++){
            box[column][i] = "#";
        }
        return box;
    }

    public static String[][] markStartandEnd(String[][] box,int column, int size){
        for (int i=0; i < size; i++){
            if(isEnds(i,size)){
                box[column][i] = "#";
            } else {
                box[column][i]= " ";
            }
        }
        return box;
    }
}
