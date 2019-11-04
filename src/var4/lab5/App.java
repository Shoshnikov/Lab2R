package var4.lab5;

import java.util.Scanner;
import var4.lab5.Z1;
import var4.lab5.Z2;
import var4.lab5.Z3;

public class App
{
	public static int correctInput(int input)
	{
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		while(flag == false)
		{	
			try
			{
				input = sc.nextInt();
				flag = true;
			}
			catch(Exception e)
			{
				sc.nextLine();
				System.out.println("�������� ������ ��������� ����");
			}
		}
		return input;
	}

	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int choise = 0;
		boolean flag = false;
		String path;
		String input = "";
		while(choise != 4)
		{

		System.out.println("\n\t������������ ������ �2 \n�������� �������� �� �������������.\n \n1) ������ 1. ������ � ������� String. \n2) ������ 2. ������ � �������� StringBuffer, StringBuilder. \n3) ������ 3. ���������� ���������.\n4) �����");

			choise = correctInput(choise);
			if(choise > 0 && choise < 5)
				switch(choise)
				{
					case 1:
						System.out.println("������� 1.");
						Z1 z = new Z1();
						while(z.getTextCorrect() == false)
						{
							System.out.println("������� ���� � �����");
							path = sc.nextLine();
							z.setFile(path);
						}
						System.out.println(z.getText());
						System.out.println("���������� ������� � �������� ������: " + z.indentationCount());
						z.printConversationsTime();
						System.out.println("\n���������� �����: \n" + z.textTransform());
						break;

					case 2:
						System.out.println("������� 2.");
						Z2 z2 = new Z2();
						while(z2.getTextCorrect() == false)
						{
							System.out.println("������� ���� � �����");
							path = sc.nextLine();
							z2.setFile(path);
						}
						System.out.println(z2.getText());
  						z2.deleteMax();
						System.out.println(z2.getText());
						z2.FixedPtoFloatP();
						System.out.println(z2.getText());
						z2.firstToLast();
						System.out.println(z2.getText());
						break;

					case 3:
						System.out.println("������� 3.");
						Z3 z3 = new Z3();
						while(input.compareTo(":q") != 0)
						{
							System.out.println("������� ������. ��������� ��������� �������� �� ������ ������� IPv4. ��� ������ ������� :q");
							input = sc.nextLine();
							z3.input(input);
							z3.IPV4Check();
						}
						input = "";

						while(z3.getTextCorrect() == false)
						{
							System.out.println("������� ���� � �����");
							path = sc.nextLine();
							z3.setFile(path);
						}
						z3.IPV6Check();
						System.out.println(z3.getText());
						break;
					case 4:
						break;
				}
			else 
				System.out.println("�������� ����� �� 1 �� 4");
		}
	}
}
