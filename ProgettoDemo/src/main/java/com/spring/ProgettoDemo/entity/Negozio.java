package com.spring.ProgettoDemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // entità persistente
@Table(name = "Negozi") // Nome del db
public class Negozio {
	@Id // chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincremento (database usando AUTO_INCREMENT)
	private Integer id;
			/*
			 * GenerationType.SEQUENCE Descrizione: Utilizza una sequenza di database per
			 * generare gli ID.
			 * 
			 * Funzionamento: JPA invoca una sequence database object, che restituisce un
			 * numero incrementale.
			 * 
			 * Richiede: Supporto alle sequenze da parte del database (es. PostgreSQL,
			 * Oracle).
			 * 
			 * Vantaggio: Ottimo per prestazioni e per il supporto del batch insert.
			 * GenerationType.TABLE Descrizione: Usa una tabella dedicata per memorizzare e
			 * aggiornare i valori della chiave primaria.
			 * 
			 * Funzionamento: Crea una tabella (es. hibernate_sequences) che tiene traccia
			 * dell’ultimo valore usato.
			 * 
			 * Compatibilità: Funziona con qualsiasi database (anche quelli che non
			 * supportano sequenze).
			 * 
			 * Contro: Più lento rispetto a IDENTITY e SEQUENCE. GenerationType.AUTO
			 * Descrizione: È la scelta predefinita. Lascia che sia JPA a decidere
			 * automaticamente la strategia migliore in base al database utilizzato.
			 * 
			 * Funzionamento:
			 * 
			 * Se usi MySQL, diventa IDENTITY.
			 * 
			 * Se usi PostgreSQL, può diventare SEQUENCE.
			 * 
			 * Se usi un database che non supporta sequenze, può diventare TABLE.
			 * 
			 */
	
			/*
			 * @NotNull Il campo non può essere null.
			 * 
			 * @NotBlank Il campo non può essere vuoto o solo spazi (valido per String).
			 * 
			 * @NotEmpty Il campo non può essere vuoto (valido per String, List, array,
			 * ecc).
			 * 
			 * @Size(min, max) Controlla la lunghezza minima e massima (Stringhe, liste,
			 * array).
			 * 
			 * @Email Verifica che il campo abbia un formato email valido.
			 * 
			 * @Min(value) Il valore minimo numerico ammesso.
			 * 
			 * @Max(value) Il valore massimo numerico ammesso.
			 * 
			 * @Pattern(regexp) Il campo deve rispettare una regex specifica.
			 * 
			 * @Positive Solo numeri positivi.
			 * 
			 * @Past, @Future La data deve essere nel passato o nel futuro.
			 */
	@NotBlank(message = "Il nome deve essere obbligatorio")
	@Size(min = 1, max = 30, message = "Il nome deve avere almeno 1 carattere e un massimo di 30")
	private String nome;
	@Email(message = "Email non valida")
	@NotBlank(message = "Email obbligatoria")
	private String email;
	@Size(min = 8, message = "La password deve avere almeno 8 caratteri")
	@NotBlank(message = "Email obbligatoria")
	private String password;
	@OneToMany(mappedBy = "negozio", cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
	// nome della colonna di join (cioè la foreign key) che verrà creata nel database
	private List<Prodotto> prodotti = new ArrayList<>();
	/*
			Un'entità è collegata a più istanze di un'altra entità.
			Esempio classico: un Negozio ha molti Prodotti.
			
			@ManyToOne – Molti a Uno
			Molte entità sono collegate a una singola istanza di un'altra entità.
			Esempio: molti Ordini sono associati a un Cliente.
			
			@OneToOne – Uno a Uno
			Un'entità è collegata a una sola istanza di un'altra entità.
			Esempio: un Utente ha una sola CartaIdentità.
			
			🔗 Relazione - Entità - Chiave Esterna
				@OneToMany → da Negozio a Prodotto → chiave esterna in Prodotto.
				
				@ManyToOne → da Prodotto a Negozio → chiave esterna in Prodotto.
				
				@OneToOne → da Utente a CartaIdentità → chiave esterna in Utente.
			
			📌 mappedBy
				Si usa solo nelle relazioni bidirezionali, cioè quando entrambe le entità si riferiscono tra loro.
				Se la relazione è unidirezionale (es. solo Ordine → Cliente), non serve mappedBy.
				
			🧾 Scenario Cliente - Ordine
				Un Cliente può avere più Ordini → @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL).
				Ogni Ordine appartiene a un Cliente → @ManyToOne @JoinColumn(name = "cliente_id").
				La chiave esterna cliente_id è gestita dalla tabella Ordine.
			
			🔄 FetchType
				FetchType.LAZY significa: "Carica l'entità collegata solo quando serve", cioè su accesso esplicito al campo.
				FetchType.EAGER significa: "Carica subito l'entità collegata, insieme a quella principale".
				

						 * 
						 */
	

	public Negozio() {
		// TODO Auto-generated constructor stub
	}

	public Negozio(Integer id,
			@NotBlank(message = "Il nome deve essere obbligatorio") @Size(min = 1, max = 30, message = "Il nome deve avere almeno 1 carattere e un massimo di 30") String nome,
			@Email(message = "Email non valida") @NotBlank(message = "Email obbligatoria") String email,
			@Size(min = 8, message = "La password deve avere almeno 8 caratteri") @NotBlank(message = "Email obbligatoria") String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public Negozio(Integer id,
			@NotBlank(message = "Il nome deve essere obbligatorio") @Size(min = 1, max = 30, message = "Il nome deve avere almeno 1 carattere e un massimo di 30") String nome,
			@Email(message = "Email non valida") @NotBlank(message = "Email obbligatoria") String email,
			@Size(min = 8, message = "La password deve avere almeno 8 caratteri") String password,
			ArrayList<Prodotto> prodotti) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.prodotti = prodotti;
	}

	public void addProdotto(Prodotto p) {
		this.prodotti.add(p);
	}

}
