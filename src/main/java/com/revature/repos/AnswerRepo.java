package com.revature.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Answer;

@Repository
public interface AnswerRepo extends  JpaRepository<Answer, Integer>{

	@SuppressWarnings("unchecked")
	Answer save(Answer answer);
	
	List<Answer> findAll();

	Answer getOne(Integer id);
	
	List<Answer> findByBountyId(int bountyId);

	List<String> findByUserIdIn(List<Integer> idList);

	Page<Answer> findByBountyId(int id, Pageable page);
	
	 @Query(value = "SELECT max(votes) from answers WHERE bounty_id = 1", nativeQuery = true)
	 int getMaxVotes(int id);
	 
	 @Query(value = "SELECT a FROM Answer a where votes = :maxVotes")
	 List<Answer> getHighestAnswers(int maxVotes);
	
	

}
