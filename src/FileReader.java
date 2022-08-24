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
        User[] usersArray = _users.toArray(new User[0]);
        ArrayList<String> distinctNames = new ArrayList<String>();
        for(int i = 0; i < usersArray.length; i++) {
            if (distinctNames.indexOf(usersArray[i].get_city()) == -1) {
                distinctNames.add(usersArray[i].get_city());
            }
        }
        return distinctNames.size();
    }

    public int getNumberOfNames(){
        User[] usersArray = _users.toArray(new User[0]);
        ArrayList<String> distinctNames = new ArrayList<String>();
        for(int i = 0; i < usersArray.length; i++) {
            if (distinctNames.indexOf(usersArray[i].get_name()) == -1) {
                distinctNames.add(usersArray[i].get_name());
            }
        }
        return distinctNames.size();
    }
}