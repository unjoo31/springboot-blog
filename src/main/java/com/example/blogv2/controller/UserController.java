package com.example.blogv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blogv2.dto.JoinDTO;
import com.example.blogv2.repository.UserRepository;

// @Controller : 1.ComponentScan → new → IoC 등록 2.return 되는값이 view 파일
// 메인 페이지 파일을 index 파일로 만들면 controller가 없어도 열린다
@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/join")
    public String join(JoinDTO joinDTO){

        // validation check (유효성 검사)
        // 프론트에서 막힌 사람들은 타지 않지만 공격자들을 걸러낸다
        if(joinDTO.getUsername() == null || joinDTO.getUsername().isEmpty()){
            return "redirect:/40x";
        }
        if(joinDTO.getPassword() == null || joinDTO.getPassword().isEmpty()){
            return "redirect:/40x";
        }
        if(joinDTO.getEmail() == null || joinDTO.getEmail().isEmpty()){
            return "redirect:/40x";
        }

        userRepository.save(joinDTO);
        return "redirect:/loginForm";
    }
	
    // ip주소 부여 : 10.5.9.200:포트번호 -> mtcoding.com:포트번호 (dns를 산다)
    // 포트번호 80은 브라우저에서 생략 가능하다
    // localhost, 127.0.0.1 : 루프백주소 (외부로 빠져나가지 않는다)
    // Get에 들어갈 수 있는 것 : a태그, form태그에 method=get
    // /joinForm : 앤드포인트
    
    @GetMapping("/joinForm")
    public String joinForm(){
        // templates/ 가 기본이라서 user앞에 /를 붙이지 않는다
        return "user/joinForm"; // ViewResolver 는 templates 폴더를 찾아간다
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("/updateForm")
    public String updateForm(){
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
