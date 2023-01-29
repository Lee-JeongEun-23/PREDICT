package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class makeData {

   public static void main(String[] args) {      
       // 파싱한 데이터를 저장할 변수
       String result = "";
       int round = 0;
       try {//복권 공공 API 가져오기

          int[] array = new int[45];


          HashMap<Integer,Integer> temp1 = new HashMap<Integer,Integer>();
         
          ArrayList<Integer> temp3 = new ArrayList<Integer>();
          
         for(round = 1000; round <= 1052; round++) {
              URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+String.valueOf(round));

              BufferedReader bf;
              bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
              result = bf.readLine();
              
               JSONParser jsonParser = new JSONParser();
               JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
              
               ArrayList<Integer> temp2 = new ArrayList<Integer>();
               
               int num1 = Integer.parseInt(jsonObject.get("drwtNo1").toString()); //1번
               int num2  = Integer.parseInt(jsonObject.get("drwtNo2").toString()); //2번
               int num3  = Integer.parseInt(jsonObject.get("drwtNo3").toString()); //3번
               int num4  = Integer.parseInt(jsonObject.get("drwtNo4").toString()); //4번
               int num5  = Integer.parseInt(jsonObject.get("drwtNo5").toString()); //5번
               int num6  = Integer.parseInt(jsonObject.get("drwtNo6").toString()); //6번
               
               //System.out.println(round + " : " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6 + " ");
               
               
               temp2.add(num1);
               temp2.add(num2);
               temp2.add(num3);
               temp2.add(num4);
               temp2.add(num5);
               temp2.add(num6);
               
               for(int i = 0; i < temp2.size(); i++) {
            	   if(temp2.get(i) >= 40 && temp2.get(i) < 46) {
            		   if(temp1.containsKey(temp2.get(i))) {
            			   temp1.put(temp2.get(i), temp1.get(temp2.get(i))+1);
            		   }else {
            			   temp1.put(temp2.get(i), 1);
            		   }
            	   }
               }
               
               
               /*
               if(round == it) {
                  temp2.add(num1);
                   temp2.add(num2);
                   temp2.add(num3);
                   temp2.add(num4);
                   temp2.add(num5);
                   temp2.add(num6);
               }else {
                  temp3.add(num1);
                   temp3.add(num2);
                   temp3.add(num3);
                   temp3.add(num4);
                   temp3.add(num5);
                   temp3.add(num6);
               }
               
               if(round == it+1) {
                  System.out.println(round-1 + " : " + temp2);
                  System.out.println(round + " : " + temp3);
                  
                  for(int i = 0; i < temp2.size(); i++) {
                     for(int j = 0; j < temp3.size(); j++) {
                         if(temp2.get(i) == temp3.get(j)) {
                            System.out.println(temp2.get(i));
                            break;
                         }
                      }
                  }
                  
               }
               */

          } //로또 데이터 가져오기 완료
         System.out.println(temp1); 
         
       }catch(Exception e) {
          e.printStackTrace();
       }
   }

}
