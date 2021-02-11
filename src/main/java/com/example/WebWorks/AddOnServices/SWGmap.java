package com.example.WebWorks.AddOnServices;

import com.example.WebWorks.DBoperations.DBconnect;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class SWGmap {
    //private9
    static String swg[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20","20.5","21","21.5","22","22.5","23","24","25","26","27","28","29","30"};
    static String aa[]={"53.1730","45.5806","38.5750","32.1636","27.2610","22.7636","18.6713","15.6850","12.9651","10.5041","8.2967","6.8130","5.4794","4.2873","3.2413","2.9240","2.6260","2.3413","2.0755","1.8232","1.5873","1.3678","1.1665","0.9812","0.8103","0.7310","0.6558","0.5846","0.5189","0.4558","0.3968","0.34195","0.2621","0.2453","0.2026","0.16395","0.1362","0.1109","0.0937","0.0779"};
    static Map<Float,Float> map=new TreeMap<>();
    public static ArrayList<Float> getAlternate(float swg, float weight, int cusid)
    {
        map();
        ArrayList<Float> alter=new ArrayList<>();
        HashSet<Float> stock_swg=new HashSet<Float>();
        int i=0;
        float sswg[];
        Map<Float,Float> stock_map=new TreeMap<>();
        float aa=map.get(swg);
        float per_weight=weight/aa;
        float tolerance=aa*0.05f;
        try {
            Connection conn= DBconnect.getConn();
            PreparedStatement st= conn.prepareStatement("select * from stockdetails where SWG>? and cusid=?");
            st.setFloat(1,swg);
            st.setInt(2,cusid);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                float st_swg=rs.getFloat("SWG");
                float st_weight=rs.getFloat("weight");
                stock_swg.add(st_swg);
                stock_map.put(st_swg,st_weight);
            }
            sswg=new float[stock_swg.size()];
            Iterator<Float> itr=stock_swg.iterator();
            while(itr.hasNext()){
                sswg[i++]= itr.next();
            }
            float left=aa;
            int flag=0;
            i=0;
            int p=0;
            Arrays.sort(sswg);
            while(true)
            {
                if(p==stock_swg.size()-1) {
                    break;
                }
                i=p;
                while(i<stock_swg.size())
                {
                    if(left>map.get(sswg[i]) && stock_map.get(sswg[i])>(per_weight*map.get(sswg[i])))
                    {
                        left-=map.get(sswg[i]);
                        alter.add(sswg[i]);
                        alter.add(per_weight*map.get(sswg[i]));
                    }
                    i++;
                }
                System.out.println(alter.toString());
                if(left<=tolerance)
                {
                    flag=1;
                    break;
                }
                else{
                    p++;
                    alter.clear();
                }
                left=aa;
            }
            if(flag==1)
            {
                return alter;
            }
        }
        catch (Exception ee)
        {
            System.out.println(ee);
        }
        return null;
    }
    static void map()
    {
        int i;
        for(i=0;i< swg.length;i++)
        {
            map.put(Float.parseFloat(swg[i]),Float.parseFloat(aa[i]));
        }
    }

    public static void main(String a[])
    {
        ArrayList<Float> test=getAlternate(17.5f,22,3);
        int i,j;
        for(i=0;i<test.size();i++)
        {
                System.out.print(test.get(i)+" ");
                //System.out.println();
        }
    }
}
