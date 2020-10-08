package com.mat.matrixcalculator;

import java.util.ArrayList;
//int

public class Converter {
    public static ArrayList<Integer> convert(String str)
    {
        String[] temp = str.split(" "); //limit 0 will discard the last empty string
        System.out.println(temp.length);

        ArrayList<Integer> mVal = new ArrayList<>();

        for(int i=0; i<=temp.length-1; i++)
        {
            System.out.println(temp[i]);
            mVal.add(Integer.valueOf(temp[i]));
        }

        return mVal;
    }
}
