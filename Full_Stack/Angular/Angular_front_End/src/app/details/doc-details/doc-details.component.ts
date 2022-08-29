import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DoctorModel } from 'src/app/model/doctor-model';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doc-details',
  templateUrl: './doc-details.component.html',
  styleUrls: ['./doc-details.component.css']
})
export class DocDetailsComponent implements OnInit {

  doctors: DoctorModel[] = [];
  doctor: DoctorModel = new DoctorModel();
  tempId: string;

  ;
  constructor(private doctorService: DoctorService,private router:Router) {
  }

  ngOnInit(): void {
    this.doctorService.getAllDoctors().subscribe(response => {
      this.doctors = response;
      console.log(response);
    })
  }


  OnChange(val: any) {
    if (val != "") {
      this.tempId = val;
      console.log(this.tempId);
      this.doctorService.getDoctorByName(this.tempId).subscribe(response => {
        this.doctor = response;
        console.log(response);
      })
    }
  }

  toHome(){
    this.router.navigate(['/home'])
  }


}

