package hr.tvz.ivankovic.hardwareapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewServiceImpl reviewService;
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReview(){
        return reviewService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<ReviewDTO>> getByCode(@PathVariable final String code){
        return Optional.of(reviewService.findByCode(code))
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }
}

