/**
 * The Runner class is responsible for executing the CourseConnect program.
 */
import main.CourseConnect;
public class Runner {
    
    /**
     * The main method is the starting point of the program.
     *
     * @param args an array of command-line arguments for the program.
     */
    public static void main(String[] args) {

        // Create new CourseConnect instance and run program
        CourseConnect cc = new CourseConnect();
        cc.Run();

    }

}