package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

	private final BookRepository bookRepository;

	@GetMapping("/books")
	public List<Book> getBooks(
			@RequestParam("id") List<Long> ids
	) {
		return bookRepository.findAllById(ids);
	}
}
