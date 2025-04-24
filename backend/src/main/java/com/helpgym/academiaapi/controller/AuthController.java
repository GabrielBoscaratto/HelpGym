package com.helpgym.academiaapi.controller;

import com.helpgym.academiaapi.dto.JwtResponseDTO;
import com.helpgym.academiaapi.dto.LoginDTO;
import com.helpgym.academiaapi.dto.RegistroDTO;
import com.helpgym.academiaapi.model.Usuario;
import com.helpgym.academiaapi.repository.UsuarioRepository;
import com.helpgym.academiaapi.security.JwtTokenUtil;
import com.helpgym.academiaapi.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(
            @Lazy AuthenticationManager authenticationManager,
            JwtTokenUtil jwtTokenUtil,
            JwtUserDetailsService userDetailsService,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) throws Exception {
        try {
            authenticate(loginDTO.getEmail(), loginDTO.getSenha());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
            final String token = jwtTokenUtil.generateToken(userDetails);

            Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail()).orElseThrow();

            return ResponseEntity.ok(new JwtResponseDTO(
                    token,
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    "Login bem-sucedido"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(new JwtResponseDTO(
                    null, null, null, null, "Credenciais inválidas"
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegistroDTO registroDTO) {
        // Verifica se o email já existe
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            return ResponseEntity.badRequest().body(new JwtResponseDTO(
                    null, null, null, null, "Email já cadastrado"
            ));
        }

        // Cria o novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(registroDTO.getNome());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(registroDTO.getSenha()));

        Usuario novoUsuario = usuarioRepository.save(usuario);

        // Gera o token JWT
        final UserDetails userDetails = userDetailsService.loadUserByUsername(novoUsuario.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDTO(
                token,
                novoUsuario.getId(),
                novoUsuario.getNome(),
                novoUsuario.getEmail(),
                "Usuário registrado com sucesso"
        ));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("Usuário desativado", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciais inválidas", e);
        }
    }
}
