import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPanelPage } from './user-panel.page';

describe('UserPanelPage', () => {
  let component: UserPanelPage;
  let fixture: ComponentFixture<UserPanelPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPanelPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPanelPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
