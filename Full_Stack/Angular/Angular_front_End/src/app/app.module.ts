import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { DocregComponent } from './newreg/docreg/docreg.component';
import { PatiregComponent } from './newreg/patireg/patireg.component';
import { DocDetailsComponent } from './details/doc-details/doc-details.component';
import { PatiDetailsComponent } from './details/pati-details/pati-details.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './pagenotfound/page-not-found/page-not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    PatiregComponent,
    DocregComponent,
    DocDetailsComponent,
    PatiDetailsComponent,
    HomeComponent,
    PageNotFoundComponent,
  
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
