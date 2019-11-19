package com.trial.project.objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by earon on 11/18/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class SquareMakerTest {

    String[][] mockBox = new String [4][4];

    @Test
    public void testEndCheck(){
        boolean isStart = SquareMaker.isEnds(0,100);
        boolean isEnd = SquareMaker.isEnds(99,100);
        boolean isMiddle = SquareMaker.isEnds(88,100);

        assertTrue(isStart);
        assertTrue(isEnd);
        assertFalse(isMiddle);
    }

    @Test
    public void testMarkAll(){
        String[][] markedAll = SquareMaker.markAllRows(mockBox,2,4);
        for (int i=0; i < 4; i++){
            assertEquals("#",markedAll[2][i]);
        }
    }

    @Test
    public void testMarkEnds(){
        String[][] markedEnds = SquareMaker.markStartandEnd(mockBox,2,4);
        assertEquals("#",markedEnds[2][0]);
        assertEquals(" ",markedEnds[2][1]);
        assertEquals(" ",markedEnds[2][2]);
        assertEquals("#",markedEnds[2][3]);
    }

    @Test
    public void testValidInt(){
        boolean notInt = SquareMaker.isInt("");
        boolean notInt1 = SquareMaker.isInt("String");
        boolean notInt2 = SquareMaker.isInt(null);
        boolean anInt = SquareMaker.isInt("32");
        assertTrue(anInt);
        assertFalse(notInt);
        assertFalse(notInt1);
        assertFalse(notInt2);
    }

    @Test
    public void testBiggestSquare(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(32);
        arrayList.add(4);

        int largest = SquareMaker.getBiggestSquare(arrayList);
        assertEquals(32,largest);
    }

    @Test
    public void testFindValidInputs(){
        String [] values = new String[]{"String","3","String2","4"};

        ArrayList<Integer> validInputs = SquareMaker.findValidInputs(values);
        assertEquals(2,validInputs.size());
    }

    @Test
    public void testCreateBiggestSquare(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(32);
        arrayList.add(4);

        String[][] biggestSquare = SquareMaker.createBiggestSquare(arrayList);
        assertEquals(32,biggestSquare.length);
    }
}
