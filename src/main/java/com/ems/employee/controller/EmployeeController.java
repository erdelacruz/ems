package com.ems.employee.controller;

import java.sql.ResultSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.commons.exception.EntityAlreadyExistException;
import com.ems.commons.exception.EntityNotFoundException;
import com.ems.employee.controller.validation.CreateAndUpdateEmployeeFormValidator;
import com.ems.employee.controller.validation.SearchEmployeeFormValidator;
import com.ems.employee.domain.dto.EmployeeDTO;
import com.ems.employee.domain.dto.EmployeeIdDTO;
import com.ems.employee.domain.dto.SearchEmployeeDTO;
import com.ems.employee.service.EmployeeService;
import com.ems.employee.service.RoleService;

@Controller
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SearchEmployeeFormValidator searchValidator;
	@Autowired
	private CreateAndUpdateEmployeeFormValidator employeeValidator;
	
	/*** VIEWING OF SEARCH FORM HANDLER 
	 * SERVED AS HOME PAGE
	 * **/
    @RequestMapping(value={"/Home","/"},method=RequestMethod.GET)
    public String searchEmployee(Model model) {
        model.addAttribute("SearchEmployeeForm", new SearchEmployeeDTO());
        model.addAttribute("BatchDeleteEmployeeForm", new EmployeeIdDTO());
    	model.addAttribute("roles", roleService.getAll());
        model.addAttribute("listOfEmployees", employeeService.getAll());
        return "SearchEmployeePage";
    }
    
    /*** SEARCH EXECUTION HANDLER **/
    @RequestMapping(value="/ExecuteSearchEmployee", method=RequestMethod.POST)
    public String executeSearchEmployee(@ModelAttribute("SearchEmployeeForm") SearchEmployeeDTO query,BindingResult result,Model model) {
    	
    	model.addAttribute("BatchDeleteEmployeeForm", new EmployeeIdDTO());
    	model.addAttribute("roles", roleService.getAll());
    	
    	searchValidator.validate(query, result);
    	if(result.hasErrors()){
    		model.addAttribute("listOfEmployees", employeeService.getAll());
    		return "SearchEmployeePage";
    	}
    	
    	
    	List<EmployeeDTO> results =employeeService.getEmployeeBy(query);
    	if(results.size()>=1){
    		model.addAttribute("listOfEmployees", results);
    	}else{
    		model.addAttribute("errorMessage","No employee record found.");
    	}
    	
    	
        return "SearchEmployeePage";
    }
    
    /*** VIEWING OF ADD/CREATE EMPLOYEE FORM HANDLER **/
    @RequestMapping(value="/AddEmployee", method=RequestMethod.GET)
    public String AddEmployee(Model model) {
        model.addAttribute("AddOrUpdateEmployeeForm", new EmployeeDTO());
        model.addAttribute("BatchDeleteEmployeeForm", new EmployeeIdDTO());
        model.addAttribute("roles", roleService.getAll());
        return "AddEmployeePage";
    }
    
    /*** VIEWING OF UPDATE/EDIT EMPLOYEE FORM HANDLER **/
    @RequestMapping(value="/UpdateEmployee", method=RequestMethod.GET)
    public String UpdateEmployee(@RequestParam("id") Long id ,Model model) {
    	
    	EmployeeDTO existingEmployee = null;
		try {
			existingEmployee = employeeService.getById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	model.addAttribute("employee", existingEmployee);
        model.addAttribute("AddOrUpdateEmployeeForm", new EmployeeDTO());
        model.addAttribute("roles", roleService.getAll());
        return "UpdateEmployeePage";
    }
    
    /*** ADD AND UPDATE EXECUTION HANDLER 
     * @throws  **/
    @RequestMapping(value="/ExecuteAddorUpdateEmployee", method=RequestMethod.POST)
    public String executeAddorUpdateEmployee(@ModelAttribute("AddOrUpdateEmployeeForm")EmployeeDTO employee,BindingResult result,Model model)  {
    	
    	employeeValidator.validate(employee, result);
    	if(result.hasErrors()){
    		if(employee.getId()==null){
    			 model.addAttribute("roles", roleService.getAll());
    			return "AddEmployeePage";
    		}else{
    			try {
					employee = employeeService.getById(employee.getId());
				} catch (EntityNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			model.addAttribute("employee",employee );
    			return "UpdateEmployeePage";
    		}
    	}
    	
    	try {
    		
			employeeService.saveOrUpdate(employee);
			
			model.addAttribute("successMessage",(employee.getId()!=null?"The Employee record of <b>"+employee.getFullname()+"</b> has been updated.":"New employee <b>"+employee.getFullname()+"</b> has been created."));
		} catch (EntityAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMessage",employee.getFullname()+ "is already existed.");
			return searchEmployee(model);
		}
        
    	return searchEmployee(model);
    }
    
    /*** DELETE EXECUTION HANDLER **/
    @RequestMapping(value="/DeleteEmployee", method=RequestMethod.GET)
    public String executeDeleteEmployee(@RequestParam("id") Long id ,Model model) {
    	
		try {
			String employeeName = employeeService.getById(id).getFullname();
			employeeService.deleteById(id);
			model.addAttribute("successMessage","Employee Record of <b>"+employeeName+"</b> has been deleted.");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return searchEmployee(model);
    }
    
    
    /*** BATCH DELETE EXECUTION HANDLER **/
    @RequestMapping(value="/ExecuteBatchDeleteEmployee", method=RequestMethod.POST)
    public String executeBatchDeleteEmployee(@ModelAttribute EmployeeIdDTO employeeIds,Model model) {
    	
    	if(employeeIds.getIds()!=null&&employeeIds.getIds().size()>=1){
    		for(Long id:employeeIds.getIds()){
    			try {
					employeeService.deleteById(id);
				} catch (EntityNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		model.addAttribute("successMessage",employeeIds.getIds().size()+" employee records has been deleted.");
    	}else{
    		model.addAttribute("errorMessage","Kindly select at least one employee record.");
    	}
		
    	
		return searchEmployee(model);
    }

    
	


    
    
}
