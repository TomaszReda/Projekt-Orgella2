package pl.orgella.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Length(min =10,max = 45,message = "{pl.orgella.model.product.length.10-45.message}")
    private String header;

    @Length(min =10,max = 1000,message = "{pl.orgella.model.product.length.10-1000.message}")
    private String opis;

    @Min(value = 1,message ="{pl.orgella.model.product.min.1.message}")
    private double cena;

    private String kategoria;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Zdjecia> zdjeciaSet=new ArrayList<>();


}