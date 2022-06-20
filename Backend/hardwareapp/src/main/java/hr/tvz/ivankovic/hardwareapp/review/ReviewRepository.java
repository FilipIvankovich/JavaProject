package hr.tvz.ivankovic.hardwareapp.review;

import hr.tvz.ivankovic.hardwareapp.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAll();

    List<Review> findByCode(String code);
}
