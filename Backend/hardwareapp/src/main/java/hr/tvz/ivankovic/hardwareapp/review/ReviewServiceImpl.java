package hr.tvz.ivankovic.hardwareapp.review;

import hr.tvz.ivankovic.hardwareapp.review.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }
    @Override
    public List<ReviewDTO> findByCode(final String code) {
        return reviewRepository.findByCode(code).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToDTO(final Review review){
        return new ReviewDTO(review.getTitle(), review.getContent(), review.getRating());
    }
}
