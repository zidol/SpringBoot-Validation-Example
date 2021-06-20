package com.example.validation.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

//    @Email
//    private String email;
//
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxxx")
//    private String  phoneNumber;
//
////    @Size(min = 6, max = 6)
//    //(pattern = "yyyyMM")
//    private String reqYearMonth; // yyyyMM;

    @Valid // 다른 객체 선언하면 어노테이션 추가해줘야함 그래야 Car에 선언된 어노테이션이 적용됨
    private List<Car> cars;

    public String getName() {
        return name;
    }



    //    @AssertTrue(message = "yyyyMM 의 형식에 맞지 않습니다.")//메소드명 is로 시작해야함
//    public boolean isReqYearMonthValidation() {
//        try {
//            LocalDate localDate = LocalDate.parse(this.reqYearMonth + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
