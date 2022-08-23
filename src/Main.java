import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){
        try{
            FileReader reader = new FileReader("C:\\Users\\marvi\\IdeaProjects\\FileReader\\src\\file.txt");
            System.out.println("The number of distinct cities is: " + reader.getNumberOfCities());
            System.out.println("The number of distinct names is: " + reader.getNumberOfNames());
        } catch (FileNotFoundException e){
            System.out.printf("File not found");
        } catch (Exception e){
            System.out.printf("There was an error with reading the file");
        }
    }
}
