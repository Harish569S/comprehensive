import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DoctorModel } from '../model/doctor-model';

@Injectable({
  providedIn: 'root'
})

export class DoctorService {
  private baseUrl = "http://localhost:8081/doctor";

  constructor(private httpClient: HttpClient) { }


  //used in registering doctor
  createDoctor(doctor: DoctorModel): Observable<DoctorModel> {
    return this.httpClient.post<DoctorModel>(`${this.baseUrl}`, doctor);
  }


  //used in doctor details and patient creation
  getAllDoctors(): Observable<DoctorModel[]> {
    return this.httpClient.get<DoctorModel[]>(`${this.baseUrl}`);
  }

  //used in doctor details     
  getDoctorByName(name: string): Observable<DoctorModel> {
    return this.httpClient.get<DoctorModel>(`${this.baseUrl}/` + "byname" + `/${name}`);
  }

}

