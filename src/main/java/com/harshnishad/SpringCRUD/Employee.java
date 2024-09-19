package com.harshnishad.SpringCRUD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //generates a constructor with no parameter
@AllArgsConstructor//generates a constructor requiring argument for every field in the annotated class
public class Employee {
    private long id;
    private String name;
    private String phone;
    private String email;

//-->no need to use below thing

//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getPhone(){
//        return phone;
//    }
//    public void setPhone(String phone){
//        this.phone = phone;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email = email;
//    }
}
