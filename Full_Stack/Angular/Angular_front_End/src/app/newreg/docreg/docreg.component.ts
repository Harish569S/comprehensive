
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { DoctorModel } from 'src/app/model/doctor-model';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-docreg',
  templateUrl: './docreg.component.html',
  styleUrls: ['./docreg.component.css']
})
export class DocregComponent implements OnInit {

  doctor:DoctorModel=new DoctorModel();
  specialities=["Cardio","Neurology","Psychiatrist","Surgeon"];
   
  constructor(private doctorService:DoctorService,private router:Router) { 
    
  }

  ngOnInit(): void {
   
  }

onSubmit(){
  this.doctor.docName="Dr."+this.doctor.docName;
  this.doctorService.createDoctor(this.doctor).subscribe(response=>{
    console.log(response);
    alert("Your Registration was successfull "+response.docName);
    this.gotoView();
   })
  
}


gotoView(){
  this.router.navigate(['/doctor-details']);
}

OnChange(str:string){
  console.log(str);
}


toHome(){
  this.router.navigate(['/home'])
}

}
