package uz.pdp.dto;

import uz.pdp.enums.HomeType;
import uz.pdp.enums.PostType;

public record FillterDTO(
        HomeType type,
        String  address,
        double field,
        int roomCount,
        long price,
        PostType postType
) {

}
