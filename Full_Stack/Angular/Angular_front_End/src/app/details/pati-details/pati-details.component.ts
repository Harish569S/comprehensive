import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientModel } from 'src/app/model/patient-model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-pati-details',
  templateUrl: './pati-details.component.html',
  styleUrls: ['./pati-details.component.css']
})
export class PatiDetailsComponent implements OnInit {

  patients: PatientModel[] = [];
  patient: PatientModel = new PatientModel();
  notPresent: boolean=false;

  constructor(private patientService: PatientService, private router: Router) {

  }

  ngOnInit(): void {

    this.patientService.getAllPatients().subscribe(
      response => {
        this.patients = response;
        console.log(response);
      }
    )
  }
  onChange(value: any) {
    if (typeof value == "number") {
      this.notPresent = true;
      for (let i = 0; i < this.patients.length; i++) {
        if (value === this.patients[i].id) {
          this.notPresent = false
          this.patientService.getPatientById(value).subscribe(
            response => {
              this.patient = response
              console.log(response);
            }
          )
          break;
        }
      }
    }
    console.log("Before NotPresent Page +" + this.notPresent)
    if (this.notPresent) {
      this.patient = new PatientModel();
      console.log("Id Entered is" + value)
      this.gotoPageNotFound(value)

    }

  }

  //Navigates to Page Not Found
  gotoPageNotFound(id: number) {
    this.router.navigate(['/page-not-found', id])

  }

  toHome() {
    this.router.navigate(['/home'])
  }

}
