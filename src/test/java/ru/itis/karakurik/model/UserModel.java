package ru.itis.karakurik.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserModel {
    @XmlElement(name = "email", required = true)
    private String email;
    @XmlElement(name = "password", required = true)
    private String password;
    @XmlElement(name = "nickname", required = true)
    private String nickName;
}
