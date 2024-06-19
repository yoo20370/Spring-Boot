package week13.YOO.dto;
import lombok.*;

import java.util.Objects;

/*
    유저의 데이터를 옮기기 위한 클래스
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDto {

    // 유저 ID(PK)
    private String id;

    // 유저 PW
    private String pw;

    // 유저 이름
    private String name;

}
