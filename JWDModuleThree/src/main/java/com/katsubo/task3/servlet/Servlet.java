package com.katsubo.task3.servlet;

import com.katsubo.task3.bean.Device;
import com.katsubo.task3.controller.Controller;
import com.katsubo.task3.controller.ControllerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = ControllerImpl.getInstance();
        controller.parseFile(req.getParameter("parser"));

        List<Device> devices = controller.getBeans();

        req.setAttribute("devices", devices);
        doGet(req, resp);
    }
}
