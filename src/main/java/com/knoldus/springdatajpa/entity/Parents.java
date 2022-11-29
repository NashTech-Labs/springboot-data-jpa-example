package com.knoldus.springdatajpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "parents_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "parents_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "parents_mobile")
        )


})
public class Parents {

    private String name;
    private String email;
    private String mobile;

}
