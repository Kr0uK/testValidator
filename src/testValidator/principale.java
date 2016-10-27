package testValidator;

public class principale {

	public static void main(String[] args) {
		MaClasse maclasse = new MaClasse("02","ff");

		TestValidator


		System.out.println(maclasse.getNumAfpa());
		System.out.println(maclasse.getEmail());
		
		maclasse.setNumAfpa("023");
		
		System.out.println(maclasse.getNumAfpa());
		

	}

}
