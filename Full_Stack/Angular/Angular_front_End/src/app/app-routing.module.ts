import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DocDetailsComponent } from './details/doc-details/doc-details.component';
import { PatiDetailsComponent } from './details/pati-details/pati-details.component';
import { HomeComponent } from './home/home.component';
import { DocregComponent } from './newreg/docreg/docreg.component';
import { PatiregComponent } from './newreg/patireg/patireg.component';
import { PageNotFoundComponent } from './pagenotfound/page-not-found/page-not-found.component';


const routes: Routes = [
  {path:'doctor-reg', component:DocregComponent},
  {path:'patient-reg',component:PatiregComponent},
  {path:'patient-details',component:PatiDetailsComponent},
  {path:'doctor-details',component:DocDetailsComponent},
  {path:'home',component:HomeComponent},
  {path:'page-not-found/:id',component:PageNotFoundComponent},
  {path:'', redirectTo:'home',pathMatch:'full'  },
  {path:'**', redirectTo:'home',pathMatch:'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
