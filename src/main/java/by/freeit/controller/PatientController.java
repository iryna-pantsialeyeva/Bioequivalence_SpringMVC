package by.freeit.controller;

import by.freeit.model.Patient;
import by.freeit.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllPatients(Model model) {
        List<Patient> patientList = patientService.getAllPatients();
        model.addAttribute("all_patients", patientList);
        return "getPatients";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("new_patient", patient);
        return "add_patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("new_patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/list";
    }

    @GetMapping("/updatePatient")
    public String updatePatient(@RequestParam("id") int id, Model model) {
        Patient patient = patientService.getPatientByID(id);
        model.addAttribute("new_patient", patient);
        return "add_patient";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam("id") int id) {
        patientService.deletePatient(id);
        return "redirect:/list";
    }
}
