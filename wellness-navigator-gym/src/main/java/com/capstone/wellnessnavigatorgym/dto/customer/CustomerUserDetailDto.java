package com.capstone.wellnessnavigatorgym.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Tuple;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUserDetailDto {
    Integer customerId;
    String customerCode;
    String customerName;
    String customerPhone;
    Boolean customerGender;
    Date dateOfBirth;
    String idCard;
    String customerAddress;
    String customerImg;
    String customerTypeName;
    String username;
    String accountEmail;

    public static CustomerUserDetailDto TupleToCustomerDto(Tuple tuple) {
        return new CustomerUserDetailDto(
                convertToInteger(tuple.get("customer_id")),
                tuple.get("customer_code", String.class),
                tuple.get("customer_name", String.class),
                tuple.get("customer_phone", String.class),
                tuple.get("customer_gender", Boolean.class),
                tuple.get("date_of_birth", Date.class),
                tuple.get("id_card", String.class),
                tuple.get("customer_address", String.class),
                tuple.get("customer_img", String.class),
                tuple.get("customer_type_name", String.class),
                tuple.get("user_name", String.class),
                tuple.get("email", String.class)
        );
    }

    private static Integer convertToInteger(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                // Handle the case where the conversion fails
                return null; // or throw an exception, depending on your requirements
            }
        } else {
            return null; // or handle other data types as needed
        }
    }
}
