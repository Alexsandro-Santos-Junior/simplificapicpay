package com.desafiopicpay.domain.user;

import com.desafiopicpay.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

// ... Entity ela representa uma entidade na tabela do banco de dados ...
@Entity(name = "users")
// ... Table representa uma tabela no banco de dados ...
@Table(name = "users")
// ... Getter do 'lombok'
@Getter
// ... Setter do 'lombok'
@Setter
// ... Cria o construtor que recebe todos parametros da classe ...
@AllArgsConstructor
// ... Definimos a chave primaria dessa entidade ...
@EqualsAndHashCode(of = "id")
public class User {
    // ... gerar de forma automatica pelo sistema o id ...
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // ... estamos definindo que esta coluna na tabela do banco de dados tem que ser unica pois é um documento e não pode se repetir!
    @Column(unique = true)
    private String document;
    // ... email unico
    @Column(unique = true)
    private String email;
    private String password;
    // ... saldo do usuario
    private BigDecimal balance;
    // ... esse enum representa um dos valores que passamos na classe `UserType` ...
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.email = data.email();

    }

}
