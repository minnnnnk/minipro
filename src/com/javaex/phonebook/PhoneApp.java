package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PhoneApp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		InputStream is = new FileInputStream("./phoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		List<Person> pList = new ArrayList<Person>();
		
		//데이터를 추가한거임 
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			
			String[] data = str.split(",");
			
			String name = data[0];
			String hp = data[1];
			String company = data[2];
			
			Person person = new Person(name , hp ,company);
			
			pList.add(person);
			
		}
	
		//시작화면
		
		System.out.println("****************************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("****************************************");
		System.out.println("");

		//반복시작
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호:");
			int mNum = sc.nextInt();
			
			
			if(mNum == 5) {
				System.out.println("****************************************");
				System.out.println("*              감사합니다              *");
				System.out.println("****************************************");
				break;
				
			} else if(mNum == 1) {
				// 리스트
				System.out.println("<1.리스트>");
				for(int i = 0; i<pList.size(); i++) {
					System.out.print(i+1); 
					pList.get(i).List();
				}
			
				System.out.println("");
			 } else if(mNum == 2) {
				 //등록
				 Writer fw = new FileWriter("./phoneDB.txt");
				 BufferedWriter bw = new BufferedWriter(fw);
				 System.out.println("<2.등록>");
				 
				 System.out.print(">이름: ");
				 String name = sc.next();
				 
				 
				 System.out.print(">휴대전화: ");
				 String hp = sc.next();
				 
				 
				 System.out.print(">회사전화: ");
				 String company = sc.next();
				 
				 Person nperson = new Person(name , hp ,company);
				 pList.add(nperson);
				 for (Person person: pList) {
					String saveStr = person.getName() + "," +person.getHp() +","+person.getCompany();
					
					bw.write(saveStr);
					bw.newLine();
				 }
				 System.out.println("[등록되었습니다.]");
				
				 bw.close();
			 } else if(mNum == 3) {
				 //삭제
				 System.out.println("<3.삭제>");
				 System.out.print(">번호: ");
			     int dNum = sc.nextInt();
				
				 pList.remove(dNum-1);
				
				 System.out.println("[삭제되었습니다.]");
				
			 } else if (mNum == 4) {
				 // 검색 
				 
			 } else {
				 // 다른숫자
				 System.out.println("[다시 입력해 주세요.]");
			 }
		
		
		}
		
		
		
		
		
		
		
		
		
		br.close();
		sc.close();
	}
}
