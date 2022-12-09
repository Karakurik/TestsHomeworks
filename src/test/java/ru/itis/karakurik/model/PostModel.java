package ru.itis.karakurik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostModel {

    @XmlElement(name = "title", required = true)
    private String title;

    @XmlElement(name = "content", required = true)
    private String content;
}
