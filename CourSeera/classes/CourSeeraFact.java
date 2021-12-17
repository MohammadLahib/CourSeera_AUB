package classes;
import java.util.List;

public class  CourSeeraFact implements CourSeeraFactory {

    public CourSeera createInstance(List<Course> courses) {
        courseera_result courSeera = new courseera_result();
            courSeera.roomSchedule();
            return new courseera_result();
        }
}
