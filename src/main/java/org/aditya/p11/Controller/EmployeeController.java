package org.aditya.p11.Controller;

import org.aditya.p11.model.EmployeeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<EmployeeDetails> employeeList = new ArrayList<>();

    // CREATE
    @PostMapping("/post")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDetails employee) {
        employeeList.add(employee); // store in memory
        System.out.println("Received Employee: " + employee);
        return new ResponseEntity<>("Employee saved successfully!", HttpStatus.CREATED);
    }


    // READ - all
    @GetMapping
    public List<EmployeeDetails> getAllEmployees() {
        return employeeList;
    }

    // READ - by id
    @GetMapping("/{id}")
    public EmployeeDetails getEmployeeById(@PathVariable int id) {
        return employeeList.stream()
                .filter(e -> e.getEid() == id)
                .findFirst()


                .orElse(null);
    }

    @GetMapping("/{name}")
    public EmployeeDetails getEmployeeByName(@PathVariable String name) {
        return employeeList.stream()
               // .filter(e -> e.getName() == name)
                .filter(e -> e.getName().equalsIgnoreCase(name))

                .findFirst()


                .orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public EmployeeDetails updateEmployee(@PathVariable int id, @RequestBody EmployeeDetails updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEid() == id) {
                employeeList.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeList.removeIf(e -> e.getEid() == id);
        return "Employee removed with ID: " + id;
    }
}
