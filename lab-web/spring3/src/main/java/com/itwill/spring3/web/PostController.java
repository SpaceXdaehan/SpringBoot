package com.itwill.spring3.web;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring3.dto.PageDto;
import com.itwill.spring3.dto.PostCreateDto;
import com.itwill.spring3.dto.PostDetailDto;
import com.itwill.spring3.dto.PostSearchDto;
import com.itwill.spring3.dto.PostUpdateDto;
import com.itwill.spring3.repository.post.Post;
import com.itwill.spring3.repository.reply.Reply;
import com.itwill.spring3.service.PostService;
import com.itwill.spring3.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    
    private final ReplyService replyService;
    
    
//    // 페이지네이션 목록 리스트
//    @GetMapping("")
//    public String post(Model model, @RequestParam int num) {      
//        log.info("post(num={})", num);
    
//        if (num <= 0) {
//           num = 0;            
//        } 
    
//        List<Post> postlist = postService.read();   
    
//        if(num > postlist.size() / 10) {
//            num = postlist.size() / 10;
//        }
//        
//        // 버튼 만드는 메서드
//        List<PageDto> list2 = postService.makebtn(num,postlist);

//        // 페이지에 표시할 게시글 리스트 만드는 메서드
//        List<Post> list = postService.readpage(num, postlist);
//        
//        model.addAttribute("postlist", list);
//        model.addAttribute("btnlist", list2);
//        model.addAttribute("num", num);
//        return "/post/read";       
//    }
    
    
    @GetMapping
    public String read(Model model) {
        log.info("read()");
        
        // 포스트 목록 검색
        List<Post> list = postService.read();
        
        // 검색 결과를 Model에 세팅:
        model.addAttribute("posts", list);
        
        return "/post/read";
    }
    
    
    @PreAuthorize("hasRole('USER')") // Pre = 이 메서드가 실행되기 전에, 페이지 접근 이전에 인증(권한, 로그인) 여부를 확인. ('USER')작은 따옴표는 스프링 EL
    @GetMapping("/create")
    public void create() {
        log.info("create() GET");
        
        // 리턴 값이 없는 경우 view의 이름은 요청 주소와 같음.
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("create(dto={})POST", dto);
        
        // form에서 submit(제출)된 내용을 DB 테이블에 insert
        postService.create(dto);
        
        // DB 테이블 insert 후 포스트 목록 페이지로 redirect 이동.
        return "redirect:/post";
                
    }
    
    
    // "/post/details", "/post/modify" 두가지 요청주소들을 처리하는 컨트롤러 메서드.
    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/details", "/modify"})
    public void read(Long id, Model model) {
        log.info("read(id={})", id);
        
        // id로 POSTS 테이블에서 id에 해당하는 포스트를 검색.
        Post post = postService.read(id);
        
        // 결과를 model에 저장하고 => 뷰로 전달됨.
        model.addAttribute("post", post);
        
        // REPLIES 테이블에서 해당 포스트에 달린 댓글 개수를 검색.
        long count = replyService.countByPost(post);
        model.addAttribute("replyCount", count);
        
        // 컨트롤러 메서드의 리턴값이 없는 경우(void인 경우).
        // 뷰의 이름은 요청 주소와 같다!
        // details => details.html, modify => modify.html로,,,
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update({})",dto);
        
        postService.update(dto);
           
        return "redirect:/post/details?id=" + dto.getId(); 
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/delete")
    public String delete(long id) {
        
        log.info("delete(id={})", id);
        
        postService.delete(id);
        
        return "redirect:/post";       
    }
    
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        log.info("search(dto={})", dto);
        
        // postService의 검색 기능 호출:
        List<Post> list = postService.search(dto);
        
        // 검색 결과를 Model에 저장해서 뷰로 전달.
        model.addAttribute("posts", list);
        
        return "/post/read";
    }
    
    
//    @GetMapping("/search")
//    public String search(PostSearchDto dto, @RequestParam int num, Model model) {
//        log.info("post(num={})", num);
//        
//        if(num<=0) {         
//            num=0;            
//        }
//        
//        List<Post> postlist = postService.findbyText(dto);
//        
//        if(num>postlist.size()/10) {
//            num = postlist.size()/10;
//        }
//        
//        // 버튼 만드는 메서드
//        List<PageDto> list2 = postService.makebtn(num,postlist);
//        
//        // 페이지에 표시할 게시글 리스트 만드는 메서드
//        List<Post> list = postService.readpage(num,postlist);
//        
//        model.addAttribute("postlist",list);
//        model.addAttribute("btnlist", list2);
//        model.addAttribute("num",num);
//        model.addAttribute("dto",dto);
//        model.addAttribute("dtoget",dto.getSearchtext());
//        
//        return "/post/search";
//    }
    
    
}
