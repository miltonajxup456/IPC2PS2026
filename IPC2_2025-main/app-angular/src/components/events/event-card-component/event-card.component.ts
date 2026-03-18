import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Event } from "../../../models/events/event";
import { CurrencyPipe, DatePipe } from "@angular/common";
import { RouterLink } from "@angular/router";
import { RoleGuardService } from "../../../services/security/role-guard.service";

@Component({
  selector: 'app-event-card',
  imports: [DatePipe, CurrencyPipe, RouterLink],
  templateUrl: './event-card.component.html',
  styleUrl: './event-card.component.css'
})
export class EventCardComponent {
  @Input({ required: true })
  selectedEvent!: Event;

  @Output()
  eventSelected = new EventEmitter<Event>();

  isAdmin: boolean;

  constructor(private roleGuardService: RoleGuardService) {
    this.isAdmin = roleGuardService.userRoleInAllowedRoles(['ADMIN']);
  }

  deleteAction(): void {
    this.eventSelected.emit(this.selectedEvent);
  }
}