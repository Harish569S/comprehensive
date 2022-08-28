import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientModel } from '../model/patient-model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
 
  private baseUrl="http://localhost:8081/patient";
  constructor(private httpClient:HttpClient) { }

  //Used in creating Patient
  createPatient(patient:PatientModel):Observable<PatientModel>{
    return this.httpClient.post<PatientModel>(`${this.baseUrl}`,patient);
    }

    //used in patient details
    getAllPatients():Observable<PatientModel[]>{
      return this.httpClient.get<PatientModel[]>(`${this.baseUrl}`);
    }
    //used in get by id of patient details
    getPatientById(id:number):Observable<PatientModel>{
      return this.httpClient.get<PatientModel>(`${this.baseUrl}/${id}`);
    }
}
