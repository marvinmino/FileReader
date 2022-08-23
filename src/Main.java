import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        FileReader reader = new FileReader("C:\\Users\\marvi\\IdeaProjects\\FileReader\\src\\file.txt");
        try{
            ArrayList<User> users = reader.read();
            System.out.println("The number of distinct cities is: " + reader.getNumberOfCities(users));
            System.out.println("The number of distinct names is: " + reader.getNumberOfNames(users));
        } catch (Exception e){
            e.printStackTrace();
            System.out.printf("There was an error with reading the file");
        }
    }
}
