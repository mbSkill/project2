import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDeviceComponent } from './pages/add-device/add-device.component';
import { PlanListComponent } from './pages/plan-list/plan-list.component';
import { UpdateDeviceComponent } from './pages/update-device/update-device.component';
import { UserComponent } from './pages/user/user.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.module').then(m => m.WelcomeModule) },
  { path: 'user' , component: UserComponent},
  { path: "adddevice", component:AddDeviceComponent},
  { path: "updatedevice/:id", component: UpdateDeviceComponent},
  { path: "updatedevice", component: UpdateDeviceComponent},
  { path: "plan", component: PlanListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
