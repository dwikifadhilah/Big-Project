package pageobject.qa14team;

import com.github.javafaker.Faker;

public class BoardPage {
		public static void main(String[] args) {
				Faker faker = new Faker();
				for (int i=0; i<100; i++){
						
						System.out.println(faker.cat().breed());
				}
				
		}
}
