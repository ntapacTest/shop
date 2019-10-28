package com.example.shop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class SystemDictionary{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date added;

    @Column(name="isActive")
    private Boolean isActive=true;
}
