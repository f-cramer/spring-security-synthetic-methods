package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Override
	@PreAuthorize("hasRole('READ_BOOKS')")
	List<Book> findAllById(Iterable<Long> longs);
}
