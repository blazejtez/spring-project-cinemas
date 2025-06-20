import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtimeViewComponent } from './showtime-view.component';

describe('ShowtimeViewComponent', () => {
  let component: ShowtimeViewComponent;
  let fixture: ComponentFixture<ShowtimeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowtimeViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowtimeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
