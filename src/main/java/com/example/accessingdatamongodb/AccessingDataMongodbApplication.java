package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private SongRepository songRepo;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	// What do the three dots mean in Java?
	// https://stackoverflow.com/questions/3158731/what-do-the-three-dots-mean-in-java
	// They are used to specify that the method can take a variable number of
	// arguments.

	public void run(String... args) throws Exception {
		// Why should I start with deleting all documents in a collection?
		// https://stackoverflow.com/questions/23559871/why-should-i-start-with-deleting-all-documents-in-a-collection

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		getSongsFromFile("songs.txt");
	}

	public void getSongsFromFile(String filePath) {
		try {
			// Is Paths.get("songs.txt") correct to get the path of a file in the same directory?
			// https://stackoverflow.com/questions/2833853/is-paths-getsongs-txt-correct-to-get-the-path-of-a-file-in-the-same-directory
			//
			
			List<Song> songs = Files.lines(Paths.get("src/main/java/com/example/accessingdatamongodb/songs.txt"))
					.map(line -> line.split("-"))
					// .map(arr -> new String[] { arr[0].trim(), arr[1].trim() })
					.map(arr -> new Song(arr[1].trim(), new Artist(arr[0].trim())))
					.collect(Collectors.toList());
			// Print songs to stdout
			songs.forEach(song -> System.out.println(song));
			songRepo.saveAll(songs);
			// songRepo.save(new Song("Song 1", new Artist("Artist 1")));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
