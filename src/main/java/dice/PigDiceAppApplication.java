package dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PigDiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigDiceAppApplication.class, args);
		System.out.println("Pig Dice");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String choice="y";

		ArrayList<Integer> highScores=new ArrayList<>();
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("How many games would you like to play? ");
			int games = sc.nextInt();
			int rollCount = 0;
			int score = 0;
			ArrayList<Integer> scores=new ArrayList<>();
				while (games>0) {
					int rollValue = rollOfTheDie();
						if (rollValue!=1) {
							rollCount+=1;
							score+=rollValue;
							scores.add(score);
						} else if (rollValue==1) {
							games-=1;
							score=0;
						}
				}
				int highScore = Collections.max(scores);
				highScores.add(highScore);
			int highestScore = Collections.max(highScores);
			System.out.println("Your high score: " +highScore +"\n"
								+"Overall highest score: " +highestScore);
			System.out.println();
			System.out.print("Continue? (y/n) ");
			choice=sc.next();
		}
		System.out.println("Goodbye!");
		sc.close();
	}

	public static int rollOfTheDie() {
		return (int) (Math.random() * 6 + 1);
	}
}