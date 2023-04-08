package org.sid.HospitalApp.repositories;

import org.sid.HospitalApp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationReposetory extends JpaRepository<Consultation,Long> {
}
