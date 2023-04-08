package org.sid.HospitalApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNessance;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch =FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
