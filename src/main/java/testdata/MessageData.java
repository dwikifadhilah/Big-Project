package testdata;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class MessageData {
		private final Faker faker = new Faker();
		
		private final String message = faker.food().fruit();
		private final String emoji = "\u2764" + " " + "\u270C"; // ❤✌
		private final String url = "https://staging.cicle.app/" + " ";
		private final String email = faker.internet().emailAddress() + " ";
}
