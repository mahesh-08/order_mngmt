import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
   { path: '', redirectTo:'login', pathMatch:'full' }, 
  { path: '', loadChildren: './tabs/tabs.module#TabsPageModule' },
  { path: 'tab1', loadChildren: './tab1/tab1.module#Tab1PageModule'},
  { path: 'tab2', loadChildren: './tab2/tab2.module#Tab2PageModule' },
  { path: 'tab3', loadChildren: './tab3/tab3.module#Tab3PageModule' },  
  { path: 'user-panel', loadChildren: './user-panel/user-panel.module#UserPanelPageModule' }, 
  { path: 'login', loadChildren: './login/login.module#LoginPageModule' },
  { path: 'distributer', loadChildren: './distributer/distributer.module#DistributerPageModule' },
  { path: 'crops', loadChildren: './crops/crops.module#CropsPageModule' },
  { path: 'end', loadChildren: './end/end.module#EndPageModule' },
  { path: 'temp', loadChildren: './tabs/temp/temp.module#TempPageModule' }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
