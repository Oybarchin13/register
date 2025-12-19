package uz.pdp.services;

import uz.pdp.dto.LoginDTO;
import uz.pdp.dto.RegisterDTO;
import uz.pdp.entity.UserEntity;
import uz.pdp.repository.UserRepository;
import static uz.pdp.util.Utils.*;

import java.util.Optional;

public class UserServices {
    private static UserServices userServices;
    private  UserServices(){}

    public static UserServices  getInstance(){
        if(userServices == null) userServices = new UserServices();
        return userServices;
    }

    private final UserRepository userRepository = UserRepository.getInstance();


    public boolean registration(RegisterDTO registerDTO) {

        Optional<UserEntity> byPhone = userRepository.getByPhone(registerDTO.phoneNumber());
        if(byPhone.isPresent()) return false;

        userRepository.saveUser(registerDTO);

        return true;
    }

    public boolean loginUser(LoginDTO loginDTO) {

        Optional<UserEntity> byPhone = userRepository.getByPhone(loginDTO.phoneNumber());
        if(byPhone.isEmpty()) return false;

        UserEntity userEntity = byPhone.get();

        if(!userEntity.getPassword().equals(loginDTO.password())) return false;
        currentUserId = userEntity.getId();

        return true;
    }

}
