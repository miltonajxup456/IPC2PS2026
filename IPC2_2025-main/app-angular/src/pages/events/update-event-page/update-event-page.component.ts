import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, ActivatedRouteSnapshot, Router, RouterLink } from "@angular/router";
import { EventFormComponent } from "../../../components/events/event-form-component/event-form.component";
import { EventsService } from "../../../services/events/events.service";
import { Event } from "../../../models/events/event";

@Component({
  selector: 'app-create-event-page',
  imports: [EventFormComponent, RouterLink],
  templateUrl: './update-event-page.component.html',
})
export class UpdateEventPageComponent implements OnInit {
  eventCode!: string
  eventToUpdate!: Event;
  exists: boolean = false;

  constructor(private router: ActivatedRoute, private eventsService: EventsService) {

  }

  ngOnInit(): void {
    this.eventCode = this.router.snapshot.params['code'];
    this.eventsService.getEventByCode(this.eventCode).subscribe({
      next: (eventToUpdate) => {
        this.eventToUpdate = eventToUpdate;
        this.exists = true;
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }


}