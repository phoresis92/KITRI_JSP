import java.util.Scanner;

public class MainProgram_180615 {
	public static void main(String[] args) {
		// ���۴ܰ� ���� ����ϱ�.
		// Java���� Console(DOS) ��½�ų �� �ֵ���
		// �������ִ� �޼ҵ�
		System.out.println("Start Program. ���α׷� ����!");
		boolean mCode = true; // ���θ޴� flag ��(���α׷� ���� ��Ű�� ���� ����)
		// �޴� ����ϱ�.
		// 1. �л�����
		// 2. �������
		while (mCode) { // ���θ޴� ���� �ݺ� ����
			System.out.println("1. �л�����");
			System.out.println("2. �������");
			System.out.println("4. ���α׷�����");
			// �Է��� �� �ֵ��� �����ϱ�.
			// �Է¹����� ����� Scanner ����
			// where empno = 1;
			Scanner sc = null;
			sc = new Scanner(System.in);
			System.out.print("[�ش� ��ȣ�� ��������.] ====>");
			// 1���� ������ ���� , sc.nextInt() = 1
			// 2���� ������ ���� , sc.nextInt() = 2
			int i_mMenu = sc.nextInt(); // sc(����� �Է°�)�� ������ �ʿ� ����.
			// i_mMenu = 1;
			// �޸𸮿��� ����ڰ� �Է��� ��(�޴� ���ð�)�� ������ �� �ִ� ����
			// �޴� ������ ���� �� ������� ����(���� ����)
			System.out.println("������ ��ȣ�� : " + i_mMenu);
			// 1�� ���̽� ���� (�л�����)
			if (i_mMenu == 1) {
				// �л����� �޴� ����ϱ�
				boolean b_stCode = true;

				while (b_stCode) {
					System.out.println("�л����� �޴��� �����ϼ̽��ϴ�. �ش� �޴��� �����ϼ���.");
					System.out.println("1. �л��߰�");
					System.out.println("2. �л���ȸ");
					System.out.println("3. ��������");
					System.out.println("4. �����޴�");
					System.out.print("[�ش� ��ȣ�� ��������.] ====>");

					sc = new Scanner(System.in);
					// �л����� ������ �޴� ���� �� ����
					int i_stMenu = sc.nextInt();
					// i_stMenu = new Scanner(System.in).nextInt();
					// i_stMenu ���� ���� ����.
					// �� ��ȣ�� ���� ������ ���μ��� ����
					// ���ǹ��� ���� ���α׷� ����
					// i_stMenu 1,2,3,4 ����Ǵ� ������ �ٲ�� ��.
					// i_stMenu 1�� ���
					// ���� stMenu == 1, mMenu == 1
					String s_stName; // �߰��� �л� �̸� ���� ����
					int i_stNum; // �߰��� �л� ��ȣ ���� ����
					int i_stNumShow; // �˻��� �л� ��ȣ ���� ����
					String s_stNameShow; // �˻��� �л� �̸� ���� ����
					if (i_stMenu == 1) {
						// �л��߰�
						System.out.println("�л��߰� �׸��Դϴ�.");
						System.out.println("�߰��ϰ��� �ϴ� �л� �̸��� �Է��ϼ���.");
						// �Է��� �� �ֵ��� ����
						sc = new Scanner(System.in);
						s_stName = sc.nextLine();
						System.out.println("�߰��ϰ��� �ϴ� �л� ��ȣ�� �Է��ϼ���.");
						sc = new Scanner(System.in);
						// �л���ȣ �Է��� �� �ֵ��� ����
						i_stNum = sc.nextInt();
						System.out.println("�Է��� �Ϸ� �Ǿ����ϴ�.");
						System.out.println("�Էµ� �л���ȣ : " + i_stNum);
						System.out.println("�Էµ� �л��̸� : " + s_stName);
					} else if (i_stMenu == 2) {
						// �л���ȸ
						System.out.println("�л���ȸ �޴��Դϴ�. ��ȸ�ϰ� ���� �л��� ��ȣ�� �Է��ϼ���.");
						sc = new Scanner(System.in);
						// int i_stNum = sc.nextInt();
						// System.out.println("�Է��� ��ȣ : " + i_stNum);
						// System.out.println("�л��̸� : " + s_stName);
					} else if (i_stMenu == 3) {
						// ��������
					} else if (i_stMenu == 4) {						
						// ����
						b_stCode = false;
					} else {
						// �߸��� ���� �Է��Ͽ����ϴ�.
						// �޴�Ȯ�� �� �ϰ� ��������. ������ ����!
					} // ���� �л��޴� if�� ����
				} // ���� �л��޴� while�� ����
			} // 1. �л��޴� if�� ����
			else if (i_mMenu == 4) {
				// while�� ����
				mCode = false;
			}

		} // while() ���� ����

	} // main() ���� ����

} // MainProgram Class ���� ���� END...
