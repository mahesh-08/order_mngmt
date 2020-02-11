import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'tab1',
        children: [
          {
            path: '',
            loadChildren: '../tab1/tab1.module#Tab1PageModule'
          }
        ]
      },
      {
        path: 'tab2',
        children: [
          {
            path: '',
            loadChildren: '../tab2/tab2.module#Tab2PageModule'
          }
        ]
      },
      {
        path: 'tab3',
        children: [
          {
            path: '',
            loadChildren: '../tab3/tab3.module#Tab3PageModule'
          }
        ]
      },
        //created for distributer page
      {
        path: 'distributer',
        children: [
          {
            path: '',
            loadChildren: '../distributer/distributer.module#DistributerPageModule'
          }
        ]
      },

      {
        path: 'temp',
        children: [
          {
            path: '',
            loadChildren: '../tabs/temp/temp.module#TempPageModule'
          }
        ]
      },
      // till here



       {
        path: '',
        redirectTo: '/tabs/tab2',
        pathMatch: 'full'
      } 
    ]
  },
   {
    path: '',
    redirectTo: '/tabs/tab2',
    pathMatch: 'full'
  } 
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
