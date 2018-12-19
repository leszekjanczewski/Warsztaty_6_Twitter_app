package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
