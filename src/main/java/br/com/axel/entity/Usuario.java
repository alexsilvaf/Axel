package br.com.axel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Length(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    @NotNull(message = "O nome é obrigatório")
    private String nome;

    @Length(max = 64, message = "O sobrenome deve ter no máximo 64 caracteres")
    @NotNull(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @Length(max = 256, message = "O email deve ter no máximo 256 caracteres")
    @NotNull(message = "O email é obrigatório")
    private String email;

    @Length(min = 11, max = 11, message = "O CPF deve ter 11 caracteres")
    @NotNull(message = "O CPF é obrigatório")
    @NumberFormat(pattern = "###.###.###-##")
    private Integer cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O endereço é obrigatório")
    @Length(max = 256, message = "O endereço deve ter no máximo 256 caracteres")
    private String endereco;

    @Length(max = 16, message = "O usuário deve ter no máximo 16 caracteres")
    @NotNull(message = "O usuário é obrigatório")
    private String usuario;

    @Length(max = 20, message = "A senha deve ter no máximo 20 caracteres")
    @NotNull(message = "A senha é obrigatória")
    private String senha;

    @OneToOne(mappedBy = "usuario")
    private Carrinho carrinho;

}
