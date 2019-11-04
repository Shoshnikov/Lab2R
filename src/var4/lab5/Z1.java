package var4.lab5;

import java.io.FileReader;
import java.util.Scanner;


public class Z1 
{
	private FileReader fr;
	private String text= "";
	private boolean textCorrect = false;

	public void setFile(String path)
	{
		try
		{
			fr = new FileReader(path);
			System.out.println("Файл успешно прочитан.");
			textCorrect= true;
			int c = 0;
			while((c = fr.read()) != -1)
				text += (char)c;
			text.trim();
		}
		catch(Exception e)
		{
			System.out.println("Путь к файлу неверен. Повторите ввод.");
		}
	}
	
	public int indentationCount()
	{
		int count = 0;
		for(int i = 0; i < text.length(); i++)
			if(text.charAt(i)== '\n')
				++count;
		return count;
	}
	
	private double[] getConversationsTime()
	{
		
		int count = indentationCount();
		double[] conversationsTime = new double[count];
		int indentationNumber = 0;
		boolean number = false;
		String numberStr = "";
		for(int i = 0; i < count; i++)
			conversationsTime[i] = 0;
		for(int i = 0; i < text.length();i++)
		{
			if(text.charAt(i) == '\n')
				++indentationNumber;

			if((int)text.charAt(i) != 32 && (int)text.charAt(i) >= 48 && (int)text.charAt(i) <= 57 || (int)text.charAt(i) == 46 && number == true)
			{
				number = true;
				numberStr += text.charAt(i);

			}

			if((int)text.charAt(i) == 32 && number == true)
			{
				conversationsTime[indentationNumber] += Double.parseDouble(numberStr);
				number = false;
				numberStr = "";
			}
				
		}
		return conversationsTime;
	}

	public boolean getTextCorrect()
	{
		return textCorrect;
	}

	public String getText()
	{
		return text;
	}

	public void printConversationsTime()
	{
		System.out.println();
		double[] arr = getConversationsTime();
		for(int i = 0; i < arr.length; i++)
			System.out.println("Суммарное время разговора за день: " + arr[i]);
	}

	public String textTransform()
	{
		boolean firstIndentation = true;
		String newText = "";
		for(int i = 0; i < text.length(); i++)
		{
			if(text.charAt(i) == '\n')
				firstIndentation = false;

			if(i > 1)
				if(text.charAt(i-1) == 32 && text.charAt(i - 2) == 46 && firstIndentation == true)
				{
					newText += '\n';
				}
			newText += text.charAt(i);
		}
		return newText;		
	}

}
