//Main method, starts program

import java.util.*;

import java.util.HashMap;
import java.util.ArrayList;

public class App {
    public static void main(String [] args) {
        
        Homer theRealHomer = new Homer(38);
        Homer fakeHomerClone = new Homer(38); 

        theRealHomer.sayMMMBeer(); 
        fakeHomerClone.isYellow();

        Marge margeOne = new Marge(50);

        margeOne.isYellow(); 
        margeOne.sayMMM();

        //Create an array

     	ArrayList<SimpsonsCharacter> characters = new ArrayList<SimpsonsCharacter>(); 
     	characters.add(theRealHomer); 
     	characters.add(fakeHomerClone); 
     	characters.add(margeOne); 

        System.out.println("The Simpson family is" + characters.size() + "members"); 

     	//Hash Map

     	HashMap<String, Integer> characterMap = new HashMap<String, Integer>();

     	for (SimpsonsCharacter character : characters) {
        	System.out.println(character);

        	characterMap.put("", character.age); //TODO add name 
        }
    }
}

//Superclass

class SimpsonsCharacter {
	
	public SimpsonsCharacter() {

	}

	public void isYellow() {
		System.out.println("This character is indeed yellow");
	}
}

//Subclasses

class Homer extends SimpsonsCharacter {

	int age; 
	Marge wife; 

	ArrayList<SimpsonsCharacter> familyMembers; 

	public Homer(int homerAge) {
		age = homerAge;
	}

	public int getAge() {
		return age;
	}

	public void sayMMMBeer() {
		System.out.println("Mmmm beer"); 
	}
	
}

class Marge extends SimpsonsCharacter {

	int hairHeight; 
	Homer husband; 

	ArrayList<SimpsonsCharacter> familyMembers; 

	public Marge(int margeHairHeight) {
		hairHeight = margeHairHeight; 
	}

	public int getHairheight() {
		return hairHeight; 
	}

	public void sayMMM() {
		System.out.println("Funny Marge Noise"); 
	}
}

class Bart extends SimpsonsCharacter {
	
	
}

class Lisa extends SimpsonsCharacter {

	
}

class Maggie extends SimpsonsCharacter {
	
	
}

//TODO implement parking lot system design in Java

class ParkingLot {

	int zipCode; 

}

class ParkingSpot {

	int spotNumber; 

	public placeVehicle(Vehicle vehicle) {

	}
}

class Vehicle {

	String spotNumber; 
	String lisencePlate; 
	String color; 

	public Vehicle(String lisencePlate, String color) {
		this.lisencePlate = lisencePlate; 
		this.color = color; 
	}

}

//Make sure retrieving vehicle is as easy as putting it in/ i.e. different buckets(organized) with hashtables for O(1) lookup etc.

//Handle ambiguity, come up with systematic approach, take sizes into account (Bus, truck, moto, car etc.)



