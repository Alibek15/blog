package org.me.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client", schema = "public", catalog = "postgres")
public class User extends BaseEntity {



    private String email;
    @Basic
    @Column(name = "full_name")
    private String fullName;

    private String password;

}
