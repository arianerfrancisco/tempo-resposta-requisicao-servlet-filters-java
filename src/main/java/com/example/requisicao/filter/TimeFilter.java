package com.example.requisicao.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;

@WebFilter(filterName = "TimeFilter", value = "/*")

// Nota: /* irá interceptar todas as URLs acessadas

public class TimeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request; // Casting Explicito
        // HttpServletRequest é uma subclasse de ServletRequest, precisa efetuar casting
        // para que torne possivel utilizar metodos de HttpServletRequest

        long inicio = System.currentTimeMillis();

        chain.doFilter(request, response);

        long fim = System.currentTimeMillis();

        long time = fim - inicio;

        FileWriter fw = new FileWriter("C:/JavaWeb/time.txt", true);
        // true - indica que o arquivo será aberto em modo apppend
        // Append - garante que se o arquivo já contiver conteúdo este não será sobrescrito
        // e sim incrementado
        fw.write("URI: " + req.getRequestURI() + ": " + time + "ms");
        fw.write(System.getProperty("line.separator"));
        fw.close();
    }
}
