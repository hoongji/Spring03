package com.mokcoding.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller 
@RequestMapping(value = "/board") 
@Log4j
public class BoardController {

   @GetMapping("/detail")
   public void detail(Integer num) {
      log.info("detail()");
   }

} // end BoardController