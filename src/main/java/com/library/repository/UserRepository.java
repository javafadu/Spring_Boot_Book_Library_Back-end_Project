package com.library.repository;

import com.library.domain.User;

import com.library.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    @Query("SELECT new com.library.dto.response.UserResponse(u) FROM User u")
    Page<UserResponse> findAllWithPage (Pageable pageable);


    @Query("SELECT new com.library.dto.response.UserResponse(u)  FROM User u where  lower(u.firstName) like %?1% OR lower(u.lastName) like %?1% OR lower(u.email) like %?1% or u.phone like %?1%")
    Page<UserResponse> getAllUserWithQAdmin(String q, Pageable pageable);



}



