package com.example.nothingbuttext.repo;

import com.example.nothingbuttext.model.MajorTextPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorTextPartRepository extends JpaRepository<MajorTextPart, Long> {
    Optional<MajorTextPart> findByYTLink(String YTLink);
}