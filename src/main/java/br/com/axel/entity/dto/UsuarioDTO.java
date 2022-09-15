package br.com.axel.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class UsuarioDTO {

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

    @Length(min = 14, max = 14, message = "O CPF deve ter 11 caracteres")
    @NotNull(message = "O CPF é obrigatório")
    @NumberFormat(pattern = "###.###.###-##")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O endereço é obrigatório")
    @Length(max = 256, message = "O endereço deve ter no máximo 256 caracteres")
    private String endereco;

    @Length(max = 16, message = "O usuário deve ter no máximo 16 caracteres")
    @NotNull(message = "O usuário é obrigatório")
    private String usuario;

    @Length(min = 8, max = 20, message = "A senha deve ter no mínimo 8 caracteres e no máximo 20 caracteres")
    @NotNull(message = "A senha é obrigatória")
    private String senha;
}
