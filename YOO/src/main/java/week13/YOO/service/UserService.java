package week13.YOO.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week13.YOO.domain.UserVO;
import week13.YOO.dto.UserDto;
import week13.YOO.repository.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    // 유저 정보가 맞는지 확인하기
    public UserVO getUserInfo(String id){
        return userMapper.getUserDB(id);
    }

    public int registerUser(UserDto userDto){
        return userMapper.regiUserDB(userDto);
    }
}
