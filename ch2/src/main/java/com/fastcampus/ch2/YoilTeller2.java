package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class YoilTeller2 {

    @RequestMapping("/yoil")
    public String yoil(int year, int month, int day, Model m, HttpServletRequest response){

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day );

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);

        m.addAttribute("year", year);
        m.addAttribute("month", month);
        m.addAttribute("day", day);
        m.addAttribute("yoil", yoil);

        return "yoil.html";
    }
}
