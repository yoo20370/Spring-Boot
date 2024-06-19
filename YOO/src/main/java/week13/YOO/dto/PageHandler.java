package week13.YOO.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageHandler {

    // 현재 페이지
    private int page = 1;
    // 게시물 개수
    private int pageSize = 10;
    // 전체 게시물
    private int totalCnt;
    // 전체 페이지
    private int totalPage;

    // 하단 네비 개수
    private int naveSize = 10;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    void doPaging(int totalCnt){
        totalPage = (int)Math.ceil(totalCnt / (double) pageSize);
        beginPage = (page - 1) / naveSize * naveSize + 1;
        endPage = Math.min(beginPage + naveSize - 1 , totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getOffset() {
        return (page -1) * pageSize;
    }

}
