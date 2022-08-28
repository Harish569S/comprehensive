import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatiDetailsComponent } from './pati-details.component';

describe('PatiDetailsComponent', () => {
  let component: PatiDetailsComponent;
  let fixture: ComponentFixture<PatiDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatiDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatiDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
