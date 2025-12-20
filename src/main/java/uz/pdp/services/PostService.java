package uz.pdp.services;

import uz.pdp.dto.AddressDTO;
import uz.pdp.dto.PostDTO;
import uz.pdp.entity.Address;
import uz.pdp.entity.PostEntity;
import uz.pdp.repository.PostRepository;
import static uz.pdp.util.Utils.*;

import java.util.List;
import java.util.UUID;

public class PostService {


    private final PostRepository postRepository = PostRepository.getInstance();

    private static PostService postService;
    private  PostService(){}
    public static PostService getInstance(){
        if(postService == null) postService = new PostService();
        return postService;
    }



    public void createPost(PostDTO postDTO){
        PostEntity entity = toEntity(postDTO);
        postRepository.savePost(entity);
    }


    public List<PostDTO> getMyPosts(String currentUserId) {
        List<PostEntity> list = postRepository.getList();

        return postRepository.getList().stream()
                .filter(entity -> entity.getUserId().equals(currentUserId))
                .map(entity -> toDTO(entity)).toList();
    }
    public List<PostDTO> getAllPosts(String currentUserId) {
        List<PostEntity> list = postRepository.getList();

        return postRepository.getList().stream()
                .map(entity -> toDTO(entity)).toList();
    }






    public PostEntity toEntity(PostDTO postDTO){
        Address address = new Address(postDTO.address().city(), postDTO.address().street(), postDTO.address().apermentNumber());
        PostEntity postEntity = new PostEntity(UUID.randomUUID().toString(),postDTO.type(), address, postDTO.field(), postDTO.roomCount(), postDTO.price(), postDTO.postType(), postDTO.description(), currentUserId);
        return postEntity;
    }

    public PostDTO toDTO(PostEntity entity){
        AddressDTO addressDTO = new AddressDTO(entity.getAddress().getCity(),entity.getAddress().getStreet(), entity.getAddress().getApermentNumber());
        return new PostDTO(entity.getType(), addressDTO, entity.getField(),entity.getRoomCount(), entity.getPrice(), entity.getPostType(),entity.getDescription());
    }



}
