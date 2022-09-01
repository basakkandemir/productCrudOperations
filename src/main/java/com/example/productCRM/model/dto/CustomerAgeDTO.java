package com.example.productCRM.model.dto;

public class CustomerAgeDTO {
    private Integer age;
    private Long count;

    public CustomerAgeDTO(Integer age, Long count) {
        this.age = age;
        this.count = count;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
