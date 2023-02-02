package com.guru99.base;

import java.util.ArrayList;

public class Temp {

    private int[] data; // intial data
    private static int DEFAULT_SIZE=10;
    private int size=0;

    public Temp()
    {
        this.data= new int[DEFAULT_SIZE];

    }
    public void add(int num)
    {
        if(isFull())
        {
            resize();
        }
        data[size]=num;
    }

    private void resize() {
        int[] temp=new int[data.length*2];
        // if data is full copy the data to the temp file

        for (int i=0;i<data.length;i++)
        {
            temp[i]=data[i];

        }
        data=temp;
    }

    private boolean isFull() {
        return size==data.length;
    }

    public int remove()
    {
         int remove=data[--size];
         return remove;
    }


    public static void main(String args[])
    {
        ArrayList arraysList=new ArrayList<>();

    }

}
