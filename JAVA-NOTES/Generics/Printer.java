package Generics;

public class Printer<T> { //Burda tip olarak her verilen paramatyereye göre değişebilen T verdik. Ne verirsek parametre olarak onu alır.
	

	T _thingToPrint;

	public Printer(T thingToPrint) { //Constructor
		_thingToPrint = thingToPrint;

	}

	public void printThing() { //Metot
		System.out.println(_thingToPrint);
	}
}
