package com.example.testspringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Integer district_id;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "district_id", insertable = false ,updatable = false)
    private District district;
    @CreatedDate
    private LocalDateTime createdAt;
    private int status;
}
