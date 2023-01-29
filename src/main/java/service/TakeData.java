package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mapper.SetData;

public class TakeData {

	public static void main(String[] args) throws SQLException {
		SetData set = new SetData();
		
		List<HashMap<Integer, Integer>> listNum = new ArrayList<HashMap<Integer, Integer>>();
		listNum = SetData.selectLottoNum1();
		int[] arr = {5, 12, 13, 31, 32, 45};
		//27, 34, 43 3번
		//27, 34, 45 2번
		//27, 34, 39 1번
		//27, 39, 43 3번
		
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mirror = new HashMap<Integer, Integer>();
		for(int i = 0; i < listNum.size(); i++) {
			HashMap<Integer, Integer> data = listNum.get(i);
			int num = 0;
			for(int j = 1; j <= 6; j++) {
				for(int k = 0; k < arr.length; k++) {
					if(data.get(j) == arr[k]) {
						num ++;
					}
				}
				if(count.containsKey(data.get(j))) { 
					count.put(data.get(j), count.get(data.get(j))+1); 
				}else { 
					count.put(data.get(j), 1); 
				}
			}
			switch (num) {
			case 5:
				System.out.println((i+1)+"회차 3등 당첨"); 
				System.out.println(data);
				System.out.println("---------------------------");
				break;
			case 4:
				System.out.println((i+1)+"회차 4등 당첨"); 
				System.out.println(data);
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println((i+1)+"회차 5등 당첨"); 
				System.out.println(data);
				System.out.println("---------------------------");
				break;
			}
		}
		System.out.println(count);
		
		
		
		
		
		
		
		
		//27 34 43
		/*
		 * List<Integer> listNum2 = new ArrayList<Integer>(); listNum2 =
		 * SetData.selectLottoNum2(); HashMap<Integer, Integer> count2 = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNum2.size(); i++) {
		 * if(count2.containsKey(listNum2.get(i))) { count2.put(listNum2.get(i),
		 * count2.get(listNum2.get(i))+1); }else { count2.put(listNum2.get(i), 1); } }
		 * System.out.println(count2);
		 * 
		 * List<Integer> listNum3 = new ArrayList<Integer>(); listNum3 =
		 * SetData.selectLottoNum3(); HashMap<Integer, Integer> count3 = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNum3.size(); i++) {
		 * if(count3.containsKey(listNum3.get(i))) { count3.put(listNum3.get(i),
		 * count3.get(listNum3.get(i))+1); }else { count3.put(listNum3.get(i), 1); } }
		 * System.out.println(count3);
		 * 
		 * List<Integer> listNum4 = new ArrayList<Integer>(); listNum4 =
		 * SetData.selectLottoNum4(); HashMap<Integer, Integer> count4 = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNum4.size(); i++) {
		 * if(count4.containsKey(listNum4.get(i))) { count4.put(listNum4.get(i),
		 * count4.get(listNum4.get(i))+1); }else { count4.put(listNum4.get(i), 1); } }
		 * System.out.println(count4);
		 * 
		 * List<Integer> listNum5 = new ArrayList<Integer>(); listNum5 =
		 * SetData.selectLottoNum5(); HashMap<Integer, Integer> count5 = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNum5.size(); i++) {
		 * if(count5.containsKey(listNum5.get(i))) { count5.put(listNum5.get(i),
		 * count5.get(listNum5.get(i))+1); }else { count5.put(listNum5.get(i), 1); } }
		 * System.out.println(count5);
		 * 
		 * List<Integer> listNum6 = new ArrayList<Integer>(); listNum6 =
		 * SetData.selectLottoNum6(); HashMap<Integer, Integer> count6 = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNum6.size(); i++) {
		 * if(count6.containsKey(listNum6.get(i))) { count6.put(listNum6.get(i),
		 * count6.get(listNum6.get(i))+1); }else { count6.put(listNum6.get(i), 1); } }
		 * System.out.println(count6);
		 * 
		 * List<Integer> listNumb = new ArrayList<Integer>(); listNumb =
		 * SetData.selectLottoNumb(); HashMap<Integer, Integer> countb = new
		 * HashMap<Integer, Integer>(); for(int i = 0; i < listNumb.size(); i++) {
		 * if(countb.containsKey(listNumb.get(i))) { countb.put(listNumb.get(i),
		 * countb.get(listNumb.get(i))+1); }else { countb.put(listNumb.get(i), 1); } }
		 * System.out.println(countb);
		 */
	}

}
