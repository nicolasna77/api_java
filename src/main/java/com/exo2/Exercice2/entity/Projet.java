package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "projet", indexes = {
        @Index(name = "index_nom_projet", columnList = "nom_projet")
}
)
@Data
@BatchSize(size = 10)

@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projet_id")
    private Long id;

    @Column(name = "nom_projet")
    private String nomProjet;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @BatchSize(size = 10)
    @JoinTable(name = "etudiant_projet", joinColumns = @JoinColumn(name = "projet_id"), inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;
}
