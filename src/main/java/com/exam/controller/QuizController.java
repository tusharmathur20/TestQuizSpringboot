package com.exam.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@CrossOrigin( "*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
//add Quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
	return ResponseEntity.ok(this.quizService.addQuiz(quiz));	
	}

	
	//updateQuiz
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get quiz
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
		
	}
	
	//Single Quiz
	@GetMapping("{qid}")
public Quiz quiz(@PathVariable("qid") long qid) {
	return 	this.quizService.getQuiz(qid);
	}
	
	
	//delete
	@DeleteMapping("{qid}")
	public void delete(@PathVariable("qid")long qid) {
		this.quizService.deleteQuiz(qid);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesofCatgory(@PathVariable("cid")Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	

	//get ACtive qUIZZES

	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzesOfCAtegory(@PathVariable("cid")Long cid){
		
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
}

