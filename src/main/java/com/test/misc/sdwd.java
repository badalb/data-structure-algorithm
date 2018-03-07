//package com.test.misc;
//
//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//class Solution {
//  public static void main(String[] args) {
//  
//    Interval interval1 = new Interval(1,4);
//    Interval interval2 = new Interval(2,7);
//    Interval interval3 = new Interval(3,6);
//    Interval interval4 = new Interval(8,10);
//    Interval interval5 = new Interval(15,18);
//    
//    IntervalCoverage ic = new IntervalCoverage();
//    ic.addInterval(interval1);
//    ic.addInterval(interval2);
//    ic.addInterval(interval3);
//    ic.addInterval(interval4);
//     ic.addInterval(interval5);
//    
//    int result = ic.getTotalCoveredLength();
//    System.out.println(result);
//    
//    // List<Interval> intervals = new ArrayList<Interval>();
//    // list
//    
//  }
//}
//
//class Interval{
//      int s;
//      int e;
//
//      public Interval(int start, int end){
//        this.s = start;
//        this.e = end;
//      }
//  
//  public int getS(){
//    return s;
//  }
//  
//  public int getE(){
//    return e;
//    }
//}
//
//class IntervalCoverage {
//    
//  private List<Interval> intervals = new ArrayList<Interval>();
//  
//  
//    public void addInterval(Interval a){  
//      intervals.add(a);
//    }
//
//
//    public int getTotalCoveredLength(){
//      
//      int[] start = new int[intervals.size()];
//      int[] end = new int[intervals.size()];
//      
//      for(int i =0; i <intervals.size(); i++){
//         
//        start[i] = intervals.get(i).getS();
//        end[i] = intervals.get(i).getE();
//        
//      }
//        
//    
//    int intervalSum = 0;  // 5
//      
//      for(int j =0; j < start.length;){
//        
//        int s = start[j];  //1  8
//        int e = end[j];      // 3  10
//        int maxEnd = end[j];
//        
//        int idx = j; 
//        int k = j; 
//        
//        for(k =j+1; k< start.length; k ++){
//          
//          if(e > start[k]){  //3 >2  
//            idx = k;   //1
//            if(maxEnd < end[k]){
//              maxEnd = end[k];
//            }
//            
//          }
//          
//        }
//        
//        
//        intervalSum += (maxEnd - s);  // 6-1
//        j= idx+1;      // j = 1+1; 
//      }
//    
//      return intervalSum;
//    }
//    
//}
//
//
//
//
//
///*
//orig [1,3],[2,6],[8,10],[15,18]
//merged: [1,6],[8,10],[15,18]
//5+2+3 = 10
//
//orig [1,4],[2,7],[3,6], [8,10],[15,18]
//merged: [1,7],[8,10],[15,18]
//6+2+3 = 11
//
//
//ic.add
//ic.add
//ic.gettotal
//ic.add
//ic.add
//ic.add
//ic.gettotal
//*/