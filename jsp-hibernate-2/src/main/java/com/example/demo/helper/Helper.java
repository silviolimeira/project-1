package com.example.demo.helper;

import javax.servlet.http.HttpServletRequest;
import com.example.demo.model.command.AtualizarDepartamento;
import com.example.demo.model.command.AtualizarFuncionario;
import com.example.demo.model.command.CadastrarDepartamento;
import com.example.demo.model.command.CadastrarFuncionario;
import com.example.demo.model.command.ConsultarDepartamento;
import com.example.demo.model.command.ConsultarFuncionario;
import com.example.demo.model.command.ExcluirDepartamento;
import com.example.demo.model.command.ExcluirFuncionario;
import com.example.demo.model.command.InterfaceCommand;
import com.example.demo.model.command.PesquisarFuncionario;

public class Helper {

    private HttpServletRequest request;

    public Helper(HttpServletRequest request) {
        super();
        this.request = request;
    }

    public InterfaceCommand getCommand() {

        String comando = request.getParameter("comando");

        if (comando == null || comando.equals("cadastrarDepartamento"))
            return new CadastrarDepartamento();
        if (comando.equals("consultarDepartamento"))
            return new ConsultarDepartamento();
        if (comando.equals("excluirDepartamento"))
            return new ExcluirDepartamento();
        if (comando.equals("atualizarDepartamento"))
            return new AtualizarDepartamento();
        if (comando.equals("cadastrarFuncionario"))
            return new CadastrarFuncionario();
        if (comando.equals("consultarFuncionario"))
            return new ConsultarFuncionario();
        if (comando.equals("excluirFuncionario"))
            return new ExcluirFuncionario();
        if (comando.equals("atualizarFuncionario"))
            return new AtualizarFuncionario();
        if (comando.equals("pesquisarFuncionario"))
            return new PesquisarFuncionario();

        return null;

    }

}
