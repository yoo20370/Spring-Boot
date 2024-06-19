package week13.YOO.repository;

import org.apache.ibatis.annotations.Mapper;
import week13.YOO.domain.UserVO;
import week13.YOO.dto.UserDto;

@Mapper
public interface UserMapper {

    // 유저 정보 가져오기
    UserVO getUserDB(String id);

    int regiUserDB(UserDto userDto);
}
