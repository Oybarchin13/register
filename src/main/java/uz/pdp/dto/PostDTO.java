package uz.pdp.dto;

import uz.pdp.entity.Address;
import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;

public record PostDTO(

        HomeType type,
        AddressDTO address,
        double field,
        int roomCount,
        long price,
        PostType postType,
        String description
) {


}
