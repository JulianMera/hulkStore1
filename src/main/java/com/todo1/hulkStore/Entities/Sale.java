package com.todo1.hulkStore.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(columnDefinition = "DATE")
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH ,fetch = FetchType.EAGER)
    private User client;

    private Double total;

    @Autowired
    public Sale(Date date, User client, Double total) {
        this.date = date;
        this.client = client;
        this.total = total;
    }
}
