package gui;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class File_manger {
	
	
	
public void save_students(ArrayList<students> s) throws IOException {
	File file = new File("students.txt");
    FileWriter filewriter = new FileWriter(file, false);
    PrintWriter printwriter = new PrintWriter(filewriter);
    String temp;
    int count = s.size();
    for(int i = 0 ; i <count ; i++)
    {
    	temp = new String();
    	students tempstudent = s.get(i);
    	if(tempstudent != null) {
	    	if(tempstudent.has_issued()) {
	    	for(Books b : tempstudent.getIssued()) {
	    		temp = temp + ","+b.getCallno();
	    	}
	    }
			printwriter.println(tempstudent.getId()+","+tempstudent.getName()+","+tempstudent.getPassword()+
					","+tempstudent.getEmail()+","+tempstudent.getAddress()+","+tempstudent.getCity()+","+tempstudent.getContactno()+temp);
    	}   
    }
    
    printwriter.close();
    try {
        filewriter.close();
    } catch (IOException ex) {
   
    }	
}
	public ArrayList<students> read_students(){
    
    File file = new File("students.txt");
    ArrayList<students> students = new ArrayList<students>();
    ArrayList<Books> books = read_books();
    int count=0;

    try {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String tokens[]=line.split(",");
            students.add(count, new students(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]));
            if(tokens.length>6) {
            for(int i = 7;i<tokens.length;i++) {
            	for(Books b : books){
            		if(b.getCallno().equalsIgnoreCase(tokens[i])){
            			students.get(count).issue_book(b);
            		}
            	}
            }
          }
            count++;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return students;
}

	public ArrayList<Books> read_books(){
        
        File file = new File("books.txt");
        ArrayList<Books> books = new ArrayList<Books>();
        int count =0;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String tokens[]=line.split(",");
                int m=parseInt(tokens[0]);
                int y=parseInt(tokens[5]);
                int z=parseInt(tokens[6]);
                books.add(count,new Books(m,tokens[1],tokens[2],tokens[3],tokens[4],y,z,tokens[7]));
                count++;
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
	
	public void save_books(ArrayList<Books> books) throws IOException {
		File file = new File("books.txt");
	    FileWriter filewriter = new FileWriter(file, false);
	    PrintWriter printwriter = new PrintWriter(filewriter);
	    int count = books.size();
	    
	    for(int i = 0 ; i < count ; i++)
        {
            printwriter.println(i+1 + "," +books.get(i).getCallno()+","+books.get(i).getName()+","+
            		books.get(i).getAuthor()+","+books.get(i).getPublisher()+","+books.get(i).getQuantity()+","+books.get(i).getIssued()+","+books.get(i).getDate());
        }
        printwriter.close();
		
	}


}
