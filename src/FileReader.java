import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class FileReader {
    String _filePath;
    ArrayList<Person> _people;

    public FileReader(String filePath) throws FileNotFoundException {
        _filePath = filePath;
        _people = read();
    }

    private ArrayList<Person> read() throws FileNotFoundException {
        ArrayList<Person> people = new ArrayList<Person>();

        File file = new File(_filePath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            people.add(new Person(data.split(",")));
        }

        myReader.close();
        return people;
    }

    public int getNumberOfCities(){
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < _people.size(); i++) {
            set.add(_people.get(i).get_city());
        }
        return set.size();
    }

    public int getNumberOfNames(){
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < _people.size(); i++) {
            set.add(_people.get(i).get_name());
        }
        return set.size();
    }
}