package com.projeto.academia.infra.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class RequestLogFilter implements Filter {

    private static final String CORRELATION_ID_KEY = "correlation-id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String correlationId = UUID.randomUUID().toString();
        MDC.put(CORRELATION_ID_KEY, correlationId);

        try {
            long startTime = System.currentTimeMillis();
            log.info("[{}] INICIO DA REQUISICAO: {} {}", correlationId, req.getMethod(), req.getRequestURI());

            chain.doFilter(request, response);

            long duration = System.currentTimeMillis() - startTime;
            log.info("[{}] FIM DA REQUISICAO: {} {} - Status: {} (Tempo: {}ms)",
                    correlationId, req.getMethod(), req.getRequestURI(), res.getStatus(), duration);

        } finally {
            MDC.remove(CORRELATION_ID_KEY);
        }
    }
}