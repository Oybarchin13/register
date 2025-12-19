package uz.pdp;


import uz.pdp.controller.UserController;

public class Main {
    public static void main(String[] args) {


        UserController userController = new UserController();
        userController.start();


    }
}