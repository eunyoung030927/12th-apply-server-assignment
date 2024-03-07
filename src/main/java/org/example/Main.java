package org.example;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		int exitN = 0;
		Boolean con = true;
		
		String[][] resOX = new String[13][3]; // 예약 현황표 OX
		for(int ri=0;ri<13;ri++) {
			for(int rj=0;rj<3;rj++) {
				resOX[ri][rj] = "X"; //모든 예약 현환 X 상태
			}}
		String[][] ans = new String[1000][2]; // 문의 리스트
		int ansN = 0; // 문의 번호
		
		System.out.println("스터디룸 예약 프로그램입니다.");
		
		do{
			
			System.out.println("----- 작업 -----");
			System.out.println();
			System.out.println("1. 스터디룸 예약"); // 선택 문구 출력
			System.out.println("2. 예약 현황 조회");
			System.out.println("3. 문의 남기기");
			System.out.println("4. 문의 리스트 보기");
			System.out.println("5. 프로그램 종료");
			System.out.println();
			System.out.printf("작업을 선택하세요: ");
			int num = input.nextInt(); // 작업 선택
			exitN = num;
			System.out.println();
			
			
			switch (num) {
			case 1:
				String abc;
				int start,end;
				int abcn=0;
				con = true; // continue의 con
				
				System.out.println("----- 스터디룸 예약 -----");
				System.out.printf("예약할 스터디룸: ");
				abc = input.next();
				System.out.printf("사용 시작 시간: "); //11시
				start = input.nextInt();
				System.out.printf("사용 종료 시간: "); //14시
				end = input.nextInt(); // 사용자 입력 받음
				
				if (abc.equals("A")) abcn=0; // 알파벳 0,1,2로 변경
				else if (abc.equals("B")) abcn=1; // ==는 주소값 비교!
				else if (abc.equals("C")) abcn=2;
				else {System.out.printf("스터디룸 %s는 존재하지 않습니다.\n",abc); //수정
				System.out.println("예약에 실패했습니다.");
				System.out.println();
				continue;} 
				
				for (int i=start-10; i<end-10;i++) {
					if (resOX[i][abcn]=="O") con=false; //하나라도 "O"면 con이 false
				}
				
				if (con) { //con이 true면 예약 진행
					for (int i=start-10; i<end-10;i++) {
						resOX[i][abcn] = "O"; // 예약 완료로 변경
					}
					System.out.println("예약이 완료되었습니다!");
					System.out.println();}
				else { // false면 진행 안함
					System.out.printf("스터디룸 %s는 해당 시간에 이미 예약되어 있습니다.\n",abc);
					System.out.println("예약에 실패했습니다.");
					System.out.println();
				}
					
				break;
				
			case 2:
				System.out.println("----- 예약 현황 -----");
				System.out.println("| A | B | C |");
				for (int i=0;i<13;i++) {//i+10이 원래 시간
					if (i+10<12) { //오전 출력
						System.out.printf("오전 %d시 | %s | %s | %s |\n",i+10,resOX[i][0],resOX[i][1],resOX[i][2]);
					}else { //오후 출력
						System.out.printf("오후 %d시 | %s | %s | %s |\n",i-2,resOX[i][0],resOX[i][1],resOX[i][2]);
					}}
				System.out.println();
				break;
				
			case 3:
				System.out.println("----- 문의 남기기 -----");
				System.out.printf("문의 아이디: ");
				ans[ansN][0] = input.next(); //첫 열에 아이디 저장
				System.out.println();
				System.out.printf("문의 내용: ");
				ans[ansN][1] = input.nextLine(); //둘째 열에 내용 저장
				ansN++;
				System.out.println();
				System.out.println("문의가 저장되었습니다.");
				System.out.println();
				break;
				
			case 4:
				System.out.println("----- 문의 남기기 -----");
				for (int i=0;i<ansN;i++) {
					System.out.printf("문의 아이디: %s", ans[i][0]);
					System.out.println();
					System.out.printf("문의 내용: %s",ans[i][1]);
				}System.out.println();
				break;
				
			case 5: // 종료 문구 출력
				System.out.println("프로그램을 종료합니다...");
				break;
				
			default:
				System.out.println("다른 번호를 선택해주십시오.");
				break;
			
			}}while(exitN!=5); // exitN이 5면 실행 종료
    }
}
