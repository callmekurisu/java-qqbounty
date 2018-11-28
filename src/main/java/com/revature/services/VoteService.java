package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Vote;
import com.revature.repos.VoteRepo;

/*
 * This class is used to keep track of votes in AnswerService.
 */
@Service
public class VoteService {
	
	@Autowired
	private VoteRepo voteRepo;

	public List<Vote> findByAnswerIdAndUserId(int answerId,int userId) {
		return voteRepo.findByAnswerIdAndUserId(answerId,userId);
	}
	
	public Vote save(Vote vote) {
		return voteRepo.save(vote);
	}

}