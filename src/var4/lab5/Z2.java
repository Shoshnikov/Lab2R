package var4.lab5;

import java.util.Scanner;
import java.io.FileReader;

class Z2 
{
	private FileReader fr;
	private StringBuffer text = new StringBuffer();
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
				text.append((char)c);

		fr.close();
		}
		catch(Exception e)
		{
			System.out.println("Путь к файлу неверен. Повторите ввод.");
		}
	}
	
	public void deleteMax()
	{
		int maxStart = 0, maxEnd = 0, count = 0, max = 0, start = 0;
		for(int i = 0; i < text.length();i++)
		{
			if(text.charAt(i) == '\n' && count > max)
			{
				maxEnd = i;
				maxStart = start;
				start = i + 1;
				max = count;
				count = 0;
			}

			if(text.charAt(i) == '\n' && count <= max)
			{
				count = 0;
				start  = i + 1;
			}	
			count++;
		}
		text.delete(maxStart,maxEnd);
		
	}

	public void FixedPtoFloatP()
	{
		int numberStart = 0;
		int numberEnd = 0;
		double number = 0;
		boolean point = false;
		int numberBeforePoint = 0;
		String numberStr = "";

		for(int i = 0; i < text.length(); i++)
		{
			if((int)text.charAt(i) >= 48 && (int)text.charAt(i) <= 57 && (int)text.charAt(i - 1) == 32 && i > 1)
				numberStart = i;
			if((int)text.charAt(i) >= 48 && (int)text.charAt(i) <= 57 && (int)text.charAt(i + 1) == 32 && i < text.length() - 1)
				numberEnd = i;

			if(numberEnd > numberStart)
			{
				for(int j = numberStart; j <= numberEnd; j++)
				{
					if((int)text.charAt(j) == 46)
					{
						point = true;
						break;
					}
					numberBeforePoint++;
				}
				if(point = true)
				{
					number = Double.parseDouble(text.substring(numberStart,numberEnd + 1)) / Math.pow(10,numberBeforePoint);
					point = false;
					numberStr = number + "*10^" + numberBeforePoint;
					text.replace(numberStart,numberEnd + 1,numberStr);
					i += 4 + numberStr.length() + Integer.toString(numberBeforePoint).length();
					numberBeforePoint = 0;
					numberEnd = -1;
					numberStart = -1;
				}
			}

		}

	}
	
	public void firstToLast()
	{
		int firstIndentationCount = 0;
		for(int i = 0; i < text.length(); i++)
		{
			if(text.charAt(i) == '\n')
			{
				firstIndentationCount = i;
				break;
			}
		}
		text.append(text.substring(0,firstIndentationCount));
		text.delete(0,firstIndentationCount);

	}


	public StringBuffer getText()
	{
		return text;
	}
	
	public boolean getTextCorrect()
	{
		return textCorrect;
	}
	
}
