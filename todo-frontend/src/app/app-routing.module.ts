import { NgModule } from "@angular/core";
import { Route, RouterModule, Routes } from "@angular/router";
import { DetailComponent } from "./detail/detail.component";
import { ListComponent } from "./list/list.component";
import { ModifyComponent } from "./modify/modify.component";

const routes: Routes =[
    {path: 'list', component: ListComponent},
    {path: '', redirectTo: '/list', pathMatch: 'full'},
    {path: 'detail/:id', component: DetailComponent},
    {path: 'modify/:id', component: ModifyComponent},

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{ }