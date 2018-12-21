import java.util.Scanner;

public class MainProgram_180615 {
	public static void main(String[] args) {
		// 시작단계 글자 출력하기.
		// Java에서 Console(DOS) 출력시킬 수 있도록
		// 지원해주는 메소드
		System.out.println("Start Program. 프로그램 시작!");
		boolean mCode = true; // 메인메뉴 flag 값(프로그램 종료 시키는 기점 설정)
		// 메뉴 출력하기.
		// 1. 학생관리
		// 2. 과목관리
		while (mCode) { // 메인메뉴 무한 반복 수행
			System.out.println("1. 학생관리");
			System.out.println("2. 과목관리");
			System.out.println("4. 프로그램종료");
			// 입력할 수 있도록 구성하기.
			// 입력문으로 사용할 Scanner 선언
			// where empno = 1;
			Scanner sc = null;
			sc = new Scanner(System.in);
			System.out.print("[해당 번호를 누르세요.] ====>");
			// 1번을 누르고 엔터 , sc.nextInt() = 1
			// 2번을 누르고 엔터 , sc.nextInt() = 2
			int i_mMenu = sc.nextInt(); // sc(사용자 입력값)을 저장할 필요 있음.
			// i_mMenu = 1;
			// 메모리에서 사용자가 입력한 값(메뉴 선택값)을 저장할 수 있는 공간
			// 메뉴 선택한 숫자 값 저장공간 선언(변수 선언)
			System.out.println("선택한 번호값 : " + i_mMenu);
			// 1번 케이스 실행 (학생관리)
			if (i_mMenu == 1) {
				// 학생관리 메뉴 출력하기
				boolean b_stCode = true;

				while (b_stCode) {
					System.out.println("학생관리 메뉴를 선택하셨습니다. 해당 메뉴를 선택하세요.");
					System.out.println("1. 학생추가");
					System.out.println("2. 학생조회");
					System.out.println("3. 점수관리");
					System.out.println("4. 이전메뉴");
					System.out.print("[해당 번호를 누르세요.] ====>");

					sc = new Scanner(System.in);
					// 학생관리 내에서 메뉴 선택 값 저장
					int i_stMenu = sc.nextInt();
					// i_stMenu = new Scanner(System.in).nextInt();
					// i_stMenu 값이 들어가진 상태.
					// 각 번호에 따라서 별도의 프로세스 연산
					// 조건문을 통한 프로그램 동작
					// i_stMenu 1,2,3,4 실행되는 동작을 바꿔야 함.
					// i_stMenu 1일 경우
					// 만약 stMenu == 1, mMenu == 1
					String s_stName; // 추가할 학생 이름 저장 공간
					int i_stNum; // 추가할 학생 번호 저장 공간
					int i_stNumShow; // 검색한 학생 번호 저장 공간
					String s_stNameShow; // 검색한 학생 이름 저장 공간
					if (i_stMenu == 1) {
						// 학생추가
						System.out.println("학생추가 항목입니다.");
						System.out.println("추가하고자 하는 학생 이름을 입력하세요.");
						// 입력할 수 있도록 구성
						sc = new Scanner(System.in);
						s_stName = sc.nextLine();
						System.out.println("추가하고자 하는 학생 번호를 입력하세요.");
						sc = new Scanner(System.in);
						// 학생번호 입력할 수 있도록 구성
						i_stNum = sc.nextInt();
						System.out.println("입력이 완료 되었습니다.");
						System.out.println("입력된 학생번호 : " + i_stNum);
						System.out.println("입력된 학생이름 : " + s_stName);
					} else if (i_stMenu == 2) {
						// 학생조회
						System.out.println("학생조회 메뉴입니다. 조회하고 싶은 학생의 번호를 입력하세요.");
						sc = new Scanner(System.in);
						// int i_stNum = sc.nextInt();
						// System.out.println("입력한 번호 : " + i_stNum);
						// System.out.println("학생이름 : " + s_stName);
					} else if (i_stMenu == 3) {
						// 점수관리
					} else if (i_stMenu == 4) {						
						// 종료
						b_stCode = false;
					} else {
						// 잘못된 값을 입력하였습니다.
						// 메뉴확인 잘 하고 누르세요. 난독증 극혐!
					} // 세부 학생메뉴 if문 종료
				} // 세부 학생메뉴 while문 종료
			} // 1. 학생메뉴 if문 종료
			else if (i_mMenu == 4) {
				// while문 종료
				mCode = false;
			}

		} // while() 종료 지점

	} // main() 종료 지점

} // MainProgram Class 종료 지점 END...
