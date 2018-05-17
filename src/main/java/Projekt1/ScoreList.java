package projekt1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class ScoreList {
	
	Hashtable<String, Integer> players;
	
	ScoreList() throws ClassNotFoundException, IOException{
		  players = new Hashtable<String, Integer>();
		  this.read();
	}
	
	public void add(String nickname) throws IOException {
		Integer i = players.get(nickname);
		 if (i == null) 
			 players.put(nickname, 1);
		 else
			 players.put(nickname, (i+1));		 
		 this.save();
		
	}
	
	public int print(String nickname) {
		
		Integer n = players.get(nickname);
		   if (n != null) {
		     System.out.println("\nWygrane gracza " + nickname + " = " + n);
		     return n;
		   }
		 return 0;		
	}
	
	public void printAll() {
		
		System.out.println("\n" + players);	
	}
	
	public void save() throws IOException {
		
		FileOutputStream file = new FileOutputStream("src/main/java/Projekt1/score/score.list");
		ObjectOutputStream object = new ObjectOutputStream(file);

		object.writeObject(players);
		object.close();
		file.close();
	}
	
	public void read() throws IOException, ClassNotFoundException {		
			
		try {
			
			FileInputStream file = new FileInputStream("src/main/java/Projekt1/score/score.list");
			ObjectInputStream object = new ObjectInputStream(file);
			players = (Hashtable<String, Integer>) object.readObject();
			object.close();
			file.close();	
			
		} catch (IOException e) {			
			this.save();
		}				
		
	}
		
}