package uz.pdp.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

public class Address {
    private String city;
    private String street;
    private int apermentNumber;
}
