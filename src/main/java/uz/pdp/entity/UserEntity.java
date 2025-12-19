package uz.pdp.entity;

import lombok.*;
import uz.pdp.enums.UserRole;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserEntity implements Serializable {

    private String id;
    private String fullName;
    private String phoneNumber;
    private String password;
    private UserRole userRole;

}
