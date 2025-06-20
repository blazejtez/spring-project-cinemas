import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtimeEditComponent } from './showtime-edit.component';

describe('ShowtimeEditComponent', () => {
  let component: ShowtimeEditComponent;
  let fixture: ComponentFixture<ShowtimeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowtimeEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowtimeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
