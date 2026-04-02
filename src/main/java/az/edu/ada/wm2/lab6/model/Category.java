package az.edu.ada.wm2.lab6.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    // Many-to-many relationship with Product
    // Product is the owner of the relationship
    @ToString.Exclude
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    // Convenience constructor without products
    public Category(String name) {
        this.name = name;
    }
}