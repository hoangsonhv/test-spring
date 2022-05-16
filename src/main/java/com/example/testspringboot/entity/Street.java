package com.example.testspringboot.entity;

import com.example.testspringboot.enums.StreetStatus;
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
@Builder
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private StreetStatus status;
    private Integer districtId;
    @ManyToOne
    @JoinColumn(name = "districtId", insertable = false, updatable = false)
    private District district;
}
