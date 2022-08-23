import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileReader {
    String _filePath;
    
    public FileReader(String filePath){
        _filePath = filePath;
    }

    public ArrayList<User> read() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<User>();

        try {
            File myObj = new File(_filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                users.add(new User(data.split(",")));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return users;
    }

    public int getNumberOfCities(ArrayList<User> users){
        int count = 0;
        int maxCount = 0;
        User[] usersArray = users.toArray(new User[0]);
        for(int i = 0; i < usersArray.length; i++){
            for(int j = 0; j < usersArray.length; j++){
                if(usersArray[i].get_city().equals(usersArray[j].get_city())){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;
    }

    public int getNumberOfNames(ArrayList<User> users){
        int count = 0;
        int maxCount = 0;
        User[] usersArray = users.toArray(new User[0]);
        for(int i = 0; i < usersArray.length; i++){
            for(int j = 0; j < usersArray.length; j++){
                if(usersArray[i].get_name().equals(usersArray[j].get_name())){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;
    }
}