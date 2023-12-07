package com.example.servicevoiture;

import com.example.servicevoiture.Model.Client;
import com.example.servicevoiture.Model.Voiture;
import com.example.servicevoiture.Repository.ClientRepository;
import com.example.servicevoiture.Repository.VoitureRepository;
import com.example.servicevoiture.ClientService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceVoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceVoitureApplication.class, args);
	}
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {

		return args -> {
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);
			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Nom est :" + c1.getAge());
			System.out.println("**************************");
			voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", 1L, c2));
			voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
			voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));
		};
	}
/*		@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository cr, VoitureRepository vr){
		return args ->{
			cr.save(new Client(Long.parseLong("1"),"Taha Elasri",Float.parseFloat("23")));
			cr.save(new Client(Long.parseLong("2"),"Mohamed Lachgar",Float.parseFloat("22")));
			cr.save(new Client(Long.parseLong("3"),"Najahi saad",Float.parseFloat("21")));

			Client c1 = cr.findById(1L).orElse(null);
			Client c2 = cr.findById(2L).orElse(null);
			// Initialisation des voitures
			vr.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", 1L, c1));
			vr.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c1));
			vr.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c2));

		};
	}*/

}
