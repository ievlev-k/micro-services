package ru.itmo.orderserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payments", schema = "public")
public class Payment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "create_date")
    private String createDate;

    @NotNull(message = "status is mandatory")
    @Column(name = "status")
    private long status;

    @NotNull(message = "amount is mandatory")
    @Column(name = "amount")
    private long amount;

    @Column(name = "description")
    private String description;
}
