package com.itwill.spring3.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);
        
        return "/main/index";   // 컨트롤러가 리턴해주는 건 View의 이름을 리턴해줌
    }
}
