package var4.lab5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileReader;

public class Z3
{
	private String input;
	private FileReader fr;
	private String text;
	private boolean textCorrect = false;	
	private Matcher mat;
	private Pattern pat;

	public void input(String input)
	{
		this.input = input;
	}

	public void IPV4Check()
	{
		if(Pattern.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}",input) == true)
			System.out.println("Correct");
		else if(input.compareTo(":q") > 0) 
			System.out.println("Not correct");
	}

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
			pat = Pattern.compile("\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}:\\w{1,4}");
			mat = pat.matcher(text);
		}
		catch(Exception e)
		{
			System.out.println("Путь к файлу неверен. Повторите ввод.");
		}
	}

	public boolean getTextCorrect()
	{
		return textCorrect;
	}

	public String getText()
	{
		return text;
	}

	public void IPV6Check()
	{
		String str;
		String newStr = "";
		while(mat.find())
		{
			str = mat.group();
			for(int i = 0; i < str.length(); i++)
			{
				switch(str.charAt(i))
				{
				case '0':
					newStr += "0000";
					break;
				case '1':
					newStr += "0001";
					break;
				case '2':
					newStr += "0010";
					break;
				case '3':
					newStr += "0011";
					break;
				case '4':
					newStr += "0100";
					break;
				case '5':
					newStr += "0101";
					break;
				case '6':
					newStr += "0110";
					break;
				case '7':
					newStr += "0111";
					break;
				case '8':
					newStr += "1000";
					break;
				case '9':
					newStr += "1001";
					break;
				case 'a':
					newStr += "1010";
					break;
				case 'b':
					newStr += "1011";
					break;
				case 'c':
					newStr += "1100";
					break;
				case 'd':
					newStr += "1101";
					break;
				case 'e':
					newStr += "1110";
					break;
				case 'f':
					newStr += "1111";
					break;
				default:
					newStr += str.charAt(i);
					break;
				}
			}
			System.out.println(str);
			System.out.println(newStr);
			text = mat.replaceAll(newStr);
		}

	}


}
