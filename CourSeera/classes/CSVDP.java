package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CSVDP implements CsvToDb{


	public void csvToDb(List<Course> courses, String csvFile) throws FileNotFoundException{

        Scanner n = new Scanner(new File(csvFile));

        // int count =  0;

        while (n.hasNextLine()){
                String line = n.nextLine();
                String[] str = line.split(",");
            // System.out.println(Arrays.toString(str));
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm", Locale.ENGLISH);
                course1 console = new course1();
                console.Crn =  str[0];
                console.Subject = str[1];
                console.CourseNumber = str[2];
                console.Section = str[3];
                console.Title = str[4];
                try {
                console.CreditsHours = Float.parseFloat(str[5]);
                }catch (Exception e){}
                console.College = str[6];
                try{
                console.ActualEnrollement = Integer.parseInt(str[7]);
                console.SeatsAvailable = Integer.parseInt(str[8]);
                } catch (Exception e){}
                try{
                console.beginTime = LocalTime.parse(str[9], formatter);
                console.endTime   = LocalTime.parse(str[10], formatter);
                }catch (Exception e){}

                console.Building = str[11];
                try {
                    console.Room = str[12];
                } catch (Exception e) {}
                console.Monday = (str[13].equals("true")?true:false);
                console.Tuesday = (str[14].equals("true")?true:false);
                console.Wednesday = (str[15].equals("true")?true:false);
                console.Thursday = (str[16].equals("true")?true:false);
                console.Friday = (str[17].equals("true")?true:false);
                console.Saturday = (str[18].equals("true")?true:false);
                console.InstructorFirstName = str[31];
                console.InstructorLastName = str[32];
                courses.add(console);  
        }
    }
}
