package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String[]> arr = new ArrayList<String[]>();
		arr.add(new String[] { "m1", "p1" });
		arr.add(new String[] { "m2", "p2" });

		String[][] str = new String[arr.size()][arr.get(1).length];

		for (int i = 0; i < arr.size(); i++) {
			for (int x = 0; x < arr.get(1).length; x++) {
				str[i][x] = arr.get(i)[x];
			}
		}

		for (int i = 0; i < arr.size(); i++) {

			System.out.println(str[i][0] + " " + str[i][1]);
		}

		someA();
	}

	public static void someA() {

		HashMap<String, ArrayList<String[]>> map = new HashMap<String, ArrayList<String[]>>();
		map.put("1", new ArrayList<String[]>());

		map.get("1").add(new String[] { "1", "200" });
		map.get("1").add(new String[] { "2", "123" });
		map.get("1").add(new String[] { "3", "2345" });
		map.get("1").add(new String[] { "5", "5678" });
		map.put("2", new ArrayList<String[]>());
		map.get("2").add(new String[] { "4", "2347" });
		map.get("2").add(new String[] { "6", "97" });
		map.get("2").add(new String[] { "7", "20" });
		map.put("3", new ArrayList<String[]>());
		map.get("3").add(new String[] { "9", "346" });
		map.get("3").add(new String[] { "12", "96" });
		map.put("4", new ArrayList<String[]>());
		map.get("4").add(new String[] { "10", "13" });
		map.get("4").add(new String[] { "11", "764" });
		map.get("4").add(new String[] { "1", "34" });
		
		String[][] str = new String[map.keySet().size()][13];

		ArrayList<String> testList;
		int strIndex = 0;
		for (String key : map.keySet()) {
			for(String[] data : map.get(key))
			{
				str[strIndex][Integer.parseInt(data[0])] = data[1];
			}
			str[strIndex][0]=key;
			for(String[] row:str)
			{
				int i = 0;
				for (String date : row) {
					if (date == null) {
						row[i] = "-";
					}
					i++;
				}
			}
			strIndex++;
		}
		
		
		for (String[] outer : str) {
			for (String inner : outer) {
				System.out.print(" " + inner + " ");
			}
			System.out.println();
		}
	}

	public static void TistenerTest() {
		ListenerTest a = new ListenerTest();
		SpeakerTest aa = new SpeakerTest();
		System.out.println(aa.GetNum());

		a.SetListener((i) -> {
			aa.UpdateNum(i);
		});
		a.ActivateListener(10);
		System.out.println(aa.GetNum());
	}

	public static void SetArray() {
		ArrayList<String> testList;
		String[] testArray;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put("a", new ArrayList<String>());
		map.get("a").add("1");
		map.get("a").add("2");
		map.get("a").add("3");
		map.put("b", new ArrayList<String>());
		map.get("b").add("1");
		map.get("b").add("3");
		map.get("b").add("4");
		map.put("c", new ArrayList<String>());
		map.get("c").add("1");
		map.get("c").add("3");
		map.get("c").add("4");
		map.put("d", new ArrayList<String>());
		map.get("d").add("1");
		map.get("d").add("3");
		map.get("d").add("7");

		String[] keys = map.keySet().toArray(new String[0]);

		for (String key : keys) {
			testList = new ArrayList<String>();
			testList.add(key);
			for (String val : map.get(key)) {
				testList.add(val);
			}
			String[] temp = new String[13];
			temp[0] = key;
			for (String date : testList) {
				if (date.matches("-?\\d+(\\.\\d+)?")) {
					int tempint = Integer.parseInt(date);
					temp[tempint] = date;
				}
			}
			int i = 0;
			for (String date : temp) {
				if (date == null) {
					temp[i] = "-";
				}
				i++;
			}
			for (String lVal : temp) {
				System.out.print(lVal);
			}
			System.out.println();
		}
	}

}
