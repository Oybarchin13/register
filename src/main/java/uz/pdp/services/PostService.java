package uz.pdp.services;

import uz.pdp.dto.PostDTO;
import uz.pdp.entity.Address;
import uz.pdp.entity.PostEntity;

import java.util.UUID;

public class PostService {


    private static PostService postService;
    private  PostService(){}
    public static PostService getInstance(){
        if(postService == null) postService = new PostService();
        return postService;
    }



    public void createPost(PostDTO postDTO){
        PostEntity entity = toEntity(postDTO);

    }


    public PostEntity toEntity(PostDTO postDTO){
        Address address = new Address(postDTO.address().city(), postDTO.address().street(), postDTO.address().apermentNumber());
        PostEntity postEntity = new PostEntity(UUID.randomUUID().toString(),postDTO.type(), address, postDTO.field(), postDTO.roomCount(), postDTO.price(), postDTO.postType(), postDTO.description());
        return postEntity;
    }













}
