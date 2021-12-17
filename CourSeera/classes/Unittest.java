package classes;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.TreeUI;
import org.junit.Test;


public class Unittest {

    courseera_result  c = new courseera_result();

        
        @Test 
    void downloader() throws FileNotFoundException {

        	downloader();

	        List<Course> allCourses = new LinkedList<>();
	        int count = 0;
	        for (char c = 'A'; c <= 'Z'; c++) {

            count += 1;
            CSVDP object = new CSVDP();
            File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/csv/file" + c + ".csv");
            String csv = csvFile.getAbsolutePath();
            object.csvToDb(allCourses, csv);

            }
            assertEquals(count, 28);
        }

        void test2() {
            int count =0;
            for(char i = 'A'; i<'Z';++i){
            	Htmltofile dw = new Htmltofile();
	            String file = "C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm";
	            dw.downloadHtmlToFile("https://www-banner.aub.edu.lb/catalog/schd_"+i+".htm", file);
	            count+=1;
                    
            }
            assertEquals(count, 27);
        }

        void test3() throws FileNotFoundException{

            int count = 0;

            for(char i = 'A'; i<'Z';++i){
            	List<Course> courses = new ArrayList<>();
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;

            }
            assertEquals(count, 27);
        }


        @Test
        void test4() throws IOException{

            int count = 0;

            for(char i = 'A'; i<'Z';++i){
            	toCSV n = new toCSV();
                n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count += 1;
            }assertEquals(count, 26);

        }

        @Test
        void test5() throws IOException{  
            int count = 0;

            for(char i = 'A'; i<'Z';++i){
            	toCSV n = new toCSV();
                n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count += 1;
            }assertEquals(count, 20);

        }

        @Test
        void test6() throws IOException{
            int count = 0;

            for(char i = 'A'; i<'Z';++i){
            	toCSV n = new toCSV();
                n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count += 1;
            }assertEquals(count, 15);

        }
        @Test
        void test7() throws IOException{

            int count = 0;
            for(char i = 'A'; i<'Z';++i){
            	toCSV n = new toCSV();
                n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count += 1;
            }assertEquals(count, 0);

            
        }
        @Test
        void test8() throws IOException{

            int count = 0;

            for(char i = 'A'; i<'Z';++i){
            	toCSV n = new toCSV();
                n.htmlToCsv("C:/Users/Abbas Atout/Desktop/ex2/html/file" + i + ".htm", "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count += 1;
            }assertEquals(count, -1);

        }
        @Test
        void test9() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;

            }
            assertEquals(count, 20);
            
        }
        @Test
        void test10() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();

            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 16);
        }

        void test11() throws FileNotFoundException{
            List<Course> courses = new ArrayList<>();
            int count = 0;
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 9);
        }

        @Test
        void test12() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 30);
        }
        @Test
        void test13() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 23);
        }
        @Test
        void test14() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 10);
        }
        @Test
        void test15() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 0);
        }
        @Test
        void test16() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, -1);
        }

        @Test
        void test17() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 16);
        }
        @Test
        void test18() throws FileNotFoundException{
            int count = 0;
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z';++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, -4);
        }
        @Test
        void test19() throws FileNotFoundException{
            int count = 0;		
            List<Course> courses = new ArrayList<>();
            for(char i = 'A'; i<'Z'; ++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 16);
        }
        @Test
        void test20() throws FileNotFoundException{
            List<Course> courses = new ArrayList<>();
            int count = 0;
            for(char i = 'A'; i<'Z'; ++i){
                CSVDP csvdp = new CSVDP();
				csvdp.csvToDb(courses, "C:/Users/Abbas Atout/Desktop/ex2/csv/file" + i + ".csv");
                count+=1;
            }
            assertEquals(count, 6);
        }



        void test26(){ 
        	Schedule schedule_res = new schedule_res();
            room2 room = new room2();
            room.building= "NICELY";
            room.roomnumber = "212";
            c.roomSchedule(room);
            assertEquals(c.roomSchedule(room), schedule_res);

        }

        @Test
        void test27(){ 
        	Schedule schedule_res = new schedule_res();
            instructor2 instructor = new instructor2();
            instructor.firstName = "Mahmoud";
            instructor.lastName = "Bdeir";
            assertEquals(c.profSchedule(instructor), schedule_res);
        }
        @Test
        void test28(){ 
            instructor2 instructor = new instructor2();
            instructor.firstName = "Mahmoud";
            instructor.lastName = "Bdeir";
            assertEquals(c.whereIsProf(instructor), "Bliss 205"); 
        }
        @Test
        void test29(){ 
            instructor2 instructor = new instructor2();
            instructor.firstName = "Erick";
            instructor.lastName = "Daminne";
            assertEquals(c.whereIsProf(instructor), null); 
        }

        @Test
        void test30(){ 
            instructor2 instructor = new instructor2();
            instructor.firstName = "Mahmoud";
            instructor.lastName = "Bdeir";
            assertEquals(c.whereWillProfBe(instructor), "Nicely 416"); 
        }

        @Test
        void test31(){
            room2 room2 =  new room2();
            room2.building = "Bliss";
            room2.roomnumber = "205";
            assertEquals(c.whoIsThereNow(room2), "Mahmoud Bdeir");
        }

        void test32(){
            room2 room2 =  new room2();
            room2.building = "Bliss";
            room2.roomnumber = "203";
            assertEquals(c.whoIsThereNow(room2), "Nabil Nassif");
        }

}
            
        