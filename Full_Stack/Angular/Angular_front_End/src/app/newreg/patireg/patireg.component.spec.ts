import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatiregComponent } from './patireg.component';

describe('PatiregComponent', () => {
  let component: PatiregComponent;
  let fixture: ComponentFixture<PatiregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatiregComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatiregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
