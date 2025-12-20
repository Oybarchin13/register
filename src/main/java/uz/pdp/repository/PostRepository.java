package uz.pdp.repository;

public class PostRepository {
    private static PostRepository postRepository;
    private PostRepository(){}
    public static PostRepository getInstance(){
        if(postRepository == null) postRepository = new PostRepository();
        return postRepository;
    }






}
