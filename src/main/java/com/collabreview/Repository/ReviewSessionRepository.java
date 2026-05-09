package com.collabreview.Repository;

import com.collabreview.Entity.ReviewSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewSessionRepository extends JpaRepository<ReviewSession, Long> {
}
