package com.example.Nastolki.Entities;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

import java.sql.Timestamp;

@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    private Integer operation_id;
    @Column(name = "time_issuance")
    private Timestamp time_issuance;
    @Column(name = "time_deadline")
    private Timestamp time_deadline;
    @Column(name = "time_return")
    private Timestamp time_return;

    @ManyToOne
    @JoinColumn(name = "person_id",foreignKey = @ForeignKey(name = "operations_person_id_fkey"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "operator_id",foreignKey = @ForeignKey(name = "operations_operator_id_fkey"))
    public Person operator;
    @ManyToOne
    @JoinColumn(name = "game_id",foreignKey = @ForeignKey(name = "operations_game_id_fkey"))
    public Bord_game bordGame;

    public Operations() {
    }

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Timestamp getTime_issuance() {
        return time_issuance;
    }

    public void setTime_issuance(Timestamp time_issuance) {
        this.time_issuance = time_issuance;
    }

    public Timestamp getTime_deadline() {
        return time_deadline;
    }

    public void setTime_deadline(Timestamp time_deadline) {
        this.time_deadline = time_deadline;
    }

    public Timestamp getTime_return() {
        return time_return;
    }

    public void setTime_return(Timestamp time_return) {
        this.time_return = time_return;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getOperator() {
        return operator;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }

    public Bord_game getBordGame() {
        return bordGame;
    }

    public void setBordGame(Bord_game bordGame) {
        this.bordGame = bordGame;
    }
}
