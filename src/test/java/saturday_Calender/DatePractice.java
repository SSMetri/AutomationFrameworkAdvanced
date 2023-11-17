package saturday_Calender;

import java.util.Date;

public class DatePractice 
{
	public static void main(String[] args) {
		
		Date d=new Date();
		String dateNow=d.toString();
		System.out.println(dateNow);
		String [] array=dateNow.split(" ");
		String datef=array[0]+" "+array[1]+" "+array[2]+" "+array[5];
		System.out.println(datef);
	}

}
