package com.projeto.academia.security;

import com.projeto.academia.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--- INICIO DO FILTRO DE SEGURANÇA ---");
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            System.out.println("1. Token encontrado no cabeçalho: " + tokenJWT.substring(0, 10) + "...");
            try {
                var subject = tokenService.getSubject(tokenJWT);
                System.out.println("2. Token válido! Usuário (Subject): " + subject);

                var usuario = repository.findByEmail(subject).orElse(null);

                if (usuario != null) {
                    System.out.println("3. Usuário encontrado no banco: " + usuario.getUsername());
                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("4. Usuário autenticado com sucesso no Contexto do Spring!");
                } else {
                    System.out.println("3. ERRO: Token válido, mas usuário não existe mais no banco!");
                }
            } catch (Exception e) {
                System.out.println("2. ERRO ao validar token: " + e.getMessage());
            }
        } else {
            System.out.println("1. AVISO: Nenhum token enviado na requisição.");
        }

        System.out.println("--- FIM DO FILTRO ---");
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "").trim();
        }
        return null;
    }
}