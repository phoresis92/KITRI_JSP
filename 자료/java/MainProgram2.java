import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MainProgram2 {
	// 전역변수
	// 클래스 내에 모든 메소드에서 공용으로 사용할 수 있도록
	// 구성된 변수
	// private int i_test_g;

	public static void main(String[] args) {
		// 배열
		// 해당 데이터 타입[] <- 배열 선언 문법
		// [] <- 공간 사이즈
		// 정수형 저장공간 4개를 만들고 싶다.
		int[] ar_int = { 1, 2, 3, 4 };
		// 생성됨 -> 칸을 4칸짜리 배열로 만듦.
		// ar_int => int[] -> 배열 메모리 주소값
		// ar_int[i] => int -> 실제 배열 내에 값
		System.out.println("배열주소값 : " + ar_int);
		System.out.println("배열 [0] 출력 결과 :" + ar_int[0]);
		System.out.println("배열 [1] 출력 결과 :" + ar_int[1]);
		System.out.println("배열 [2] 출력 결과 :" + ar_int[2]);
		System.out.println("배열 [3] 출력 결과 :" + ar_int[3]);
		// 배열의 크기 확인하기
		System.out.println("배열 크기 : " + ar_int.length);

		int[] ar_int2 = null;
		// Scanner sc = null;
		// sc = new Scanner(System.in);
		ar_int2 = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] ar_int3 = null;
		ar_int3 = new int[10];
		boolean[] ar_bool = new boolean[10];
		String[] ar_string = new String[10];
		// 해당되는 사원의 사원번호(int)
		// 해당사원의 이름 입력(String)
		// 총 10개 입력할 수 있는 공간 생성하기
		int empno[] = new int[10];
		String ename[] = new String[10];
		Scanner sc = null;
		System.out.println(empno.length);
		int cnt = 0;

//		while (cnt < 10) {
//			System.out.println("해당 사원의 번호를 입력하시오.");
//			sc = new Scanner(System.in);
//			empno[cnt] = sc.nextInt();
//			System.out.println("해당 사원의 이름을 입력하시오.");
//			sc = new Scanner(System.in);
//			ename[cnt] = sc.nextLine();
//			cnt++;
//		}
//
//		// empno, ename 출력하기
//		// for(기준값;조건범위;후위연산)
//		for (int a = 0; a < empno.length; a++) {
//			System.out.println(empno[a]);
//			System.out.println(ename[a]);
//
//		}
		
		//배열을 선언합니다.
		//처음에 배열이 1칸입니다.
		// 배열에 1칸 입력을 합니다.
		// 후행에 추가 값을 입력하고 싶습니다.
		// 배열이 2칸으로 생성이 되어야 합니다.
		// 이런식으로 배열에 값을 추가할때 마다
		// 배열의 공간을 재 지정하면서 추가될 수 있는
		// 배열공간 관리 프로그램을 만드세요.
		// 무한반복, 1개 값 입력받기.
		// 총 15개까지 입력 받을 수 있도록 구성
		// 초기 배열은 1칸 -> 입력 받으면 -> 1칸씩 증가할 수 있도록
		// 구성하기.
		
		//사용할 배열 선언
//		String[] ar_st = null;
//		
//		//사용할 배열 공간 선언
//		ar_st = new String[1];
//		Scanner sc1 = null;
//		sc1 = new Scanner(System.in);
//		//배열 1번째공간에 입력값 저장
//		ar_st[0] = sc1.nextLine();		
//		System.out.println(ar_st[0]);
//		
//		//추가 값 입력
//		String[] ar_st_backup = new String[1];
//		ar_st_backup[0] = ar_st[0]; // ar_st(sc1을 입력된 값)을 backup 저장
//		// 백업 배열공간에 기존 자료 저장
//		ar_st = new String[2];
//		// 기존 ar_st에 있는 값을 저장할 별도 백업 배열공간 생성
//		ar_st[0] = ar_st_backup[0];
//		// 추가 입력값 ar_st[1] 저장
//		sc = new Scanner(System.in);
//		ar_st[1] = sc.nextLine();
//		System.out.println(ar_st[0]);
//		System.out.println(ar_st[1]);
		String[] ar_st = null;
		String[] ar_st_backup = null;
		
		for(int i=1; i <= 15; i++) {
			//15번 수행되는 반복문 생성
			// 입력 받을 시 마다 ar_st 배열 재생성(공간 1개씩 추가)
			if(i > 1) { // 시작 배열일 시(백업할 배열 값이 없을 시)
				ar_st_backup = new String[i];
				for(int x=0;x<ar_st.length;x++) {
					ar_st_backup[x] = ar_st[x];
				}
			}		
			// 새롭게 갱신된 String 배열 생성 영역
			ar_st = new String[i];
			// 새롭게 갱신된 String 배열에 backup 값 복원
			if(i > 1) { // 시작 배열일 시(백업할 배열 값이 없을 시)				
				for(int x=0;x<ar_st_backup.length;x++) {
					ar_st[x] = ar_st_backup[x];
				}
			}
			
			sc = new Scanner(System.in);
			ar_st[i-1] = sc.nextLine();
			//출력
			System.out.println("현재 입력된 배열 내의 값");
			for(int j=0;j<ar_st.length;j++) {				
				System.out.println((j+1) + "번째 값 : " + ar_st[j]);
			}
		}
		
		


		
		

	} // main() close
}
