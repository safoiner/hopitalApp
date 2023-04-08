package org.sid.HospitalApp.repositories;

import org.sid.HospitalApp.entities.Patient;
import org.sid.HospitalApp.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<RendezVous,Long> {
}
