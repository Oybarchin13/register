package uz.pdp.entity;

import lombok.*;
import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"id"})
public class PostEntity {

    private String id;
    private HomeType type;
    private Address address;
    private double field;
    private int roomCount;
    private long price;
    private PostType postType;
    private String description;

}
