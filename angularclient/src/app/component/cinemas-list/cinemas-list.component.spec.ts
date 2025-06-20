import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemasListComponent } from './cinemas-list.component';

describe('CinemasListComponent', () => {
  let component: CinemasListComponent;
  let fixture: ComponentFixture<CinemasListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CinemasListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CinemasListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
