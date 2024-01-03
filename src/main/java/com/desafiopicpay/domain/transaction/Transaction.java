package com.desafiopicpay.domain.transaction;

import com.desafiopicpay.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// ... evitar usar palavras reservadas pelos sistemas exemplo 'transaction' é reservada então se usa o plural ...
@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    // ... estamos criando uma relação na tabela 'User' e estamos dizendo que esta relação é de muitos para um, significa que um usuario pode ter varias transações porem uma transação so pode ter um sender e um receiver
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    private LocalDateTime timestamp;

}
