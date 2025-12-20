package uz.pdp.controller;

import uz.pdp.dto.AddressDTO;
import uz.pdp.dto.PostDTO;
import uz.pdp.entity.Address;
import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;

import static uz.pdp.util.Utils.*;

public class MainController {


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
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 0 -> {}
            }

        }
    }

    private void creatPost() {
        System.out.println("""
                1.Kvartira
                2.Xonadon
                3.Hovli
                """);
        int homeType = getNum("Bittasini tanlang");

        HomeType homeTypeEnum;
        switch (homeType){
            case 1 -> homeTypeEnum = HomeType.KVARTIRA;
            case 2 -> homeTypeEnum = HomeType.XONADON;
            case 3 -> homeTypeEnum = HomeType.HOVLI;
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




    }
}
