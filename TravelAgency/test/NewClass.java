
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liluyi
 */
public class NewClass {
    public static void main(String[] args)
    {
        int[] arr=new int[5];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i;
        }
        ArrayList<int[]> list=new ArrayList<int[]>();
        
        list.add(arr);
        arr=new int[5];
        for(int[] x:list)
        {
            for(int y:x)
            {
                System.out.print(y);
            }
        }
    }
}
