package desdeJava8;

import java.time.Instant;

public class Ejemplo4Instant {

	public static void main(String[] args) {
		
		Instant instant1 = Instant.ofEpochSecond(120);
		System.out.println(instant1);
		
		Instant instant2 = Instant.now();
		System.out.println(instant2);
	}

}
