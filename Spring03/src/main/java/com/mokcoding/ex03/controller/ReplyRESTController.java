package com.mokcoding.ex03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokcoding.ex03.domain.ReplyVO;
import com.mokcoding.ex03.service.ReplyService;

import lombok.extern.log4j.Log4j;

//* RESTful url과 의미
// /reply (POST) : 댓글 추가(insert)
// /reply/all/숫자 (GET) : 해당 글 번호(boardId)의 모든 댓글 검색(select)
// /reply/숫자 (PUT) : 해당 댓글 번호(replyId)의 내용을 수정(update)
// /reply/숫자 (DELETE) : 해당 댓글 번호(replyId)의 댓글을 삭제(delete)


@RestController
@RequestMapping(value="/reply")
@Log4j
public class ReplyRESTController { // url만 보고도 어떤 기능을 알 수 있는지 하는게 RESTAPI
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping // POST : 댓글 입력
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO replyVO) {
		log.info("createReply()");
		
		int result = replyService.createReply(replyVO);
		return new ResponseEntity<Integer>(result, HttpStatus.OK); // result = 1 : 성공, 0 : 실패
	}
	
	@GetMapping("/all/{boardId}") // GET : 댓글 선택(all)
	public ResponseEntity<List<ReplyVO>> readAllReply( // list에 담아서 get으로 페이지 보내기
			@PathVariable("boardId") int boardId) {
		// PathVariable("boardId") : {boardId} 값을 설정된 변수에 저장
		log.info("readAllReply()");
		log.info("boardId = " + boardId);
		
		List<ReplyVO> list = replyService.getAllReply(boardId); // JSON으로 알아서 보낸다. 받는 쪽에서 처리해줘야함
		return new ResponseEntity<List<ReplyVO>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/{replyId}") // PUT : 댓글 수정
	   public ResponseEntity<Integer> updateReply(
	         @PathVariable("replyId") int replyId,
	         @RequestBody String replyContent
	         ){
	      log.info("updateReply()");
	      log.info("replyId = " + replyId);
	      int result = replyService.updateReply(replyId, replyContent);
	      return new ResponseEntity<Integer>(result, HttpStatus.OK);
	   }
	   
	
	 @DeleteMapping("/{replyId}/{boardId}") // DELETE : 댓글 삭제
	   public ResponseEntity<Integer> deleteReply(
	         @PathVariable("replyId") int replyId,
	         @PathVariable("boardId") int boardId) {
	      log.info("deleteReply()");
	      log.info("replyId = " + replyId);
	      
	      int result = replyService.deleteReply(replyId,boardId);
	      
	      return new ResponseEntity<Integer>(result, HttpStatus.OK);
	   }
 	
	
}
