package com.enterprise.java.services;

import com.enterprise.java.models.Review;
import com.enterprise.java.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void createOrUpdateReview(Review review) {
        reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

//    public List<Review> filterReviewsByBookId(int bookId) {
//        List<Review> inReviews = getAllReviews();
//        List<Review> outReviews = new ArrayList<>();
//        for (Review review : inReviews) {
//            if (review.getBookId() == bookId) {
//                outReviews.add(review);
//            }
//        }
//        return outReviews;
//    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
}
