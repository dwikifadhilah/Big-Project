package testdata;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class BlastData {
		Faker faker = new Faker();
		private final String blastTitle = faker.name().title();
		private final String blastDesc = faker.food().ingredient();
		private final String cheers = faker.animal().name();
		private final String comment = faker.cat().breed();
}
