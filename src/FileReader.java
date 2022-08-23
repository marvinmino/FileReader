import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class FileReader {
    String _filePath;
    ArrayList<User> _users;

    public FileReader(String filePath) throws FileNotFoundException {
        _filePath = filePath;
        _users = read();
    }

    public ArrayList<User> read() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<User>();

        File file = new File(_filePath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            users.add(new User(data.split(",")));
        }

        myReader.close();
        return users;
    }

    public int getNumberOfCities(){
        int count = 0;
        int maxCount = 0;
        User[] usersArray = _users.toArray(new User[0]);
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

    public int getNumberOfNames(){
        int count = 0;
        int maxCount = 0;
        User[] usersArray = _users.toArray(new User[0]);
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