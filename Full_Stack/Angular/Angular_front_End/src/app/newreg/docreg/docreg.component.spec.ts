import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocregComponent } from './docreg.component';

describe('DocregComponent', () => {
  let component: DocregComponent;
  let fixture: ComponentFixture<DocregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocregComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
