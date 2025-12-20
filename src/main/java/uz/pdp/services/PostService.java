package uz.pdp.services;

import uz.pdp.dto.PostDTO;

public class PostService {


    private static PostService postService;
    private  PostService(){}
    public static PostService getInstance(){
        if(postService == null) postService = new PostService();
        return postService;
    }



    void createPost(PostDTO postDTO){

    }
}
