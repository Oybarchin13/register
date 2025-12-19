package uz.pdp.controller;

import uz.pdp.dto.LoginDTO;
import uz.pdp.dto.RegisterDTO;
import uz.pdp.services.UserServices;

import static uz.pdp.util.Utils.*;

public class UserController {
    private final UserServices userServices = UserServices.getInstance();


    public void start(){
        while (true){
            System.out.println("""
                    1.Sign In
                    2.Sign Up
                    3.Exit
                    """);

            int menu = getNum("Choose one");
            switch (menu){
                case 1 -> {loginUser();}
                case 2 -> {registration();}
                case 3 -> {return;}
            }

        }
    }

    private void loginUser() {
        String phoneNumber = getStr("Enter phone number");
        String password = getStr("Enter password");
        LoginDTO loginDTO = new LoginDTO(phoneNumber, password);
        boolean res = userServices.loginUser(loginDTO);
        if (res) System.out.println();



    }

    private void registration() {
        String fullName = getStr("Enter full name");
        String phoneNumber = getStr("Enter phone number");
        String password = getStr("Created password");

        RegisterDTO registerDTO = new RegisterDTO(fullName, phoneNumber, password);
        boolean res = userServices.registration(registerDTO);
        if(res) System.out.println("Success");
        else System.out.println("Error");

    }

}
