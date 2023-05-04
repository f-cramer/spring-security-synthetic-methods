package com.example;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;

@SpringBootApplication
public class SpringSecuritySyntheticMethodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySyntheticMethodsApplication.class, args);
	}

	CommandLineRunner databasePopulator(BookRepository bookRepository) {
		return args -> {
			com.github.javafaker.Book book = Faker.instance().book();
			List<Book> books = IntStream.range(0, 10)
					.mapToObj(i -> new Book(0, book.title()))
					.toList();
			bookRepository.saveAll(books);
		};
	}
}
