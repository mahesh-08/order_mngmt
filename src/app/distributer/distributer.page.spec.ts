import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistributerPage } from './distributer.page';

describe('DistributerPage', () => {
  let component: DistributerPage;
  let fixture: ComponentFixture<DistributerPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistributerPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistributerPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
