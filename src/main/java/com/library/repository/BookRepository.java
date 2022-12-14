package com.library.repository;

import com.library.domain.Book;
import com.library.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT new com.library.dto.response.BookResponse(book)  FROM Book book")
    Page<BookResponse> findAllBookWithPage(Pageable pageable);

    // Get All Books with parameters:

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where b.active=TRUE and (lower(b.name) like %?1% OR lower(b.bookAuthor.name) like %?1% OR b.isbn like %?1% or lower(b.bookPublisher.name) like %?1%)")
    Page<BookResponse> getAllBooksWithQ(String q, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where b.active=TRUE and b.bookCategory.id=?1")
    Page<BookResponse> getAllBooksWithCat(Long cat, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where b.active=TRUE and b.bookAuthor.id=?1")
    Page<BookResponse> getAllBooksWithAuthor(Long author, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where b.active=TRUE and b.bookPublisher.id=?1")
    Page<BookResponse> getAllBooksWithPublisher(Long publisher, Pageable pageable);

    // active true and false for admin

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where lower(b.name) like %?1% OR lower(b.bookAuthor.name) like %?1% OR b.isbn like %?1% or lower(b.bookPublisher.name) like %?1% ")
    Page<BookResponse> getAllBooksWithQAdmin(String q, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where  b.bookCategory.id=?1")
    Page<BookResponse> getAllBooksWithCatAdmin(Long cat, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where  b.bookAuthor.id=?1")
    Page<BookResponse> getAllBooksWithAuthorAdmin(Long author, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where  b.bookPublisher.id=?1")
    Page<BookResponse> getAllBooksWithPublisherAdmin(Long publisher, Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b")
    Page<BookResponse> getAllBooksWithPageByAdmin(Pageable pageable);

    @Query("SELECT new com.library.dto.response.BookResponse(b)  FROM Book b where b.featured=true")
    Page<BookResponse> findAllFeaturedIsTrue(Pageable pageable);


   }
