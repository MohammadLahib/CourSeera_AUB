package classes;

// import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
// import java.io.File;

public class toCSV implements HtmlToCsv {
    
    public void htmlToCsv(String htmlFile, String csvFile) throws IOException{

        String html = Files.readString(Path.of(htmlFile));

        String fall = html.substring(html.indexOf("Fall 2021-2022(202210)"));
        fall = fall.substring(0, fall.indexOf("</TABLE")).trim();
        String[] rows = fall.split("</TR>");
        FileWriter writer = new FileWriter(csvFile);
        for (String row : rows){
            String[] tds = row.split("</TD>"); 
            if (tds[0].replace("<TD>","") .trim().equals("Spring 2021-2022(202220)")){
                break;
            }
            String crn = tds[1].replace("<TD>", "").trim();
            String subject = tds[2].replace("<TD>", "").trim();
            String course_num = tds[3].replace("<TD>", "").trim();
            String section = tds[4].replace("<TD>","").trim();
            String Title =  tds[5].replace("<TD>", "").trim().replace(",", " ");
            String Credithrs =  tds[6].replace("<TD>", "").trim();
            String College = tds[8].replace("<TD>", "").trim();
            String ActualEnrollement = tds[9].replace("<TD>", "").trim();
            String SeatsAvailable = tds[10].replace("<TD>", "").trim();
            String Begin_time = tds[11].replace("<TD>", "").trim();
            String End_time = tds[12].replace("<TD>", "").trim();
            String bldg = tds[13].replace("<TD>", "").trim();
            String Room = tds[14].replace("<TD>", "").trim();
            String Monday = (tds[15].replace("<TD>", "").trim().equals("M")?"true":"false");
            String Tuesday = (tds[16].replace("<TD>", "").trim().equals("T")?"true":"false");
            String Wednesday = (tds[17].replace("<TD>", "").trim().equals("W")?"true":"false");
            String Thursday = (tds[18].replace("<TD>", "").trim().equals("R")?"true":"false");
            String Friday = (tds[19].replace("<TD>", "").trim().equals("F")?"true":"false");
            String Saturday = (tds[20].replace("<TD>", "").trim().equals("S")?"true":"false");
            String Sunday = tds[21].replace("<TD>", "").trim();
            String Begin_time2 = tds[22].replace("<TD>", "").trim();
            String End_time2 = tds[23].replace("<TD>", "").trim();
            String bldg2 = tds[24].replace("<TD>", "").trim();
            String Room2 = tds[25].replace("<TD>", "").trim();
            String Monday2 = tds[26].replace("<TD>", "").trim();
            String Tuesday2 = tds[27].replace("<TD>", "").trim();
            String Wednesday2 = tds[28].replace("<TD>", "").trim();
            String Thursday2 = tds[29].replace("<TD>", "").trim();
            String Friday2 = tds[30].replace("<TD>", "").trim();
            String Saturday2 = tds[31].replace("<TD>", "").trim();
            String Sunday2 = tds[32].replace("<TD>", "").trim();
            String Instructor_first = tds[33].replace("<TD>", "").trim();
            String Instructor_last = tds[34].replace("<TD>", "").trim();
            // String LinkedCrn = tds[35].replace("<TD>", "").trim();
            // String Instructional_Method = tds[36].replace("<TD>", "").trim();
            
            
            String line = (crn + "," + subject + "," + course_num + ","+ section + ","  + Title + "," + 
            Credithrs +"," + College  +","+ ActualEnrollement +","+  SeatsAvailable + "," + Begin_time +"," + 
            End_time+ "," + bldg + "," + Room + ","+ Monday+"," + Tuesday +"," + Wednesday +"," + Thursday + "," + 
            Friday + "," + Saturday + "," + Sunday + "," +    Begin_time2 +"," +  End_time2+ "," + bldg2 + "," + Room2 + ","+ Monday2+"," + Tuesday2 +"," + Wednesday2 +"," + Thursday2 + "," + 
            Friday2 + "," + Saturday2 + "," + Sunday2 + "," + Instructor_first + "," + Instructor_last + "\n");
            
            writer.append(line); 
        }
        writer.close();;

    }
}