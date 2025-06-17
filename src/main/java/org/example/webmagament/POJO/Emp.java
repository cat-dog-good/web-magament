package org.example.webmagament.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用户表
public class Emp {
        private Integer id;
        private String workNo;
        private String name;
        private String gender;
        private Short age;
        private String idCard;
}
