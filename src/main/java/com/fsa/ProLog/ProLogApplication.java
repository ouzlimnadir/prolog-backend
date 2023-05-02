package com.fsa.ProLog;

import com.fsa.ProLog.dao.*;
import com.fsa.ProLog.dto.request.ColisRequestDto;
import com.fsa.ProLog.dto.request.FactureColisRequestDto;
import com.fsa.ProLog.dto.request.PointRelaisRequestDto;
import com.fsa.ProLog.faker.UserFaker;
import com.fsa.ProLog.models.*;

import net.datafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class ProLogApplication {

    // Default admin  : admin@prolog.com admin123
    // First Customer : nadir@prolog.com pfe2023

    public static void main(String[] args) {
        SpringApplication.run(ProLogApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner commandLineRunner(UserDao userDao, ColisDao colisDao, FactureColisDao factureColisDao, VehiculeDao vehiculeDao, PointRelaisDao pointRelaisDao) {
        // TODO facker facture -> colis -> desti
        return args -> {
            // Initialisation de la base de donnée si elle n'existe pas
            Optional<User> user = userDao.findByEmail("admin@prolog.com");
            if(user.isEmpty()){
                // Creation de les premiers utilisateurs
                generateUsers(userDao);

                // Set up PointsRelais
                tousLesPoitsRelais(pointRelaisDao);

                // Generation d'autre données pour tests
                generateFakers(userDao,Role.MANAGER,5);
                generateFakers(userDao,Role.DRIVER,5);
                generateFakers(userDao,Role.CLIENT,10);

                // Creation des elements : Colis & Destinataire
                generatingColis(colisDao,factureColisDao,userDao,10);
            }




			
//
//			generatingVehicules(vehiculeDao, VehiculeType.FOURGON,10);
//			generatingVehicules(vehiculeDao, VehiculeType.FRIGOROFIQUE,5);
//			generatingVehicules(vehiculeDao, VehiculeType.PLATEAU,5);
//			generatingVehicules(vehiculeDao, VehiculeType.BENNE,2);

        };
    }

    private void generateUsers(UserDao userDao) {
        // Données Importants
        UserFaker userFaker = new UserFaker(userDao);
        userFaker.creatUser("super admin","admin@prolog.com","admin123","911",Role.ADMIN);
        userFaker.creatUser("mon gerant","manager@prolog.com","manager","06 12 34 56 78",Role.MANAGER);
        userFaker.creatUser("premier chauffeur","driver@prolog.com","driver","06 12 34 56 78",Role.DRIVER);
        userFaker.creatUser("Nadir Ouzlim","nadir@prolog.com","prolog2023","06 12 34 56 78",Role.CLIENT);
        userFaker.creatUser("Abdellah Fanidi","abdo@prolog.com","prolog2022","06 12 34 56 78",Role.CLIENT);
    }
    private void generateFakers(UserDao userDao, Role role, int lignes) {
        UserFaker userFaker = new UserFaker(userDao);
        Faker faker = new Faker();
        String fullname;
        String password;
        String email;
        String telephone;

        for (int i = 0; i < lignes; i++) {
            fullname = faker.name().fullName();
            password = faker.internet().password(9, 10);
            email = faker.internet().emailAddress();
            telephone = faker.phoneNumber().phoneNumber();

            userFaker.creatUser(fullname,email,password,telephone,role);
        }
    }

//        private void generatingVehicules(VehiculeDao vehiculeDao, VehiculeType type, int lignes) {
//        ModelMapper modelMapper = new ModelMapper();
//        VehiculeRequestDto vehiculeRequestDto;
//        Vehicule vehicule;
//        Faker faker = new Faker();
//
//        Integer volume;
//        String immatriculation;
//        String marque;
//        LocalDate fin_assurance;
//        LocalDate fin_vignette;
//        String[] lettre = {"A", "B", "C"};
//
//        for (int i = 0; i < lignes; i++) {
//            volume = faker.random().nextInt(10, 50);
//            immatriculation = faker.random().nextInt(10000, 99999) + lettre[faker.random().nextInt(0, 2)] + faker.random().nextInt(1, 70);
//            marque = faker.vehicle().model();
//            fin_assurance = LocalDate.now().plusDays(faker.number().numberBetween(180, 365));
//            fin_vignette = LocalDate.now().plusDays(faker.number().numberBetween(180, 365));
//
//            vehiculeRequestDto = new VehiculeRequestDto(type, volume, immatriculation, marque, fin_assurance, fin_vignette);
//            vehicule = modelMapper.map(vehiculeRequestDto, Vehicule.class);
//            vehiculeDao.save(vehicule);
//        }
//    }

    private static void generatingColis(ColisDao colisDao, FactureColisDao factureColisDao, UserDao userDao,int lignes) {
        // Client qui aura la liste des colis
        User user = userDao.findById(4)
                .orElse(null);

        ModelMapper modelMapper = new ModelMapper();
        ColisRequestDto colisRequestDto;
        Colis colis;
        Colis saved;
        Faker faker = new Faker();
        Random rand = new Random();
        int poids;
        int longueur;
        int largeur;
        int hauteur;
        boolean froid;
        boolean fragile;
        String adresse;
        
        Tracking trackingNumber = new Tracking();
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();

        Destinataire destinataire;
        String firstname;
        String lastname;
        String adresseD;
        String telephone;

        FactureColisRequestDto factureColisRequestDto;
        FactureColis factureColis;
        double prix;
        Date date;

        for (int i = 0; i < lignes; i++) {
            // Creation du colis
            poids = (rand.nextInt(181) + 20) * 10;
            longueur = (rand.nextInt(11) + 10) * 5;
            largeur = (rand.nextInt(11) + 10) * 5;
            hauteur = (rand.nextInt(11) + 10) * 5;
            froid = (rand.nextInt(2) % 2) == 0;
            fragile = (rand.nextInt(2) % 2) == 0;
            adresse = faker.address().fullAddress();
            
            // Creation de son Tracking
            for (int j = 0; j < 15; j++) {
                int index = rand.nextInt(ALPHA_NUMERIC_STRING.length());
                char randomChar = ALPHA_NUMERIC_STRING.charAt(index);
                builder.append(randomChar);
            }
            trackingNumber.setTrackingNumber(builder.toString());
            builder.delete(0, builder.length());

            // Creation de son destinataire
            firstname = faker.name().firstName();
            lastname = faker.name().lastName();
            telephone = faker.phoneNumber().phoneNumber();
            adresseD = faker.address().fullAddress();
            destinataire = new Destinataire(firstname,lastname,adresseD,telephone);

            // Creation facture
            prix = (((double) poids /10)+ (double) (hauteur * largeur * longueur * 2) /1000000)*(froid?1.3:1)*(fragile?1.2:1);
            prix = Math.round(prix * 100.0) / 100.0;

            date = new Date();
            
            // Save colis
            colisRequestDto = new ColisRequestDto(poids, largeur, longueur, hauteur, froid, fragile,false,false, trackingNumber,adresse, destinataire);
            colis = modelMapper.map(colisRequestDto, Colis.class);
            saved = colisDao.save(colis);

            // Save facture Colis
            factureColisRequestDto = new FactureColisRequestDto(prix, date, user, saved);
            factureColis = modelMapper.map(factureColisRequestDto, FactureColis.class);
            factureColisDao.save(factureColis);
        }

    }

    private static void tousLesPoitsRelais(PointRelaisDao pointRelaisDao) {
        String[] villes = {"Agadir","Marrakesh","Casablanca","Rabat","Tanger"};
        String[] adresses = {"cite Dakhla","Derb Assehbi","Boulevard Zerktouni","Rue Chellah","Rue de La Liberte"};

        ModelMapper modelMapper = new ModelMapper();
        
        PointRelaisRequestDto pointRelaisRequestDto;
        PointRelais pointRelais;
        for(int i=0; i<5; i++) {
            pointRelaisRequestDto = new PointRelaisRequestDto(villes[i], adresses[i]);
            pointRelais = modelMapper.map(pointRelaisRequestDto, PointRelais.class);
            pointRelaisDao.save(pointRelais);
        }
    }
}