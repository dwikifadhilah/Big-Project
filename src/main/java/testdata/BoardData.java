package testdata;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class BoardData {
    Faker faker = new Faker();
    private final String listName = "Check-Check";
    private final String cardName = "Dwk test";
    private final String memberName = "dwiki";
    private final String filePath = "D:\\images.jpg";
    private final String notes = faker.food().fruit();
    private final String labels = faker.country().currency();
    private final String commentCard = faker.music().genre();
}
