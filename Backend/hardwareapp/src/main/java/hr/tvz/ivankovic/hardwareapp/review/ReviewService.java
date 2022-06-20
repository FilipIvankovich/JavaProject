package hr.tvz.ivankovic.hardwareapp.review;

import hr.tvz.ivankovic.hardwareapp.review.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();
    List<ReviewDTO> findByCode(String code);
}
