package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // 1. 입력 (요청으로부터)
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 작업 - 요일을 계산
        // 현재 시간을 가져온다.
        Calendar cal = Calendar.getInstance();
        cal.clear(); // cal의 모든 필드를 초기화 (정확한 계산을 위해서)
        cal.set(yyyy, mm-1, dd); // 월(ㅡㅡ)은 0 ~ 11이므로 1을 빼줘야 함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1 ~ 7반환, 1 : 일요일, 2:월요일
        char yoil = "일월화수목금토".charAt(dayOfWeek -1); // 1-7 -> 0 ~ 6

        response.setCharacterEncoding("ms949"); // 한글 윈도우 MS 949

        // 3. 출력 - 작업 결과를 브라우저에 전송
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("year = " + year );
        out.println("month = " + month );
        out.println("day = " + day);
        out.println("yoil = "+yoil);
        out.println("</body>");
        out.println("</html>");

    }
}
