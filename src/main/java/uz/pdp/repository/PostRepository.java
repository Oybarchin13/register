package uz.pdp.repository;

import uz.pdp.entity.Address;
import uz.pdp.entity.PostEntity;
import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PostRepository {
    private static PostRepository postRepository;
    private PostRepository(){}
    public static PostRepository getInstance(){
        if(postRepository == null) postRepository = new PostRepository();
        return postRepository;
    }



    public void savePost(PostEntity postEntity){
        List<PostEntity> list = getList();
        list.add(postEntity);
        saveList(list);

    }


    public List<PostEntity> getList(){

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/java/uz/pdp/repository/post_data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<PostEntity> list = (List<PostEntity>) objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return Collections.emptyList();
    }

    public void saveList(List<PostEntity> list){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/uz/pdp/repository/post_data.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    {
        List<PostEntity> list = getList();
        if(list.isEmpty()){
            List<PostEntity> arrayLists = new ArrayList<>();
            Address address = new Address("Tashkent", "Alisher Navoiy", 123);
            PostEntity postEntity = new PostEntity(UUID.randomUUID().toString(), HomeType.HOVLI, address, 50, 3, 5000, PostType.IJARA, "Ijaraga beriladi", UUID.randomUUID().toString());
            arrayLists.add(postEntity);
            saveList(arrayLists);
        }
    }






}
