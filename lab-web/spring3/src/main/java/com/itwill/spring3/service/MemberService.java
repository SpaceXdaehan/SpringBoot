package com.itwill.spring3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwill.spring3.member.MemberSignUpDto;
import com.itwill.spring3.repository.member.Member;
import com.itwill.spring3.repository.member.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor    // final로 생성된 맴버를 초기화하는 생성자 
// implements UserDetailsService = Security Filter Chain에서 UserDetailsService 객체를 사용할 수 있도록 하기 위해서.
public class MemberService implements UserDetailsService{

    private final MemberRepository memberRepository;
    
    // SecurityConfig에서 설정한 PasswordEncoder 빈(Bean)을 주입해줌.
    private final PasswordEncoder passwordEncoder;
    
    
    // 회원가입
    public Long registerMember(MemberSignUpDto dto) {
        log.info("registerMember(dto={})", dto);
        
        Member entity = Member.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .build();
        log.info("save 전: entity={}", entity);
        
        memberRepository.save(entity);
        log.info("save 후: entity={}", entity);
        
        return entity.getId();  // DB에 저장된 ID(고유키)를 리턴.
    }

    
    // 로그인 요청이 들어오면 filter에서 loadUserByUsername메서드를 호출함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername(username={})",username);
        
        // DB에서 username으로 사용자 정보 검색(select).
        UserDetails user = memberRepository.findByUsername(username);
        
        if (user != null) {
            return user;            
        } 
        
        throw new UsernameNotFoundException(username + "not found");       
    }
}
