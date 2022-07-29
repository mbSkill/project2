import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IconsProviderModule } from './icons-provider.module';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { UserComponent } from './pages/user/user.component';
import { LoginComponent } from './pages/login/login.component';
import { CookieService } from 'ngx-cookie-service';
import { AddDeviceComponent } from './pages/add-device/add-device.component';
import { UpdateDeviceComponent } from './pages/update-device/update-device.component';
import { PlanListComponent } from './pages/plan-list/plan-list.component';
import { PlandetailComponent } from './pages/plandetail/plandetail.component';
import { AnalysisComponent } from './pages/analysis/analysis.component';
import { AddplanComponent } from './pages/addplan/addplan.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    AddDeviceComponent,
    UpdateDeviceComponent,
    PlanListComponent,
    PlandetailComponent,
    AnalysisComponent,
    AddplanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    IconsProviderModule,
    NzLayoutModule,
    NzMenuModule,
    
  ],
  providers: [
    CookieService, 
    { provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
