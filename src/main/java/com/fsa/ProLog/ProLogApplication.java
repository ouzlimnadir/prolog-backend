package com.fsa.ProLog;

import com.fsa.ProLog.dao.ColisDao;
import com.fsa.ProLog.dao.UserDao;
import com.fsa.ProLog.dao.VehiculeDao;
import com.fsa.ProLog.dto.request.ColisRequestDto;
import com.fsa.ProLog.dto.request.UserRequestDto;
import com.fsa.ProLog.dto.request.VehiculeRequestDto;
import com.fsa.ProLog.models.*;

import net.datafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@SpringBootApplication
public class ProLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProLogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner commandLineRunner(UserDao userDao, ColisDao colisDao, VehiculeDao vehiculeDao){
		return args -> {
			generatingUsers(userDao,Role.ADMIN,2);
			generatingUsers(userDao,Role.CLIENT,20);
			generatingUsers(userDao,Role.MANAGER,10);
			generatingUsers(userDao,Role.DRIVER,10);

			generatingColis(colisDao,30);

			generatingVehicules(vehiculeDao, VehiculeType.FOURGON,10);
			generatingVehicules(vehiculeDao, VehiculeType.FRIGOROFIQUE,5);
			generatingVehicules(vehiculeDao, VehiculeType.PLATEAU,5);
			generatingVehicules(vehiculeDao, VehiculeType.BENNE,2);

		};
	}

	private void generatingVehicules(VehiculeDao vehiculeDao, VehiculeType type, int lignes) {
		ModelMapper modelMapper = new ModelMapper();
		VehiculeRequestDto vehiculeRequestDto;
		Vehicule vehicule;
		Faker faker = new Faker();

		Integer volume;
		String immatriculation;
		String marque;
		LocalDate fin_assurance;
		LocalDate fin_vignette;
		String[] lettre = {"A","B","C"};

		for(int i=0; i<lignes; i++){
			volume = faker.random().nextInt(10,50);
			immatriculation = faker.random().nextInt(10000,99999)+lettre[faker.random().nextInt(0,2)]+faker.random().nextInt(1,70);
			marque = faker.vehicle().model();
			fin_assurance = LocalDate.now().plusDays(faker.number().numberBetween(180, 365));
			fin_vignette = LocalDate.now().plusDays(faker.number().numberBetween(180, 365));

			vehiculeRequestDto = new VehiculeRequestDto(type,volume,immatriculation,marque,fin_assurance,fin_vignette);
			vehicule = modelMapper.map(vehiculeRequestDto, Vehicule.class);
			vehiculeDao.save(vehicule);
		}
	}

	private static void generatingColis(ColisDao colisDao, int lignes) {
		ModelMapper modelMapper = new ModelMapper();
		ColisRequestDto colisRequestDto;
		Colis colis;
		Faker faker = new Faker();
		Random rand = new Random();
		Integer poids;
		Integer longueur;
		Integer largeur;
		Integer hauteur;
		Boolean froid;
		Boolean fragile;
		Integer trackingNumber;

		for(int i=0; i<lignes; i++){
			poids = (rand.nextInt(181)+20)*10;
			longueur = (rand.nextInt(11)+10)*10;
			largeur = (rand.nextInt(11)+10)*10;
			hauteur = (rand.nextInt(11)+10)*10;
			froid = (rand.nextInt(2) % 2) == 0;
			fragile = (rand.nextInt(2) % 2) == 0;
			trackingNumber = faker.random().nextInt(25000,30000);

			colisRequestDto = new ColisRequestDto(poids,largeur,longueur,hauteur,froid,fragile,trackingNumber);
			colis = modelMapper.map(colisRequestDto, Colis.class);
			colisDao.save(colis);
		}

	}

	private static void generatingUsers(UserDao userDao, Role role, Integer lignes) {
		ModelMapper modelMapper = new ModelMapper();
		Faker faker = new Faker();
		String username;
		String password;
		String email;
		String telephone;
		UserRequestDto userRequestDto;
		User user;

		for(int i=0; i<lignes; i++){
			username = faker.name().username();
			password = faker.internet().password(9,10);
			email = faker.internet().emailAddress();
			telephone = faker.phoneNumber().cellPhone();

			userRequestDto = new UserRequestDto(username,password,email,telephone,role);
			user = modelMapper.map(userRequestDto, User.class);
			userDao.save(user);
		}
	}

}
