package com.db.VoteChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VoteChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteChallengeApplication.class, args);
	}

}
