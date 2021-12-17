package classes;
public class room2 implements Room {

    public String building;
    public String roomnumber;

    public String getBuilding(){
        return building;
    };
	public String getRoomNumber(){
        return  roomnumber;
    }

    public String tostring(){
        return getBuilding() + " " + getRoomNumber();
    }
    
}
