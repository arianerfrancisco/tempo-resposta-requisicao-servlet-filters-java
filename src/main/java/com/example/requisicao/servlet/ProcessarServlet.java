package com.example.requisicao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//localhost:8080/requisicao_war_exploded/Processar
@WebServlet(name = "ProcessarServlet", value = "/Processar")
public class ProcessarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = null;

        try {
            out = response.getWriter();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            out.print("Processamento Realizado!");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}