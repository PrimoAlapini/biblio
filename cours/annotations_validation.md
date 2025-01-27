
Voici les annotations de validation les plus couramment utilisées dans Spring, provenant du package `javax.validation` ou `jakarta.validation`, et comment elles peuvent être appliquées pour valider des champs dans tes DTOs :

### 1. **@NotNull**
- Indique qu'un champ ne peut pas être `null`.
- Utilisé sur les types d'objet, mais pas sur les types primitifs (car ceux-ci ne peuvent jamais être `null`).
  
  **Exemple :**
  ```java
  @NotNull(message = "Le titre ne peut pas être nul.")
  private String title;
  ```

### 2. **@NotEmpty**
- S'applique aux types `String`, `Collection`, `Map` ou `Array`.
- Vérifie que le champ n'est ni `null` ni vide (`""` pour `String`, ou de taille zéro pour les collections).
  
  **Exemple :**
  ```java
  @NotEmpty(message = "Le titre ne peut pas être vide.")
  private String title;
  ```

### 3. **@NotBlank**
- Similaire à `@NotEmpty`, mais pour les chaînes de caractères, il vérifie en plus qu'il ne s'agit pas d'une chaîne composée uniquement d'espaces.
  
  **Exemple :**
  ```java
  @NotBlank(message = "Le nom d'auteur ne peut pas être vide ou blanc.")
  private String author;
  ```

### 4. **@Size**
- Contraint la taille des champs `String`, `Collection`, `Map` ou `Array`.
- Permet de définir une taille minimale et/ou maximale.

  **Exemple :**
  ```java
  @Size(min = 1, max = 100, message = "Le titre doit contenir entre 1 et 100 caractères.")
  private String title;
  ```

### 5. **@Pattern**
- Contraint une chaîne de caractères à correspondre à une expression régulière (regex).
  
  **Exemple :**
  ```java
  @Pattern(regexp = "^[0-9]{13}$", message = "L'ISBN doit comporter exactement 13 chiffres.")
  private String isbn;
  ```

### 6. **@Min** / **@Max**
- Contraint la valeur numérique d'un champ à une valeur minimale ou maximale. Utilisable sur des types numériques comme `int`, `long`, etc.

  **Exemple :**
  ```java
  @Min(value = 1, message = "Le prix minimum doit être au moins 1.")
  @Max(value = 1000, message = "Le prix ne peut pas dépasser 1000.")
  private int price;
  ```

### 7. **@Email**
- Valide qu'une chaîne est une adresse email bien formée.

  **Exemple :**
  ```java
  @Email(message = "Veuillez entrer une adresse email valide.")
  private String email;
  ```

### 8. **@Past** / **@PastOrPresent**
- Valide que la date est dans le passé (ou au présent).

  **Exemple :**
  ```java
  @Past(message = "La date de naissance doit être dans le passé.")
  private LocalDate birthDate;
  ```

### 9. **@Future** / **@FutureOrPresent**
- Valide que la date est dans le futur (ou au présent).

  **Exemple :**
  ```java
  @Future(message = "La date d'expiration doit être dans le futur.")
  private LocalDate expirationDate;
  ```

### 10. **@Positive** / **@PositiveOrZero**
- Valide que la valeur est positive ou positive/égale à zéro.
  
  **Exemple :**
  ```java
  @Positive(message = "Le prix doit être supérieur à zéro.")
  private int price;
  ```

### 11. **@Negative** / **@NegativeOrZero**
- Valide que la valeur est négative ou négative/égale à zéro.

  **Exemple :**
  ```java
  @Negative(message = "Le montant de la dette doit être négatif.")
  private int debt;
  ```

---

### **Validation complète dans un DTO :**
Voici comment combiner plusieurs de ces annotations dans un DTO pour s'assurer que les données fournies sont correctes.

```java
public class BookDTO {

    @NotNull(message = "Le titre est obligatoire.")
    @Size(min = 1, max = 100, message = "Le titre doit contenir entre 1 et 100 caractères.")
    private String title;

    @NotBlank(message = "Le nom de l'auteur ne peut pas être vide ou blanc.")
    private String author;

    @NotNull(message = "Le champ ISBN est obligatoire.")
    @Pattern(regexp = "^[0-9]{13}$", message = "L'ISBN doit comporter 13 chiffres.")
    private String isbn;

    @PositiveOrZero(message = "Le prix doit être positif ou égal à zéro.")
    private double price;

    @Email(message = "Veuillez fournir une adresse email valide pour l'auteur.")
    private String authorEmail;
}
```

Avec ces annotations, dès que tu envoies des données à ce DTO via une requête HTTP, Spring va valider ces données avant de les accepter.


