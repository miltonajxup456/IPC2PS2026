import { Routes } from '@angular/router';
import { CounterPage } from '../pages/counter-page/counter-page.component';
import { EventsPageComponent } from '../pages/events/events-page/events-page.component';
import { CreateEventPageComponent } from '../pages/events/create-event-page/create-event-page.component';
import { UpdateEventPageComponent } from '../pages/events/update-event-page/update-event-page.component';
import { LoginPageComponent } from '../pages/login-page/login-page.component';
import { RoleGuardService } from '../services/security/role-guard.service';
import { FilesPageComponent } from '../pages/files-page/files-page.component';

export const routes: Routes = [
    {
        path: '',
        component: CounterPage,
    },
    {
        path: 'events',
        component: EventsPageComponent,
        canActivate: [RoleGuardService],
        data: {allowedRoles: ['ADMIN', 'USUARIO']},
    },
    {
        path: 'events/new',
        component: CreateEventPageComponent,
        canActivate: [RoleGuardService],
        data: {allowedRoles: ['ADMIN']},
    },
    {
        path: 'events/update/:code',
        component: UpdateEventPageComponent,
        canActivate: [RoleGuardService],
        data: {allowedRoles: ['ADMIN']},
    },
    {
        path: 'login',
        component: LoginPageComponent,
    },
    {
        path: 'files',
        component: FilesPageComponent,
    },
];
