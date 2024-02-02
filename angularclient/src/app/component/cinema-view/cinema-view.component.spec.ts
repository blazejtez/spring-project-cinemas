import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemaViewComponent } from './cinema-view.component';

describe('CinemaViewComponent', () => {
  let component: CinemaViewComponent;
  let fixture: ComponentFixture<CinemaViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CinemaViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CinemaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
