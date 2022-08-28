import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorModel } from 'src/app/model/doctor-model';
import { PatientModel } from 'src/app/model/patient-model';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patireg',
  templateUrl: './patireg.component.html',
  styleUrls: ['./patireg.component.css']
})
export class PatiregComponent implements OnInit {

  patient: PatientModel = new PatientModel();

  doctors: DoctorModel[] = [];

  constructor(private doctorService: DoctorService, private patientService: PatientService,
    private router: Router) { }


  ngOnInit(): void {
    this.doctorService.getAllDoctors().subscribe(response => {
      this.doctors = response;
      console.log(response);
    })

  }


  onSubmit() {
    this.patientService.createPatient(this.patient).subscribe(data => {
      console.log(data);
      alert("Your id is " + data.id)
      this.gotoPatientList();

    })
  }


  gotoPatientList() {
    this.router.navigate(['/patient-details']);
  }

}






