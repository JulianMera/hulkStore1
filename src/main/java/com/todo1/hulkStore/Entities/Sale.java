package com.todo1.hulkStore.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
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

    public Sale(double total, Date date, User client) {
        this.total = total;
        this.date = date;
        this.client = client;

    }
}
