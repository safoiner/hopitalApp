package org.sid.HospitalApp;

import org.sid.HospitalApp.entities.Medecin;
import org.sid.HospitalApp.entities.Patient;
import org.sid.HospitalApp.entities.RendezVous;
import org.sid.HospitalApp.entities.StatusRDV;
import org.sid.HospitalApp.repositories.MedecinRepository;
import org.sid.HospitalApp.repositories.PatientRepository;
import org.sid.HospitalApp.repositories.RendezvousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppApplication.class, args);
	}

	@Bean
	CommandLineRunner CLR(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezvousRepository rendezvousRepository){
		return args ->  {


			Stream.of("mohamed","youssef","merry")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNessance(
								new Date()
						);
						patient.setMalade(false);
						patientRepository.save(patient);
					});

			Stream.of("achiki","mossafir","Hajji")
					.forEach(name->{
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecin.setEmail(name + "@hopital_H2.gov.ma");
						medecinRepository.save(medecin);
					});


			//une methohe de creation
			// patientRepository.save(new Patient(null,"el haj",new Date(),false,null));


//			 autre methode de creation et sauvgare du patient injectable au demmarage de l'application
//			Patient patient = new Patient();
//			patient.setNom("el haj");
//			patient.setDateNessance(
//					new Date()
//			);
//			patient.setMalade(false);
//			patientRepository.save(patient);


			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom(" ");
			Medecin medecin = new Medecin();
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatusRDV(StatusRDV.CANCELED);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient1);
//			rendezvousRepository.save(rendezVous);


		};
	}
}
