package helpers;

import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class StringProcessor {

	private static final char[] specialChars={' ','’','\'',',','.','~','!','@','#','$','%','^','&','*','(',')','_','-','=','+',';',':','"','/','\\','|','{','}','[',']','?','`','<','>'};
	private static final String[] SectionNameVars={"other","others"};
	
	
	
//removes special characters(including spaces)
	/*Returns a valid string
	 * A valid string should not have any special characters(including spaces)
	 * 
	 */
	public static  String stringValidator(String temp)
	{
		StringBuffer trimmedString=new StringBuffer();
		String trimmedText=temp.trim();
		
		//checking each char for special character
		for(int i=0;i<trimmedText.length();i++)
		{
		
				if(! isSpecialChar(trimmedText.charAt(i))   ) //if a non-special char is found,add to buffer :else Discard it
				{
					if(i==0)//for 1st char
					{
						//makes the first char Uppercase
						trimmedString.append(new String(""+trimmedText.charAt(i)).toUpperCase());
					}
					else//for all other remaining chars
					{
						trimmedString.append(new String(""+trimmedText.charAt(i)).toLowerCase());
					}
				}
		}
	//	System.out.println("Trimmed string:"+trimmedString.toString());
		return trimmedString.toString();
		
	}//stringTrimmer
	
	private static String[] batchStringValidator(String[] labels)
	{		
		String[] newArrays = new String[labels.length];

		for(int i=0;i<labels.length;i++)
		{
			newArrays[i]=StringProcessor.stringValidator(labels[i]);
		}

		return newArrays;
	}
	
	private static String stringTruncator(String label,int maxlength)
	{
		if(label.length()>maxlength)
			return label.substring(0,maxlength);
		return label;
	}
	
	
	//truncates all the string in this array to n chars
	private static String[] stringArrayTruncator(String[] labels,int maxlength)
	{
		String[] newArray=new String[labels.length];

		for(int i=0;i<labels.length;i++)
		{
			//check whether the name>maxlength..
			if( labels[i].length()>maxlength)
			{
				newArray[i]=labels[i].substring(0, maxlength);//first maxlength chars only!
			}
			else//if name is within 15char length,assign without any truncation
			{
				newArray[i]=labels[i];
			}
			
		}//for
		return newArray;
	}//getTrunca...
	
	

	private static boolean isSpecialChar(char temp)
	{
		for(int charCount=0;charCount<specialChars.length;charCount++)
		{
			if(temp==specialChars[charCount])//if a special char is found,return TRUE
				return true;
		}
		return false; //reached only when no special char is found
	}
	
	//returns the JTextarea as String[] with each index is a line
	public static String[] getTextAreaLines(JTextArea textarea)
	{
		final int LINE_COUNT=textarea.getLineCount();
		final String TEXT_CONTENT=textarea.getText();
		
		System.out.println("TextProcessor:Retrieving each lines from the given JTextArea...");
		System.out.println("TextProcessor:No.of lines in JTextArea:"+LINE_COUNT);
		
		try
		{
			String[] lines=new String[LINE_COUNT];
			
			for(int line=0;line<LINE_COUNT;line++)
			{
				//get each line
				lines[line]=TEXT_CONTENT.substring(textarea.getLineStartOffset(line), textarea.getLineEndOffset(line));
			}
			System.out.println("TextProcessor:Populated String[] size:"+lines.length);
			return lines;
		}
		catch(Exception e){
			System.out.println("TextProcessor:Invalid Location in JTextArea(Labels)!!!"+e);
			return null;
        }
	}//getLines
	
	//input:String with CSV .
	//output:String[].
	public static String[] getCSVasStringArray(String labelLine)
	{
		StringTokenizer st=new StringTokenizer(labelLine,",");
		int tokenCount=st.countTokens();
			if(tokenCount==0)
			{
				System.out.println("TextProcessor:No Token found!.Sending empty String[]");
				return new String[]{""};
			}
			
			String[] labelArray=new String[tokenCount];
			
			System.out.println("TextProcessor:Tokens found:"+tokenCount);
			
			int i=0;
			while(st.hasMoreTokens())
			{
				labelArray[i]=st.nextToken();
				i++;
			}//while
		
		return labelArray;
	}
	
	public static String getStringArrayasCSV(String[] Labelarray)
	{
		StringBuffer Buffer=new StringBuffer();
		
		for(int i=0;i<Labelarray.length;i++)
		{
			Buffer.append(Labelarray[i]);
			
			//if this is not the last label,append ","
			if((i+1)!=Labelarray.length)
				Buffer.append(",");
		}//for
		
		return Buffer.toString();
	}
}
