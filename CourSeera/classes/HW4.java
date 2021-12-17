package classes;
// import java.io.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
// import java.time.LocalDate;
// import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW4 {

	public static int count() throws FileNotFoundException {
	
		int num = 0;
		
		
			for (char c = 'A'; c<='Z'; ++c){
				if(c=='J' || c=='K' || c=='Q' || c=='V' || c=='W' || c=='X' || c=='Y' || c=='Z'){
					continue;
				}
				else{
				Scanner scanner = new Scanner(new File("C:/Users/Abbas Atout/Desktop/ex2/csv/file" + c + ".csv")); 
				while (scanner.hasNextLine()){
					num++;
					scanner.nextLine();
				}	
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		//Downloader + HTML to CSV
			
		// course1 console = new course1();
		System.out.println("Loading Files...");
		Htmltofile dw = new Htmltofile();

		toCSV n = new toCSV();

		List<Course> courses = new ArrayList<>();
		
		for(char i = 'A'; i<'Z';++i){
	
			if(i=='J' || i=='K' || i=='Q' || i=='V' || i=='W' || i=='X' || i=='Y' || i=='Z'){
				System.out.println("Letter " + i + " has no HTML table");
				continue;
			}
			else{
				
				String file = "C:/Users/Abbas Atout/Desktop/ex2/courSeera/html/file" + i + ".htm";
				dw.downloadHtmlToFile("https://www-banner.aub.edu.lb/catalog/schd_"+i+".htm", file);
				n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/courSeera/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + i + ".csv");
				System.out.println("Done letter "+i+"!");
				CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + i + ".csv");
			}
		}
		courseera_result c = new courseera_result();
		room2 room = new room2();
		room.building= "NICELY";
		room.roomnumber = "212";
		room2 room2 =  new room2();
		room2.building = "NICELY";
		room2.roomnumber = "214";
		instructor2 instructor = new instructor2();
		instructor.firstName = "Mahmoud";
		instructor.lastName = "Bdeir";



		System.out.println(c.roomSchedule(room));

		System.out.println(c.whoWasThereLast(room));
		System.out.println(c.whereIsProf(instructor));
		System.out.println(c.profSchedule(instructor));
		System.out.println(c.roomSchedule(room2, LocalDate.of(2021, 11, 29)));
		System.out.println(c.roomSchedule(room2, DayOfWeek.Tuesday));
		System.out.println(c.whoIsThereNow(room2));
		System.out.println(c.whereWillProfBe(instructor));

		System.out.println();


		System.out.println("\n");
		System.out.println("Finished!");
		
	}
}