import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeatherShowComponent } from './weather-show/weather-show.component';

const routes: Routes = [
  {path: '', component:WeatherShowComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
