package com.example.demo.filtro;

import org.apache.cxf.transport.commons_text.StringEscapeUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//ref: https://www.codejava.net/java-ee/servlet/webfilter-annotation-examples
@WebFilter("/*")
public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        // Respect the client-specified character encoding
        // (see HTTP specification section 3.4.1)
//        String mensagem = request.getParameter("mensagem");
//        if (null != mensagem) {
//            mensagem = StringEscapeUtils.escapeHtml4(mensagem);
//            request.setAttribute("mensagem", mensagem);
//        }
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }

        // Set the default response content type and encoding
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }

    public void destroy() {
    }
}