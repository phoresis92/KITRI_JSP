import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MainProgram2 {
	// ��������
	// Ŭ���� ���� ��� �޼ҵ忡�� �������� ����� �� �ֵ���
	// ������ ����
	// private int i_test_g;

	public static void main(String[] args) {
		// �迭
		// �ش� ������ Ÿ��[] <- �迭 ���� ����
		// [] <- ���� ������
		// ������ ������� 4���� ����� �ʹ�.
		int[] ar_int = { 1, 2, 3, 4 };
		// ������ -> ĭ�� 4ĭ¥�� �迭�� ����.
		// ar_int => int[] -> �迭 �޸� �ּҰ�
		// ar_int[i] => int -> ���� �迭 ���� ��
		System.out.println("�迭�ּҰ� : " + ar_int);
		System.out.println("�迭 [0] ��� ��� :" + ar_int[0]);
		System.out.println("�迭 [1] ��� ��� :" + ar_int[1]);
		System.out.println("�迭 [2] ��� ��� :" + ar_int[2]);
		System.out.println("�迭 [3] ��� ��� :" + ar_int[3]);
		// �迭�� ũ�� Ȯ���ϱ�
		System.out.println("�迭 ũ�� : " + ar_int.length);

		int[] ar_int2 = null;
		// Scanner sc = null;
		// sc = new Scanner(System.in);
		ar_int2 = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] ar_int3 = null;
		ar_int3 = new int[10];
		boolean[] ar_bool = new boolean[10];
		String[] ar_string = new String[10];
		// �ش�Ǵ� ����� �����ȣ(int)
		// �ش����� �̸� �Է�(String)
		// �� 10�� �Է��� �� �ִ� ���� �����ϱ�
		int empno[] = new int[10];
		String ename[] = new String[10];
		Scanner sc = null;
		System.out.println(empno.length);
		int cnt = 0;

//		while (cnt < 10) {
//			System.out.println("�ش� ����� ��ȣ�� �Է��Ͻÿ�.");
//			sc = new Scanner(System.in);
//			empno[cnt] = sc.nextInt();
//			System.out.println("�ش� ����� �̸��� �Է��Ͻÿ�.");
//			sc = new Scanner(System.in);
//			ename[cnt] = sc.nextLine();
//			cnt++;
//		}
//
//		// empno, ename ����ϱ�
//		// for(���ذ�;���ǹ���;��������)
//		for (int a = 0; a < empno.length; a++) {
//			System.out.println(empno[a]);
//			System.out.println(ename[a]);
//
//		}
		
		//�迭�� �����մϴ�.
		//ó���� �迭�� 1ĭ�Դϴ�.
		// �迭�� 1ĭ �Է��� �մϴ�.
		// ���࿡ �߰� ���� �Է��ϰ� �ͽ��ϴ�.
		// �迭�� 2ĭ���� ������ �Ǿ�� �մϴ�.
		// �̷������� �迭�� ���� �߰��Ҷ� ����
		// �迭�� ������ �� �����ϸ鼭 �߰��� �� �ִ�
		// �迭���� ���� ���α׷��� ���弼��.
		// ���ѹݺ�, 1�� �� �Է¹ޱ�.
		// �� 15������ �Է� ���� �� �ֵ��� ����
		// �ʱ� �迭�� 1ĭ -> �Է� ������ -> 1ĭ�� ������ �� �ֵ���
		// �����ϱ�.
		
		//����� �迭 ����
//		String[] ar_st = null;
//		
//		//����� �迭 ���� ����
//		ar_st = new String[1];
//		Scanner sc1 = null;
//		sc1 = new Scanner(System.in);
//		//�迭 1��°������ �Է°� ����
//		ar_st[0] = sc1.nextLine();		
//		System.out.println(ar_st[0]);
//		
//		//�߰� �� �Է�
//		String[] ar_st_backup = new String[1];
//		ar_st_backup[0] = ar_st[0]; // ar_st(sc1�� �Էµ� ��)�� backup ����
//		// ��� �迭������ ���� �ڷ� ����
//		ar_st = new String[2];
//		// ���� ar_st�� �ִ� ���� ������ ���� ��� �迭���� ����
//		ar_st[0] = ar_st_backup[0];
//		// �߰� �Է°� ar_st[1] ����
//		sc = new Scanner(System.in);
//		ar_st[1] = sc.nextLine();
//		System.out.println(ar_st[0]);
//		System.out.println(ar_st[1]);
		String[] ar_st = null;
		String[] ar_st_backup = null;
		
		for(int i=1; i <= 15; i++) {
			//15�� ����Ǵ� �ݺ��� ����
			// �Է� ���� �� ���� ar_st �迭 �����(���� 1���� �߰�)
			if(i > 1) { // ���� �迭�� ��(����� �迭 ���� ���� ��)
				ar_st_backup = new String[i];
				for(int x=0;x<ar_st.length;x++) {
					ar_st_backup[x] = ar_st[x];
				}
			}		
			// ���Ӱ� ���ŵ� String �迭 ���� ����
			ar_st = new String[i];
			// ���Ӱ� ���ŵ� String �迭�� backup �� ����
			if(i > 1) { // ���� �迭�� ��(����� �迭 ���� ���� ��)				
				for(int x=0;x<ar_st_backup.length;x++) {
					ar_st[x] = ar_st_backup[x];
				}
			}
			
			sc = new Scanner(System.in);
			ar_st[i-1] = sc.nextLine();
			//���
			System.out.println("���� �Էµ� �迭 ���� ��");
			for(int j=0;j<ar_st.length;j++) {				
				System.out.println((j+1) + "��° �� : " + ar_st[j]);
			}
		}
		
		


		
		

	} // main() close
}
