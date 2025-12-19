package uz.pdp.repository;

import uz.pdp.dto.RegisterDTO;
import uz.pdp.entity.UserEntity;
import uz.pdp.enums.UserRole;

import java.io.*;
import java.util.*;

public class UserRepository {

    public static UserRepository userRepository;
    private UserRepository(){}

    public static UserRepository getInstance(){
        if(userRepository == null) userRepository = new UserRepository();
        return userRepository;
    }

    public void saveUser(RegisterDTO registerDTO){
        UserEntity userEntity = new UserEntity(UUID.randomUUID().toString(),registerDTO.fullName(), registerDTO.phoneNumber(), registerDTO.password(), UserRole.USER);
        List<UserEntity> list = getList();
        list.add(userEntity);
        saveList(list);

    }


    public Optional<UserEntity> getByPhone(String phone){
        List<UserEntity> list = getList();
        for (UserEntity userEntity : list) {
            if(userEntity.getPhoneNumber().equals(phone)) return Optional.of(userEntity);
        }
        return Optional.empty();
    }


    public List<UserEntity> getList(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/uz/pdp/repository/user_data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<UserEntity> list = (List<UserEntity>) objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }




    public void saveList(List<UserEntity> list){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/uz/pdp/repository/user_data.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    {

        List<UserEntity> list1 = getList();
        if(list1.isEmpty()){
            List<UserEntity> list = new ArrayList<>();
            list.add(new UserEntity(UUID.randomUUID().toString(), "Vali Valiyev", "901234567","Dog", UserRole.ADMIN));
            saveList(list);
        }



    }







}
