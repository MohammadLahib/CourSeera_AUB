package classes;
import java.time.LocalTime;
import java.util.List;

public class schedule_res implements Schedule{

    String room;
    LocalTime fromtime;
    LocalTime totime;
    String instructor;
    String course;
    String day;

    public String getRoom(){
        return room;
    };
	public LocalTime getFromTime(){
        return fromtime;
    };
	public LocalTime getToTime(){
        return totime;
    };
	public String getInstructor(){
        return instructor;
    };
	public String getCourse(){
        return course;
    };
    public String getDay(){
        return day;
    };
    public String toString(){
        return  "ROOM: " + room  + "\n From: "  + fromtime + "\n to: "  + totime + "\n Instructor: " + instructor + "\n Course: " + course + "\n Day: " + day + "\n ----- \n";
    }
}

