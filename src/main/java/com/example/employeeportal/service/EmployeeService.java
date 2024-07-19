package com.example.employeeportal.service;

import com.example.employeeportal.model.Employee;
import com.example.employeeportal.repository.EmployeeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId().isEmpty()) {
            employee.setId(null);
        }
        return repository.save(employee);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }

    public void exportToExcel(HttpServletResponse response) throws IOException {
        List<Employee> employees = getAllEmployees();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employees");

        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Employee Code", "Employee Name", "Father Name", "Mobile No", "Date of Joining", "Date of Birth", "PAN No", "Aadhar No", "Address", "Official Mail", "Personal Mail",  "Work Status"};

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowIdx = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getEmpCode());
            row.createCell(2).setCellValue(employee.getEmpName());
            row.createCell(3).setCellValue(employee.getFatherName());
            row.createCell(4).setCellValue(employee.getMobileNo());
            row.createCell(5).setCellValue(employee.getDateOfJoining());
            row.createCell(6).setCellValue(employee.getDateOfBirth());
            row.createCell(7).setCellValue(employee.getPanNo());
            row.createCell(8).setCellValue(employee.getAadharNo());
            row.createCell(9).setCellValue(employee.getAddress());
            row.createCell(10).setCellValue(employee.getOfficialMail());
            row.createCell(11).setCellValue(employee.getPersonalMail());
            row.createCell(12).setCellValue(employee.getWorkStatus());
        }

        //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
