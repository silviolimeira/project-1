package com.example.demo.model.command;

import com.example.demo.model.bean.Departamento;
import com.example.demo.model.dao.HibernateDAO;
import com.example.demo.model.dao.InterfaceDAO;
import com.example.demo.util.HibernateUtil;
import org.apache.cxf.transport.commons_text.StringEscapeUtils;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarDepartamento implements InterfaceCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Departamento departamento = new Departamento();

        departamento.setNomDep(request.getParameter("nome"));
        departamento.setTelDep(request.getParameter("telefone"));
        try {
            if (departamento.isValido()) {
                InterfaceDAO<Departamento> deparamentoDAO = new
                        HibernateDAO<Departamento>(Departamento.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
                deparamentoDAO.salvar(departamento);
                request.setAttribute("mensagem", "Departamento " + departamento.getNomDep() + " gravado com sucesso.");
            } else if (request.getMethod().equalsIgnoreCase("post")) {
                //request.setAttribute("mensagem", "Preencha os campos obrigatórios");
            }
        } catch (Exception e) {
            request.setAttribute("mensagem", "Problemas com a gravação: " + e.getMessage());
            e.printStackTrace();
        }
        return "cadastro_departamento.jsp";
    }
}
