package uebung2;

public class VariablenBeispiele {
	public static void main(String[] args) {
		
		// Die runden Klammern aendern die Ausfuehrungsreihenfolge.
		System.out.println(9.1*4.5-2.7/3);
		System.out.println(9.1*(4.5-2.7)/3);
		
		int jahr; //Definition der Variable
		jahr = 2018; //Initialisierung der Variable
		System.out.println(jahr);
		jahr = 2019;
		System.out.println(jahr);
		
		double celsius = 20.4; //Definition und Initialisierung der Variable
		double fahrenheit = 9/5*celsius+32;
		System.out.println(celsius+"C ist "+fahrenheit + "F");
		
		String vorname = "Konstantin";
		String ganzerName = vorname + " Trendafilov";
		System.out.println(ganzerName);

	}
}
