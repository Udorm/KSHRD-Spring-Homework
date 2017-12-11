package com.kshrd;

//import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.github.javafaker.Faker;

@SpringBootApplication
public class HomeworkBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkBookApplication.class, args);
		
//		Faker faker = new Faker();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		for (int i = 1; i <= 30; i++) {
//			String st = "insert into books (id, title, publishDate, author, page, coverImage) " +
//						"values ("+ i +",'"+ faker.book().title() +"','"+ sdf.format(faker.date().birthday()) +"', '"+ faker.name().fullName() +"', "+ faker.number().digits(2) +",'"+ faker.internet().image(35, 50, false, null) + "');";
//			System.out.println(st);
//		}
	}
}
