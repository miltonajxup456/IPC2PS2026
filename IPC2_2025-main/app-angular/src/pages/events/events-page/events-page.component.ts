import { Component, OnInit } from '@angular/core';
import { Event } from '../../../models/events/event';
import { EventTypeEnum } from '../../../models/events/event-type-enum';
import { NgFor } from '@angular/common';
import { EventCardComponent } from '../../../components/events/event-card-component/event-card.component';
import { RouterLink } from '@angular/router';
import { EventsService } from '../../../services/events/events.service';
import { ConfirmationModalComponent } from "../../../shared/restapi/components/confirmation-modal/confirmation-modal.component/confirmation-modal.component";
import { RoleGuardService } from '../../../services/security/role-guard.service';

@Component({
  selector: 'app-events-page',
  imports: [NgFor, EventCardComponent, RouterLink, ConfirmationModalComponent],
  templateUrl: './events-page.component.html',
  styleUrl: './events-page.component.css'
})
export class EventsPageComponent implements OnInit {
  protected events: Event[] = [];
  selectedEvent!: Event;
  deleted: boolean = false;;
  isAdmin: boolean;

  constructor(private eventsService: EventsService, private roleGuardService: RoleGuardService) {
    this.isAdmin = roleGuardService.userRoleInAllowedRoles(['ADMIN']);
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.eventsService.getAllEvents().subscribe({
      next: (eventsFromServer: Event[]) => {
        this.events = eventsFromServer;
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

  onSelectedEvent(event: Event): void {
    this.selectedEvent = event;
    this.deleted = false;
  }

  deleteEvent(): void {
    this.eventsService.deleteEvent(this.selectedEvent.code).subscribe({
      next: () => {
        // deleted
        this.loadData();
        this.deleted = true;
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }
}
