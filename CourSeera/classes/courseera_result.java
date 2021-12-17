package classes;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class courseera_result implements CourSeera {


        public static class  Roomcomp implements Comparator<Room>{

            public int compare(Room r1, Room r2) {
                return (r1.getBuilding() + " " + r1.getRoomNumber()).compareTo(r2.getBuilding() + " " + r1.getRoomNumber());
            } 
        }


        public static class  timecomp implements Comparator<Schedule>{

            public int compare(Schedule r1, Schedule r2){
                return (r1.getFromTime().compareTo(r2.getFromTime()));
            }
        }
        
        public TreeMap<Room, List<Schedule>> roomSchedule() {

            Roomcomp comparator = new Roomcomp();
            TreeMap<Room, List<Schedule>> roomschedule = new TreeMap<>(comparator);
            List<Course> allCourses = new LinkedList<>();
            List<Room> rooms = new ArrayList<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                try {
                    CSVDP object = new CSVDP();
                    File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + c + ".csv");
                    String csv = csvFile.getAbsolutePath();
                    object.csvToDb(allCourses, csv);}

                catch (Exception e){}
            }
            for (int i = 0; i < allCourses.size(); i++) {
                room2 room = new room2();
                room.building = allCourses.get(i).getBldg();
                room.roomnumber = allCourses.get(i).getRoom();
                rooms.add(room);
            }
            for(Room room : rooms){
                List<Schedule> list = new LinkedList<>();
                for (int i = 0; i < allCourses.size(); i++) {
                    if (allCourses.get(i).getBldg().equals(room.getBuilding()) && allCourses.get(i).getRoom().equals(room.getRoomNumber())){
                        schedule_res schedule = new schedule_res();
                        schedule.course = allCourses.get(i).getSubject() + " " + allCourses.get(i).getCourse_num();
                        schedule.fromtime = allCourses.get(i).getBegin_time();
                        schedule.totime = allCourses.get(i).getEnd_time();
                        schedule.room = room.getBuilding() + " " + room.getRoomNumber();
                        schedule.instructor = allCourses.get(i).getInstructor_first() + " " + allCourses.get(i).getInstructor_last();
                        String Day = "";
                        if(allCourses.get(i).getMonday() && allCourses.get(i).getWednesday() && allCourses.get(i).getFriday()) {
                        	Day = "MWF";
                        }
                        else if(allCourses.get(i).getTuesday()&&allCourses.get(i).getThursday()) {
                        	Day = "TR";
                        }
                        else if(allCourses.get(i).getMonday()&&allCourses.get(i).getWednesday()) {
                        	Day = "MW";
                        }
                        else if(allCourses.get(i).getMonday()) {
                        	Day = "Monday";
                        }
                        else if(allCourses.get(i).getTuesday()) {
                        	Day = "Tuesday";
                        }
                        else if(allCourses.get(i).getWednesday()) {
                        	Day = "Wednesday";
                        }
                        else if(allCourses.get(i).getThursday()) {
                        	Day = "Thursday";
                        }
                        else if(allCourses.get(i).getFriday()) {
                        	Day = "Friday";
                        }
                        else if(allCourses.get(i).getSaturday()) {
                        	Day = "Saturday";
                        }
                        schedule.day = Day;
                        list.add(schedule);
                    }
                }
                roomschedule.put(room , list);
            }
            return roomschedule;
        }



    public List<Schedule> roomSchedule(Room room){

        List<Course> allCourses = new LinkedList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                CSVDP object = new CSVDP();
                File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + c + ".csv");
                String csv = csvFile.getAbsolutePath();
                object.csvToDb(allCourses, csv);}

            catch (Exception e){}
        }

      
        List<Schedule> lst = new LinkedList<>();

        for (Course course: allCourses){
            if (course.getBldg().equals(room.getBuilding()) && course.getRoom().equals(room.getRoomNumber())){
                schedule_res schedule = new schedule_res();
                schedule.course = course.getSubject() + " " + course.getCourse_num();
                schedule.fromtime = course.getBegin_time();
                schedule.totime = course.getEnd_time();
                schedule.room = room.getBuilding() + " " + room.getRoomNumber();
                schedule.instructor = course.getInstructor_first() + " " + course.getInstructor_last();
                String Day = "";
                if(course.getMonday() && course.getWednesday() && course.getFriday()) {
                	Day = "MWF";
                }
                else if(course.getTuesday()&&course.getThursday()) {
                	Day = "TR";
                }
                else if(course.getMonday()&&course.getWednesday()) {
                	Day = "MW";
                }
                else if(course.getMonday()) {
                	Day = "Monday";
                }
                else if(course.getTuesday()) {
                	Day = "Tuesday";
                }
                else if(course.getWednesday()) {
                	Day = "Wednesday";
                }
                else if(course.getThursday()) {
                	Day = "Thursday";
                }
                else if(course.getFriday()) {
                	Day = "Friday";
                }
                else if(course.getSaturday()) {
                	Day = "Saturday";
                }
                schedule.day = Day;
                lst.add(schedule);
                
            }
        }return lst;
    };

   

    
	public List<Schedule> roomSchedule(Room room, java.time.LocalDate date){

        timecomp comparator2 = new timecomp();


        java.time.DayOfWeek day = date.getDayOfWeek();
       
        List<Course> allCourses = new LinkedList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                CSVDP object = new CSVDP();
                File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + c + ".csv");
                String csv = csvFile.getAbsolutePath();
                object.csvToDb(allCourses, csv);}

            catch (Exception e){}
        }

        
        // course1 c =  new course1();

        List<Schedule> lst = new LinkedList<>();



        for (Course course: allCourses){
            boolean state = switch (day) {
                case MONDAY -> course.getMonday();
                case TUESDAY -> course.getTuesday();
                case WEDNESDAY -> course.getWednesday();
                case THURSDAY -> course.getThursday();
                case FRIDAY -> course.getFriday();
                case SATURDAY -> course.getSaturday();
                default -> false;
            };
            
            if (course.getBldg().equals(room.getBuilding()) && (course.getRoom().equals(room.getRoomNumber())) && state){
                schedule_res schedule = new schedule_res();
                schedule.course = course.getSubject() + " " + course.getCourse_num();
                schedule.fromtime = course.getBegin_time();
                schedule.totime = course.getEnd_time();
                schedule.room = room.getBuilding() + " " + room.getRoomNumber();
                schedule.instructor = course.getInstructor_first() + " " + course.getInstructor_last();
                String Day = "";
                if(course.getMonday() && course.getWednesday() && course.getFriday()) {
                	Day = "MWF";
                }
                else if(course.getTuesday()&&course.getThursday()) {
                	Day = "TR";
                }
                else if(course.getMonday()&&course.getWednesday()) {
                	Day = "MW";
                }
                else if(course.getMonday()) {
                	Day = "Monday";
                }
                else if(course.getTuesday()) {
                	Day = "Tuesday";
                }
                else if(course.getWednesday()) {
                	Day = "Wednesday";
                }
                else if(course.getThursday()) {
                	Day = "Thursday";
                }
                else if(course.getFriday()) {
                	Day = "Friday";
                }
                else if(course.getSaturday()) {
                	Day = "Saturday";
                }
                schedule.day = Day;
                lst.add(schedule); 
            }
        }Collections.sort(lst, comparator2);

        return lst;
    };

    

    public List<Schedule> roomSchedule(Room room, DayOfWeek day){

        timecomp comparator2 = new timecomp();
               
        List<Course> allCourses = new LinkedList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                CSVDP object = new CSVDP();
                File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + c + ".csv");
                String csv = csvFile.getAbsolutePath();
                object.csvToDb(allCourses, csv);}

            catch (Exception e){}
        }

      
        List<Schedule> lst = new LinkedList<>();

        course1 c =  new course1();
        // Calendar cal = Calendar.getInstance();


        for (Course course: allCourses){
            boolean state = switch (day) {
                case Monday -> course.getMonday();
                case Tuesday -> course.getTuesday();
                case Wednesday -> course.getWednesday();
                case Thursday -> course.getThursday();
                case Friday -> course.getFriday();
                case Saturday -> course.getSaturday();
                default -> false;
            };
            
            if (course.getBldg().equals(room.getBuilding()) && course.getRoom().equals(room.getRoomNumber()) && state){
                schedule_res schedule = new schedule_res();
                schedule.course = course.getSubject() + " " + course.getCourse_num();
                schedule.fromtime = course.getBegin_time();
                schedule.totime = course.getEnd_time();
                schedule.room = room.getBuilding() + " " + room.getRoomNumber();
                schedule.instructor = course.getInstructor_first() + " " + course.getInstructor_last();
                String Day = "";
                if(course.getMonday() && course.getWednesday() && course.getFriday()) {
                	Day = "MWF";
                }
                else if(course.getTuesday()&&course.getThursday()) {
                	Day = "TR";
                }
                else if(course.getMonday()&&course.getWednesday()) {
                	Day = "MW";
                }
                else if(course.getMonday()) {
                	Day = "Monday";
                }
                else if(course.getTuesday()) {
                	Day = "Tuesday";
                }
                else if(course.getWednesday()) {
                	Day = "Wednesday";
                }
                else if(course.getThursday()) {
                	Day = "Thursday";
                }
                else if(course.getFriday()) {
                	Day = "Friday";
                }
                else if(course.getSaturday()) {
                	Day = "Saturday";
                }
                schedule.day = Day;
                lst.add(schedule); 
            }
        }Collections.sort(lst, comparator2);
        return lst;
    };

    
	public Schedule whoWasThereLast(Room room){
            LocalDate date = LocalDate.now();
            List<Schedule> list = roomSchedule(room, date);
            
            LocalTime time = LocalTime.now();
            // LocalTime time = LocalTime.parse("10:00");
            LocalTime time2 = LocalTime.parse("08:00");
            Schedule schedulelist = new schedule_res();
            for (Schedule schedule : list){
                if ((schedule.getToTime().isAfter(time2)) && (schedule.getFromTime().isBefore(time))){
                    schedulelist = schedule;
                }
            }        
        return schedulelist;
    };

    
	public Schedule whoIsThereNow(Room room){

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();


        List<Schedule> list = roomSchedule(room, date);
        Schedule schedulelist = new schedule_res();
        for (Schedule schedule : list){
            if ((schedule.getFromTime().isBefore(time)&&(schedule.getToTime().isAfter(time)))){
                schedulelist = schedule;
            }
        }
            return schedulelist;
    }      


	public List<Schedule> profSchedule(Instructor instructor){
        List<Course> allCourses = new LinkedList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                CSVDP object = new CSVDP();
                File csvFile = new File("C:/Users/Abbas Atout/Desktop/ex2/courSeera/csv/file" + c + ".csv");
                String csv = csvFile.getAbsolutePath();
                object.csvToDb(allCourses, csv);}

            catch (Exception e){}
        }
        List<Schedule> lst = new LinkedList<>();

        for (Course course: allCourses){
            if (course.getInstructor_first().equals(instructor.getFirstName()) && course.getInstructor_last().equals(instructor.getLastName())){
                schedule_res schedule = new schedule_res();
                schedule.course = course.getSubject() + " " + course.getCourse_num();
                schedule.fromtime = course.getBegin_time();
                schedule.totime = course.getEnd_time();
                schedule.room = course.getBldg() + " " + course.getRoom();
                schedule.instructor = course.getInstructor_first() + " " + course.getInstructor_last();
                String Day = "";
                if(course.getMonday() && course.getWednesday() && course.getFriday()) {
                	Day = "MWF";
                }
                else if(course.getTuesday()&&course.getThursday()) {
                	Day = "TR";
                }
                else if(course.getMonday()&&course.getWednesday()) {
                	Day = "MW";
                }
                else if(course.getMonday()) {
                	Day = "Monday";
                }
                else if(course.getTuesday()) {
                	Day = "Tuesday";
                }
                else if(course.getWednesday()) {
                	Day = "Wednesday";
                }
                else if(course.getThursday()) {
                	Day = "Thursday";
                }
                else if(course.getFriday()) {
                	Day = "Friday";
                }
                else if(course.getSaturday()) {
                	Day = "Saturday";
                }
                schedule.day = Day;
                lst.add(schedule); 
            }
        }
        return lst;
    }; 



    public Schedule whereIsProf(Instructor instructor){
        Schedule whereIsProf = new schedule_res();
        try{
            //LocalTime time = LocalTime.now();
             LocalTime time = LocalTime.parse("05:55");
            List<Schedule> scheduleList = profSchedule(instructor);
            for (Schedule schedule : scheduleList){
                if ((schedule.getToTime().isAfter(time) || schedule.getToTime().equals(time)) && (schedule.getFromTime().isBefore(time) || schedule.getFromTime().equals(time)) && (schedule.getFromTime() != null && schedule.getToTime() != null)){
                    whereIsProf = schedule;
                }
            }
        }catch (Exception e) {}
            return whereIsProf;
        }


	public List<Schedule> whereWillProfBe(Instructor instructor){
        
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        // LocalDate date = LocalDate.parse("2021-11-26");


        List<Schedule> list = profSchedule(instructor);
        Schedule schedulelist = new schedule_res();
        // LocalTime time = LocalTime.parse("08:00");
        for (Schedule schedule : list){
            if ((schedule.getFromTime().equals(time))){
                schedulelist = schedule;
            }
        }
            return list;
    }
}; 



	