package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entity.Data;
import mapper.SetData;

public class GetData {

   public static void main(String[] args) {
      SetData set = new SetData();

       // 파싱한 데이터를 저장할 변수
       String result = "";
       try {//복권 공공 API 가져오기
          for(int round = 1; round <= 1051; round++) {
              URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+String.valueOf(round));

              BufferedReader bf;
              bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
              result = bf.readLine();

               JSONParser jsonParser = new JSONParser();
               JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
               
               String date = jsonObject.get("drwNoDate").toString();
               int num1 = Integer.parseInt(jsonObject.get("drwtNo1").toString()); //1번
               int num2  = Integer.parseInt(jsonObject.get("drwtNo2").toString()); //2번
               int num3  = Integer.parseInt(jsonObject.get("drwtNo3").toString()); //3번
               int num4  = Integer.parseInt(jsonObject.get("drwtNo4").toString()); //4번
               int num5  = Integer.parseInt(jsonObject.get("drwtNo5").toString()); //5번
               int num6  = Integer.parseInt(jsonObject.get("drwtNo6").toString()); //6번
               int numb  = Integer.parseInt(jsonObject.get("bnusNo").toString()); //보너스
               
               Data data = new Data();
               data.setNo(round);
               data.setNum1(num1);
               data.setNum2(num2);
               data.setNum3(num3);
               data.setNum4(num4);
               data.setNum5(num5);
               data.setNum6(num6);
               data.setNumb(numb);
               data.setDate(date);
               SetData.insertLottoNum(data);
          }
       }catch(Exception e) {
          e.printStackTrace();
       }
   }

}
