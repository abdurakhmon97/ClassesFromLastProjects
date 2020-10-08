package com.mat.matrixcalculator;

import java.util.ArrayList;

public class Multiplication {
    public static Matrix1 multiply(Matrix1 m1, Matrix1 m2)
    {
        ArrayList<Integer> newMat = new ArrayList();

        int newMatrix = m1.getRow()*m2.getColumn();
        int[] newMatrixValue = new int[newMatrix];

        //calculation
        int m2No= 0; //can go up to m2Column
        int m1No= 0; //increases by m1Column
        for(int i=0; i<newMatrixValue.length; i++)
        {
            if(m2No>=m2.getColumn())
            {
                m2No = 0;
                m1No = m1No+m1.getColumn();
            }
            //newMatrixValue[i]=m1.mat.get(m1No) * m2.mat.get(m2No) +m1.mat.get(m1No+1) * m2.mat.get(m2No+m2.getColumn());
            int temp = 0;
            int counter = 0;
            for(int j = m1No; j < m1No + m1.getColumn(); j++)
            {
                temp+=m1.matrix.get(j) * m2.matrix.get(m2No+counter*(m2.getColumn()));
                counter++;
            }
            newMatrixValue[i] = temp;
            newMat.add(newMatrixValue[i]);
            m2No++;
        }
        return new Matrix1(m1.getRow(), m2.getColumn(), newMat);

    }

//	//have to be in order
//	public static Matrix multiply(Matrix m1, Matrix m2)
//	{
//		if(m1.checkIfCompatible(m2)) // check if multiplying is possible
//		{
//			String mat1Row = ""; //deep copy problem, need to chage the clone method
//			ArrayList<Integer> row = new ArrayList(); //change
//			for(int i =0; i <= m1.mat.size()-1; i++)
//			{
//				if(i%m1.getColumn() == m1.getColumn()-1)
//				{
//					row.add(m1.mat.get(i));//has to be the last entry, i%m1.getColumn()
//					for(Integer temp : row)
//						mat1Row+=temp+" ";
//					mat1Row+="\n";
//					row.clear();
//				}
//				else
//				{
//					row.add(m1.mat.get(i));
//				}
//			} //have first mat sorted according to rows
//			System.out.println(mat1Row);
//			String[] test = mat1Row.split("\n");
//			for(int i=0; i<test.length; i++)
//			{
//				test[i].split(" ");
//			}
//			System.out.println();
//
////			ArrayList<ArrayList<Integer>> mat2Col = new ArrayList(); //column wise
////			for(int i = 0; i <= m2.getRow(); i+=m2.getRow())
////			{
////				int counter = 0; //keep track of columns
////				ArrayList<Integer> column = new ArrayList();
////				if(i+m2.getRow() > m2.mat.size()-1)
////				{
////					counter++;
////					column.add(m2.mat.get(i)); //has to be the last entry, i%m1.getColumn()
////					mat2Col.add(column);
////					column.clear();
////					if(i == m2.mat.size()-1)
////						break;
////					else
////						i = counter; //resetting
////				}
////				else
////				{
////					column.add(m2.mat.get(i));
////				}
////			}
////			for(Object[] i : mat1Row)
////			{
////				System.out.println(i.toString());
////			}
////			for(ArrayList<Integer> i : mat2Col)
////			{
////				System.out.println(i);
////			}
//		}
//		return null;
//	}

    public static ArrayList<Integer> genRow(ArrayList<Integer> r, ArrayList<ArrayList<Integer>> c)
    {
        ArrayList<Integer> temp = new ArrayList();
        int returnNumber = r.size();
        for(int i=0; i<returnNumber; i++)
        {
            ArrayList<Integer> currentColumn = c.get(i);
            int val = 0;
            for(int j = 0; j<r.size(); j++)
            {
                val+=r.get(j)*currentColumn.get(j);
            }
            temp.add(val);

        }
        return temp;
    }

}