package week13.YOO.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserVO {

    // 유저 ID(PK)
    private String id;

    // 유저 PW
    private String pw;

    // 유저 이름
    private String name;

    public UserVO(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

}
