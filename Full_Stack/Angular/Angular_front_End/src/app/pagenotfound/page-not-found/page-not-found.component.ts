import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit {
  id:any;
  constructor(private router:Router,private acRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.acRoute.snapshot.params['id'];
  }
  toRedirect(){
    this.router.navigate(['/patient-details'])
  }
  toHome(){
    this.router.navigate(['/home'])
  }
}
