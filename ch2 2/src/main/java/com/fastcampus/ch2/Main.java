package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

// 프로그램 등록
@Controller
public class Main {
    // 프로그램과 URL 연결
    @RequestMapping("/yoil")
    //public void main(int year, int month, int day, HttpServletResponse response, Model m){
    public ModelAndView main(int year, int month, int day, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("yoilError");

        if(isValid(year,month, day)){
            return mv; // 사용자가 요청한 날짜가 유효하지 않으면 yoilError를 보여준다.
        }
    // 스프링은 map을 참조하여 쿼리스트링 값을 인자에 적절하게 전달함, model도 key:value 형태로 값을 저장
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);

        // 모델은 스프링이 자동으로 view로 전달함
//        m.addAttribute("year", year);
//        m.addAttribute("month", month);
//        m.addAttribute("day", day);
//        m.addAttribute("yoil", yoil);
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);

        //return "yoil";
        mv.setViewName("yoil");

        return mv;
    }

    private boolean isValid(int year, int month, int day) {
        return false;
    }
}
