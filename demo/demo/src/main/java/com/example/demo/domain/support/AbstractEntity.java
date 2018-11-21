package com.example.demo.domain.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString
@EqualsAndHashCode(of = {"id"})
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public long getId() {
        return id;
    }

    public AbstractEntity setId(long id) {
        this.id = id;
        return this;
    }

    @JsonIgnore
    public String getFormattedCreateDate() {
        return getFormattedDate(createdAt, "yyyy.MM.dd HH:mm:ss");
    }

    @JsonIgnore
    public String getFormattedModifiedDate() {
        return getFormattedDate(updatedAt, "yyyy.MM.dd HH:mm:ss");
    }

    private String getFormattedDate(LocalDateTime dateTime, String format) {
        if(dateTime == null) {
            return "";
        }
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }
}
