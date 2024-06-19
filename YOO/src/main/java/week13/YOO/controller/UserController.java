package week13.YOO.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import week13.YOO.domain.UserVO;
import week13.YOO.dto.UserDto;
import week13.YOO.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "") String msg, RedirectAttributes m){
        m.addFlashAttribute("msg",msg);
        return "/user/login";
    }

    // 로그인 시도
    @PostMapping("/login")
    public String loginTry(@ModelAttribute UserDto userDto, RedirectAttributes m, HttpSession session){
        String msg;
        UserVO userVO = userService.getUserInfo(userDto.getId());

        // DB에 일치하는 정보 없음
        if(userVO == null) {
            msg = "존재하지 않는 유저입니다.";
            m.addAttribute("msg",msg);
            return "redirect:/login";
        }

        // 아이디 혹은 비밀번호 불일치
        if(!userDto.getId().equals(userVO.getId()) || !userDto.getPw().equals(userVO.getPw())){
            msg = "아이디 혹은 비밀번호가 일치하지 않습니다.";
            m.addAttribute("msg", msg);
            return "redirect:/login";
        }

        // 로그인 유지를 위해 세션 저장소에 추가
        session.setAttribute("userId", userVO.getId());
        session.setAttribute("userName", userVO.getName());

        // 로그인이 정보 일치
        msg = "로그인 성공";
        m.addAttribute("msg", msg);
        return "redirect:/";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/register")
    public String register(@RequestParam(required = false, defaultValue = "") String msg, RedirectAttributes m){
        System.out.println("register msg = " + msg);
        m.addFlashAttribute("msg",msg);
        return "/user/register";
    }

    // 회원가입 시도
    @PostMapping("/register")
    public String registerTry(@ModelAttribute UserDto userDto, RedirectAttributes m){

        System.out.println("userDto = " + userDto);

        if(userDto == null){
            m.addAttribute("msg", "잘못된 접근입니다.");
            return "redirect:/register";
        }

        // DB에 일치하는 유저 정보 있는지 확인
        UserVO userVO = userService.getUserInfo(userDto.getId());
        if(userVO != null){
            m.addAttribute("msg","아이디가 이미 존재합니다.");
            return "redirect:/register";
        }

        // DB에 유저 정보 등록 실패
        if(userService.registerUser(userDto) == 0){
            m.addAttribute("msg","회원가입 실패");
            return "redirect:/register";
        }

        m.addAttribute("msg", "회원가입 완료");
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("실행됨");
        // 세션 모두 제거
        session.invalidate();
        return "redirect:/";
    }
}
