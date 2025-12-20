package uz.pdp.controller;

import uz.pdp.dto.AddressDTO;
import uz.pdp.dto.FillterDTO;
import uz.pdp.dto.PostDTO;
import uz.pdp.entity.Address;
import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;
import uz.pdp.services.PostService;

import java.util.List;

import static uz.pdp.util.Utils.*;

public class MainController {

    private final PostService postService = PostService.getInstance();


    public void mainMenu() {
        while (true){
            System.out.println("""
                    1.Yangi e'lon joylash
                    2.Mening e'lonlarim
                    3.E'lonlar
                    4.Qidirish
                    0.Chiqish
                    """);

            int menu = getNum("menu tanlang");
            switch (menu){
                case 1 -> {creatPost();}
                case 2 -> {myPosts();}
                case 3 -> {allPosts();}
                case 4 -> {search();}
                case 0 -> {return;}
            }

        }
    }

    private void search() {
        System.out.println("""
                Nima bo'yicha qidirmoqchisiz?
                1.Home type
                2.Manzil boyicha
                3.Narxi boyicha
                4.Xonalar soni boyicha
                5.Maydoni boyicha
                6.Post type
                7.Hammasi boyicha""");

        int menu = getNum("Tanlang");
        switch (menu){
            case 1-> {
                String homeType = getStr("(KVARTIRA,  HOVLI) kiriting");
                HomeType homeTypeEnum = HomeType.valueOf(homeType);
                FillterDTO fillterDTO = new FillterDTO(homeTypeEnum, null, 0,0,0,null);
                postService.fillter(fillterDTO).forEach(System.out::println);
            }
            case 2-> {
                String address = getStr("(Shaxar nomini kiriting");
                FillterDTO fillterDTO = new FillterDTO(null, address, 0,0,0,null);
                postService.fillter(fillterDTO).forEach(System.out::println);
            }
            case 3-> {
                int price = getNum("Narxini  kiriting");
                FillterDTO fillterDTO = new FillterDTO(null, null, 0,0,price,null);
                postService.fillter(fillterDTO).forEach(System.out::println);
            }
            case 4-> {
                int roomCount = getNum("Xonalar sonini kiriting");
                FillterDTO fillterDTO = new FillterDTO(null, null, 0,roomCount,0,null);
                postService.fillter(fillterDTO).forEach(System.out::println);
            }

        }

    }

    private void allPosts() {
        postService.getAllPosts().forEach(System.out::println);


    }

    private void myPosts() {
      postService.getMyPosts(currentUserId).forEach(System.out::println);

    }

    private void creatPost() {
        System.out.println("""
                1.Kvartira
                2.Hovli
                """);
        int homeType = getNum("Bittasini tanlang");

        HomeType homeTypeEnum;
        switch (homeType){
            case 1 -> homeTypeEnum = HomeType.KVARTIRA;
            case 2 -> homeTypeEnum = HomeType.HOVLI;
            default -> {
                System.out.println("Noto‘g‘ri tanlov!");
                return;
            }

        }

        String city = getStr("Shaxarni kiriting");
        String sreet = getStr("Ko'cha nomini kiriting");
        int roomNumber = getNum("Uy raqamini kiriting");

        AddressDTO addressDTO = new AddressDTO(city, sreet, roomNumber);
        int field = getNum("Uy maydonini kiriting");
        int roomCount = getNum("Xonalar sonini kiring");
        long price = getNum("Narxini kiriting");

        System.out.println("""
                1.Sotish
                2.Ijara  """);
        int postTypeMenu = getNum("Tanlang");
        PostType postType;

        switch (postTypeMenu){
            case 1 -> {postType = PostType.SOTISH;}
            case 2 -> {postType = PostType.IJARA;}
            default -> {
                System.out.println("Noto‘g‘ri tanlov!");
                return;
            }
        }

        String desc = getStr("Qo'shimcha ma'lumot");

        PostDTO postDTO = new PostDTO(homeTypeEnum,addressDTO,field,roomCount,price,postType,desc);

        postService.createPost(postDTO);




    }
}
