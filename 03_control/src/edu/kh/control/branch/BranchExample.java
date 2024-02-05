package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		//1부터 10까지 1씩 증가하며 출력하는 반복문 작성
		//단, 5를 출력하면 반복문 종료
		//1 2 3 4 5
		
		for(int i = 1;  i <= 10; i++) {
			System.out.print(i + " ");
			
			if(i ==5) {
				break;
			}
		}
		
		
		
	}

	
	
	
	
	public void ex2() {
		//입력받은 모든 문자열을 누적
		//단, "exit@" 입력시 문자열 누적을 종료하고 결과 출력
		
	
		String str = ""; //빈문자열
		
		while(true) {
			
			System.out.print("문자열 입력(exit@ 입력 시 종료) : ");
			String input = sc.nextLine();
			
			//next(): 다음 한 단어(띄어쓰기 포함 X)
			//nextLine(): 다음 한 줄(띄어쓰기 포함 0)
			
			if(input.equals("exit@")) {
				//String 자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없다
				// 비교연산자(==)는 보통 기본자료형끼리의 연산에서만 사용 가능함
				//-> String은 기본자료형이 아닌 참조형
				
				//** 해결방법 : 문자열1.equals(문자열2) 으로 비교 가능 ***
				break;
				
			}
			
			str += input + "\n";
		
		}
		
		System.out.println("==================");
		System.out.println(str);
	
	}




	public void ex3() {
		//continue : 다음 반복으로 넘어감
		
		// 1-10 까지 1씩 증가하며 출력
		// 단, 3의 배수 제외
		
		for(int i=1; i <= 10; i++) {
			
			if(i % 3 ==0) {
				
				continue;
				
			}
			
		
			System.out.print(i + " ");
			
		}
	  
	  
	  
	  
	  
  }



     public void ex4() {
	   //1-100 까지 1씩 증가하며 출력하는 반복문
      // 단 5의 배수는 건너뛰고
    	 //증가하는 값이 40이 되었을떄 반복을 멈춤
    	 //1
    	 //2
    	 //3
    	 //..
    	 //39
    	 
    	 for(int i =1; i <= 100; i ++) {
    		
    		 
    		 if (i == 40) {
    			 break;
    			 
    		 }
    		 
    		 
    		 if(i % 5 ==0) {
    			 continue;
    		 } 
    		 
    		
    		 
    		 System.out.println(i);
    		 
    	 }
	  
	   
   }
	
	
	
	
	
     public void RSPGame( ) {
    	 
    	 //가위바위보 게임을 할건데
    	 //몇 판 할지 입력받음
    	 //입력받은 판 수 만큼 반복
    	 //컴퓨터 : Math.random() : 0.0 ~1.0미만 난수생성
    	 // int random = (int) (Math.random() * 3 + 1);
    	 // 0.0 <= x < 1.0
    	 //0.0 <= x * 3 < 3.0
    	 //1.0 <= x* 3+1 < 4.0
    	 //1 <= (int)(x*3+1) < 4
    	 // ==> 1이상 4 미만 정수 -> 1 2 3
    	 //1)1 ~ 3 사이 난수 생성
    	 // 2) 1이면 가위 2이면 바위 3이면 보 지정 (switch)
    	 //컴퓨터와 플레이어 가위바위보 판별
    	 //플레이어 승! /졌습니다 출력
    	 //매판마다 끝나면
    	 //현재 기록 : 2승 1무 0패
    	 
    	System.out.println("[가위, 바위, 보 게임~!!]");
    	System.out.print("몇 판 ? : ");
    	int round = sc.nextInt();
    	
    	//승패 기록용 변수
    	int win = 0;
    	int draw = 0;
    	int lose = 0;
    	
    	for(int i = 1; i <= round; i++) {
    		
    		System.out.println("\n" + i + "번쨰 게임");
    		System.out.printf("가위/바위/보 중 하나를 입력 : ");
    		String input = sc.next();
    		
    		int random = (int)(Math.random() * 3 + 1); //123
    		
    		String com = null; //null :아무것도 참조하고 있지 않음
    		
    		switch(random) {
    		
    		case 1 : com = "가위"; break;
    		case 2 : com = "바위"; break;
    		case 3 : com = "보"; break;
    		
    		}
    		
    		// 컴퓨터는 [바위]를 선택했습니다
    		System.out.printf("컴퓨터는 [%s]를 선택했습니다 \n" , com);
    		
    		//컴퓨터와 플레이어 가위바위보 판별
    		if(input.equals(com)){
    			System.out.println("비겼습니다");
    			draw++;
    		}else {
    			
    			boolean win1 = input.equals("가위") &&  com.equals("보");
    			boolean win2 = input.equals("바위") &&  com.equals("가위");
    			boolean win3 = input.equals("보") &&  com.equals("바위");
    			
    			if(win1 || win2 || win3) {
    				System.out.println("플레이어 승!");
    				win++;
    				
    			}else {
    				System.out.println("졌습니다");
    				lose++;
    			}
    			
    			
    			
    			
    		}
  
    		
    		
    		
    		
    	System.out.printf("현재 기록 : %d 승 %d 무 %d 패 \n" , win , draw, lose);	
    		
    		
    	} 
    	
    	
    	
  
    	 
    	
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }
	
	
	
	
	


}
